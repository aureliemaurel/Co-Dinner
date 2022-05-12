<%-- 
    Document   : register
    Created on : 11 mai 2022, 10:22:11
    Author     : stag
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
   <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inscription</title>
        
        <link rel="stylesheet" href="<c:url value='/rsc/css/form.css'/>">
    </head>
    <body>
        <%@include file="./jspf/header.jspf" %>
       
        <main>
            <form action="" method="post">
                <fieldset>
                    <legend>Inscription</legend>
                    <div>
                        <label for="name">Votre courriel<span class="required">*</span></label>
                        <input type="text" id="email" name="email" value="<c:out value="${requestScope.user.email}"/>">
                        <span class="error">${requestScope.errors.email}</span>
                    </div>
                    <div>
                        <label for="pwd">Votre mot de passe<span class="required">*</span></label>
                        <input type="password" id="pwd" name="pwd">
                        <span class="error">${requestScope.errors.pwd}</span>
                    </div>
                    <div>
                        <label for="confirm">Confirmation<span class="required">*</span></label>
                        <input type="password" id="confirm" name="confirm">
                        <span class="error">${requestScope.errors["confirm"]}</span>
                    </div>
                    <div>
                        <label for="email">Votre pseudo</label>
                        <input type="text" id="pseudo" name="pseudo" value="<c:out value="${requestScope.user.pseudo}"/>">
                        <span class="error">${requestScope.errors.pseudo}</span>
                    </div>
                    <div>
                        <label for="tel">Votre tel</label>
                        <input type="text" id="pseudo" name="tel" value="<c:out value="${requestScope.user.tel}"/>">
                        <span class="error">${requestScope.errors.tel}</span>
                    </div>
                    <div>
                        <label for="name">Votre nom</label>
                        <input type="text" id="name" name="name" value="<c:out value="${sessionScope.user.name}"/>">
                        <span class="error">${requestScope.errors.name}</span>
                    </div>
                    <div>
                        <label for="first_name">Votre prenom</label>
                        <input type="text" id="first_name" name="first_name" value="<c:out value="${requestScope.user.first_name}"/>">
                        <span class="error">${requestScope.errors.first_name}</span>
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
