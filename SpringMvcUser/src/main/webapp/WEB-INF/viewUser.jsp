<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%> 
    
    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
.button {
  font: bold 11px Arial;
  text-decoration: none;
  background-color: #EEEEEE;
  color: #333333;
  padding: 2px 6px 2px 6px;
  border-top: 1px solid #CCCCCC;
  border-right: 1px solid #333333;
  border-bottom: 1px solid #333333;
  border-left: 1px solid #CCCCCC;
}
</style>

</head>
<body>

<h1>Users List</h1> 

<table>
	<tr>
		<td>Username</td><td>Password</td><td>Firstname</td><td>Lastname</td><td>Email</td><td>Address</td><td>Phone</td>
	</tr>
	
	 <c:forEach var="user" items="${list}">   
   <tr>  
   <td>${user.username}</td>  
   <td>${user.password}</td>  
   <td>${user.firstname}</td>  
   <td>${user.lastname}</td>  
    <td>${user.email}</td> 
     <td>${user.address}</td> 
      <td>${user.phone}</td> 
 <td><a href="editUser/${user.username}" class="button">Edit</a></td> 
   <td><a href="deleteUser/${user.username}" class="button">Delete</a></td>
   </tr>  
   </c:forEach>  
	
</table> 

</body>
</html>


<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Employees List</h1>  
<table border="2" width="70%" cellpadding="2">  
<tr><th>UserName</th><th>Password</th><th>FirstName</th><th>LastName</th><th>Email</th><th>Address</th><th>Phone</th></tr>  
   <c:forEach var="user" items="${list}">   
   <tr>  
   <td>${user.username}</td>  
   <td>${user.password}</td>  
   <td>${user.firstname}</td>  
   <td>${user.lastname}</td>  
    <td>${user.email}</td> 
     <td>${user.address}</td> 
      <td>${user.phone}</td> 
   <td><a href="editemp/${emp.id}">Edit</a></td>  
   <td><a href="deleteemp/${emp.id}">Delete</a></td>  
   </tr>  
   </c:forEach>  
   </table>  
   <br/>  
   <a href="empform">Add New Employee</a>  
   
</body>
</html> --%>