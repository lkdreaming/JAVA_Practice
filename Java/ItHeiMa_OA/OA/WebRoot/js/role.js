
var role = {
		data : {
			roleNode : null,
			zTreePlugin : null
		},
		
		roleTree : {
			setting : {
				showLine : true,
				isSimpleData : true,
			    treeNodeKey : "roleId",
			    treeNodeParentKey : "pid",
				rootPID : -1,
					callback: {
								rightClick: zTreeOnRightClick
					}
			},
			loadRoleTree : function() {
				$.ajax({
					url : "roleAction_showAllRolesForTree.action",
					data : null,
					success : function(data) {
						//alert(data);
						//model中的name字段名称必须叫name,才能和zTree中的name对应起来,以显示节点的名称,否则无法显示节点名称.
						role.data.zTreePlugin = $("#roleTree").zTree(role.roleTree.setting, data);
					},
				}); 
			},
			
			addTreeNode : function () {
				$(rMenu).hide();
				var roleName = window.prompt("请输入节点名称");
				if(roleName) {
					if(!role.data.zTreePlugin.getNodeByParam("name",roleName)) {
						$.ajax({
							url : "roleAction_add.action",
							data : {
								pid : role.data.roleNode.roleId,
								name : roleName
							},
							type: "POST",//不用POST形式汉字传到后台就会乱码!
							success : function(data) {
								//alert(data);
								var newNode = {
									roleId : data.roleId,
									name : roleName,
									pid : role.data.roleNode.roleId
								};
								role.data.zTreePlugin.addNodes(role.data.roleNode, newNode, true);
							}
							
						});
					} else {
						alert("节点名称已存在!");
					}
				}
			},
			
			deleteRole : function() {
				$(rMenu).hide();
				if(!role.data.zTreePlugin.getNodeByParam("pid", role.data.roleNode.roleId)) {
					if(window.confirm("确定删除吗?")) {
						$.ajax({
							url : "roleAction_delete.action",
							data : {
								roleId : role.data.roleNode.roleId
							},
							success : function() {
								role.data.zTreePlugin.removeNode(role.data.roleNode);
							}
						});
					}
				} else {
					alert("该节点下存在子节点,不能删除!");
				}
			},
			updateRole : function () {
				$(rMenu).hide();
				var rename = window.prompt("请输入节点名称", role.data.roleNode.name);
				if(rename) {
					if(!role.data.zTreePlugin.getNodeByParam("name",rename)) {
						$.ajax({
							url : "roleAction_update.action",
							data : {
								roleId : role.data.roleNode.roleId,
								pid : role.data.roleNode.pid,
								name : rename
							},
							type: "POST",//不用POST形式汉字传到后台就会乱码!
							success : function() {
								role.data.roleNode.name = rename;
								role.data.zTreePlugin.refresh();
								alert("修改成功");
							}
							
						});
					} else {
						alert("节点名称已存在!");
					}
				}
			},
		},
		
		
		
		init : {
			initEvent : function(){
				$("#rMenu").hover(
					//鼠标进入右键菜单范围内做该做的事
					function() {},
					//鼠标划出右键菜单后隐藏
					function(){
						$(this).hide();
					}
				);
				$("#addRole").unbind("click");
				$("#addRole").bind("click", function(){
					role.roleTree.addTreeNode();
				});
				$("#deleteRole").unbind("click");
				$("#deleteRole").bind("click", function(){
					role.roleTree.deleteRole();
				});
				$("#updateRole").unbind("click");
				$("#updateRole").bind("click", function(){
					role.roleTree.updateRole();
				});
			}
			
			
		}
};

function showRMenu(type, x, y) {
	$("#rMenu ul").show();
	$("#rMenu").css({"top":y+"px", "left":x+"px", "display":"block"});
}
function hideRMenu() {
	$("#rMenu").hide();
}

function zTreeOnRightClick(event, treeId, treeNode){
	role.data.roleNode = treeNode;
	showRMenu("root", event.clientX, event.clientY);
}

$().ready(function() {
	role.init.initEvent();
	role.roleTree.loadRoleTree();
});
