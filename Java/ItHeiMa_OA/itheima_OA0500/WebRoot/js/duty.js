var duty = {
		setting : {
				isSimpleData: true,
				treeNodeKey: "id",
				treeNodeParentKey: "pid",
				showLine: true,
				root:{ 
					isRoot:true,
					nodes:[]
				}
		},
		loadDutyTree:function() {
			$.ajax({
				url:"dutyAction_showALLDuties.action",
				data:null,
				success:function(data) {
					//alert(data);
					$("#dutyTree").zTree(duty.setting,data);
				}
			});
		}
};


$().ready(function() {
	//¼ÓÔØ½ÇÉ«Ê÷
	duty.loadDutyTree();
});