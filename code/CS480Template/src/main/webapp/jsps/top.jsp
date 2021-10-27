<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>top</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="content-type" content="text/html;charset=utf-8">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">
	body {
		background: #b5ffc8; 
	}
	a {
		text-transform:none;
		text-decoration:none;
	} 
	a:hover {
		text-decoration:underline;
	}
</style>
  </head>
  
  <body>
<h1 style="text-align: center;">Ameesha Saxena</h1> 
<h3 style="text-align: center;">CS 480 Project</h3> 
<div style="font-size: 10pt;">
	<c:choose>
		<c:when test="${empty sessionScope.session_user }">
			<a href="<c:url value='/jsps/user/login.jsp'/>" target="_parent">Login</a> |&nbsp; 
			<a href="<c:url value='/jsps/user/regist.jsp'/>" target="_parent">Register</a> |&nbsp; <br/>
			<a href="<c:url value='/jsps/animal/animal_create.jsp'/>" target="_parent">Create animal</a> |&nbsp; 
			<a href="<c:url value='/jsps/animal/animal_read.jsp'/>" target="_parent">Read animal</a> |&nbsp; 
			<a href="<c:url value='/jsps/animal/animal_update.jsp'/>" target="_parent">Update animal</a> |&nbsp;
			<a href="<c:url value='/jsps/animal/animal_delete.jsp'/>" target="_parent">Delete animal</a> |&nbsp; <br/>
			
			<a href="<c:url value='/jsps/person/person_create.jsp'/>" target="_parent">Create person</a> |&nbsp; 
			<a href="<c:url value='/jsps/person/person_read.jsp'/>" target="_parent">Read person</a> |&nbsp; 
			<a href="<c:url value='/jsps/person/person_update.jsp'/>" target="_parent">Update person</a> |&nbsp;
			<a href="<c:url value='/jsps/person/person_delete.jsp'/>" target="_parent">Delete person</a> |&nbsp; <br/>
			
			<a href="<c:url value='/jsps/medical/medical_create.jsp'/>" target="_parent">Create medical</a> |&nbsp; 
			<a href="<c:url value='/jsps/medical/medical_read.jsp'/>" target="_parent">Read medical</a> |&nbsp; 
			<a href="<c:url value='/jsps/medical/medical_update.jsp'/>" target="_parent">Update medical</a> |&nbsp;
			<a href="<c:url value='/jsps/medical/medical_delete.jsp'/>" target="_parent">Delete medical</a> |&nbsp; <br/>
			
			<a href="<c:url value='/jsps/shelter_animal/shelter_animal_create.jsp'/>" target="_parent">Create shelter_animal</a> |&nbsp; 
			<a href="<c:url value='/jsps/shelter_animal/shelter_animal_read.jsp'/>" target="_parent">Read shelter_animal</a> |&nbsp; 
			<a href="<c:url value='/jsps/shelter_animal/shelter_animal_update.jsp'/>" target="_parent">Update shelter_animal</a> |&nbsp;
			<a href="<c:url value='/jsps/shelter_animal/shelter_animal_delete.jsp'/>" target="_parent">Delete shelter_animal</a> |&nbsp; <br/>
			
			<a href="<c:url value='/jsps/shelter_finance/shelter_finance_create.jsp'/>" target="_parent">Create shelter_finance</a> |&nbsp; 
			<a href="<c:url value='/jsps/shelter_finance/shelter_finance_read.jsp'/>" target="_parent">Read shelter_finance</a> |&nbsp; 
			<a href="<c:url value='/jsps/shelter_finance/shelter_finance_update.jsp'/>" target="_parent">Update shelter_finance</a> |&nbsp;
			<a href="<c:url value='/jsps/shelter_finance/shelter_finance_delete.jsp'/>" target="_parent">Delete shelter_finance</a> |&nbsp; <br/>
	
		</c:when>
		<c:otherwise>
			Hello：${sessionScope.session_user.username };
			<a href="<c:url value='/jsps/user/queries.jsp'/>" target="body">Query Result</a> |&nbsp;&nbsp;
			<a href="<c:url value='/UserServletLogout'/>" target="_parent">Logout</a> |&nbsp; 
			<a href="<c:url value='/jsps/entity1/menu.jsp'/>" target="body">CRUD entity 1</a> |&nbsp;&nbsp;

		</c:otherwise>
	</c:choose>

</div>
  </body>
</html>

