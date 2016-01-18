<%--
  Created by IntelliJ IDEA.
  User: anisbhat
  Date: 6/3/12
  Time: 10:54 AM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="customMain">
  <title>Delete</title>
    <script type="text/javascript" src="<%=application.getContextPath()%>/js/jquery-1.7.1.js"></script>
    <link rel="stylesheet" href="../css/customCss.css" type="text/css" />
</head>
<body>
<center>
<g:form class="formMargin" controller="edi" action="deleting" method="post">
    <g:if test="${flash.message3}">
        <div class="message" style="margin-top: -20px;">${flash.message3}</div>
    </g:if>
            <label class="name">Enter name of the file to be deleted:</label> &nbsp;
            <input type="text" id="filename" name="filename" onchange="showButton()"/><br/> <br/>
            <input class="font2" type="submit" value="SUBMIT"/>
</g:form>
</center>

</body>
</html>