
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%><%@taglib prefix="c"
	uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../gestioneGenerale/header.jsp">
	<jsp:param name="pageTitle" value="${servizio.nome}"/>
</jsp:include>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
	<style>
	
	.btns {
	  border: 2px solid black;
	  background-color: white;
	  color: black;
	  padding: 14px 28px;
	  font-size: 16px;
	  cursor: pointer;
	}
	
	/* #00ced1 */
	.success {
	  border-color: #00ced1;
	  color: #00ced1;
	}
	
	.success:hover {
	  background-color: #00ced1;
	  color: white;
	}

	/* Create two equal columns that floats next to each other */
	.column {
	  float: left;
	  width: 50%;
	  padding: 10px;
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
	
	/* Style the content */
	.content {
	  padding: 60px;
	}

	</style>
</head>
<body>

<div class="content">

	<c:if test="${!(utente.cliente)}">
		<h1>${servizio.nome}</h1>
	</c:if>

		<c:if test="${utente.gestoreOfferte}">
				<form action="RimuoviServizio" method="post">
					<input type="hidden" name="id" value="${offerta.id}">
					<input type="submit" class="btnn success" name="rimuovi" value="Rimuovi">
				</form>
				<form action="ModificaServizio" method="post">
					<input type="hidden" name="id" value="${offerta.id}">
					<input type="submit" class="btnn success" value="Modifica">
				</form>
		</c:if>
		
	
	<h3>${servizio.descrizione}</h3>
	
	<c:forEach items="${offerte}" var="offerta">
		<div class="row">
		  	<div class="column">
		    	<a href="ViusalizzaOfferta?id=${offerta.id}"><img src="img/offerte/${offerta.id}.jpg" width="500" height="200"></a>
		  	</div>
		  	<div class="column">
			    <h3><a href="VisualizzaOfferta?id=${offerta.id}">${offerta.destinazione}</a></h3>
				<p>
					<h3>DESCRIZIONE: ${offerta.descrizione}</h3>
					
					<h3>POSTI DISPONIBILI: ${offerta.posti_disponibili}</h3>
				</p>
				<h4>PREZZO: ${offerta.prezzoCent} &euro;</h4>
				<h3>-------------------------------------------------------------------------------</h3>
  			</div>
		</div>
	</c:forEach>


	<c:if test="${empty offerte}">
		<div class="row">
			<div class="column" >
			    <h2>Nessun offerta nel servizio.</h2>
			</div>
		</div>
	</c:if>

</div>

</body>
</html>


<%@include file="../gestioneGenerale/footer.jsp"%>


