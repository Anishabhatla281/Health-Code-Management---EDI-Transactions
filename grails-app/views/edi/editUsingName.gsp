<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
  <title>File Name</title>
    <meta name="layout" content="customMain">
    <link rel="stylesheet" href="../css/customCss.css" type="text/css" />
</head>
<body>
<center>
    <g:form class="formMargin" controller="edi" action="editing" method="post">
      <g:if test="${flash.message2}">
            <div class="message" style="margin-top: -20px">${flash.message2}</div>
        </g:if>
                 <label class="name">Enter name of the file to be edited:</label>
                 <input type="text" id="filename" name="filename" onkeyup="showbutton()"/><br/> <br/>
                 <input class="font2" type="submit" value="SUBMIT"/></td>
     </g:form>
    </center>
</body>
</html>