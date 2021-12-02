<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Update animal</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="content-type" content="text/html;charset=utf-8">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  <h1>Update animal</h1>
<p style="color: red; font-weight: 900">${msg }</p>
<form>
	id    :<input type="text" name="id" value="${animal.id }" disabled/>
	<br/>
	name：<input type="text" name="name" value="${animal.name }" disabled/>
	<br/>
	species	：<input type="text" name="species" value="${animal.species }" disabled/>
	<br/>
	age	：<input type="text" name="age" value="${animal.age }" disabled/>
	<br/>
	physical_description	：<input type="text" name="physical_description" value="${animal.physical_description }" disabled/>
	<br/>
	microchip_id	：<input type="text" name="microchip_id" value="${animal.microchip_id }" disabled/>
	<br/>
	adoption_history	：<input type="text" name="adoption_history" value="${animal.adoption_history }" disabled/>
	<br/>
</form>


<h1>Update the values below</h1>
<form action="<c:url value='/animalServletUpdate'/>" method="post">
		<input type="hidden" name="method" value="update"/>
		<input type="hidden" name="id" value="${animal.id }"/>
	name：<input type="text" name="name" value="${form.name }"/>
	<span style="color: red; font-weight: 900">${errors.name }</span>
	<br/>
	species	：<input type="text" name="species" value="${form.species }"/>
	<span style="color: red; font-weight: 900">${errors.species }</span>
	<br/>
	age	：<input type="text" name="age" value="${form.age }"/>
	<span style="color: red; font-weight: 900">${errors.age }</span>
	<br/>
	physical_description	：<input type="text" name="physical_description" value="${form.physical_description }"/>
	<span style="color: red; font-weight: 900">${errors.physical_description }</span>
	<br/>
	microchip_id	：<input type="text" name="email" value="${form.microchip_id }"/>
	<span style="color: red; font-weight: 900">${errors.microchip_id }</span>
	<br/>
	adoption_history	：<input type="text" name="adoption_history" value="${form.adoption_history }"/>
	<span style="color: red; font-weight: 900">${errors.adoption_history }</span>
	<br/>
	<input type="submit" value="Update animal"/>
</form>

</body>
</html>
