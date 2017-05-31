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
    
<title><spring:message code="label.hospitals" /></title>
<div style="float:right" id="map"></div>

<script>
    var locations = [];
    var labels = [];
    <c:forEach items="${hospitals}" var="hospital">
	    <c:if test="${hospital.lat!=null && hospital.lng!=null}">
		    locations.push({lat:<c:out value="${hospital.lat}" />,
				lng:<c:out value="${hospital.lng}" />});
	    	labels.push('<c:out value="${hospital.naimenovanieOganizacii}" />');
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
        $('.hospitalItem').each(function(i){
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

		<section class="ins1">
		<div class="container hr" style="width:100%; !important">
			<span><spring:message code="label.sortBy" /></span>
			<select onchange="location = this.value;">
				<option value="${contextPath}/places/hospitals?nameSort=true"><spring:message code="label.sortBy.name" /></option>
				<option value="${contextPath}/places/hospitals?priceSort=true"><spring:message code="label.sortBy.price" /></option>
				<option value="${contextPath}/places/hospitals?serviceSort=true"><spring:message code="label.sortBy.service" /></option>
			</select>
		</div>
          <div class="container hr" style="width:100%; !important">
            <ul class="row product-list" style="margin-left:-20px;">
              <li class="grid_6">
              <c:forEach items="${hospitals}" var="hospital">
              	<div class="box wow fadeInRight hospitalItem" data-lat="<c:out value="${hospital.lat}"/>" data-lng="<c:out value="${hospital.lng}"/>">
                  <div class="box_aside grid_4">
                    <h5><a onclick="window.open('${contextPath}/places/hospital?id=${hospital.id}', '_blank')" style="cursor:pointer"><c:out value="${hospital.naimenovanieOganizacii}" /></a></h5>
                  </div>
                  <div class="grid_4">
                    <span style="margin-right:20px"><spring:message code="hospitalRating.price" /> ${hospital.priceRating}/${maxRateValue }</span>
                    <span><spring:message code="hospitalRating.service" /> ${hospital.serviceRating}/${maxRateValue }</span>
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