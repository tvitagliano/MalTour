<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%><%@taglib prefix="c"
                                         uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../gestioneGenerale/header.jsp">
    <jsp:param name="pageTitle" value="Carrello"/>
</jsp:include>

<!DOCTYPE html>
<%@ page
	import="java.util.List,GestioneOrdini.Ordine,GestioneUtente.Utente,GestioneOrdini.ComponentiViaggio"%>
<html>
<head>
<%
		List <Ordine> componenti =  (List <Ordine>) request.getAttribute("componenti");
 		Utente utenti = (Utente) request.getAttribute("utente");
%>


	<style>
	input[type=text], select {
	  width: 100%;
	  padding: 12px 20px;
	  margin: 8px 0;
	  display: inline-block;
	  border: 1px solid #ccc;
	  border-radius: 4px;
	  box-sizing: border-box;
	}
	
	
	
	
	/* Style the content */
	.content {
	  padding: 60px;
	  width: 1000px;
	  
	}
	
	.btnn {
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


<div class="content">

  	<form  action="AggiungiComponenti" method="post">

            <input type="hidden" name="id" value="${utente.id}">
            <input type="hidden" name="prezzo" value="${carrello.getPrezzoTotEuro()}">
			
			<label for="fname">Specifica l'email destinatario</label>
             <input type="text" name="indirizzo">
             <label for="fname">inserisci componenti viaggio </label>
             	<% 
					for(int i = 0; i< componenti.size() ; i++){
						Ordine ordine =  componenti.get(i);
				%>
				<label for="fname">Nome</label>
             	<input type="text" name="nome">
             	
             	<label for="fname">Cognome</label>
             	<input type="text" name="cognome">
             	
             	<label for="fname">data di nascita</label>
             	<input type="text" name="data_nascita">
             		
				<%
					}
				%>
            
             
            <input id="acquista" class="btnn success" type="submit" value="Procedi" >

	</form>
</div>

</body>
</html>



<%@include file="../gestioneGenerale/footer.jsp"%>
