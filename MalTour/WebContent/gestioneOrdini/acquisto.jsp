<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%><%@taglib prefix="c"
                                         uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../gestioneGenerale/header.jsp">
    <jsp:param name="pageTitle" value="Carrello"/>
</jsp:include>
<!DOCTYPE html>
<html>
<head>
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

  	<form  action="Ordine" method="post">

            <input type="hidden" name="id" value="${utente.id}">
            <input type="hidden" name="prezzo" value="${carrello.getPrezzoTotEuro()}">
			
			<label for="fname">Specifica un indirizzo di spedizione del pacchetto viaggio</label>
            
            <input type="text" name="indirizzo">
            <input id="acquista" class="btnn success" type="submit" value="Procedi" >

	</form>
</div>

</body>
</html>



<%@include file="../gestioneGenerale/footer.jsp"%>
