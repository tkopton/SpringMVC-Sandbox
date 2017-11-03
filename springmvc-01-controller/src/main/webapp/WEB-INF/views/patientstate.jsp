<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Patient State</title>
</head>
<body>
	<section>
		<div class="jumbotron">
			<div class="container">
				<h1>Selected Patient State</h1>
			</div>
		</div>
	</section>
	<section class="container">
		<div class="row">
			<div class="col-md-5">
				<img src="<c:url value="/img/doc-1.png"></c:url>"
					alt="image" style="width: 100%" />
			</div>
			<div class="col-md-5">
				<h3>${patientstate.patientId}</h3>
					<strong>Patient Position : </strong><span class="label label-warning">${patientstate.patientPosition}</span>
				</p>
				<p>
					<strong>Patient Location : </strong> : ${patientstate.patientLocation}
				</p>
				<p>
					<strong>Audio Sequenze : </strong> : ${patientstate.audioSequenze}
				</p>
				<p>
					<strong>Video Sequenze : </strong> : ${patientstate.videoSequenze}
				</p>
				<h4><strong>Case Status : </strong> : ${patientstate.caseState}</h4>
				<p>
					<a href="<spring:url value="/annotation/patientstates" />"
						class="btn btn-default"> <span
						class="glyphicon-hand-left glyphicon"></span> back
					</a> <a href="#" class="btn btn-warning btn-large"> <span
						class="glyphicons glyphicons-heart"></span> To Do
					</a>
				</p>
			</div>
		</div>
	</section>
</body>
</html>
