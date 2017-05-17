<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../layout/header.jsp"%>
<link rel="stylesheet" href="${contextPath}/resources/css/mailform.css">
<meta name="_csrf" content="${_csrf.token}"/>
<meta name="_csrf_header" content="${_csrf.headerName}"/>
<style>
	#map {
		height: 300px;
		width: 400px;
	}
</style>
    
<title>Drugstore</title>

<script>
    function initMap() {
    	var location = {};
        <c:if test="${drugstore.lat!=null && drugstore.lng!=null}">
    	    location = {lat:<c:out value="${drugstore.lat}" />,
    			lng:<c:out value="${drugstore.lng}" />};
    	</c:if>
		var center = {lat: 51.1535545, lng: 71.4809837};
        var map = new google.maps.Map(document.getElementById('map'), {
          zoom: 13,
          center: !$.isEmptyObject(location)?location:center
        });
        var marker = new google.maps.Marker({
          position: location,
          map: map
        });
	}
</script>
<script async defer src="https://maps.googleapis.com/maps/api/js?key=AIzaSyD1eYhE8DgMPKw78c4t-ER7WONluE7cjkE&callback=initMap"></script>

<main>
        <section class="well1 ins2 mobile-center">
        <div class="container">
            <div class="row off2">
              <div class="grid_4">
              <div id="map"></div>
                <h3><c:out value="${drugstore.naimenovanieAptek}" /></h3>
                <p><c:out value="${drugstore.address}" /></p>
                <div>
		                  <c:forEach begin="1" end="${drugstore.rating}" varStatus="loop">
	                  		<i class="fa fa-star" aria-hidden="true" data-index="<c:out value="${loop.count}" />" style="cursor:pointer"></i>
						  </c:forEach>
						  <c:forEach begin="${drugstore.rating+1}" end="${maxRateValue}" varStatus="loop">
	                  		<i class="fa fa-star" aria-hidden="true" data-index="<c:out value="${loop.count}" />" style="color:gray;cursor:pointer"></i>
						  </c:forEach>
	                  </div>
	                  <h3>${drugstore.peopleQuantity}</h3>
              </div>
              
            </div>
            <hr>
            <div class="row off2">
            <div class="grid_6">
            	<p><spring:message code="info.youCanLeaveACommentHereAndRateTheDrugstore" /></p>
            </div>
            </div>
            <c:choose>
				<c:when test="${pageContext.request.userPrincipal == null}">
				<div class="row off2">
				<div class="grid_6">
					<p><spring:message code="info.toLeaveACommentYouHaveTo" /> <a href="${contextPath}/sign-in" style="color:#5ab7de; cursor:pointer;"><spring:message code="label.signin" /></a></p>
				</div>
				</div>
				</c:when>
				<c:otherwise>
				<div class="row off2">
				<div class="grid_12">
				<span>Цена: 
					<c:forEach begin="1" end="${maxRateValue}" varStatus="loop">
						<i class="fa fa-star priceRating" aria-hidden="true" data-index="<c:out value="${loop.count}" />" style="color:gray;cursor:pointer"></i>
					</c:forEach></span>
				</div>
				<div class="grid_12">
				<span>Наличие препаратов: 
					<c:forEach begin="1" end="${maxRateValue}" varStatus="loop">
						<i class="fa fa-star drugsAvailabilityRating" aria-hidden="true" data-index="<c:out value="${loop.count}" />" style="color:gray;cursor:pointer"></i>
					</c:forEach></span>
				</div>
				</div>
				<div class="row off2">
					<%-- <form:form id="commentForm" method="post" modelAttribute="comment" action="${contextPath}/comments/add" class="mailform off2 grid_6" style="margin-left:auto;">
		              <fieldset class="row">
		                <label class="grid_6">
		                <spring:bind path="comment">
		                  <form:textarea style="height:200px;" path="comment" rows="3" value="sdvsvs" placeholder="Message:"></form:textarea>
		                  <form:errors path="comment"></form:errors>
		                </spring:bind>
		                </label>
		                <div class="mfControls grid_4" style="float:right">
		                  <button id="commentBtn" class="btn" style="float:right"><spring:message code="label.send" /></button>
		                </div>
		              </fieldset>
					</form:form> --%>
					<form id="commentForm" method="post" action="${contextPath}/comments/add" class="mailform off2 grid_6">
		              <fieldset class="row">
		                <label class="grid_6">
		                  <textarea style="height:200px;" name="comment" rows="3" value="sdvsvs" placeholder="Message:"></textarea>
		                  
		                </label>
		                <div class="mfControls grid_4" style="float:right">
		                  <button class="btn" style="float:right"><spring:message code="label.send" /></button>
		                </div>
		              </fieldset>
					</form>
				</div>
				</c:otherwise>
			</c:choose>
			<hr>
			<div id="comments">
			<!-- <div class="row off2">
				<div class="grid_6">
					<h4>Username asdv</h4>
					<p>lore ipsum bla bla bla sfedfbujhksdjfvkwjvhuihviwf wsdjhwgfuywg jdgwuy qawjfuhqif skfuywiuh</p>
				</div>
			</div> -->
			</div>
          </div>
        </section>
       </main>
<script>
$(function(){
	
	$('.priceRating').click(function(){
		$.ajax({
		    type: 'GET',
		    url: ctx+"/rating/rate",
		    data: {price:$(this).data('index')},
		    success: function(data) {
		    	console.log(data);
		    }
	    });
	});
	
	var token = $("meta[name='_csrf']").attr("content");
	var header = $("meta[name='_csrf_header']").attr("content");
	var newCommentBlock;
	$(document).ajaxSend(function(e, xhr, options) {
	    xhr.setRequestHeader(header, token);
	});
	$("#commentForm").submit(function(e) {
		e.preventDefault();
	    var comment = $(this).serialize();
	    $.ajax({
		    type: 'POST',
		    url: ctx+"/comments/add",
		    data: comment,
		    success: function(data) {
		    	newCommentBlock = "<div class=\"row off2\"><div class=\"grid_6\"><h4>" + data.username + "</h4><p>" + data.comment + "</p></div></div>";
		    	$("#comments").prepend(newCommentBlock);
		    }
	    });
	    return false;
	});
});
</script>


<%@include file="../layout/footer.jsp"%>