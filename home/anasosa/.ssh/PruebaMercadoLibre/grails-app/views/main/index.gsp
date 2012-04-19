<html>
	<head>
		<title>Busqueda de articulos</title>
	</head>
	<body>
		<br/>
		<g:form>
			<center><h2>Busqueda de articulos</h2></center> 
			<br/>
			Nombre de articulo: <g:textField name="searchString"/>
			<g:actionSubmit value="Buscar"/>
		</g:form>
		<br/>
		<g:if test="${session.results }">
			<g:each in="${session.results}" var="item">
				<table>
					<tr>
						<td><g:img uri="${item.thumbnailURL}"/><br/></td>
						<td><g:link url="${item.permalink}">${item.title}</g:link></td>
					</tr>
				</table>
			</g:each>
		</g:if>
	</body>
</html>