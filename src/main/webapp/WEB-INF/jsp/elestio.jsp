<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<!DOCTYPE html>
<html lang="en">
  
  <head>
    
    <title>Elestio static example</title>
    
    
    <link rel="icon"  href="\resources\images\favicon.ico">

    <link href="\resources\css\style.css" rel="stylesheet">
  </head>

  <body id="home" data-spy="scroll" data-target="#navbar-wd" data-offset="98">

  
    <header class="app-header">
      <img src="\resources\images\elestio-logo.svg" alt="logo" />
    </header>



    <div class="app-body">
      <div class="app-heading" style="margin-bottom: 40px;">
        <h1>Welcome to Elestio</h1>
        <h4>Deploy your apps quickly with the easiest CI/CD system</h2>
      </div>

      <p class="app-info-block">
        This Host <strong class="subVal" id="host">${host}</strong>
      </p>

      <p class="app-info-block">
        Your IP <strong class="subVal" id="yourIP">${ip}</strong>
      </p>


     
     <c:choose>
       <c:when test="${bool == true}">
          <p class="app-info-block" >
            Your Location<strong class="subVal" id="yourIP"> ${country},${city}</strong>
          </p>
        </c:when>
      </c:choose>
      


       

      <p class="app-info-block">
        Latency to server <strong class="subVal" id="latency">? ms</strong>
      </p>

      

      <div class="app-deploy">
        <a href="https://dash.elest.io/deploy?source=cicd&social=Github&url=https://github.com/elestio-examples/static" class="btn mb-10-m btn-try"
          >Deploy on Elestio
        </a>
      </div>
    </div>

  
    <div class="area">
        <ul class="circles">
            <li></li>
            <li></li>
            <li></li>
            <li></li>
            <li></li>
            <li></li>
            <li></li>
            <li></li>
            <li></li>
            <li></li>
        </ul>
    </div>
  </body>
</html>
<script>
  function getLatency() {
    var started = new Date().getTime();
    var url = "/data?t=" + (+new Date());
    fetch(url)
    .then(function(response) {
        var ended = new Date().getTime();
        var milliseconds = ended - started;
        document.getElementById("latency").innerHTML = milliseconds + " ms";
    }).catch(function(error) {
        document.getElementById("latency").innerHTML = "? ms";
    });
  
  }
  var timerLatency = window.setInterval(getLatency, 1000);
  
</script>
