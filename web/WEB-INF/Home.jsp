<%-- 
    Document   : Home
    Created on : 12 mai 2022, 14:03:32
    Author     : stag
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
        <link rel="stylesheet" href="<c:url value='/css/style.css'/>">

    </head>
    <body>
        <%@include file="./jspf/header.jspf" %>
        <main>
            <h1> Bienvenue sur Co-Dinner !</h1>
            <h4>L'application pour organiser vos repas de partage.</h4>

            <a href="<c:url value='/connect'/>" class="btn btn-primary btn-lg disabled" role="button" aria-disabled="true">Connexion</a>
            <a href="<c:url value='/register'/>" class="btn btn-primary btn-lg disabled" role="button" aria-disabled="true">Inscription</a>
           




        </main>
        <%@include file="./jspf/footer.jspf" %>
    </body>
</html>
