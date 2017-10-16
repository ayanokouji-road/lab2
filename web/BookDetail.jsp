<!--BookDetail.5.2-->
<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: wandi
  Date: 2017/10/7
  Time: 0:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Book Detail</title>
    <link rel="stylesheet" type="text/css" href="page.css">
</head>
<body>
<div class="body">
<table>
    <tr><td>ISBN</td><td><s:property value="isbn"/></td></tr>
    <tr><td>Title</td><td><s:property value="title"/></td></tr>
    <tr><td>Author ID</td><td><s:property value="authorID"/></td></tr>
    <tr><td>Publisher</td><td><s:property value="publisher"/></td></tr>
    <tr><td>Publish Date</td><td><s:property value="publishDate"/></td></tr>
    <tr><td>Price</td><td><s:property value="price"/></td></tr>
    <tr><td>Name</td><td><s:property value="name"/></td></tr>
    <tr><td>Age</td><td><s:property value="age"/></td></tr>
    <tr><td>Country</td><td><s:property value="country"/></td></tr>
</table>
</div>
</body>
</html>
