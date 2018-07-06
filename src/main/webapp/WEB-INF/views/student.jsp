<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Form</title>
</head>
<style>
.error {
    color: #ff0000;
    font-style: italic;
    font-weight: bold;
}
</style>
<body>
    <div align="center">
        <h2>Add Student</h2>
        <table border="0" width="90%">
            <form:form modelAttribute="Student" action="addstudent" method="POST">
                
                <tr>
                    <td align="left" width="20%">Student Name:</td>
                    <td align="left" width="40%"><form:input path="studentName"
                            size="30" value="" /></td>
                    <td align="left"><form:errors path="studentName" cssClass="error" /></td>
                </tr>

                <tr>
                    <td>Student Type:</td>
                    <td> <form:select path ="studentType">
                     <form:option style="display:none" value = "NONE" label = "Select" disabled="none"/>
                     <form:option value = "REGULAR" label = "Regular" />
                     <form:option value = "FastTrack" label = "Fast-Track" />
                  </form:select> </td>
                    <td><form:errors path="studentType" cssClass="error" /></td>
                    
                </tr>
                    <td>Mobile:</td>
                    <td><form:input path="mobileNo" size="30"
                            value="" /></td>
                    <td><form:errors path="mobileNo" cssClass="error" /></td>
              
                <tr>
                    <td></td>
                    <td align="center"><input type="submit" value="addstudent" /></td>
                    <td></td>
                </tr>
            </form:form>
        </table>
    </div>

</body>
</html>