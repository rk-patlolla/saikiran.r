<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="boot.jsp"></jsp:include>
	
<center>
<form:form modelAttribute="Student" action="getStudentDetailsById" method="POST">
<center><c:if test="${not empty MSG}">
		<b><c:out value="${MSG}"></c:out></b>
	</c:if></center>
		<div>
			Student :

			<form:select  path="sId" >
			   <option style="display:none" value="None">Select</option>
				<c:forEach var="map" items="${studentslist}">
					<option value="${map.key}"><c:out value="${map.value}"/></option>
				</c:forEach>
			</form:select >
			<form:button type="submit">Submit</form:button>
		</div>
	</form:form>
</center>
</body>
</html>