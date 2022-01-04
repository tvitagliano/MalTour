 <%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%><%@taglib prefix="c"
	uri="http://java.sun.com/jsp/jstl/core"%>
	
	<jsp:include page="header.jsp">
		<jsp:param name="pageTitle" value="Home"/>
	</jsp:include>
	
		
	<%@ page import="java.util.List, GestioneOfferte.Offerta" %>
<head>
 	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
  	
  	<% 
		List <Offerta> offerte =  (List <Offerta>) request.getAttribute("offerte");
	%>
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
  	

			<h2>Offerte in evidenza</h2>

			<div class=row>
				<% 
					for ( int i = 0; i < offerte.size(); i++){
						Offerta offerta = offerte.get(i);
				%>
				<div class=column>
					<h3>
						<a href="VisualizzaOfferta?id=<%= offerta.getId() %>"><%= offerta.getDestinazione() %></a>
					</h3>
					<a href="ViusalizzaOfferta?id=<%= offerta.getId() %>"><img src="img/offerte/<%= offerta.getId() %>.jpg" width="400" height="200"></a>
					<h4>Prezzo: <%= offerta.getPrezzoCent() %> &euro;</h4>
				
				
				</div>
				<h5>------------------------------ </h5>
				<%
				}
				%>
				
			</div>
	

<p> <br> <br></p>
</div>
  

</body>	

<%@include file="footer.jsp"%>
