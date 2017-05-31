<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../layout/header.jsp"%>
<link rel="stylesheet" href="${contextPath}/resources/css/mailform.css">
<meta name="_csrf" content="${_csrf.token}"/>
<meta name="_csrf_header" content="${_csrf.headerName}"/>
<style>
	#map {
		height: 400px;
		width: auto;
	}
</style>
    
<title><spring:message code="label.polyclinic" /></title>

<script>
    function initMap() {
    	var location = {};
        <c:if test="${polyclinic.lat!=null && polyclinic.lng!=null}">
    	    location = {lat:<c:out value="${polyclinic.lat}" />,
    			lng:<c:out value="${polyclinic.lng}" />};
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

<main class="mobile-center">
        <section>
        <div class="container hr well1 ins2">
            <div class="row">
              <div class="grid_6">
              	<div id="map"></div>
              </div>
              <div class="grid_6">
	              <h4><c:out value="${polyclinic.organizationName}" /></h4>
	              <div class="row">
                  <div class="grid_3">
                    <dl class="info">
                      <dt><spring:message code="polyclinic.name" /></dt>
                      <dd><c:out value="${polyclinic.organizationName}" /></dd>
                      <dt><spring:message code="polyclinic.address" /></dt>
                      <dd><c:out value="${polyclinic.address}" /></dd>
                      <dt><spring:message code="polyclinic.siteAddress" /></dt>
                      <dd><c:out value="${polyclinic.siteAddress}" /></dd>
                      <dt><spring:message code="polyclinic.phonenumber" /></dt>
                      <dd><c:out value="${polyclinic.phonenumber}" /></dd>
                      <dt><spring:message code="polyclinic.headName" /></dt>
                      <dd><c:out value="${polyclinic.headName}" /></dd>
                      <dt><spring:message code="polyclinic.visitTime" /></dt>
                      <dd><c:out value="${polyclinic.visitTime}" /></dd>
                    </dl>
                  </div>
                  <div class="grid_3">
                  	<div style="text-align:center"><p><spring:message code="polyclinicRating.price" /></p></div>
                    <div style="text-align:center">
	                  <c:forEach begin="1" end="${polyclinic.priceRating}" varStatus="loop">
                  		<i class="fa fa-star" aria-hidden="true"></i>
					  </c:forEach>
					  <c:forEach begin="${polyclinic.priceRating+1}" end="${maxRateValue}" varStatus="loop">
                  		<i class="fa fa-star" aria-hidden="true" style="color:gray;"></i>
					  </c:forEach>
                  	</div>
                  	<div style="text-align:center">
                  		<h3>${polyclinic.priceCount}</h3>
                  	</div>
                  	<div style="text-align:center"><p><spring:message code="polyclinicRating.service" /></p></div>
                    <div style="text-align:center">
	                  <c:forEach begin="1" end="${polyclinic.serviceRating}" varStatus="loop">
                  		<i class="fa fa-star" aria-hidden="true"></i>
					  </c:forEach>
					  <c:forEach begin="${polyclinic.serviceRating+1}" end="${maxRateValue}" varStatus="loop">
                  		<i class="fa fa-star" aria-hidden="true" style="color:gray;"></i>
					  </c:forEach>
                  	</div>
                  	<div style="text-align:center">
                  		<h3>${polyclinic.serviceCount}</h3>
                  	</div>
                  </div>
               	  </div>
              </div>
            </div>
        </div>
        </section>
        <section class="well1 ins3">
          	<div class="container">
            <div class="row off1">
            <div class="grid_6">
            	<p><spring:message code="info.youCanLeaveACommentHereAndRateThePolyclinic" /></p>
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
				<span><spring:message code="polyclinicRating.price" />
					<c:forEach begin="1" end="${polyclinic.curUserPriceRating}" varStatus="loop">
                 		<i class="fa fa-star priceRating" aria-hidden="true" data-index="<c:out value="${loop.index}" />" style="cursor:pointer"></i>
				  	</c:forEach>
				  	<c:forEach begin="${polyclinic.curUserPriceRating+1}" end="${maxRateValue}" varStatus="loop">
                 		<i class="fa fa-star priceRating" aria-hidden="true" data-index="<c:out value="${loop.index}" />" style="color:gray;cursor:pointer"></i>
				  	</c:forEach></span>
				</div>
				<div class="grid_12">
				<span><spring:message code="polyclinicRating.service" />
					<c:forEach begin="1" end="${polyclinic.curUserServiceRating}" varStatus="loop">
                 		<i class="fa fa-star serviceRating" aria-hidden="true" data-index="<c:out value="${loop.index}" />" style="cursor:pointer"></i>
				  	</c:forEach>
				  	<c:forEach begin="${polyclinic.curUserServiceRating+1}" end="${maxRateValue}" varStatus="loop">
                 		<i class="fa fa-star serviceRating" aria-hidden="true" data-index="<c:out value="${loop.index}" />" style="color:gray;cursor:pointer"></i>
				  	</c:forEach></span>
				</div>
				</div>
				<div class="row off2">
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
			<div class="row off2">
				<div class="grid_6">
				<div id="comments">
				</div>
				<div id="moreComments" style="cursor:pointer; text-align:center">
				</div>
				</div>
			</div>
          </div>
        </section>
       </main>
<script>
$(function(){
	var page = 0;
	loadComments();
	function loadComments(){
		var id = ${polyclinic.id};
		$.ajax({
		    type: 'GET',
		    url: ctx+"/polyclinic/comments",
		    dataType: 'json',
		    contentType: 'application/json',
		    data: {id:id,pageNumber:page},
		    success: function(response) {
		    	if((response.totalPages-1)>page){
		    		page = response.number+1;
		    		var leftComments;
		    		if((page+1)==response.totalPages){
		    			leftComments = response.totalElements%response.size;
		    		} else{
		    			leftComments = response.size;//response.totalElements - (page*response.size);
		    		}
		    		$('#moreComments').html('');
		    		$('#moreComments').append("<p>еще "+leftComments+"</p>");
		    	} else{
		    		$('#moreComments').html('');
		    	}
		    	var cmntArr = response.content;
		    	$.each(cmntArr,function(i){
		    		var cmnt = cmntArr[i];
		    		newCommentBlock = "<div class=\"row off2\"><div class=\"grid_6\"><h4>" + cmnt.user.username + "</h4><p>" + cmnt.comment + "</p><p>" + cmnt.formattedDate + "</p></div></div>";
			    	$("#comments").append(newCommentBlock);
		    	});
		    }
	    });
	}
	$('#moreComments').click(function(){loadComments()});
	
	$('.priceRating').click(function(){
		var rateNum = $(this).data('index');
		$.ajax({
		    type: 'GET',
		    url: ctx+"/polyclinic/rate-price",
		    data: {id:${polyclinic.id},price:rateNum},
		    success: function(response) {
		    	if(response==='success'){
		    		$('.priceRating').each(function(index){
		    			if(index<rateNum){
		    				$(this).css('color','');
		    			}else{
		    				$(this).css('color','gray');
		    			}
		    		});
		    	}
		    }
	    });
	});
	
	$('.serviceRating').click(function(){
		var rateNum = $(this).data('index');
		$.ajax({
		    type: 'GET',
		    url: ctx+"/polyclinic/rate-service",
		    data: {id:${polyclinic.id},service:rateNum},
		    success: function(response) {
		    	if(response==='success'){
		    		$('.serviceRating').each(function(index){
		    			if(index<rateNum){
		    				$(this).css('color','');
		    			}else{
		    				$(this).css('color','gray');
		    			}
		    		});
		    	}
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
		    url: ctx+"/polyclinic/leave-a-comment?polyclinicId="+${polyclinic.id},
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