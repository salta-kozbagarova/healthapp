<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@include file="../layout/header.jsp"%>


<p>Welcome ${pageContext.request.userPrincipal.name}!</p>

<form id="logoutForm" method="POST" action="${contextPath}/logout">
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
</form>
<a onclick="document.forms['logoutForm'].submit()"><span style="padding-right:5px" class="glyphicon glyphicon-log-in"></span><spring:message code="label.logout" /></a>
<%@include file="../layout/footer.jsp"%>