<%-- 
    Document   : GerenciamentoCurso
    Created on : 07/04/2014, 10:18:11
    Author     : Renan Huf Silveira
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="beans.Curso"%>
<%@page import="bd.CursoDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%
            CursoDAO cursoDAO = new CursoDAO();
            ArrayList<Curso> listCurso;
             if (request.getParameter("nomeCurso") == null) {
                listCurso = cursoDAO.listar();
          } else {
                listCurso = cursoDAO.consultar(request.getParameter("nomeCurso"));
            }
        %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="../css/bootstrap-responsive.min.css" rel="stylesheet" type="text/css"/>
        <!-- Optional theme -->
        <script src="../js/bootstrap.js" type="text/javascript"></script>
        <link rel="stylesheet" href="../css/bootstrap.min.css">
        <script src="../js/bootstrap.min.js"></script>
        <title>Gerenciamento de Estágiario</title>
    </head>
    <body>
        <div class="container">
            <div>
                <h4 class="form-heading">Gerenciamento de Estágiario</h4>
            </div>
            <form class="form-horizontal" role="form" action="GerenciamentoEstagiario.jsp" method="get">
                <div class="form-group">
                    <div class="col-sm-3">
                        <input class="form-control" type="text" name="nomeCurso"/>
                    </div>
                    <button class="btn btn-primary" type="submit"><span class="glyphicon glyphicon-search"></span> Procurar</button>
                    <a class="btn btn-primary" href="CadastrarEstagiario.jsp"><span class="glyphicon glyphicon-plus"></span> Cadastrar Novo Estágiario</a>
                </div>
            </form>


            <table class="table table-striped table-bordered">
                <tr><th class="col-lg-3 h5 text-center"><b>Nome</b></th><th class="col-lg-3 h5 text-center"><b>Matrícula</b></th><th class="col-lg-1 h5 text-center"><b>Editar</b></th><th class="col-lg-1 h5 text-center"><b>Desativar</b></th></tr>
                        <%
                            for (int i = 0; i < listCurso.size(); i++) {
                        %>

                <tr><td class="col-lg-3 h5 text-center"><%=  listCurso.get(i).getNome()%></td>
                    <td class="col-lg-3 h5 text-center"><%= listCurso.get(i).getTipo()%></td>
                    <td class="col-lg-1 h5 text-center"><a class="btn btn btn-primary" href="EditarEstagiario.jsp?id=<%= listCurso.get(i).getId()%>"><span class="glyphicon glyphicon-pencil"></span> Editar</a></td>
                    <td class="col-lg-1 h5 text-center"><form action="ExcluirCurso" method="post"><input type="hidden" name="idCurso" value="<%= listCurso.get(i).getId()%>"/><button class="btn btn-primary" type="submit"><span class="glyphicon glyphicon-remove"></span>Desativar</button></form></td></tr>    

                <%
                    }
                %>
            </table>
        </div>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
    <script src="//netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>
</body>
</html>
