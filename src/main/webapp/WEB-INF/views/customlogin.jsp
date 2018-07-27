<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	  <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
  <%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
  <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>PLEASE LOGIN</title>
<meta name="viewport" content="width=device-width, initial-scale=3">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script type="text/javascript">

function CheckNumeric(e) {
	 
    if (window.event) // IE 
    {
        if ((e.keyCode < 48 || e.keyCode > 57) & e.keyCode != 8) {
            event.returnValue = false;
            return false;

        }
    }
    else { // Fire Fox
        if ((e.which < 48 || e.which > 57) & e.which != 8) {
            e.preventDefault();
            return false;

        }
    }
}
</script>
</head>
<body>
	<center>
	
		<c:if test="${not empty SPRING_SECURITY_LAST_EXCEPTION}">
      <font color="red">
        Your login attempt was not successful due to <br/><br/>
        <c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}"/>.
      </font>
</c:if>
	</center>

	<!--   
<div class="container" align="center">
      <form class="form-signin" method="post" action="/userlogin">
        <h2 class="form-signin-heading">Please sign in</h2>
        <p>
          <label for="username" class="col-xs-3">Username</label>
          <input type="text" id="username" name="username" class="col-xs-3" placeholder="Username" required="" autofocus="">
        </p>
        <p>
          <label for="password" class="col-xs-3">Password</label>
          <input type="password" id="password" name="password" class="col-xs-3" placeholder="Password" required="">
        </p>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
      </form>
</div>
 -->


	<div class="container" align="center">
		<form class="form-inline" method="post" action="/login">
			<h2 class="form-signin-heading">Please sign in</h2>
			<div class="form-group">
				<label for="username">Mobile No:</label> <input type="text"
					class="form-control" id="username" placeholder="Enter MobileNo"
					onkeypress="CheckNumeric(event)" name="username" maxlength="10">
			</div>
			<br> <br>
			<div class="form-group">
				<label for="pwd">Password:</label> <input type="password"
					class="form-control" id="password" placeholder="Enter password"
					name="password">
			</div>


			<br> <br>
			<button type="submit" class="btn btn-default">Login</button>
		</form>
	</div>

</body>
</html>