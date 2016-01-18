<%--
  Created by IntelliJ IDEA.
  User: anisbhat
  Date: 29/2/12
  Time: 3:05 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="customMain">
    <title>Success</title>
    <link rel="stylesheet" href="../css/customCss.css" type="text/css" />
</head>
<body>
<center>
<div class="formMargin">
<g:if test="${flash.message}">
    <div class="message">${flash.message}</div>
</g:if>

    </center>
</center>
</body>
</html>