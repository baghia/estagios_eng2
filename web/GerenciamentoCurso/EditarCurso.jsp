<%-- 
    Document   : EditarCurso
    Created on : 07/04/2014, 14:17:43
    Author     : Renan Huf Silveira
--%>

<%@page import="bd.CursoDAO"%>
<%@page import="model.Curso"%>
<%@page import="model.Curso"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%
            CursoDAO cursoDAO = new CursoDAO();
            Curso c = cursoDAO.consultarId(Integer.parseInt(request.getParameter("id")));
        %>
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
            <form class="form-horizontal" role="form" action="EditarCurso" method="Post">
                <input type="hidden" name="idCurso" value="<%= c.getId()%>">

                <div>
                    <h4 class="form-heading">Editar Curso</h4>
                </div>

                <div class="form-group">
                    <label class="col-sm-2 control-label">Nome do Curso:</label>
                    <div class="col-sm-3">
                        <input type="text" class="form-control" name="nomeCurso" value="<%= c.getNome()%>" required>
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-sm-2 control-label">Tipo do Curso:</label>
                    <div class="col-sm-3">
                        <input type="text" class="form-control" name="tipoCurso" value="<%= c.getTipo()%>" required>
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-sm-2 control-label">Turno:</label>
                    <div class="col-sm-3">
                        <input type="text" class="form-control" name="turnoCurso" value="<%= c.getTurno()%>" required>
                    </div>
                </div>

                <button type="submit" class="btn btn-primary col-lg-offset-2">Salvar</button>
            </form>
        </div>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
        <script src="//netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>
    </body>
</html>
