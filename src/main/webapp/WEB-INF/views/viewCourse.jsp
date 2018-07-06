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
<jsp:include page="boot.jsp"></jsp:include>
<div class="container">
<h3 align="center">View Course</h3>
<body>
<c:if test="${empty Course}">
<b>No Data Found</b>
</c:if>
<c:if test="${not empty Course}">
<table border="1" align="center">
<th>
Course ID
</th>
<th>
Course Name
</th>
<th>
Course Type
</th>
<th>
Course description
</th>
<th>
Course status
</th>
<th>
Date 
</th>


			<c:forEach var="listValue" items="${Course}">
			<%-- 	<li>
				${listValue.cId}
				${listValue.courseName}
				${listValue.courseType}
				${listValue.courseDescription}
				${listValue.cStatus}
				${listValue.createdDate}</li> --%>
				
</tr>
 
<td>${listValue.cId}</td>
<td>${listValue.courseName}</td>
<td>${listValue.courseType}</td>
<td>${listValue.courseDescription}</td>
<td>${listValue.cStatus}</td>
<td>${listValue.createdDate}</td>
    


			</c:forEach>
			</table> 
	

	</c:if>
	<a href="admin">Home</a>
	</div>
</body>
</html>