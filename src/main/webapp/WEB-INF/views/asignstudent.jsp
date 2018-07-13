<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Geee here</title>
</head>
<body>
	<form:form modelAttribute="StudentCourse" action="asignstudent"
		method="POST">
		<div>
			Student :

			<form:select path="sId">
				<c:forEach var="map" items="${student}">
					<option value="${map.key}"><c:out value="${map.value}" /></option>
				</c:forEach>
			</form:select>
			&nbsp;&nbsp; Course :
			<form:select path="cId">
				<c:forEach var="map" items="${corse}">
					<option value="${map.key}"><c:out value="${map.value}" /></option>
				</c:forEach>
			</form:select>
		</div>
	</form:form>
</body>
</html>