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
    <title>modifybook</title>
    <link rel="stylesheet" type="text/css" href="page.css">
</head>
<body>
<div class="body">
<form action="update_book">
    <table>
        <tr><td>请输入AuthorID:</td><td><input type="text" name="modifybookAuthorID"/></td></tr>
        <tr><td>请输入Publisher:</td><td><input type="text" name="modifybookPublisher"/></td></tr>
        <tr><td>请输入PublishDate:</td><td><input type="text" name="modifybookPublishDate"/></td></tr>
        <tr><td>请输入Price:</td><td><input type="text" name="modifybookPrice"></td></tr>
        <tr><td><input type="submit" value="Update" class="tablebutton"></td><td><input type="hidden" name="isbn" value="<s:property value='isbn'/>"></td></tr>
    </table>
</form>
</div>
</body>
</html>
