<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: wandi
  Date: 2017/10/7
  Time: 9:57
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
<h1>存在这个作者，查询成功!</h1>
<h2>搜索结果如下:</h2>
<table width="400">
    <tr><td class="title">标题</td><td class="title">删除</td><td class="title">修改</td></tr>
    <s:iterator value="titleList" status="it">
    <tr><td><s:a href="/book_detail?title=%{top}"><s:property/></s:a></td>
        <td><s:a href="/book_delete?isbn=%{isbnList[#it.index]}"><input type="button" value="delete"/></s:a></td>
        <td><s:a href="/book_update_select?isbn=%{isbnList[#it.index]}"><input type="button" value="modify"/></s:a></td></tr>
    </s:iterator>
</div>
</body>
</html>
