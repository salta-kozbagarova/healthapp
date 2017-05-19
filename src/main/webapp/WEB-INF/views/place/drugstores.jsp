<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../layout/header.jsp"%>
<style>
	#map {
		height: 800px;
		width: 65%;
	}
</style>
    
<title><spring:message code="label.drugstores" /></title>
<div style="float:right" id="map"></div>

<script>
    var locations = [];
    var labels = [];
    <c:forEach items="${drugstores}" var="drugstore">
	    <c:if test="${drugstore.lat!=null && drugstore.lng!=null}">
		    locations.push({lat:<c:out value="${drugstore.lat}" />,
				lng:<c:out value="${drugstore.lng}" />});
	    	labels.push('<c:out value="${drugstore.naimenovanieAptek}" />');
		</c:if>
    </c:forEach>
    
    
    function initMap() {
		var center = {lat: 51.1535545, lng: 71.4809837};
        var map = new google.maps.Map(document.getElementById('map'), {
          zoom: 13,
          center: center
        });
        var markers = locations.map(function(location, i) {
        	return new google.maps.Marker({
              position: location,
              label: labels[i]
            });
        });

        var markerCluster = new MarkerClusterer(
       		map, 
       		markers,
           	{imagePath: 'https://developers.google.com/maps/documentation/javascript/examples/markerclusterer/m'}
        );
        
        var coords, bounds, lat, lng;
        $('.drugstoreItem').each(function(i){
        	$(this).click(function(){
        		if((lat = $(this).data("lat"))!="" && (lng = $(this).data("lng"))!=""){
        			coords = new google.maps.LatLng(lat,lng);
            		bounds = new google.maps.LatLngBounds();
            		bounds.extend(coords);
            		map.fitBounds(bounds);
            		//map.panTo(coords);
        		} else{
        			return false;
        		}
        	});
        });
	}
</script>
<script src="https://developers.google.com/maps/documentation/javascript/examples/markerclusterer/markerclusterer.js"></script>
<script async defer src="https://maps.googleapis.com/maps/api/js?key=AIzaSyD1eYhE8DgMPKw78c4t-ER7WONluE7cjkE&callback=initMap"></script>
<div style="overflow-y:scroll; height:800px;width:35%">

		<section class="well ins1">
          <div class="container hr" style="width:100%; !important">
            <ul class="row product-list" style="margin-left:-20px;">
              <li class="grid_6">
              <c:forEach items="${drugstores}" var="drugstore">
              	<div class="box wow fadeInRight drugstoreItem" data-lat="<c:out value="${drugstore.lat}"/>" data-lng="<c:out value="${drugstore.lng}"/>">
                  <div class="box_aside">
                    <div class="icon fa-plus"></div>
                  </div>
                  <div class="box_cnt__no-flow" style="float:left; width:350px;">
                    <h3><a onclick="window.open('${contextPath}/places/drugstore?id=${drugstore.id}', '_blank')" style="cursor:pointer"><c:out value="${drugstore.naimenovanieAptek}" /></a></h3>
                    <p><c:out value="${drugstore.address}" /></p>
                  </div>
                  <div class="box_right_side">
	                  <div>
		                  <c:forEach begin="1" end="${drugstore.priceRating}" varStatus="loop">
	                  		<i class="fa fa-star" aria-hidden="true"></i>
						  </c:forEach>
						  <c:forEach begin="1" end="${maxRateValue-drugstore.priceRating}" varStatus="loop">
	                  		<i class="fa fa-star" aria-hidden="true" style="color:gray"></i>
						  </c:forEach>
	                  </div>
	                  <div>
	                  <h3>${drugstore.priceCount}</h3>
	                  </div>
                  </div>
                </div>
                <hr>
              </c:forEach>
              </li>
            </ul>
          </div>
        </section>
        </div>
<%@include file="../layout/footer.jsp"%>