<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: wandi
  Date: 2017/10/6
  Time: 2:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="page.css">

</head>
<body>
<div class="body">
<h1>请输入你要查询的作家名字</h1>

<form action="query_information" method="post" enctype="multipart/form-data">
    <input type="text" name="queryAuthorID" class="inputtext" /><br />
    <input type="submit" value="search" class="button"/>
</form>
</div>
</body>
</html>