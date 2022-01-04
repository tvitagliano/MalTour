
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%><%@taglib prefix="c"
	uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../gestioneGenerale/header.jsp">
	<jsp:param name="pageTitle" value="${servizio.nome}"/>
</jsp:include>
<!DOCTYPE html>
<%@ page import="java.util.List,GestioneServizi.Servizio,GestioneUtente.Utente"%>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<%

 		Utente utenti = (Utente) request.getAttribute("utente");
	%>
	
	<style>
	
		html, body{
	margin:0;
	padding:0;
	font-family: "Trebuchet MS", Georgia, Arial, sans-serif;
	font-size:100%;
	text-align:center;
	} 
	
	
	#contenitore{
	width: 98%;
	margin: 1% 1% 1% 1%;
	background:none;
	height:300;
	
	}
	
	.sin{
	position: relative;
	height: 300;
	float: left;
	margin-right: 8%;
	background-color: none;
	width:28%;
	
	}
	
	.cen{
	position: relative;
	float: left;
	background: none;
	width: 28%;
	height: 300; 
	
	}
	
	.des{
	position: relative;
	float: right;
	background: none;
	width:28%;
	height: 300;
	
	}
	.content {
	height: 600px;
  	
	}
	/* Responsive layout - makes the three columns stack on top of each other instead of next to each other */
		@media screen and (max-width: 600px) {
		  .column {
		    width: 100%;
		  }
		}
		
	.btn {
	  background-color: #00ced1;
	  color: black;
	  padding: 15px 20px;
	  border: none;
	  cursor: pointer;
	  width: 100%;
	  opacity: 0.9;
	}
	
	.btn:hover {
	  opacity: 1;
	}
	.custom-select {
	  position: relative;
	  font-family: Arial;
	}
	
	.custom-select select {
	  display: none; /*hide original SELECT element:*/
	}
	
	.select-selected {
	  background-color: #00ced1;
	}
	
	/*style the arrow inside the select element:*/
	.select-selected:after {
	  position: absolute;
	  content: "";
	  top: 14px;
	  right: 10px;
	  width: 0;
	  height: 0;
	  border: 6px solid transparent;
	  border-color: #fff transparent transparent transparent;
	}
	
	/*point the arrow upwards when the select box is open (active):*/
	.select-selected.select-arrow-active:after {
	  border-color: transparent transparent #fff transparent;
	  top: 7px;
	}
	
	/*style the items (options), including the selected item:*/
	.select-items div,.select-selected {
	  color: #ffffff;
	  padding: 8px 15px;
	  border: 1px solid transparent;
	  border-color: transparent transparent rgba(0, 0, 0, 0.1) transparent;
	  cursor: pointer;
	  user-select: none;
	}
	
	/*style items (options):*/
	.select-items {
	  position: absolute;
	  background-color: #00ced1;
	  top: 100%;
	  left: 0;
	  right: 0;
	  z-index: 99;
	}
	
	/*hide the items when the select box is closed:*/
	.select-hide {
	  display: none;
	}
	
	.select-items div:hover, .same-as-selected {
	  background-color: rgba(0, 0, 0, 0.1);
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
<div id="contenitore">

<h2>Offerta </h2>
	<div class="sin">
		<img src="img/offerte/${offerta.id}.jpg" width="500" height="200">
	</div>
	
	<div class="cen">
		<h3>${offerta.destinazione}</h3>
		<h3>DESCRIZIONE: ${offerta.descrizione}</h3>
		<h3>DATA PARTENZA: ${offerta.data_partenza}</h3>
		<h3>ORA PARTENZA:${offerta.ora_partenza}</h3>
		<h3>DATA RITORNO: ${offerta.data_ritorno}</h3>
		<h3>ORA RITORNO: ${offerta.ora_ritorno}</h3>
		<h3>PARTENZA DA: ${offerta.partenza_da}</h3>
		<h3>ARRIVO A: ${offerta.arrivo_a}</h3>
		<h3>PERNOTTAMENTO: ${offerta.pernottamento}</h3>
		<h3>POSTI DISPONIBILI: ${offerta.posti_disponibili}</h3>
	</div>
	
	<div class="des">
		
		<c:if test="${utente.gestoreOfferte}">
				<form action="RimuoviOfferta" method="post">
					<input type="hidden" name="id" value="${offerta.id}">
					<input type="submit" class="btnn success" name="rimuovi" value="Rimuovi">
				</form>
				<form action="ModificaOfferta" method="post">
					<input type="hidden" name="id" value="${offerta.id}">
					<input type="submit" class="btnn success" value="Modifica">
				</form>
		</c:if>
		
		
		<p>Servizi:
			<c:forEach items="${offerta.servizi}" var="servizio" varStatus="status">
				<a href="VisualizzaServizio?id=<c:out value="${servizio.id}"/>"><c:out value="${servizio.nome}" /></a><c:if test="${not status.last}">, </c:if>
			</c:forEach>
		</p>
		
		<c:if test="${utente.cliente}">
			<h4>PREZZO PER PERSONA: ${offerta.prezzoCent} &euro;</h4>
				<form action="AggiungiCarrello" method="post">
					<label>PERSONE:</label>
						<select name="addNum">
							<c:forEach begin="1" end= "${offerta.posti_disponibili}" varStatus="loop">
								<option value="${loop.index}">${loop.index}</option>
							</c:forEach>
						</select>
					<br>
					<input type="hidden" name="prodId" value="${offerta.id}">
					<input type="submit" class="btnn success"  value="Aggiungi al carrello">
				</form>
		</c:if>
	</div>

</div>
</div>
	

<script>
var x, i, j, l, ll, selElmnt, a, b, c;
/*look for any elements with the class "custom-select":*/
x = document.getElementsByClassName("custom-select");
l = x.length;
for (i = 0; i < l; i++) {
  selElmnt = x[i].getElementsByTagName("select")[0];
  ll = selElmnt.length;
  /*for each element, create a new DIV that will act as the selected item:*/
  a = document.createElement("DIV");
  a.setAttribute("class", "select-selected");
  a.innerHTML = selElmnt.options[selElmnt.selectedIndex].innerHTML;
  x[i].appendChild(a);
  /*for each element, create a new DIV that will contain the option list:*/
  b = document.createElement("DIV");
  b.setAttribute("class", "select-items select-hide");
  for (j = 1; j < ll; j++) {
    /*for each option in the original select element,
    create a new DIV that will act as an option item:*/
    c = document.createElement("DIV");
    c.innerHTML = selElmnt.options[j].innerHTML;
    c.addEventListener("click", function(e) {
        /*when an item is clicked, update the original select box,
        and the selected item:*/
        var y, i, k, s, h, sl, yl;
        s = this.parentNode.parentNode.getElementsByTagName("select")[0];
        sl = s.length;
        h = this.parentNode.previousSibling;
        for (i = 0; i < sl; i++) {
          if (s.options[i].innerHTML == this.innerHTML) {
            s.selectedIndex = i;
            h.innerHTML = this.innerHTML;
            y = this.parentNode.getElementsByClassName("same-as-selected");
            yl = y.length;
            for (k = 0; k < yl; k++) {
              y[k].removeAttribute("class");
            }
            this.setAttribute("class", "same-as-selected");
            break;
          }
        }
        h.click();
    });
    b.appendChild(c);
  }
  x[i].appendChild(b);
  a.addEventListener("click", function(e) {
      /*when the select box is clicked, close any other select boxes,
      and open/close the current select box:*/
      e.stopPropagation();
      closeAllSelect(this);
      this.nextSibling.classList.toggle("select-hide");
      this.classList.toggle("select-arrow-active");
    });
}
function closeAllSelect(elmnt) {
  /*a function that will close all select boxes in the document,
  except the current select box:*/
  var x, y, i, xl, yl, arrNo = [];
  x = document.getElementsByClassName("select-items");
  y = document.getElementsByClassName("select-selected");
  xl = x.length;
  yl = y.length;
  for (i = 0; i < yl; i++) {
    if (elmnt == y[i]) {
      arrNo.push(i)
    } else {
      y[i].classList.remove("select-arrow-active");
    }
  }
  for (i = 0; i < xl; i++) {
    if (arrNo.indexOf(i)) {
      x[i].classList.add("select-hide");
    }
  }
}
/*if the user clicks anywhere outside the select box,
then close all select boxes:*/
document.addEventListener("click", closeAllSelect);
</script>
</body>
	
<%@include file="../gestioneGenerale/footer.jsp"%>