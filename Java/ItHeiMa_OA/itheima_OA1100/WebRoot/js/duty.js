var duty = {
	/**
	 * 用来保存数据.
	 */
	data : {
		dutyNode : null,
		/**
		 * zTreePlugin是一个 zTreePlugin 对象(就是一个zTree树的对象)
		 */
		zTreePlugin: null
		
	},
	dutyTree : {
		setting : {
			isSimpleData : true,
			treeNodeKey : "dutyId",
			treeNodeParentKey : "pid",
			showLine : true,
			/*root : {
				isRoot : true,
				nodes : []
			},*/
			callback : {
				rightClick : zTreeOnRightClick/*
				 function(event, treeId, treeNode) {
					duty.showRMenu(event, treeId, treeNode)
				}
				*/
			}
		},
		loadDutyTree : function() {
			$.ajax({
				url : "dutyAction_showALLDutiesForAjax.action",
				data : null,
				success : function(data) {
					//alert(data);
					//赋值zTreePlugin
					duty.data.zTreePlugin = $("#dutyTree").zTree(duty.dutyTree.setting, data);
				}
			});
		},
		/**
		 * 增加角色
		 */
		addDuty : function() {
			/**
			 * 1.隐藏右键菜单
			 * 2.弹出输入职务的名字的框框
			 */
			$(rMenu).hide();
			var dutyName = window.prompt("请输入职务的名称");
			if(dutyName) {
				/**
				 * 如果输入的名字不存在
				 */
				if(!duty.data.zTreePlugin.getNodeByParam("name", dutyName)) {
					/**
					 * 发出ajax请求,把数据发送到后台
					 */
					$.ajax({
						url : "dutyAction_add.action",
						data : {
							//action中duty相关参数的名字:页面输入或ajax传递的参数名字
							name:dutyName,
							pid:duty.data.dutyNode.dutyId
							
						},
						type: "POST",
						success : function(data) {//后台添加成功,执行
							//alert(data);
							var newNode = {
								dutyId : data.dutyId,
								name : dutyName,
								pid : duty.data.dutyNode.dutyId
							};
							duty.data.zTreePlugin.addNodes(duty.data.dutyNode, newNode, true);
						}
					});	
				}else {
					alert("该名称已存在");
				}
				
			}
		},
		
		deleteDuty : function() {
			/**
			 * 判断该节点是否存在一个子节点的PID等于自己的ID的,即该节点是否存在子节点
			 */
			if(!duty.data.zTreePlugin.getNodeByParam("pid", duty.data.dutyNode.dutyId)) {
				if(window.confirm("确认要删除吗?")) {
					$.ajax({
						url : 'dutyAction_delete.action',
						data : {
							dutyId : duty.data.dutyNode.dutyId
						},
						success : function() {
							duty.data.zTreePlugin.removeNode(duty.data.dutyNode);
						}
					});
				}	
			}else {
				alert("该节点含有子节点不能删除!");
			}
			
		},
		
		updateDuty : function() {
			var rename = window.prompt("修改名称", duty.data.dutyNode.name);
			
			if(!duty.data.zTreePlugin.getNodeByParam("name", rename)) {
				//alert(rename);
				$.ajax({
					url : 'dutyAction_update.action',
					data: {
						dutyId : duty.data.dutyNode.dutyId,
						name : rename,
						pid : duty.data.dutyNode.pid
					},
					type : 'POST',
					success : function() {
						duty.data.dutyNode.name = rename;
						duty.data.zTreePlugin.refresh();
						alert("修改成功");
					}
				});
			}else {
				alert("节点名称已存在");
			}
			
		}
		
	},/*
	showRMenu : function(event, treeId, treeNode) {
		var x = event.clientX;
		var y = event.clientY;
		$("#rMenu").show();
		$("#rMenu").css({
			"top": y + "px",
			"left": x + "px",
			"display": "block"
		});
		
		
	},
	*/
	/**
	 * 初始化
	 */
	init: {
		initEvent:function() {
			$("#rMenu").hover(
							/*
							 * 当鼠标在右键菜单范围内应该做的事情
							 */
							function() {},
							/*
							 * 当鼠标划出范围后隐藏邮件菜单
							 */
							function() {
								$(this).hide();
							}
			); 
			/**
			 * 右键添加,删除,修改角色的click事件
			 */
			$("#addDuty").unbind("click");
			$("#addDuty").bind("click",function() {
				duty.dutyTree.addDuty();
			});
			
			$("#deleteDuty").unbind("click");
			$("#deleteDuty").bind("click",function() {
				duty.dutyTree.deleteDuty();	
			});
			
			$("#updateDuty").unbind("click");
			$("#updateDuty").bind("click",function() {
				duty.dutyTree.updateDuty();
			});
			
			
		}
		
		
	}
	
};

$().ready(function() {
	//加载事件
	duty.init.initEvent();
	//加载角色树
	duty.dutyTree.loadDutyTree();
});
/**
 * 
 * @param {Object} event
 * @param {Object} treeId	树容器的ID
 * @param {Object} treeNode	当前点击的节点ID
 */
function zTreeOnRightClick(event, treeId, treeNode) {
	/**
	 * 把treeNode保存到dutyNodeId中,为了要treeNode中的ID
	 */
	duty.data.dutyNode = treeNode;
	showRMenu("root", event.clientX, event.clientY);
}

function showRMenu(type, x, y) {
		$("#rMenu ul").show();
		$("#rMenu").css({"top":y+"px", "left":x+"px", "display":"block"});
	}


function hideRMenu() {
	$("#rMenu").hide();
}