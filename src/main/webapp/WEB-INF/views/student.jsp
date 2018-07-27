<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Form</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
</head>
<!-- <script type="text/javascript">
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
 -->
<style>
.error {
	color: #ff0000;
	font-style: italic;
	font-weight: bold;
}
</style>
<body style="width: 975px">


	<div class="container" align="center">
		<div style="width: 775px;" align="center">
			<h2>Add Student</h2>
			<table border="0" width="50%" align="center">
				<form:form modelAttribute="Student" action="addstudent"
					method="POST">

					<tr>
						<td align="left" width="20%">Student Name:</td>
						<td align="left" width="40%"><form:input path="studentName"
								class="alphaonly" size="30" value="" /></td>
						<td align="left"><form:errors path="studentName"
								cssClass="error" /></td>
					</tr>
					<tr>
						<td align="left" width="20%">Enter Password:</td>
						<td align="left" width="40%"><form:password
								path="studentpassword" class="alphaonly" size="30" value="" /></td>
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
								<option style="display: none" value="NONE">Select
									Course</option>
								<c:forEach var="map" items="${course}">
									<option value="${map.key}"><c:out value="${map.value}" /></option>
								</c:forEach>
							</form:select></td>
						<td><form:errors path="studentType" cssClass="error" /></td>

					</tr>



					<td>Mobile:</td>
					<td><form:input path="mobileNo" size="10" id="mobileNo"
							class="alphaonlys" maxlength="10" /></td>
					<td><form:errors path="mobileNo" cssClass="error" /></td>
					<td><div class="form-group" id="groupNameTest"
							style="color: red;"></div></td>
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
<script type="text/javascript">
	$('.alphaonlys').bind('keyup blur', function() {
		var node = $(this);
		if (node.value != "") {
			node.val(node.val().replace(/[^0-9/^ ]/g, ''))
		} else {

			alert("DONT SUBMIT EMPTY SPACES")
			return false;
		}
		return true;
		;
	});
</script>
<script type="text/javascript">
	$(document)
			.ready(
					function() {
						$("#mobileNo")
								.keyup(
										function() {
											var mobileNo = $(this).val();
											if (mobileNo.length >= 10) {
												$
														.ajax({
															type : "post",
															url : "${pageContext.request.contextPath}/searchByMobileNo",
															data : "mobileNo="
																	+ mobileNo,
															success : function(
																	response) {
																if (response == "available") {
																	//alert("inside if: "+response);
																	$(
																			'#groupNameTest')
																			.html(
																					"This Mobile No Already Exists!");
																} else {
																	//alert("inside else: "+response);
																	$(
																			'#groupNameTest')
																			.html(
																					"Available");
																}
															},
															error : function(
																	err) {
																$(
																		'#groupNameTest')
																		.html(
																				"ERROR");
																alert(err);
															}
														});

											}

										})
					});

	function validate() {

		if ($('#mobileNo').val() == "" || $('#mobileNo').val() == null) {

			alert("Please Enter Mobile No");
			$("#mobileNo").focus();

			return false;
		}
	}
</script>
</html>