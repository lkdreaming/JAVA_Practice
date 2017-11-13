/**
 * user_duty  大的方法里面有两个小方法:dutyTree, init
 */
var user_duty = {
		data : {
			user : {
				username : '',
				userId : ''
			},
			zTreePlugin : '',
			displayStrInTd : ''
		},
		
		/**
		 * 
		 */
		init : {
			initData : function() {
				user_duty.data.user.username = $(this).parent().siblings("td:first").text();
				user_duty.data.user.userId = $(this).parent().siblings("input[type='hidden']").val();
			},
			initEvent : function() {
				/**
				 * 1.点击属性设置后发生的事件
				 */
				$("a").each(function() {
					if($(this).text() == "设置职务") {
						$(this).unbind("click");
						$(this).bind("click", function() {
							/**
							 * 1.把所有隐藏的DIV全部显示出来.
							 */
							
							user_duty.operation.divOpt.showDiv();
							/**
							 * 2.动态地显示用户名
							 */
							user_duty.init.initData.call(this);
							user_duty.operation.userOpt.showUserName();
							user_duty.operation.dutyTree.loadDutyTree();
							/**
							 * 3.加载树的完成状态
							 */
							user_duty.operation.dutyTree.loadingDutyTree({
								done : false
							});
						});
					}
				});
				/**
				 * 2.点击全选复选框发生的事件
				 */
				$("#allchecked").unbind("change");
				$("#allchecked").bind("change", function() {
					user_duty.operation.dutyTree.isCheckedAll.call(this);
				});
				
				/**
				 * 3.点击保存按钮发生的事件
				 */
				$("#InputDetailBar>img").click(function() {
					//alert("保存");
						
						user_duty.operation.dutyTree.saveDuty();
					
					
				}); 
			}
						
						
		
		},
		
		operation : {
			/**
			 * div的操作
			 */
			divOpt : {
				showDiv : function() {
					$("div:hidden").show();
				}
			},
			/**
			 * user的操作
			 */
			userOpt : {
				showUserName : function() {
					$("#userImage").text("用户:"+user_duty.data.user.username);
				}
			},
			/**
			 * 树的操作
			 */
			dutyTree : {
				setting : {
					isSimpleData : true,
					checkable : true,
					checkType : { "Y": "s", "N": "ps" },
					treeNodeKey : "dutyId",
					treeNodeParentKey : "pid",
					showLine : true,
					callback : {
						change : function() {
							user_duty.operation.dutyTree.isCheckedAllNotes();
							user_duty.operation.dutyTree.displayInTd();
						}
					}
				},
				loadDutyTree : function() {
					$.ajax({
						url : 'dutyAction_showCheckedNodeTree.action',
						data : {
							userId : user_duty.data.user.userId
						},//这里的data是指dutyAction_showALLDuties.action页面后面加不加参数?xx={xx}
						success : function(data) {//这里的data是指ajax从dutyAction_showALLDuties.action中得到的数据的容器,作为zTRee的节点
							user_duty.data.zTreePlugin = $("#dutyTree").zTree(user_duty.operation.dutyTree.setting, data);
							/**
							 * 加载树的数据之后的情况
							 */
							user_duty.operation.dutyTree.loadingDutyTree({
								done : true
							});
							/**
							 * 设置全选框的初始值
							 */
							user_duty.operation.dutyTree.isCheckedAllNotes();
						}
					});
				},
				
				/**
				 * 加载树时候的控制函数
				 * @param json
				 */
				loadingDutyTree : function(json) {
					//当树加载完成时隐藏Loading图片的DIV层,显示DutyTree的DIV层,并使全选框可用.
					if(json.done) {
						$("#loading").hide();
						$("#dutyTree").show();
						$("#allchecked").attr("disabled", "");
					} else {//加载树的时候隐藏显示树的DIV,显示Loading图片的DIV,并使全选框失效
						$("#loading").show();
						$("#dutyTree").hide();
						$("#allchecked").attr("disabled", "disabled");
					}
				},
				/**
				 * 判断全选框是否被选中
				 */
				isCheckedAll : function() {
					if($(this).attr("checked")) {
						user_duty.data.zTreePlugin.checkAllNodes(true);
					} else {
						user_duty.data.zTreePlugin.checkAllNodes(false);
					}
				},
				/**
				 * 判断树的节点是否全部被选中
				 */
				isCheckedAllNotes : function() {
					if( user_duty.data.zTreePlugin.getCheckedNodes(false).length == 0) {//全部节点被选中
						$("#allchecked").attr("checked", "checked");
					} else {
						$("#allchecked").attr("checked", "");
					}
				},
				
				/**
				 * 注册保存按钮点击调用的方法
				 */
				saveDuty : function() {
					/**
					 * 得到所有选中的node
					 */
					var checkedNodes = user_duty.data.zTreePlugin.getCheckedNodes(true);
					var checkedNodesIdsStr = "";
					/**
					 * 将所有选中的node的id抽出来组成一个用逗号隔开的字符串
					 */
					for(var i = 0; i < checkedNodes.length; i++) {
						if(i == checkedNodes.length - 1) {
							checkedNodesIdsStr = checkedNodesIdsStr +  checkedNodes[i].dutyId;
						} else {
							checkedNodesIdsStr = checkedNodesIdsStr +  checkedNodes[i].dutyId + ",";
						} 
					}
					$.ajax({
						url : 'dutyAction_saveUserDuty.action',
						data: {
							userId : user_duty.data.user.userId,
							checkedNodesIdsStr : checkedNodesIdsStr
						},
						success : function(data) {
							  alert("操作成功");
						}
					});
				},
				
				/**
				 * 在相应的地方显示出所选节点的名称.
				 */
				displayInTd : function() {
					user_duty.data.displayStrInTd = "";
					var checkedNodes = user_duty.data.zTreePlugin.getCheckedNodes(true);
					for(var i = 0; i < checkedNodes.length; i++) {
						if(i == checkedNodes.length - 1) {
							user_duty.data.displayStrInTd = user_duty.data.displayStrInTd +  checkedNodes[i].name;
						} else {
							user_duty.data.displayStrInTd = user_duty.data.displayStrInTd +  checkedNodes[i].name + ",";
						} 
					}
					var username = $("#userImage").text().split(":")[1];
					$("td:contains("+ username +")").siblings("td:eq(1)").text(user_duty.data.displayStrInTd);
				}
				
			}
		}

};
$().ready(function() {
	//加载事件
	//duty.init.initEvent();
	//加载角色树
	//user_duty.init.initData();
	
	user_duty.init.initEvent();
	user_duty.operation.user_dutyTree.loadUser_dutyTree();
});
