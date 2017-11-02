<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"   href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Patient States</title>
</head>
<body>
  <section>
    <div class="pull-right" style="padding-right: 50px">
      <a href="?language=en">English</a>|<a href="?language=de">German</a>
    </div>
  </section>
   <section>
      <div class="jumbotron">
         <div class="container">
            <h1>Patient States</h1>
            <p>Add a new patient state</p>
         </div>
      </div>
   </section>
   <section class="container">
      <form:form  method="POST" modelAttribute="newPatientState" class="form-horizontal" enctype="multipart/form-data">
         <fieldset>
            <legend>Add new patient state</legend>

            <div class="form-group">
               <label class="control-label col-lg-2 col-lg-2" for="eventId"><spring:message code="addPatientState.form.eventId.label"/></label>
               <div class="col-lg-10">
                  <form:input id="eventId" path="eventId" type="text" class="form:input-large"/>
               </div>
            </div>

             <div class="form-group">
               <label class="control-label col-lg-2 col-lg-2" for="caseState"><spring:message code="addPatientState.form.caseState.label"/></label>
               <div class="col-lg-10">
                  <form:input id="caseState" path="caseState" type="text" class="form:input-large"/>
               </div>
            </div>

             <div class="form-group">
               <label class="control-label col-lg-2 col-lg-2" for="patientId"><spring:message code="addPatientState.form.patientId.label"/></label>
               <div class="col-lg-10">
                  <form:input id="patientId" path="patientId" type="text" class="form:input-large"/>
               </div>
            </div>

            <div class="form-group">
               <label class="control-label col-lg-2" for="healthState"><spring:message code="addPatientState.form.healthState.label"/></label>
               <div class="col-lg-10">
                  <form:radiobutton path="healthState" value="GOOD" />Good
                  <form:radiobutton path="healthState" value="NEUTRAL" />Neutral
                  <form:radiobutton path="healthState" value="BAD" />Bad
               </div>
            </div>

            <div class="form-group">
               <label class="control-label col-lg-2" for="emotionalState"><spring:message code="addPatientState.form.emotionalState.label"/></label>
               <div class="col-lg-10">
                  <form:radiobutton path="emotionalState" value="GOOD" />Good
                  <form:radiobutton path="emotionalState" value="NEUTRAL" />Neutral
                  <form:radiobutton path="emotionalState" value="BAD" />Bad
               </div>
            </div>

            <div class="form-group">
               <label class="control-label col-lg-2" for="patientPosition"><spring:message code="addPatientState.form.patientPosition.label"/></label>
               <div class="col-lg-10">
                  <form:radiobutton path="patientPosition" value="SITTING" />Sitting
                  <form:radiobutton path="patientPosition" value="RUNNING" />Running
                  <form:radiobutton path="patientPosition" value="LYING" />Lying
               </div>
            </div>

            <div class="form-group">
               <label class="control-label col-lg-2" for="patientLocation"><spring:message code="addPatientState.form.patientLocation.label"/></label>
               <div class="col-lg-10">
                  <form:radiobutton path="patientLocation" value="KITCHEN" />Kitchen
                  <form:radiobutton path="patientLocation" value="BATH" />Bathroom
                  <form:radiobutton path="patientLocation" value="LIVING" />Living Room
                  <form:radiobutton path="patientLocation" value="BED" />Bedroom
               </div>
            </div>

            <div class="form-group">
               <label class="control-label col-lg-2 col-lg-2" for="audioSequenze"><spring:message code="addPatientState.form.audioSequenze.label"/></label>
               <div class="col-lg-10">
                  <form:input id="audioSequenze" path="audioSequenze" type="text" class="form:input-large"/>
               </div>
            </div>

            <div class="form-group">
               <label class="control-label col-lg-2 col-lg-2" for="videoSequenze"><spring:message code="addPatientState.form.videoSequenze.label"/></label>
               <div class="col-lg-10">
                  <form:input id="videoSequenze" path="videoSequenze" type="text" class="form:input-large"/>
               </div>
            </div>

            <div class="form-group">
              <label class="control-label col-lg-2" for="actionPlan01"> <spring:message
                  code="addPatientState.form.actionPlan01.label" />
              </label>
              <div class="col-lg-10">
                <form:input id="actionPlan01" path="actionPlan01" type="file"
                  class="form:input-large" />
              </div>
            </div>

            <div class="form-group">
               <div class="col-lg-offset-2 col-lg-10">
                  <input type="submit" id="btnAdd" class="btn btn-primary" value ="Add"/>
               </div>
            </div>
         </fieldset>
      </form:form>
   </section>
</body>
</html>
