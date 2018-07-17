<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Campusguide</title>
</head>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Bootstrap Example</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style>
body {font-family: Arial, Helvetica, sans-serif;}

/* Full-width input fields */
input[type=text], input[type=password] {
    width: 100%;
    padding: 12px 20px;
    margin: 8px 0;
    display: inline-block;
    border: 1px solid #ccc;
    box-sizing: border-box;
}

/* Set a style for all buttons */
button {
    background-color: #4CAF50;
    color: white;
    padding: 14px 20px;
    margin: 8px 0;
    border: none;
    cursor: pointer;
    width: 100%;
}

button:hover {
    opacity: 0.8;
}

/* Extra styles for the cancel button */
.cancelbtn {
    width: auto;
    padding: 10px 18px;
    background-color: #f44336;
}




.container {
    padding: 16px;
}

span.psw {
    float: right;
    padding-top: 16px;
}


</style>



</head>
<body>

	<nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#myNavbar">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="#">CampusGuide</a>
		</div>
		<div class="collapse navbar-collapse" id="myNavbar">
		<!-- 	<ul class="nav navbar-nav">
				<li class="active"><a href="#">Home</a></li>
				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#">Page 1 <span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="#">Page 1-1</a></li>
						<li><a href="#">Page 1-2</a></li>
						<li><a href="#">Page 1-3</a></li>
					</ul></li>
				<li><a href="#">Page 2</a></li>
				<li><a href="#">Page 3</a></li>
			</ul> -->
			<ul class="nav navbar-nav navbar-right">
				<sec:authorize access="isAuthenticated()">
					<li><a href="userlogin"><span
							class="glyphicon glyphicon-log-in"></span> <sec:authentication
								property="principal.username" /></a></li>
				</sec:authorize>
				<sec:authorize access="!isAuthenticated()">
				<li><a href="userlogin"><span
						class="glyphicon glyphicon-log-in"></span> LOG IN</a></li>
						</sec:authorize>
				<li><a href="student"><span
						class="glyphicon glyphicon-log-in"></span> Student Registration</a></li>
			</ul>
		</div>
	</div>
	</nav>
	<center><c:if test="${not empty MESSAGE}">
		<b><c:out value="${MESSAGE}"></c:out></b>
	</c:if></center>
	

	<div class="container">
		<h3>CampusGuide</h3>
		<p>One stop solution for all IT services,placements and Overseas education.We are providing online software training based on specific needs of the students especially we give innovative one to one training in all the software which are having great opportunities in the present trend. We provides Class room training and as well as online training to contend with today's competitive software world. Students can grasp the subject from our experienced and certified trainers which helps the students to work in real time environment. Students can choose either normal track or fast track course or weekends classes.We also provide classroom training to the students for wide range of technologies. Our practice is to partner with cutting edge individuals, organizations and industry experts to ensure content and technologies lead the field.
		
	</div>
	<button onclick="document.getElementById('id01').style.display='block'" style="width:auto;">Login</button>

<div id="id01" class="modal">
  
  <form class="modal-content animate" action="/login" method="POST">
    <div class="imgcontainer">
      <span onclick="document.getElementById('id01').style.display='none'" class="close" title="Close Modal">&times;</span>
    <div class="container">Campus Guide</div>
    </div>

    <div class="container">
      <label for="uname"><b>Username</b></label>
      <input type="text" placeholder="Enter Username" name="username " required>

      <label for="psw"><b>Password</b></label>
      <input type="password" placeholder="Enter Password" name="password" required>
        
      <button type="submit" value="login">Login</button>
      
    </div>

    <div class="container" style="background-color:#f1f1f1">
      <button type="button" onclick="document.getElementById('id01').style.display='none'" class="cancelbtn">Cancel</button>
      <span class="psw">Forgot <a href="#">password?</a></span>
    </div>
  </form>
</div>

<script>
// Get the modal
var modal = document.getElementById('id01');

// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
    if (event.target == modal) {
        modal.style.display = "none";
    }
}
</script>

</body>
</html>


<!-- <center>
<a href="admin"><button>Admin</button></a>
<a href="student"><button>Student</button></a>
<a href="asignstudentcourse"><button>Asign Course to Student</button></a>
</center> -->
</body>
</html>