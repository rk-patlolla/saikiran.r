<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Form</title>
</head>
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
<style>
.error {
	color: #ff0000;
	font-style: italic;
	font-weight: bold;
}
</style>
<body style="width: 975px">


	<div class="container" align="left">
		<div align="right" style="width: 975px;">
			<h2>Add Student</h2>
			<table border="0" width="50%">
				<form:form modelAttribute="Student" action="addstudent"
					method="POST">

					<tr>
						<td align="left" width="20%">Student Name:</td>
						<td align="left" width="40%"><form:input path="studentName"
							class="alphaonly"	size="30" value="" /></td>
						<td align="left"><form:errors path="studentName"
								cssClass="error" /></td>
					</tr>
					<tr>
						<td align="left" width="20%">Enter Password:</td>
						<td align="left" width="40%"><form:password path="studentpassword"
							class="alphaonly"	size="30" value="" /></td>
						<td align="left"><form:errors path="studentpassword"
								cssClass="error" /></td>
					</tr>

					<tr>
						<td>Student Type:</td>
						<td><form:select path="studentType">
								<form:option style="display:none" value="NONE" label="Select"
									disabled="none" />
								<form:option value="REGULAR" label="Regular" />
								<form:option value="FastTrack" label="Fast-Track" />
							</form:select></td>
						<td><form:errors path="studentType" cssClass="error" /></td>

					</tr>
					<tr>
						<td>Course Type:</td>
						<td><form:select path="course">
								<option style="display:none" value="NONE">Select Course</option>
								<c:forEach var="map" items="${course}">
									<option value="${map.key}"><c:out value="${map.value}" /></option>
								</c:forEach>
							</form:select></td>
						<td><form:errors path="studentType" cssClass="error" /></td>

					</tr>



					<td>Mobile:</td>
					<td><form:input path="mobileNo" size="10" value=""
							onkeypress="CheckNumeric(event)" maxlength="10" /></td>
					<td><form:errors path="mobileNo" cssClass="error" /></td>

					<tr>
						<td></td>
						<td align="center"><input type="submit" value="addstudent" /></td>
						<td></td>
					</tr>
				</form:form>
			</table>
		</div>
	</div>
</body>
<script type="text/javascript">
	$('.alphaonly').bind('keyup blur', function() {
		var node = $(this);
		if (node.value != "") {
			node.val(node.val().replace(/[^a-z/^A-Z/^ ]/g, ''))
		} else {

			alert("DONT SUBMIT EMPTY SPACES")
			return false;
		}
		return true;
		;
	});
</script>
</html>