<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: theto
  Date: 03.10.2017
  Time: 19:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
    <head>
        <title>POSTS</title>
    </head>
    <body>
        <table>
            <c:forEach items = "${requestScope.posts}" var = "post">
                <tr>
                    <td>${post.id}</td>
                    <td>${post.txt}</td>
                    <td>
                        <a href="/delete?id=${post.id}">
                            <img src="res/delete.png"/>
                        </a>
                    </td>
                </tr>
            </c:forEach>
            <form action="/add" method="POST">
                <tr>
                    <td colspan="2">
                        <input name="txt" type="text">
                    </td>
                    <td>
                        <input text="ADD" type="submit">
                    </td>
                </tr>
            </form>
        </table>
    </body>
</html>
