<%-- 
    Document   : formFood
    Created on : 11 mai 2022, 19:54:34
    Author     : stag
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Formulaire pour entrer les plats amenés</title>

       <link rel="stylesheet" href="<c:url value='/rsc/css/form.css'/>">
    </head>
    <body>
        <%@include file="./jspf/header.jspf" %>

        <main>
            <form action="" method="post">
                <fieldset>
                    <legend>Qu'amènes-tu?</legend>
                    <div>
                        <label for="entree">Une entrée ?</label>
                        <input type="text" id="entree" name="entree" value="<c:out value="${requestScope.food.entree}"/>">

                    </div>
                    <div>
                        <label for="plat">Un plat ?</label>
                        <input type="text" id="plat" name="plat" value="<c:out value="${requestScope.food.plat}"/>">

                    </div>
                    <div>
                        <label for="dessert">Un dessert ?</label>
                        <input type="text" id="dessert" name="dessert" value="<c:out value="${requestScope.food.dessert}"/>">

                    </div>
                    <div>
                        <label for="boisson">Un Boisson ?</label>
                        <input type="text" id="boisson" name="boisson" value="<c:out value="${requestScope.food.boisson}"/>">

                    </div>
                    <div>
                        <label for="remarque">Vos remarque !!!</label>
                        <input type="text" id="remarque" name="remarque" value="<c:out value="${requestScope.food.remarque}"/>">

                    </div>

                    <div>
                        <input type="submit" value="Envoyer">
                    </div>
                </fieldset>
            </form>
        </main>
        <%@include file="./jspf/footer.jspf" %>
    </body>
</html>
