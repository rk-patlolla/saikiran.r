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

	<div class="container" align="left">
		<div align="right" style="width: 975px;">
			<h2>View Student</h2>
			<table border="0" width="50%">
				<form:form modelAttribute="Student" action="updatestudent"
					method="POST">

					<tr>
						<td align="left" width="20%">Student Name:</td>
						<td align="left" width="40%"><form:input path="studentName"
							class="alphaonly"	size="30"  />
							<form:input type="hidden" path="sId" />
					
							
							
							</td>
						<td align="left"><form:errors path="studentName"
								cssClass="error" />
								
								
								</td>
					</tr>

					<tr>
						<td>Student Type:</td>
						<td><form:input path="studentType" readonly/>
						</td>
						<td><form:errors path="studentType" cssClass="error" /></td>

					</tr>
					<tr>
						<td>Course Type:</td>
						<td><form:input path="course" readonly/>
							    </td>
						<td><form:errors path="course" cssClass="error" /></td>

					</tr>



					<td>Mobile:</td>
					<td><form:input path="mobileNo" size="10" 
							onkeypress="CheckNumeric(event)" maxlength="10" readonly/></td>
					<td><form:errors path="mobileNo" cssClass="error" /></td>

					<tr>
						<td></td>
						<td align="center"><input type="submit" value="updatestudent" /></td>
						<td></td>
					</tr>
				</form:form>
			</table>
		</div>
	</div>
</center>
</body>
</html>