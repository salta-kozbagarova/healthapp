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
<div id="map"></div>

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

		<section class="well ins1">
          <div class="container hr">
            <ul class="row product-list">
              <li class="grid_6">
              	<div class="box wow fadeInRight"/>
                  <div class="box_aside">
                    <div class="icon fa-plus"></div>
                  </div>
                  <div class="box_cnt__no-flow">
                    <h3><c:out value="${drugstore.naimenovanieAptek}" /></h3>
                    <p><c:out value="${drugstore.address}" /></p>
                  </div>
                  <div class="box_right_side">
	                  <div>
		                  <c:forEach begin="1" end="${drugstore.raiting}" varStatus="loop">
	                  		<i class="fa fa-star" aria-hidden="true"></i>
						  </c:forEach>
						  <c:forEach begin="1" end="${maxRateValue-drugstore.raiting}" varStatus="loop">
	                  		<i class="fa fa-star" aria-hidden="true" style="color:gray"></i>
						  </c:forEach>
	                  </div>
	                  <div>
	                  <h3>${drugstore.peopleQuantity}</h3>
	                  </div>
                  </div>
                </div>
                <hr>
              </li>
            </ul>
          </div>
        </section>
<%@include file="../layout/footer.jsp"%>