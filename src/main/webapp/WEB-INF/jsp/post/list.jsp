<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Posts</title>
</head>
<form>
    <h1>Posts</h1>
    <a href="/posts/add">Add post</a><br/>
    <form method="get" action="/posts"/>
    <input type="text" name="content"/>
    <input type="submit" value="szukaj"/>
</form>
<c:forEach var="post" items="${posts}">
    <c:out value="${post.title}"/><a href="/posts/edit/${post.id}">Edit Post</a><br/>
</c:forEach>
</body>
</html>
