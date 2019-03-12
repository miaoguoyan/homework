<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<body>
<h2>Hello World!</h2>
<a href="${pageContext.request.contextPath}/add.jsp">添加用户</a>
<table>
    <tr>
        <td>用户名</td>
        <td>密码</td>
        <td>路径</td>
        <td>操作</td>
    </tr>
    <c:forEach items="${requestScope.list}" var="user">
        <tr>
            <td>${user.username}</td>
            <td>${user.password}</td>
            <td>${user.url}</td>
            <td><a href= "${pageContext.request.contextPath}/user/download?url=${user.url}">下载</a></td>
        </tr>
    </c:forEach>
    <script>

    </script>
</table>

</body>
</html>
