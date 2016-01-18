<%@ page import="editransactions.TransAckCode" %>



<div class="fieldcontain ${hasErrors(bean: transAckCodeInstance, field: 'code', 'error')} ">
	<label for="code">
		<g:message code="transAckCode.code.label" default="Code" />
		
	</label>
	<g:textField name="code" value="${transAckCodeInstance?.code}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: transAckCodeInstance, field: 'description', 'error')} ">
	<label for="description">
		<g:message code="transAckCode.description.label" default="Description" />
		
	</label>
	<g:textField name="description" value="${transAckCodeInstance?.description}"/>
</div>

