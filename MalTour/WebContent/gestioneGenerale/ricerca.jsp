<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%><%@taglib prefix="c"
	uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="header.jsp">
	<jsp:param name="pageTitle" value="${param.q}"/>
</jsp:include>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
* {
  box-sizing: border-box;
}

/* Create two equal columns that floats next to each other */
.column {
  float: left;
  width: 50%;
  padding: 10px;
  height: 300px; /* Should be removed. Only for demonstration */
}

/* Clear floats after the columns */
.row:after {
  content: "";
  display: table;
  clear: both;
}

/* Responsive layout - makes the two columns stack on top of each other instead of next to each other */
@media screen and (max-width: 600px) {
  .column {
    width: 100%;
  }
}
</style>
</head>
<body>

<div class="row">

	<c:forEach items="${offerte}" var="offerta">
	
	  <div class="column">
	    <a href="#"><img src="img/offerte/${offerta.id}.jpg" width="600" height="250"></a>
	  </div>
	  
	  <div class="column">
	    	<h3><a href="Offerta?id=${offerta.id}">${offerta.nome}</a></h3>
			<p>${offerta.descrizione}</p>
			<h4>Prezzo: ${offerta.prezzoEuro} &euro;</h4>
	  </div>
	  
  	</c:forEach>
  	
  	<c:if test="${empty offerte}">
		<div class="column">Nessun offerta trovata.</div>
	</c:if>
  
</div>

</body>
</html>

<%@include file="footer.jsp"%>