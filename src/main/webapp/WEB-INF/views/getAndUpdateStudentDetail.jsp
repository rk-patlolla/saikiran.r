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
	<jsp:include page="studentleftboot.jsp"></jsp:include>
	<center>
		<div class="container" style="margin-right: -305px;">
			<form:form class="form-horizontal" modelAttribute="Student"
				action="updatestudent" method="POST">
				<div class="form-group">
					<label class="col-sm-2 control-label">NAME</label>
					<div class="col-sm-3">
						<form:input path="studentName" class="form-control" />
					</div>
					<div class="col-sm-3">
						<form:errors path="studentName" cssClass="error" />
					</div>

				</div>
				<div class="form-group">
					<label class="col-sm-2 control-label">Student Type</label>
					<div class="col-sm-3">
						<form:input path="studentType" class="form-control"  readonly="true"/>
					</div>
					<div class="col-sm-3">
						<form:errors path="studentType" cssClass="error" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 control-label">Course Type</label>
					<div class="col-sm-3">
						<form:input path="course.courseName" class="form-control" readonly="true"/>
					</div>
					<div class="col-sm-3">
						<form:errors path="course.courseName" cssClass="error" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 control-label">Mobile No</label>
					<div class="col-sm-3">
						<form:input path="mobileNo" class="form-control" readonly="true"/>
					</div>
					<div class="col-sm-3">
						<form:errors path="mobileNo" cssClass="error" />
					</div>
				</div>
				<div class="form-group">
				<div class="col-sm-3" align="right">
					<form:button type="submit" value="updatestudent" >UPDATE</form:button>
				</div>
				</div>
			</form:form>
		</div>
	</center>



</body>
</html>