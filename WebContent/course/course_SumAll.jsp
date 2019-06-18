<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
	<meta http-equiv="content-type" content="text/html;charset=UTF-8">
	<link rel="stylesheet" type="text/css" href="../css/default.css" />
<style type="text/css">
* {
    background: none repeat scroll 0 0 transparent;
    border: 0 none;
    margin: 0;
    padding: 0;
    vertical-align: baseline;
	font-family:微软雅黑;
	overflow:hidden;
}
#navi{
	width:100%;
	position:relative;
	word-wrap:break-word;
	border-bottom:1px solid #065FB9;
	margin:0;
	padding:0;
	height:40px;
	line-height:40px;
	vertical-align:middle;
    background-image: -moz-linear-gradient(top,#EBEBEB, #BFBFBF);
    background-image: -webkit-gradient(linear, left top, left bottom, color-stop(0, #EBEBEB),color-stop(1, 
#BFBFBF));
}
#naviDiv{
	font-size:14px;
	color:#333;
	padding-left:10px;
}
#tips{
	margin-top:10px;
	width:100%;
	height:40px;
}
#buttonGroup{
	padding-left:10px;
	float:left;
	height:35px;
}
.button{
	float:left;
	margin-right:10px;
	padding-left:10px;
	padding-right:10px;
	font-size:14px;
	width:70px;
	height:30px;
	line-height:30px;
	vertical-align:middle;
	text-align:center;
	cursor:pointer;
    border-color: #77D1F6;
    border-width: 1px;
    border-style: solid;
    border-radius: 6px 6px;
    -moz-box-shadow: 2px 2px 4px #282828;
    -webkit-box-shadow: 2px 2px 4px #282828;
    background-image: -moz-linear-gradient(top,#EBEBEB, #BFBFBF);
    background-image: -webkit-gradient(linear, left top, left bottom, color-stop(0, #EBEBEB),color-stop(1, #BFBFBF));
}
#mainContainer{
	padding-left:10px;
	padding-right:10px;
	text-align:center;
	width:98%;
	font-size:12px;
}
</style>
<body>
<div id="navi">
	<div id='naviDiv'>
		<span><img src="../images/arror.gif" width="7" height="11" border="0" alt=""></span>&nbsp;课程管理<span>&nbsp;
		<span><img src="../images/arror.gif" width="7" height="11" border="0" alt=""></span>&nbsp;<a href="<%=path%>/course/Course_query.action">课程列表</a><span>&nbsp;
	</div>
</div>
<div id="tips">
	<div id="buttonGroup">
		<div class="button" onmouseout="this.style.backgroundColor='';this.style.fontWeight='normal'" onmouseover="this.style.backgroundColor='#77D1F6';this.style.fontWeight='bold'">
			<a href="<%=path%>/course/course_add.jsp">上传总结汇报</a>
		</div>
	</div>
</div>
<div id="mainContainer">
<!-- 从session中获取学生集合 -->

<table class="default" width="100%">

	<tr class="title">
		<td>教师姓名</td>
		<td>教学成果汇报文件</td>
		<td>上传日期</td>
		<td>操作</td>
	</tr>
	<tr class="list">
		<td>leon</td>
		<td><a href="http://localhost:8080/TeachersHelper/1.doc" download="教学成果汇报文件.doc">教学成果汇报文件</a></td>
		<td>2019年1月20日</td>
		<td><a>删除</a></td>
	</tr>
<%-- 	<s:iterator value="#session.course_list" var="cs">
	<tr class="list">
		<td><a href="<%=path%>/course/Course_queryByCoursename.action?csname=<s:property value='#cs.csname'/>"><s:property value="#cs.csname"/></a></td>
		<td><a href="<%=path%>/course/Course_queryByClassroom.action?cscn=<s:property value='#cs.cscn'/>"><s:property value="#cs.cscn"/></a></td>
		<td><a href="<%=path%>/course/Course_queryByTeachername.action?ctn=<s:property value='#cs.ctn'/>"><s:property value="#cs.ctn"/></a></td>
		<td><a href="<%=path%>/course/Course_delete.action?csid=<s:property value="#cs.csid"/> " onclick="javascript: return confirm('真的要删除吗？');">删除</a></td>
		<td><a href="<%=path%>/students/Students_queryByClassroom.action?address=<s:property value='#cla.cname'/>"><s:property value="#cla.cname"/></a></td>
		<td><a href="<%=path%>/classroom/Classroom_delete.action?cid=<s:property value="#cla.cid"/> " onclick="javascript: return confirm('真的要删除吗？');">删除</a></td>
	</tr>
	</s:iterator> --%>
	
	<!-- 遍历开始 -->

<!-- 	<tr class="list">
		<td>java</td>
		<td>15软本1</td>
		<td>张三</td>
	</tr>
	<tr class="list">
		<td>php</td>
		<td>15软本2</td>
		<td>李四</td>
	</tr> -->
	<!-- 遍历结束 -->
</table>
</div>
</body>
</html>