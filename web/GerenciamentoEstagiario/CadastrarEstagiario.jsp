<%-- 
    Document   : CadastrarCurso
    Created on : 07/04/2014, 11:22:06
    Author     : Renan Huf Silveira
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="../css/bootstrap-responsive.min.css" rel="stylesheet" type="text/css"/>
        <!-- Optional theme -->
        <script src="../js/bootstrap.js" type="text/javascript"></script>
        <link rel="stylesheet" href="../css/bootstrap.min.css">
        <script src="../js/bootstrap.min.js"></script>
        <title>Gerenciamento de Curso</title>
    </head>
    <body>
        <div class="container">
            <form class="form-horizontal" role="form" action="CadastroCurso" method="Post">
                <div>
                    <h4 class="form-heading">Cadastro de Curso</h4>
                </div>

                <div class="form-group">
                    <label class="col-sm-2 control-label">Nome do Curso:</label>
                    <div class="col-sm-3">
                        <input type="text" class="form-control" name="nomeCurso" required>
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-sm-2 control-label">Tipo do Curso:</label>
                    <div class="col-sm-3">
                        <input type="text" class="form-control" name="tipoCurso" required>
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-sm-2 control-label">Turno:</label>
                    <div class="col-sm-3">
                        <input type="text" class="form-control" name="turnoCurso" required>
                    </div>
                </div>

                <button type="submit" class="btn btn-primary col-lg-offset-2">Salvar</button>
            </form>
        </div>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
        <script src="//netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>
    </body>
</html>
