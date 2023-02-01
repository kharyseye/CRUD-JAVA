<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Mettre a jour un produit</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<body>
	<%@include file="header.jsp" %>
	<p></p>
	<div class="container col-md-6 col-md-offset-2">
		<div class="card">
			<div class="card-header text-center text-white" style="background-color: #412b8a;">Editer un produit</div>
			<div class="card-body">
				<form action="update.php" method="post">
					<div class="form-group">
						<label class="form-label">ID :</label> 
						<input type="text"name="id" value="${produit.id}" class="form-control" diseable="disable"/>
					</div>
					<div class="form-group">
						<label class="form-label">Designation :</label> 
						<input type="text"name="designation" value="${produit.designation}" class="form-control" required="required"/>
					</div>
					<div class="form-group">
						<label class="form-label">Prix :</label> 
						<input type="text"name="prix" value="${produit.prix}" class="form-control"/>
					</div>
					<div class="form-group">
						<label class="form-label">Quantite :</label> 
						<input type="text"name="quantite" value="${produit.quantite}" class="form-control"/>
					</div>
					<p></p> 
					<div class="d-grid gap-2 col-6 mx-auto" >
						<button type="submit" class="btn text-white" style="background-color: #412b8a;">Editer</button>
					</div>
					
				</form>
				<p></p>
				
			</div>
		</div>
	</div>

</body>
</html>