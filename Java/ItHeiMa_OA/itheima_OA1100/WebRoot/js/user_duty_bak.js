var zTree1;
var setting;

setting = {
	checkable : true,
	callback : {
		change : zTreeOnChange
	}
};

$(document).ready(function() {
	refreshTree();

});

function zTreeOnChange(event, treeId, treeNode) {
	getCheckedNodesLength();
}

function getCheckBoxType() {
	var py = $("#py").attr("checked") ? "p" : "";
	var sy = $("#sy").attr("checked") ? "s" : "";
	var pn = $("#pn").attr("checked") ? "p" : "";
	var sn = $("#sn").attr("checked") ? "s" : "";

	var type = {
		"Y" : py + sy,
		"N" : pn + sn
	};
	return type;
}

function refreshTree() {
	var checkType = getCheckBoxType();
	setting.checkType = checkType;
	zTree1 = $("#treeDemo").zTree(setting, clone(zNodes));
	$("#checkTypeCode").html(
			"{\"Y\":" + checkType.Y + ", \"N\":" + checkType.N + "}");
	getCheckedNodesLength();
}

function getCheckedNodesLength() {
	var tmp = zTree1.getCheckedNodes();
	$("#checkedNum").html(tmp.length);
	tmp = zTree1.getChangeCheckedNodes();
	$("#checkedChangeNum").html(tmp.length);
	if ($("#changeYes").attr("checked")) {
		for ( var i = 0; i < tmp.length; i++) {
			tmp[i].checkedOld = tmp[i].checked;
		}
	}
}
