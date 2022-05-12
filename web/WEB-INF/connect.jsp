<%-- 
    Document   : Connect
    Created on : 9 mai 2022, 11:52:51
    Author     : stag
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
          <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Connexion</title>
        <link rel="stylesheet" href="<c:url value='/rsc/css/style.css'/>">
        <link rel="stylesheet" href="<c:url value='/rsc/css/form.css'/>">
    </head>
    <body>
        <%@include file="./jspf/header.jspf" %>
        
        <main>
            <fieldset>
                <legend>Connexion</legend>
                <form action="" method="post">
                    <div>
                        <label for="email">Votre courriel<span class="required">*</span></label>
                        <input type="text" id="email" name="email" value="<c:out value="${requestScope.user.email}"/>">
                        <span class="error">${requestScope.errors.email}</span>
                    </div>
                    <div>
                        <label for="pwd">Votre mot de passe<span class="required">*</span></label>
                        <input type="password" id="pwd" name="pwd">
                        <span class="error">${requestScope.errors.pwd}</span>
                    </div>
                    <div>
                        <input type="submit" value="Envoyer">
                    </div>
                </form>
            </fieldset>
        </main>
        <%@include file="./jspf/footer.jspf" %>
  
    </body>
</html>
