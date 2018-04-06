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
<style>
    #posts {
        font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
        border-collapse: collapse;
        width: 100%;
    }

    #posts td, #posts th {
        border: 1px solid #ddd;
        padding: 8px;
    }

    #posts tr:nth-child(even){background-color: #f2f2f2;}

    #posts tr:hover {background-color: #ddd;}

    #posts th {
        padding-top: 12px;
        padding-bottom: 12px;
        text-align: left;
        background-color: #4CAF50;
        color: white;
    }
</style>
    <head>
        <title>POSTS</title>
    </head>
    <body>
        <table id="posts">
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
                        <input name="txt" type="text" style="width: 100%;">
                    </td>
                    <td>
                        <input type="image" src="res/add.png">
                    </td>
                </tr>
            </form>
        </table>
    </body>
</html>
