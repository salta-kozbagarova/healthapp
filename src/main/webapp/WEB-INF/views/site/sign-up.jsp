<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../layout/header.jsp"%>
<link rel="stylesheet" href="${contextPath}/resources/css/mailform.css">

<main>
<section class="well1">
  <div class="container">
  <div class="grid_4" style="margin:auto;float:none;">
    <h2><spring:message code="label.signup" /></h2>
    <form:form method="POST" modelAttribute="user" class="mailform off2" action="${contextPath}/sign-up">
      
      	<label class="grid_4" style="margin-left:auto;">
      	<spring:bind path="email">
       	<spring:message code="user.email" var="emailPlaceholder" />
           <div class="form-group ${status.error ? 'has-error' : ''}">
	          <form:input type="email" path="email" placeholder="${emailPlaceholder }"></form:input>
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
	          <form:input type="text" path="username" placeholder="${usernamePlaceholder }"></form:input>
	          <form:errors path="username"></form:errors>
          </div>
        </spring:bind>
        </label>
      	<label class="grid_4" style="margin-left:auto;">
        <div style="height:10px">
      	</div>
      	</label>
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
        <div class="mfControls grid_12" style="margin-left:auto;">
          <button type="submit" class="btn"><spring:message code="label.signup" /></button>
        </div>
      
    </form:form>
    </div>
  </div>
</section>
</main>



<%@include file="../layout/footer.jsp"%>