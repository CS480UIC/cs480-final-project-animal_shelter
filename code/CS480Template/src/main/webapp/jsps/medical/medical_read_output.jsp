<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Read Medical Output</title>
    
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
  <h1>Read Medical Output</h1>
<p style="color: red; font-weight: 900">${msg }</p>
<form>
	animal_id    :<input type="text" name="animal_id" value="${medical.animal_id }" disabled/>
	<br/>
	clinic_id：<input type="text" name="clinic_id" value="${medical.clinic_id }" disabled/>
	<br/>
	vet_id	：<input type="text" name="vet_id" value="${medical.vet_id }" disabled/>
	<br/>
	date_of_visit	：<input type="text" name="date_of_visit" value="${medical.date_of_visit }" disabled/>
	<br/>
	diagnosis	：<input type="text" name="diagnosis" value="${medical.diagnosis }" disabled/>
	<br/>
	prescription	：<input type="text" name="prescription" value="${medical.prescription }" disabled/>
	<br/>
	total_due	：<input type="text" name="total_due" value="${medical.total_due }" disabled/>
	<br/>
</form>

<button onclick="window.location.href='<c:url value='/jsps/main.jsp'/>'">Continue</button>
</body>
</html>
