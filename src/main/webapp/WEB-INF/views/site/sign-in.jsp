<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../layout/header.jsp"%>
<link rel="stylesheet" href="${contextPath}/resources/css/mailform.css">
<main>

<section class="well1">
  <div class="container">
  <div class="grid_4" style="margin:auto;float:none;">
    <h2><spring:message code="label.signin" /></h2>
    <form method="POST" action="${contextPath}/login" class="mailform off2">
      <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
      	<label class="grid_4" style="margin-left:auto;">
      	<spring:message code="user.username" var="usernamePlaceholder" />
          <input type="text" name="username" placeholder="${usernamePlaceholder }">
        </label>
      	<label class="grid_4" style="margin-left:auto;">
        <div style="height:10px">
      	</div>
      	</label>
        <label class="grid_4" style="margin-left:auto;">
        <spring:message code="user.password" var="passwordPlaceholder" />
          <input type="password" name="password" placeholder="${passwordPlaceholder }">
        </label>
        <c:if test="${not empty error}">
			<div class="error">${error}</div>
		</c:if>
		<c:if test="${not empty message}">
			<div class="msg">${message}</div>
		</c:if>
        <div class="mfControls grid_12" style="margin-left:auto;">
          <button type="submit" class="btn"><spring:message code="label.signin" /></button>
        </div>
    </form>
    </div>
  </div>
</section>
</main>


<%@include file="../layout/footer.jsp"%>