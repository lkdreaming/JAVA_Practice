var role = {
	setting:{
		isSimpleData: true,
		treeNodeKey: "id",
		treeNodeParentKey: "pid",
		showLine: true,
		root:{ 
			isRoot:true,
			nodes:[]
		},
		callback:{
			rightClick:function(event, treeId, treeNode){
				role.zTreeOnRightClick(event, treeId, treeNode);
			}
		}
	},
	zNodes:[
		{id:'1',name:'供应链管理系统',pid:'0',isParent:true}
	],
	zTreeOnRightClick:function(event, treeId, treeNode){
		role.showRMenu("root", event.clientX, event.clientY);
	},
	showRMenu:function(type, x, y){
		$("#rMenu li").show();
		$("#rMenu").css({"top":y+"px", "left":x+"px", "display":"block"});
	},
	loadRoleTree:function(){
		$("#tree").zTree(role.setting,role.zNodes);
	}
};
$().ready(function(){
	role.loadRoleTree();
});
