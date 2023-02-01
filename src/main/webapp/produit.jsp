<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Produit</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<body>
<%@include file="header.jsp" %>
<p></p>
	<div class="container col-md-10 col-md-offset-1">
		<div class="card">
			<div class="card-header bg-info text-center text-white">Chercher des produits</div>
			<div class="card-body">
				<form action="chercher.php" method="get" class="text-center">
					<label>Mot-cle :</label> 
					<input type="text"name="motcle" value="${model.motcle}"/>
					<button type="submit" class="btn btn-info">Chercher</button>
				</form>
				<p></p>
				<div>
					<table class="table table-striped">
						<tr>
							<th>ID</th>
							<th>DESIGNATION</th>
							<th>PRIX</th>
							<th>QUANTITE</th>
							<th>SUPPRIMER</th>
							<th>EDITER</th>
						</tr>
						<c:forEach items="${model.produit}" var="p">
							<tr>
								<td>${p.id}</td>
								<td>${p.designation}</td>
								<td>${p.prix}</td>
								<td>${p.quantite}</td>
								<td> <a onclick="return confirm('Voulez-vous supprimer?')" href="supprimer.php?id=${p.id}"><img alt="" src="icone/delete-2.png"></a></td>
								<td> <a href="editer.php?id=${p.id}"><img alt="" src="icone/pencil.png"></a></td>
							</tr>
							
						</c:forEach>
					</table>
				</div>
			</div>
		</div>
	</div>
</body>
</html>