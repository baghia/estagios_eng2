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
                <div>
                    <h4 class="form-heading">Contato</h4>
                </div>

                <div class="form-group">
                    <label class="col-sm-2 control-label">Contato:</label>
                    <div class="col-sm-3">
                        <input type="text" class="form-control" name="contatoValor" required>
                    </div>
                </div>

                <button type="submit" class="btn btn-primary col-lg-offset-2">Salvar</button>
            </form>
        </div>
        <jsp:include page = "../js/bibliotecasjs.jsp"/>
    </body>
</html>

