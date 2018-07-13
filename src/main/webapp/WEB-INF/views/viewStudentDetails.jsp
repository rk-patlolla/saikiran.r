<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="width: 975px">
	<jsp:include page="studentleftboot.jsp"></jsp:include>
	<div class="container">
		<h3 align="center">View Student</h3>

		<c:if test="${empty student}">
			<b>No Data Found</b>
		</c:if>
		<c:if test="${not empty student}">
			<table border="1" align="center">
				<th>Student ID</th>
				<th>Student Name</th>
				<th>Student Type</th>
				<th>Mobile No</th>
				<th>Student status</th>
				<th>Date</th>


				<c:forEach var="listValue" items="${student}">
					<%-- 	<li>
				${listValue.cId}
				${listValue.courseName}
				${listValue.courseType}
				${listValue.courseDescription}
				${listValue.cStatus}
				${listValue.createdDate}</li> --%>

					</tr>

					<td>${listValue.sId}</td>
					<td>${listValue.studentName}</td>
					<td>${listValue.studentType}</td>
					<td>${listValue.mobileNo}</td>
					<td>${listValue.course.courseName}</td>
					<td>${listValue.created}</td>



				</c:forEach>
			</table>


		</c:if>
		<a href="admin">Home</a>
	</div>
</body>
</html>