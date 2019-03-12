<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2019/3/11
  Time: 19:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>添加用户</h2>
<form method="post" action="${pageContext.request.contextPath}/user/add" enctype="multipart/form-data">
    用户名：<input name="username"/><br/>
    密码：<input name="password"/><br/>
    文件：<input name="file" type="file"/><br/>
    <input type="submit" value="提交">
</form>

</body>
</html>
