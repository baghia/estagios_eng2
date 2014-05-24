<%-- 
    Document   : GerenciamentoCurso
    Created on : 07/04/2014, 10:18:11
    Author     : Renan Huf Silveira
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="beans.Estagiario"%>
<%@page import="bd.EstagiarioDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%
            EstagiarioDAO eDAO = new EstagiarioDAO();
            ArrayList<Estagiario> list = null;
             if (request.getParameter("nomeCurso") == null) {
                list = eDAO.listar();
          } else {
                //list = EstagiarioDAO.consultar(request.getParameter("nomeCurso"));
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
                <tr><th class="col-lg-3 h5 text-center"><b>Mátricula</b></th><th class="col-lg-3 h5 text-center"><b>Nome</b></th><th class="col-lg-1 h5 text-center"><b>Editar</b></th><th class="col-lg-1 h5 text-center"><b>Desativar</b></th></tr>
                        <%
                            for (int i = 0; i < list.size(); i++) {
                        %>

                <tr><td class="col-lg-3 h5 text-center"><%=  list.get(i).getMatricula() %></td>
                    <td class="col-lg-3 h5 text-center"><%= list.get(i).getNome()%></td>
                    <td class="col-lg-1 h5 text-center"><a class="btn btn btn-primary" href="EditarEstagiario.jsp?id=<%= list.get(i).getId()%>"><span class="glyphicon glyphicon-pencil"></span> Editar</a></td>
                    <td class="col-lg-1 h5 text-center"><form action="ExcluirCurso" method="post"><input type="hidden" name="idCurso" value="<%= list.get(i).getId()%>"/><button class="btn btn-primary" type="submit"><span class="glyphicon glyphicon-remove"></span>Desativar</button></form></td></tr>    

                <%
                    }
                %>
            </table>
        </div>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
    <script src="//netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>
</body>
</html>
