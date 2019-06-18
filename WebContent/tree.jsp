<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
	<title>导航树</title>
	<meta http-equiv="content-type" content="text/html;charset=UTF-8">
	<style type="text/css">@import url('components/dtree/dtree.css');</style>
	<script type="text/javascript">var dtreeIconBasePath = "components/dtree";</script>
	<script type="text/javascript"  src="components/dtree/dtree.js"></script>
</head>
<body>
<script type="text/javascript"> 
var treeMenu = [
	{ level:1, name:"教学工作管理"},
	{ level:2, name:"教学进度管理", ico:"images/icon_default.gif",link:"course/Course_querybyUser.action"},
	{ level:2, name:"学生成绩管理", ico:"images/icon_default.gif",link:"students/Students_score_query.jsp"},
	{ level:2, name:"优秀生管理", ico:"images/icon_default.gif",link:"students/Students_excellent.jsp"},
	{ level:2, name:"教学总结管理", ico:"images/icon_default.gif",link:"course/course_Sum.jsp"},
	{ level:1, name:"教研工作管理"},
	{ level:2, name:"教研课题管理", ico:"images/icon_default.gif",link:"projects/Projects_query_success.jsp"},
	{ level:2, name:"教研活动管理", ico:"images/icon_default.gif",link:"projects/Projects_query_activity.jsp"},
	{ level:2, name:"教研总结管理", ico:"images/icon_default.gif",link:"projects/projects_Sum.jsp"},
	{ level:1, name:"日程规划管理"},
	{ level:2, name:"行程表", ico:"images/icon_default.gif",link:"plan/Plan_timetable.jsp"},
	{ level:2, name:"考核时间管理", ico:"images/icon_default.gif",link:"plan/Plan_timetable_examine.jsp"},
	{ level:2, name:"培训时间管理", ico:"images/icon_default.gif",link:"plan/Plan_timetable_train.jsp"},
	{ level:2, name:"课表时间管理", ico:"images/icon_default.gif",link:"plan/Plan_timetable_class.jsp"},
	{ level:2, name:"会议时间管理", ico:"images/icon_default.gif",link:"plan/Plan_timetable_meeting.jsp"},
	{ level:1, name:"账号管理"},
	{ level:2, name:"修改个人信息", ico:"images/icon_default.gif",link:"users/Users_modify.action?uid=10"},
];
</script>
<style>
* {
    background: none repeat scroll 0 0 transparent;
    border: 0 none;
    margin: 0;
    padding: 0;
    vertical-align: baseline;
	font-family:微软雅黑;
	overflow:hidden;
}
#menuControll{
	width:100%;
	position:relative;
	word-wrap:break-word;
	border-bottom:1px solid #065FB9;
	margin:0;
	padding:0 10px;
	font-size:14px;
	height:40px;
	line-height:40px;
	vertical-align:middle;
    background-image: -moz-linear-gradient(top,#EBEBEB, #BFBFBF);
    background-image: -webkit-gradient(linear, left top, left bottom, color-stop(0, #EBEBEB),color-stop(1, 
#BFBFBF));
}
</style>
<div id="menuControll">
菜单控制:【<a href="#" onclick="tree.openAll();this.blur();return false;" style="color:#333333;text-decoration:none">展开</a>】
【<a href="#" onclick="tree.closeAll();this.blur();return false;" style="color:#333333;text-decoration:none">折叠</a>】
</div>
<div class="dtree" style="margin:10px;">
<script type="text/javascript"> 
//建立新树
tree = new dTree('tree');
tree.config.target = "MainFrame";
tree.config.useCookies = false;
var selNum = -1;
var link = "";
//根目录
tree.add(0,-1,'管理中心', null, null, null, '', '');
var count = 0;
var pLevelIdArray = new Array();
pLevelIdArray[1] = 0;
var currLevel = 1;
for (var i=0; i<treeMenu.length; i++) {
	var item = treeMenu[i];
	var itemLevel = item.level;
	pLevelIdArray[itemLevel+1] = ++count;
	if (item.link!=null && item.link!="") {
		if (item.ico!=null) {
			tree.add(count, pLevelIdArray[itemLevel], item.name, item.link, null, null, item.ico, item.ico);
		} else {
			tree.add(count, pLevelIdArray[itemLevel], item.name, item.link);
		}
	} else {
		if (item.ico!=null) {
			tree.add(count, pLevelIdArray[itemLevel], item.name, null, null, null, item.ico, item.ico);
		} else {
			tree.add(count, pLevelIdArray[itemLevel], item.name);
		}
	}
	if (item.select) {
		selNum = count;
		link = item.link;
	}
}
document.write(tree);
tree.openAll();
if (selNum != -1) {
	tree.openTo(selNum,true);
	top.document.frames["MainFrame"].location.href=link;
}
</script>
</div>
</body>
</html>