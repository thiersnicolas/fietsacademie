<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://vdab.be/tags" prefix="v"%>
<!doctype html>
<html lang="nl">
<head>
<v:head title="Docenten voornamen"></v:head>
</head>
<body>
	<v:menu />
	<h1>Docenten voornamen</h1>
	<ul class="zonderbolletjes">
		<c:forEach var="voornaam" items="${voornamen}">
			<li style="font-size:${voornaam.length() mod 3+1}em">${voornaam}</li>
		</c:forEach>
	</ul>
</body>
</html>