<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ taglib prefix='c' uri='http://java.sun.com/jstl/core_rt'%>
<%--<c:set var="ctx" value="${pageContext.request.contextPath}" />
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	String ipaddr = request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>--%>
<head>
	<script type="text/javascript" src="js/jquery.mini/jquery-3.1.1.min.js"></script>
	<title>主页</title>
	</head>

	<body>
		<h2>Hello World!</h2>
		${value}
		<form action="index/insertOrUpdate.do">
			id:<input type="text" name="id" id="testId"/><br/>
			age:<input type="text" name="age" id="testAge"/><br/>
			name:<input type="text" name="name" id="testName"/>
			<input type="submit" onclick="subJson()" value="提交"/>
		</form>
		<%--<input onclick="subJson()" type="button" value="提交json"/>--%>
		<%--<input onclick="subes()" type="button" value="提交es"/>--%>
		<script type="text/javascript">
			function subJson(){
			    var testId = document.getElementById("testId").value;
			    var testName = document.getElementById("testName").value;
                var testAge = document.getElementById("testAge").value;
			    alert("testId："+testId+",testAge:"+testAge+",testName:"+testName);
				$.post("index/index.do",{id:testId,name:testName,age:testAge},
				          function(data){
                              alert("返回数据为:id->"+data.id+",text->"+data.name);
				          }
				);
                location.reload();
			}
			
			function subes(){
				$.post("pet/index/es.do",{id:22,text:"谭峻" },
				          function(data){
					          alert(data); // John
				          }
				);
			}
		</script>
	</body>
</html>
