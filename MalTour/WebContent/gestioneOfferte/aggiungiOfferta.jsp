<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%><%@taglib prefix="c"
	uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="operazione" value="${param.rimuovi != null ? 'Rimozione' : (offerta == null ? 'Aggiungi' : 'Modifica')}"/>
<jsp:include page= "../gestioneGenerale//header.jsp">
	<jsp:param name="pageTitle" value="${operazione} offerta"/>
</jsp:include>



<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
	
	<style>
	
	input[type=text], select, textarea {
	  width: 100%;
	  padding: 12px;
	  border: 1px solid #ccc;
	  border-radius: 4px;
	  resize: vertical;
	}
	
	label {
	  padding: 12px 12px 12px 0;
	  display: inline-block;
	}
	
	
	.containerr {
	  border-radius: 5px;
	  background-color: none;
	  padding: 90px;
	}
	
	.col-25 {
	  float: left;
	  width: 25%;
	  margin-top: 6px;
	}
	
	.col-75 {
	  float: left;
	  width: 75%;
	  margin-top: 6px;
	}
	
	/* Clear floats after the columns */
	.rows:after {
	  content: "";
	  display: table;
	  clear: both;
	}
	
	/* Responsive layout - when the screen is less than 600px wide, make the two columns stack on top of each other instead of next to each other */
	@media screen and (max-width: 600px) {
	  .col-25, .col-75, input[type=submit] {
	    width: 100%;
	    margin-top: 0;
	  }
	}
	
	.btn {
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

	
	</style>
</head>
<body>

<div class="containerr">

		<h1>${operazione} Offerta</h1>
		<h5>${notifica}</h5>
		<c:if test="${param.rimuovi == null}">
		
			<form action="AdminOfferte" method="post">
			
				<input type="hidden" name="id" value="${prodotto.id}">
				
				<div class="rows">
      				<div class="col-25">
        				<label>Servizi</label>
      				</div>
      				<div class="col-75">
        				<c:forEach items="${servizi}" var="servizio">
							<input type="checkbox" name="servizi" value="${servizio.id}" <c:if test="${offerta.servizi.stream().anyMatch(c -> c.id == servizio.id).orElse(false)}">checked</c:if>> <label> ${servizio.nome}</label>
						</c:forEach>
      				</div>
    			</div>
    			
    			<div class="rows">
      				<div class="col-25">
        				<label>DESTINAZIONE</label>
      				</div>
      				<div class="col-75">
        				<input type="text" name="nome" value="${offerta.destinazione}">
      				</div>
    			</div>
				
				<div class="rows">
      				<div class="col-25">
        				<label>DESCRIZIONE</label>
      				</div>
      				<div class="col-75">
        				<textarea name="descrizione">${offerta.descrizione}</textarea>
      				</div>
    			</div>
    			<div class="rows">
      				<div class="col-25">
        				<label>DATA PARTENZA</label>
      				</div>
      				<div class="col-75">
        				<textarea name="descrizione">${offerta.data_partenza}</textarea>
      				</div>
    			</div>
    			<div class="rows">
      				<div class="col-25">
        				<label>ORA PARTENZA</label>
      				</div>
      				<div class="col-75">
        				<textarea name="descrizione">${offerta.ora_partenza}</textarea>
      				</div>
    			</div>
    			<div class="rows">
      				<div class="col-25">
        				<label>DATA RITORNO</label>
      				</div>
      				<div class="col-75">
        				<textarea name="descrizione">${offerta.data_ritorno}</textarea>
      				</div>
    			</div>
    			<div class="rows">
      				<div class="col-25">
        				<label>ORA RITORNO</label>
      				</div>
      				<div class="col-75">
        				<textarea name="descrizione">${offerta.ora_ritorno}</textarea>
      				</div>
    			</div>
    			<div class="rows">
      				<div class="col-25">
        				<label>PARTENZA DA</label>
      				</div>
      				<div class="col-75">
        				<textarea name="descrizione">${offerta.partenza_da}</textarea>
      				</div>
    			</div>
    			<div class="rows">
      				<div class="col-25">
        				<label>ARRIVO A </label>
      				</div>
      				<div class="col-75">
        				<textarea name="descrizione">${offerta.arrivo_a}</textarea>
      				</div>
    			</div>
    			<div class="rows">
      				<div class="col-25">
        				<label>PERNOTTAMENTO</label>
      				</div>
      				<div class="col-75">
        				<textarea name="descrizione">${offerta.pernottamento}</textarea>
      				</div>
    			</div>
    			<div class="rows">
      				<div class="col-25">
        				<label>POSTI DISPONIBILI</label>
      				</div>
      				<div class="col-75">
        				<textarea name="descrizione">${offerta.posti_disponibili}</textarea>
      				</div>
    			</div>
				
				<div class="rows">
      				<div class="col-25">
        				<label>PREZZO:</label>
      				</div>
      				<div class="col-75">
        				<input type="number" name="prezzoCent" value="${offerta.prezzoCent}">
      				</div>
    			</div>
				
				
				
				
				
				<input type="submit"  class="btn success" value="${operazione}">
				
				<form action="RimuoviOfferta" method="post">
				<c:if test="${offerta != null}">
					<input type="submit"  class="btn success" name="rimuovi" value="Rimuovi">
				</c:if>
				</form>
			</form>
			
		</c:if>

	
</div>


</body>
</html>	
	
<%@include file="../gestioneGenerale/footer.jsp"%>



