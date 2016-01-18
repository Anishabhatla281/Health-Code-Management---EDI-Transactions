<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Upload File</title>
    <meta name="layout" content="customMain">

</head>
<body>
       <center>
<g:uploadForm class="formMargin" action="upload" method="post" >
    <g:if test="${flash.message1}">
        <div class="message" style="margin-top: -20px;">${flash.message1}</div>
    </g:if>
    <g:hasErrors bean="${ackFileInstance}">
        <div class="errors">
            <g:renderErrors bean="${ackFileInstance}" as="list" />
        </div>
    </g:hasErrors>
            <label class="name">Select .txt/.dat/.edi File:</label> &nbsp;
            <input type="file" id="file1" name="file1"/><br/><br/>
            <input align="center" class="font2" type="submit" value="SUBMIT"/>
</g:uploadForm>
       </center>

</div>
</body>
</html>