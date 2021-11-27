<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>footer</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
	<style>
	* {
	  box-sizing: border-box;
	}
	#grad{
		height: 250px;
	 	background: -webkit-linear-gradient(#00ffff, yellow); /* For Safari 5.1 to 6.0 */
	}
	/* Create two equal columns that floats next to each other */
	.column {
	  float: left;
	  width: 50%;
	  padding: 30px;
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
<div id="grad">
	<div class="row">
	
	  <div class="column">
	    <h2>MALTOUR</h2>
	    <p>Indirizzo : Trav. P.Falciatore, 1/8<br>
				80047 S.Giuseppe Ves. (NA)<br>
				Tel.: +39 081 528 04 18<br>
				Tel.: +39 081 528 07 37<br>
				Email: info@maltour.it<br>
		</p>
	  </div>
	  
	  <div class="column">
	    <a onclick="topFunction()"><img src="img/logo1.png" width="450" height="250"></a>
	  </div>
	  
	</div>
</div>

<script>
//Get the button
var mybutton = document.getElementById("myBtn");

// When the user scrolls down 20px from the top of the document, show the button
window.onscroll = function() {scrollFunction()};

function scrollFunction() {
  if (document.body.scrollTop > 20 || document.documentElement.scrollTop > 20) {
    mybutton.style.display = "block";
  } else {
    mybutton.style.display = "none";
  }
}

// When the user clicks on the button, scroll to the top of the document
function topFunction() {
  document.body.scrollTop = 0;
  document.documentElement.scrollTop = 0;
}
</script>

</body>
</html>