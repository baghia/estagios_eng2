

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastrar Contato</title>
        <jsp:include page = "../css/bibliotecascss.jsp"/>
    </head>
    <body>
        <div class="container">
            <form class="form-horizontal" role="form" action="../CadastroContatoConvenio" method="Post">
                <input type="hidden" name="id_convenio" value="<%= request.getParameter("id_convenio")%>">

                <div>
                    <h4 class="form-heading">Contatos:</h4>
                </div>

                <div class="form-group">
                    <label class="col-sm-2 control-label">Nome:</label>
                    <div class="col-sm-3">
                        <input type="text" class="form-control" name="nome" required>
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-sm-2 control-label">Email:</label>
                    <div class="col-sm-3">
                        <input type="text" class="form-control" name="email" placeholder="exemplo@exemplo.com.br">
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-sm-2 control-label">Cargo:</label>
                    <div class="col-sm-3">
                        <input type="text" class="form-control" name="cargo" required>
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-sm-2 control-label">Setor:</label>
                    <div class="col-sm-3">
                        <input type="text" class="form-control" name="setor">
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-sm-2 control-label">Horario:</label>
                    <div class="col-sm-3">
                        <input type="text" class="form-control" name="horario">
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-sm-2 control-label">Telefone:</label>
                    <div class="col-sm-3">
                        <input type="text" class="form-control" name="telefone" pattern="\([0-9]{2}\)[\s][0-9]{4}-[0-9]{4}" placeholder="(xx) xxxx-xxxx">
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-sm-2 control-label">Celular:</label>
                    <div class="col-sm-3">
                        <input type="text" class="form-control" name="celular" pattern="\([0-9]{2}\)[\s][0-9]{4}-[0-9]{4}" placeholder="(xx) xxxx-xxxx">
                    </div>
                </div>

                <button type="submit" class="btn btn-primary col-lg-offset-2">Salvar</button>
            </form>
        </div>
        <jsp:include page = "../js/bibliotecasjs.jsp"/>
    </body>
</html>
