<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
   href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Patient State Events</title>
</head>
<body>
   <section>
      <div class="jumbotron">
         <div class="container">
            <h1>Patient State Events</h1>
            <p>All current events in our annotation system</p>
         </div>
      </div>
   </section>

   <section class="container">
      <div class="row">
        <c:forEach items="${patientstates}" var="state">
            <div class="col-sm-8 col-md-5" style="padding-bottom: 15px">
               <div class="thumbnail">
                 <img src="<c:url value="/img/mon-1.png"></c:url>" alt="image"  style = "width:25%"/>
                  <div class="caption">
                     <h3>Event ID: ${state.eventId}</h3>
                     <h4>Case Status: ${state.caseState}</h4>
                     <p>Patient ID: ${state.patientId}</p>
                     <p>Patient's health state ${state.healthState}</p>
                     <p>Patient's emotional state ${state.emotionalState}</p>
                     <p>
       								<a
       									href=" <spring:url value="/annotation/patientstate?eventid=${state.eventId}" /> "
       									class="btn btn-primary"> <span
       									class="glyphicon-info-sign glyphicon" /></span> Details
       								</a>
       							</p>
                  </div>
               </div>
            </div>
          </c:forEach>
      </div>
   </section>
</body>
</html>
