<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%> 
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<h1>Edit User</h1>  
       <form:form method="POST" action="/SpringMvcUser/editsave">    
        <table >    
        <tr>  
        <td>Username</td>    
        <td><form:input path="username"  /></td>
         <%-- <td><form:hidden  path="username" /></td> --%>  
         </tr>   
         <tr>    
          <td>Password : </td>   
          <td><form:input path="password"  /></td>  
         </tr>    
         <tr>    
          <td>Firstname :</td>    
          <td><form:input path="firstname" /></td>  
         </tr>   
         <tr>    
          <td>Lastname :</td>    
          <td><form:input path="lastname" /></td>  
         </tr>  
         <tr>    
          <td>Email :</td>    
          <td><form:input path="email" /></td>  
         </tr> 
         <tr>    
          <td>Address :</td>    
          <td><form:input path="address" /></td>  
         </tr> 
         <tr>    
          <td>Phone :</td>    
          <td><form:input path="phone" /></td>  
         </tr>  
           
         <tr>    
          <td> </td>    
          <td><input type="submit" value="Edit Save" /></td>    
         </tr>    
        </table>    
       </form:form>    


</body>
</html>