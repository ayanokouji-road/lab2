<!--addnewbook.5.2-->
<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: wandi
  Date: 2017/10/6
  Time: 2:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>add new final_action_package.Book</title>
    <link rel="stylesheet" type="text/css" href="page.css">
</head>
<body>
<div class="body">
<h1>填写新加入的图书的信息（最后三项可不填）</h1>
<form action="addnewbook_information" method="post" enctype="multipart/form-data">
    <table>
        <tr><td>Title</td><td><input type="text" name="newbookTitle" /></td></tr>
        <tr><td>AuthorID</td><td><input type="text" name="newbookAuthorID" /></td></tr>
        <tr><td>Publisher</td><td><input type="text" name="newbookPublisher" /></td></tr>
        <tr><td>PublishDate</td><td><input type="text" name="newbookPublishDate" /></td></tr>
        <tr><td>newbookPrice</td><td><input type="text" name="newbookPrice" /></td></tr>
        <tr><td>newbookName</td><td><input type="text" name="newbookName" /></td></tr>
        <tr><td>newbookAge</td><td><input type="text" name="newbookAge" /></td></tr>
        <tr><td>newbookCountry</td><td><input type="text" name="newbookCountry" /></td></tr>
        <tr><td><input type="submit" class="tablebutton" value="add"/></td></tr>
    </table>
</form>
</div>
</body>
</html>
