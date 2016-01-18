
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
  <title>Display</title>
  <meta name="layout" content="customMain">
    <link rel="stylesheet" href="../css/customCss.css" type="text/css" />
</head>
<body>
<center>
    <div class="displayMargin" >
            <g:if test="${files}">
                <h1 class="font">Files</h1>
                 <g:link class="fontDelete" action="deleteAll" controller="edi">Delete All</g:link>
                <table>
<g:each  in="${files}" var="file">
    <tr>
                <td>
                 <p class="font">   ${file.fileName}</p>
                </td>
                <td>
                   &nbsp;&nbsp;&nbsp; <g:link class="fontEdit" action="editing" params="['filename':file.fileName]" controller="edi">Edit</g:link>
                </td>
                <td>
                    &nbsp;&nbsp;&nbsp;   <g:link class="fontDelete" action="deleting" params="['filename':file.fileName]" controller="edi">Delete</g:link>
                </td>
            </tr>
    </g:each>
 </g:if>
            <g:else>
                <h2 class="font">No Files Found!</h2>
            </g:else>
</table>

<div class="message">
    <g:paginate total="${AckFileInstanceTotal}" />
</div>
    </div>

    </center>
</body>
</html>