<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
   href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Experts</title>
</head>
<body>
   <section>
      <div class="jumbotron">
         <div class="container">
            <h1>Experts</h1>
            <p>All experts working with the Annotation Service</p>
         </div>
      </div>
   </section>

   <section class="container">
      <div class="row">
        <c:forEach items="${experts}" var="expert">
            <div class="col-sm-8 col-md-5" style="padding-bottom: 15px">
               <div class="thumbnail">
                  <div class="caption">
                     <h3>Expert ID: ${expert.expertId}</h3>
                     <h3>Medical Field: ${expert.medicalField}</h3>
                     <h3>Field of Expertise: ${expert.fieldOfExpertise}</h3>
                     <p>Contact Information ${expert.contactInformation}</p>
                     <p>Is GP ${expert.isGp}</p>
                     <p>Is Part of Alertchain ${expert.isAlertchain}</p>
                     <p>Is Part of Collaboration ${expert.isCollaboration}</p>
                     <p>Is Part of Annotation ${expert.isAnnotation}</p>
                  </div>
               </div>
            </div>
          </c:forEach>
      </div>
   </section>
</body>
</html>
