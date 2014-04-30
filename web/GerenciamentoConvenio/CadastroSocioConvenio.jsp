<%-- 
    Document   : CadastroSocio
    Created on : 04/04/2014, 10:28:15
    Author     : Guilherme
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:include page = "../css/bibliotecascss.jsp"/>
        <title>Cadastro Socio</title>
    </head>
    <body>
        <div class="container">
            <form class="form-horizontal" role="form" action="../CadastroSocioConvenio" method="Post">
                <input type="hidden" name="id_convenio" value="<%= request.getParameter("id_convenio")%>">

                <div>
                    <h4 class="form-heading">Socio:</h4>
                </div>

                <div class="form-group">
                    <label class="col-sm-2 control-label">Nome:</label>
                    <div class="col-sm-3">
                        <input type="text" class="form-control" name="nome" required>
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-sm-2 control-label">RG:</label>
                    <div class="col-sm-3">
                        <input type="text" class="form-control" name="rg" required>
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-sm-2 control-label">CPF:</label>
                    <div class="col-sm-3">
                        <input type="text" class="form-control" name="cpf" pattern="[0-9]{3}.[0-9]{3}.[0-9]{3}-[0-9]{2}" placeholder="000.000.000-00" required>
                    </div>
                </div>


                <button type="submit" class="btn btn-primary col-lg-offset-2">Salvar</button>
            </form>
        </div>
        <jsp:include page = "../js/bibliotecasjs.jsp"/>
    </body>
</html>
