<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@include file="../layout/header.jsp"%>
<link rel="stylesheet" href="${contextPath}/resources/css/mailform.css">

<main>

<section class="well1">
<div class="container">
	<div class="row off2">
	<div class="grid_6">
		<form:form id="generalForm" method="POST" modelAttribute="user" class="mailform off2" action="${contextPath}/update-profile">
        <form:input type="hidden" path="id"></form:input>
      	<label class="grid_4" style="margin-left:auto;">
      	<spring:bind path="email">
       	<spring:message code="user.email" var="emailPlaceholder" />
           <div class="form-group ${status.error ? 'has-error' : ''}">
	          <form:input type="email" path="email" placeholder="${emailPlaceholder }" style="color:black;"></form:input>
	          <form:errors path="email"></form:errors>
          </div>
        </spring:bind>
        </label>
        <label class="grid_4" style="margin-left:auto;">
        <div style="height:10px">
      	</div>
      	</label>
      	<label class="grid_4" style="margin-left:auto;">
      	<spring:bind path="username">
       	<spring:message code="user.username" var="usernamePlaceholder" />
           <div class="form-group ${status.error ? 'has-error' : ''}">
	          <form:input type="text" path="username" placeholder="${usernamePlaceholder }" style="color:black;"></form:input>
	          <form:errors path="username"></form:errors>
          </div>
        </spring:bind>
        </label>
      	<label class="grid_4" style="margin-left:auto;">
        <div style="height:10px">
      	</div>
      	</label>
        <label class="grid_4" style="margin-left:auto;">
        <div class="form-group">
        <a onclick="document.forms['generalForm'].submit()" style="font-size:18px;color:#5ab7de; cursor:pointer;float:right;">save</a>
        </div>
        </label>
    </form:form>
    </div>
	</div>
	<div class="row off2">
	<div class="grid_6">
		<form:form id="passwordForm" method="POST" modelAttribute="passwordForm" class="mailform off2" action="${contextPath}/set-password?id=${user.id }">
		<label class="grid_4" style="margin-left:auto;">
        <spring:bind path="password">
       	<spring:message code="user.password" var="passwordPlaceholder" />
           <div class="form-group ${status.error ? 'has-error' : ''}">
	          <form:input type="password" path="password" placeholder="${passwordPlaceholder }"></form:input>
	          <form:errors path="password"></form:errors>
          </div>
        </spring:bind>
        </label>
        <label class="grid_4" style="margin-left:auto;">
        <div style="height:10px">
      	</div>
      	</label>
      	<label class="grid_4" style="margin-left:auto;">
        <spring:bind path="confirmPassword">
       	<spring:message code="user.confirmPassword" var="confirmPasswordPlaceholder" />
           <div class="form-group ${status.error ? 'has-error' : ''}">
	          <form:input type="password" path="confirmPassword" placeholder="${confirmPasswordPlaceholder }"></form:input>
	          <form:errors path="confirmPassword"></form:errors>
          </div>
        </spring:bind>
        </label>
        <label class="grid_4" style="margin-left:auto;">
        <div class="form-group">
        <a onclick="document.forms['passwordForm'].submit()" style="font-size:18px;color:#5ab7de; cursor:pointer;float:right;">save</a>
        </div>
        </label>
		</form:form>
</div>
</section>
</main>
<%@include file="../layout/footer.jsp"%>