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
    
<title><spring:message code="label.drugstore" /></title>

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

<main class="mobile-center">
        <section>
        <div class="container hr well1 ins2">
            <div class="row">
              <div class="grid_6">
              	<div id="map"></div>
              </div>
              <div class="grid_6">
	              <h2><c:out value="${drugstore.naimenovanieAptek}" /></h2>
	              <div class="row">
                  <div class="grid_3">
                    <dl class="info">
                      <dt>Name</dt>
                      <dd><c:out value="${drugstore.naimenovanieAptek}" /></dd>
                      <dt>Address</dt>
                      <dd><c:out value="${drugstore.address}" /></dd>
                    </dl>
                  </div>
                  <div class="grid_3">
                  	<div style="text-align:center"><p><spring:message code="drugstoreRating.price" /></p></div>
                    <div style="text-align:center">
	                  <c:forEach begin="1" end="${drugstore.priceRating}" varStatus="loop">
                  		<i class="fa fa-star" aria-hidden="true" style="cursor:pointer"></i>
					  </c:forEach>
					  <c:forEach begin="${drugstore.priceRating+1}" end="${maxRateValue}" varStatus="loop">
                  		<i class="fa fa-star" aria-hidden="true" style="color:gray;cursor:pointer"></i>
					  </c:forEach>
                  	</div>
                  	<div style="text-align:center">
                  		<h3>${drugstore.priceCount}</h3>
                  	</div>
                  	<div style="text-align:center"><p><spring:message code="drugstoreRating.drugsAvailability" /></p></div>
                    <div style="text-align:center">
	                  <c:forEach begin="1" end="${drugstore.drugsAvailabilityRating}" varStatus="loop">
                  		<i class="fa fa-star" aria-hidden="true" style="cursor:pointer"></i>
					  </c:forEach>
					  <c:forEach begin="${drugstore.drugsAvailabilityRating+1}" end="${maxRateValue}" varStatus="loop">
                  		<i class="fa fa-star" aria-hidden="true" style="color:gray;cursor:pointer"></i>
					  </c:forEach>
                  	</div>
                  	<div style="text-align:center">
                  		<h3>${drugstore.drugsAvailabilityCount}</h3>
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
				<span><spring:message code="drugstoreRating.price" />
					<c:forEach begin="1" end="${drugstore.curUserPriceRating}" varStatus="loop">
                 		<i class="fa fa-star priceRating" aria-hidden="true" data-index="<c:out value="${loop.index}" />" style="cursor:pointer"></i>
				  	</c:forEach>
				  	<c:forEach begin="${drugstore.curUserPriceRating+1}" end="${maxRateValue}" varStatus="loop">
                 		<i class="fa fa-star priceRating" aria-hidden="true" data-index="<c:out value="${loop.index}" />" style="color:gray;cursor:pointer"></i>
				  	</c:forEach></span>
				</div>
				<div class="grid_12">
				<span><spring:message code="drugstoreRating.drugsAvailability" />
					<c:forEach begin="1" end="${drugstore.curUserDrugsAvailabilityRating}" varStatus="loop">
                 		<i class="fa fa-star drugsAvailabilityRating" aria-hidden="true" data-index="<c:out value="${loop.index}" />" style="cursor:pointer"></i>
				  	</c:forEach>
				  	<c:forEach begin="${drugstore.curUserDrugsAvailabilityRating+1}" end="${maxRateValue}" varStatus="loop">
                 		<i class="fa fa-star drugsAvailabilityRating" aria-hidden="true" data-index="<c:out value="${loop.index}" />" style="color:gray;cursor:pointer"></i>
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
		var id = ${drugstore.id};
		$.ajax({
		    type: 'GET',
		    url: ctx+"/drugstore/comments",
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
		    url: ctx+"/drugstore/rate-price",
		    data: {id:${drugstore.id},price:rateNum},
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
	
	$('.drugsAvailabilityRating').click(function(){
		var rateNum = $(this).data('index');
		$.ajax({
		    type: 'GET',
		    url: ctx+"/drugstore/rate-drugs-availability",
		    data: {id:${drugstore.id},drugsAvailability:rateNum},
		    success: function(response) {
		    	if(response==='success'){
		    		$('.drugsAvailabilityRating').each(function(index){
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
		    url: ctx+"/drugstore/leave-a-comment?drugstoreId="+${drugstore.id},
		    data: comment,
		    success: function(data) {
		    	newCommentBlock = "<div class=\"row off2\"><div class=\"grid_6\"><h4>" + data.username + "</h4><p>" + data.comment + "</p><p>" + data.formattedDate + "</p></div></div>";
		    	$("#comments").prepend(newCommentBlock);
		    }
	    });
	    return false;
	});
});
</script>


<%@include file="../layout/footer.jsp"%>