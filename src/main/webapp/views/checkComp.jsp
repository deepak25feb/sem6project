<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html>
  <head>
    <title>Check Compatibility</title>
    <link rel="stylesheet" href="/css-res/comP.css" />
  </head>
  <body>
  <center>
    <div id="container">
      <video id="gum" playsinline autoplay muted></video>
      <video id="recorded" playsinline loop></video>

      <div>
        <button id="start">Start camera</button>
        <button id="record" disabled>Record</button>
        <button id="play" disabled>Play</button>
        <button id="download" disabled>Download</button>
      </div>

      <div>
        <h4>Media Stream Constraints options</h4>
        <p>
          Echo cancellation: <input type="checkbox" id="echoCancellation" />
        </p>
      </div>

      <div>
        <span id="errorMsg"></span>
      </div>
    </div>
	</center>
  </body>
  <script src="/js-res/comPj.js"></script>
</html>
