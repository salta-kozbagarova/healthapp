<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../layout/header.jsp"%>
<link rel="stylesheet" href="${contextPath}/resources/css/google-map.css">
<link rel="stylesheet" href="${contextPath}/resources/css/mailform.css">
      <!--
      ========================================================
                                  CONTENT
      ========================================================
      -->
      <main>
        <section class="map">
          <div id="google-map" class="map_model"></div>
          <ul class="map_locations">
            <li data-x="-73.9874068" data-y="40.643180">
              <p>9870 St Vincent Place, Glasgow, DC 45 Fr 45. <span>800 2345-6789</span></p>
            </li>
          </ul>
        </section>
        <section class="well3 bg-secondary">
          <div class="container">
            <ul class="row contact-list">
              <li class="grid_4">
                <div class="box">
                  <div class="box_aside">
                    <div class="icon2 fa-map-marker"></div>
                  </div>
                  <div class="box_cnt__no-flow">
                    <address>4578 Marmora Road,Glasgow<br/> D04 89GR</address>
                  </div>
                </div>
                <div class="box">
                  <div class="box_aside">
                    <div class="icon2 fa-envelope"></div>
                  </div>
                  <div class="box_cnt__no-flow"><a href="mailto:#">info@demolink.org</a></div>
                </div>
              </li>
              <li class="grid_4">
                <div class="box">
                  <div class="box_aside">
                    <div class="icon2 fa-phone"></div>
                  </div>
                  <div class="box_cnt__no-flow"><a href="callto:#">800-2345-6789</a></div>
                </div>
                <div class="box">
                  <div class="box_aside">
                    <div class="icon2 fa-fax"></div>
                  </div>
                  <div class="box_cnt__no-flow"><a href="callto:#">800-2345-6790</a></div>
                </div>
              </li>
              <li class="grid_4">
                <div class="box">
                  <div class="box_aside">
                    <div class="icon2 fa-facebook"></div>
                  </div>
                  <div class="box_cnt__no-flow"><a href="#">Follow on facebook</a></div>
                </div>
                <div class="box">
                  <div class="box_aside">
                    <div class="icon2 fa-twitter"></div>
                  </div>
                  <div class="box_cnt__no-flow"><a href="#">Follow on Twitter</a></div>
                </div>
              </li>
            </ul>
          </div>
        </section>
        <section class="well1">
          <div class="container">
            <h2>Feedback</h2>
            <form method="post" action="bat/rd-mailform.php" class="mailform off2">
              <input type="hidden" name="form-type" value="contact">
              <fieldset class="row">
                <label class="grid_4">
                  <input type="text" name="name" placeholder="Your Name:" data-constraints="@LettersOnly @NotEmpty">
                </label>
                <label class="grid_4">
                  <input type="text" name="phone" placeholder="Telephone:" data-constraints="@Phone">
                </label>
                <label class="grid_4">
                  <input type="text" name="email" placeholder="Email:" data-constraints="@Email @NotEmpty">
                </label>
                <label class="grid_12">
                  <textarea name="message" placeholder="Message:" data-constraints="@NotEmpty"></textarea>
                </label>
                <div class="mfControls grid_12">
                  <button type="submit" class="btn">Sumbit comment</button>
                </div>
              </fieldset>
            </form>
          </div>
        </section>
      </main>
      <%@include file="../layout/footer.jsp"%>