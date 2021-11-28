<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%><%@taglib prefix="c"
	uri="http://java.sun.com/jsp/jstl/core"%>
	
<jsp:include page="../gestioneGenerale/header.jsp">
	<jsp:param name="pageTitle" value="Carrello"/>
</jsp:include>
	

<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
		<style>

		table {
		  border-collapse: collapse;
		  border-spacing: 0;
		  width: 100%;
		  border: 1px solid #ddd;
		}
		
		th, td {
		  text-align: left;
		  padding: 8px;
		}
		
		tr:nth-child(even){background-color: none}
				
		</style>
</head>
<body>
<div style="overflow-x:auto;">
	<h1>CARRELLO</h1>
  <table>
  
  	<c:forEach var="pq" items="${carrello.prodotti}" >
	    <tr>
	      	<td><a href="#"><img src="img/offerte/${pq.offerta.id}.jpg" width="500" height="200"></a></td>
			<td>
				<h3><a href="Offerta?id=${pq.offerta.id}">${pq.offerta.nome}</a></h3>
				<p>${pq.offerta.descrizione}</p>
				<h5>Quantità: ${pq.quantita}, Prezzo unit.: ${pq.offerta.prezzoEuro} &euro;, Prezzo tot.: ${pq.prezzoTotEuro} &euro;</h5>
				<form action="Carrello" method="post">
					<input type="hidden" name="prodId" value="${pq.offerta.id}">
					<input type="hidden" name="setNum" value="0">
					<input type="submit" class="btnn success" value="Rimuovi">
				</form>
			</td>
		</tr>
    </c:forEach>
    
    <c:if test="${empty carrello.prodotti}">
	    <tr>
	      <td> </td>
	      <td>Nessun offerta nel carrello</td>
	      <td> </td>
		</tr>
	</c:if>
    
    <c:if test="${not empty carrello.prodotti}">
	    <tr>
	      <td> </td>
	      <td> </td>
	      	<td>
				<h2>Totale: ${carrello.prezzoTotEuro} &euro;</h2>
				<form action="Spedizione">
					<input  type="submit"  class="btnn success" value="Acquista">
				</form>
			</td>
		</tr>
	</c:if>
    
    
  </table>
</div>




	
</body>
</html>

	
	
<%@include file="../gestioneGenerale/footer.jsp"%>