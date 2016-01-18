<%--
  Created by IntelliJ IDEA.
  User: anisbhat
  Date: 5/3/12
  Time: 10:37 AM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
  <title>Edit</title>
    <meta name="layout" content="customMain">
</head>
<body>
<center>
 <div class="displayMargin">
<g:hasErrors bean="${ackFile}">
    <div class="errors">  <h3 class="font">Errors</h3>
        <g:renderErrors class="font" bean="${ackFile}" as="list" />
    </div>
</g:hasErrors>
  <g:form action="change" method="post">
      <table>
       <h2 class="font">${ackFile.fileName}</h2>
      <g:if test="${ackFile.stCode!=null}">
      <tr>
      <td valign="top">
      <span class="font">ST Code:</span>
      </td>
      <td valign="top">
      <g:textField  name="stCode" value="${ackFile.stCode}" readonly="true" />
      </td>
      </tr>
      </g:if>
      <g:if test="${ackFile.funcIdentifierCode!=null}">
      <tr>
      <td valign="top">
          <span class="font">Functional Identifier Code:</span>
      </td>
      <td valign="top">
      <g:textField name="funcIdentifierCode" value="${ackFile.funcIdentifierCode}"/>
      </td>
      </tr>
      </g:if>
      <g:if test="${ackFile.versionCustom!=null}">
      <tr>
      <td valign="top">
          <span class="font">Version/Industry Identifier Code:</span>
      </td>
      <td valign="top">
      <g:textField name="versionCustom" value="${ackFile.versionCustom}"/>
      </td>
      </tr>
      </g:if>
      <g:if test="${ackFile.transIdentifierCode!=null}">
      <tr>
      <td valign="top">
     <span class="font"> Transaction Set Identifier Code:</span>
      </td>
      <td valign="top">
      <g:textField name="transIdentifierCode" value="${ackFile.transIdentifierCode}"/>
      </td>
      </tr>
      </g:if>
      <g:if test="${ackFile.idCode!=null}">
      <tr>
      <td valign="top">
      <span class="font">Segment ID Code:</span>
      </td>
      <td valign="top">
      <g:textField name="idCode" value="${ackFile.idCode}"/>
      </td>
      </tr>
      </g:if>
      <g:if test="${ackFile.transPos!=null}">
      <tr>
      <td valign="top">
      <span class="font">Segment Position in Transaction Set:</span>
      </td>
      <td valign="top">
      <g:textField name="transPos" value="${ackFile.transPos}"/>
      </td>
      </tr>
      </g:if>
      <g:if test="${ackFile.errorCode!=null}">
      <tr>
      <td valign="top">
      <span class="font">Segment Syntax Error Code:</span>
      </td>
      <td valign="top">
      <g:select name="errorCode" from="${['1','2','3','4','5','6','7','8']}" value="${errorCode}"/>
      </td>
      </tr>
      </g:if>
       <g:if test="${ackFile.dataPos!=null}">
      <tr>
      <td valign="top">
      <span class="font">Segment Position:</span>
      </td>
      <td valign="top">
      <g:textField name="dataPos" value="${ackFile.dataPos}"/>
      </td>
      </tr>
      </g:if>
      <g:if test="${ackFile.dataElementPos!=null}">
      <tr>
      <td valign="top">
      <span class="font">Element Position in Segment:</span>
      </td>
      <td valign="top">
      <g:textField name="dataElementPos" value="${ackFile.dataElementPos}"/>
      </td>
      </tr>
      </g:if>
      <g:if test="${ackFile.dataElementRef!=null}">
      <tr>
      <td valign="top">
      <span class="font">Data Element Reference Number:</span>
      </td>
      <td valign="top">
      <g:select name="dataElementRef" from="${['1','2','3','4','5','6','7','8','9','10','12','13']}" value="${dataRefNumber}"/>
      </td>
      </tr>
      </g:if>
      <g:if test="${ackFile.ackCode!=null}">
      <tr>
      <td valign="top">
      <span class="font">Transaction Set Acknowledgment Code:</span>
      </td>
      <td valign="top">
      <g:select name="ackCode" from="${['A','E','M','R','W','X']}" value="${transAckCode}"/>
      </td>
      </tr>
      </g:if>
      <g:if test="${ackFile.transErrorCode!=null}">
      <tr>
      <td valign="top">
     <span class="font">Implementation Transaction Set Syntax Error Code:</span>
      </td>
      <td valign="top">
      <g:select name="transErrorCode" from="${['1','2','3','4','5','6','7','8','9','10','11','12','13','15','16','17','18','19','23','24','25','26','27']}" value="${transErrorCode}"/>
       </td>
      </tr>
      </g:if>
      <g:if test="${ackFile.funcAckCode!=null}">
      <tr>
      <td valign="top">
     <span class="font">Functional Group Acknowledge Code:</span>
      </td>
      <td valign="top">
      <g:select name="funcAckCode" from="${['A','E','M','P','R','W','X']}" value="${fAckCode}"/>
      </td>
      </tr>
      </g:if>
      <g:if test="${ackFile.transSets!=null}">
      <tr>
      <td valign="top">
      <span class="font">Number Of Transaction Sets Included:</span>
      </td>
      <td valign="top">
      <g:textField name="transSets" value="${ackFile.transSets}"/>
      </td>
      </tr>
      </g:if>
      <g:if test="${ackFile.recSets!=null}">
      <tr >
      <td valign="top">
     <span class="font">Number Of Received Transaction Sets</span>
      </td>
      <td valign="top">
      <g:textField name="recSets" value="${ackFile.recSets}"/>
      </td>
      </tr>
      </g:if>
      <g:if test="${ackFile.accSets!=null}">
      <tr >
      <td valign="top">
     <span class="font">Number Of Accepted Transaction Sets:</span>
      </td>
      <td valign="top">
      <g:textField name="accSets" value="${ackFile.accSets}"/>
      </td>
      </tr>
      </g:if>
      </table>
      <input class="font2" type="submit" name="submit" value="SUBMIT"/>
      </g:form>
 </div>

</center>
</body>
</html>