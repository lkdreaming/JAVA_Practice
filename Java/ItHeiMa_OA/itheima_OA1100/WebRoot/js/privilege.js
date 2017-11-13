var privilege = {
	privilegeTree : {
		setting : {
			isSimpleData : true,
			treeNodeKey : "privilegeId",
			treeNodeParentKey : "pid",
			showLine : true,
			/*root : {
				isRoot : true,
				nodes : []
			},*/
		},
		loadPrivilegeTree : function() {
			$.ajax({
				url : 'privilegeAction_getPrivilegesByUserId.action',
				data : null,
				success : function(data) {
					$("#menuTree").zTree(privilege.privilegeTree.setting,data);
				}
			});
		}
	}
};

$().ready(function() {
	/**
	 * 加载树
	 */
	privilege.privilegeTree.loadPrivilegeTree();
});