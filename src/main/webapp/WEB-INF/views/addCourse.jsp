<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
       
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>CampusGuide | Add Course</title>
</head>
<body>
<form action="save" method="POST">
<table border="1" align="center">

<th>
Course Name
</th>
<th>
Course Type
</th>
<th>
Course description
</th>

</tr>
 
<td><input name="courseName" type="text" id="courseName" value="" size="30"/></td>
<td><input name="courseType" type="text" id="courseType" value="" size="30"/></td>
<td><input name="courseDescription" type="text" id="courseDescription" value="" size="30"/></td>
<tr><th colspan="4"><button type="submit">ADD</button></th>
 </tr>
    

</table>   
      </form>    
      	<a href="admin">Home</a>
</body>
</html>