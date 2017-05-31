<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <link rel="icon" href="${contextPath}/resources/images/favicon.ico" type="image/x-icon">
    <link rel="stylesheet" href="${contextPath}/resources/css/grid.css">
    <link rel="stylesheet" href="${contextPath}/resources/css/style.css">
    <link rel="stylesheet" href="${contextPath}/resources/css/camera.css">
    <link rel="stylesheet" href="${contextPath}/resources/css/owl-carousel.css">
    <script>var ctx = "${contextPath}"</script>
    <script src="${contextPath}/resources/js/jquery.js"></script>
    <script src="${contextPath}/resources/js/jquery-migrate-1.2.1.js"></script><!--[if lt IE 9]>
    <html class="lt-ie9">
      <div style="clear: both; text-align:center; position: relative;"><a href="http://windows.microsoft.com/en-US/internet-explorer/.."><img src="${contextPath}/resources/images/ie8-panel/warning_bar_0000_us.jpg" border="0" height="42" width="820" alt="You are using an outdated browser. For a faster, safer browsing experience, upgrade for free today."></a></div>
    </html>
    <script src="${contextPath}/resources/js/html5shiv.js"></script><![endif]-->
    <script src="${contextPath}/resources/js/device.min.js"></script>
</head>
<body>
<div class="page">
<!--
      ========================================================
      							HEADER
      ========================================================
      
      
      -->
      <header>
        <div class="container">
          <div class="brand">
            <h1 class="brand_name"><a href="./">Health</a></h1>
            <p class="brand_slogan">App</p>
          </div>
          <c:choose>
			<c:when test="${pageContext.request.userPrincipal == null}">
				<p><a href="${contextPath}/sign-in" style="color:#5ab7de; cursor:pointer;"><spring:message code="label.signin" /><i class="fa-sign-in"></i></a></p>
			</c:when>
			<c:otherwise>
				<p><a href="${contextPath}/profile" style="color:#5ab7de; cursor:pointer;">${pageContext.request.userPrincipal.name }</a></p>
			</c:otherwise>
		  </c:choose>
          
        </div>
        <div id="stuck_container" class="stuck_container">
          <div class="container">
            <nav class="nav">
              <ul data-type="navbar" class="sf-menu">
                <li><a href="${contextPath}/home"><spring:message code="page.home"/></a>
                </li>
                <li><a onclick="return false;"><spring:message code="page.drugstoresAndMedicalFacilities"/></a>
                  <ul>
                    <li><a href="${contextPath}/places/drugstores"><spring:message code="page.drugstores"/></a></li>
                    <li><a href="${contextPath}/places/hospitals"><spring:message code="page.hospitals"/></a></li>
                    <li><a href="${contextPath}/places/polyclinics"><spring:message code="page.polyclinics"/></a></li>
                    <li><a href="${contextPath}/places/medical-centers"><spring:message code="page.medicalCenters"/></a></li>
                  </ul>
                </li>
                <li><a href="index-2.html">Services</a>
                </li>
                <li><a href="index-3.html">FAQS</a>
                </li>
                <li><a href="index-4.html">Contacts</a>
                </li>
              </ul>
            </nav>
          </div>
        </div>
        <script>
        $(".nav a").on("click", function(){
       	   $(".nav").find(".active").removeClass("active");
       	   $(this).parent().addClass("active");
       	});
        </script>
      </header>
      
