<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>CampusGuide | Add Course</title>
</head>
<style>
.error {
	color: #ff0000;
	font-style: italic;
	font-weight: bold;
}
</style>
<body style="width: 1476px">

	<jsp:include page="boot.jsp"></jsp:include>
	<center><c:if test="${not empty MSG}">
		<b><c:out value="${MSG}"></c:out></b>
	</c:if></center>
	<h3 align="center">Add Course</h3>

	<form:form modelAttribute="Course" action="save" method="POST">
		<table border="1"
			style="width: 1190px; height: 2px; margin-left: 197px;">

			<th>Course Name</th>
			<th>Course Type</th>
			<th>Course description</th>
			<th>Add Course</th>


			</tr>
			<td><form:input path="courseName" id="courseName" value=""
					size="45" />
				<h3 align="right">
					<form:errors path="courseName" cssClass="error" /></td>

			<td><form:input path="courseType" type="text" id="courseType"
					value="" size="45" /> <form:errors path="courseType"
					cssClass="error" /></td>

			<td><form:input path="courseDescription" type="text"
					id="courseDescription" value="" size="45" /> <form:errors
					path="courseDescription" cssClass="error" /></td>

			<td><button type="submit" style="align-content: right: 120px;">ADD
					Course</button></td>

		</table>


		</h3>


	</form:form>

	<a href="admin">Home</a>

</body>

</html>