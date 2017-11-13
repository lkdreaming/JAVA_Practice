var duty_privilege = {
	data : {
		duty : {
			dutyId : '',
			name : ''	
		},
		zTreePlugin : ''
	},
	
	init : {
		initData : function() {
			duty_privilege.data.duty.dutyId =  $(this).parent().siblings("input[type='hidden']").val();
			duty_privilege.data.duty.name = $(this).parent().siblings("td:first").text();
		},
		initEvent : function() {
			$("a").each(function() {
				if($(this).text() == "设置权限") {
					$(this).unbind("click");
					$(this).bind("click", function() {
						$("div:hidden").show();
						duty_privilege.init.initData.call(this);
						$("#dutyImage").text("岗位:"+duty_privilege.data.duty.name);
						duty_privilege.operation.duty_privilegeTree.loadingDuty_privilegeTree({
							done : false
						});
						duty_privilege.operation.duty_privilegeTree.loadDuty_privilegeTree();
						$("#allchecked").unbind("change");
						$("#allchecked").bind("change", function() {
							duty_privilege.operation.duty_privilegeTree.isCheckAll.call(this);
						});
						
						$("#save").click(function() {
							duty_privilege.operation.duty_privilegeTree.saveDuty_Privilege();
						});
						
					});
				} 
			});
		}
	},
	operation: {
		duty_privilegeTree : {
			setting : {
				isSimpleData : true,
				checkable : true,
				checkType : { "Y": "s", "N": "ps" },
				treeNodeKey : "privilegeId",
				treeNodeParentKey : "pid",
				showLine : true,
				callback :  {
					change : function() {
						duty_privilege.operation.duty_privilegeTree.isCheckedAllNotes();
					}
				}
			},
			loadDuty_privilegeTree : function() {
				$.ajax({
					url : 'privilegeAction_showPrivilegeByDutyId.action',
					data: {
						dutyId : duty_privilege.data.duty.dutyId,
					},
					success : function(data) {
						duty_privilege.data.zTreePlugin = $("#privilegeTree").zTree(duty_privilege.operation.duty_privilegeTree.setting, data);
						/**
						 * 加载完树之后隐藏loading,显示Tree的div
						 */
						duty_privilege.operation.duty_privilegeTree.loadingDuty_privilegeTree({
							done : true
						});
					}
				});
			},
			loadingDuty_privilegeTree: function(json) {
				if(json.done) {
					$("#loading").hide();
					$("#privilegeTree").show();
				} else {
					$("#loading").show();
					$("#privilegeTree").hide();
				}
			},
			isCheckAll : function() {
				if($(this).attr("checked")) {
					duty_privilege.data.zTreePlugin.checkAllNodes(true);
				} else {
					duty_privilege.data.zTreePlugin.checkAllNodes(false);
				}
			},
			isCheckedAllNotes : function() {
				if(duty_privilege.data.zTreePlugin.getCheckedNodes(false).length == 0) {
					$("#allchecked").attr("checked", "checked"); 
				} else {
					$("#allchecked").attr("checked", ""); 
				}
			},
			
			saveDuty_Privilege : function() {
				var checkedNotes = duty_privilege.data.zTreePlugin.getCheckedNodes(true);
				var checkedPrivilegeIdsStr = "";
				for(var i = 0; i < checkedNotes.length; i++) {
					if(i == checkedNotes.length - 1) {
						checkedPrivilegeIdsStr = checkedPrivilegeIdsStr + checkedNotes[i].privilegeId;
					} else {
						checkedPrivilegeIdsStr = checkedPrivilegeIdsStr + checkedNotes[i].privilegeId + ",";
					}
				}
				$.ajax({
					url : 'privilegeAction_saveDutyPrivilege.action',
					data : {
						dutyId : duty_privilege.data.duty.dutyId,
						checkedPrivilegeIdsStr : checkedPrivilegeIdsStr
					},
					success : function(data){
						alert("保存成功");
					}
				});
			}
		}
		
	}
};


$().ready(function() {
	//加载事件
	//duty.init.initEvent();
	//加载角色树
	//user_duty.init.initData();
	
	duty_privilege.init.initEvent();
	
});