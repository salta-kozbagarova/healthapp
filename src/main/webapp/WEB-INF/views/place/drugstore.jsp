<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../layout/header.jsp"%>

<style>
	#map {
		height: 300px;
		width: 400px;
	}
</style>
    
<title>Drugstore</title>

<script>
    var location, label;
    <c:if test="${drugstore.lat!=null && drugstore.lng!=null}">
	    location = {lat:<c:out value="${drugstore.lat}" />,
			lng:<c:out value="${drugstore.lng}" />};
    	label = '<c:out value="${drugstore.naimenovanieAptek}" />';
	</c:if>
    
    
    function initMap() {
		var center = {lat: 51.1535545, lng: 71.4809837};
        var map = new google.maps.Map(document.getElementById('map'), {
          zoom: 13,
          center: center
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
		                  <c:forEach begin="1" end="${drugstore.raiting}" varStatus="loop">
	                  		<i class="fa fa-star" aria-hidden="true" data-index="<c:out value="${loop.count}" />" style="cursor:pointer"></i>
						  </c:forEach>
						  <c:forEach begin="${drugstore.raiting+1}" end="${maxRateValue}" varStatus="loop">
	                  		<i class="fa fa-star" aria-hidden="true" data-index="<c:out value="${loop.count}" />" style="color:gray;cursor:pointer"></i>
						  </c:forEach>
	                  </div>
	                  <h3>${drugstore.peopleQuantity}</h3>
              </div>
              
            </div>
            <hr>
            <p><spring:message code="info.youCanLeaveACommentHere" /></p>
            <c:if test="${pageContext.request.userPrincipal == null}">
            	<p>Чтобы оставить комментарии вам нужно <a href="${contextPath}/sign-up-form">войти в систему</a></p>
            </c:if>
          </div>
        </section>
       </main>
<%@include file="../layout/footer.jsp"%>