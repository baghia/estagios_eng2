
<%@page import="dao.ConvenioDAO"%>
<%@page import="beans.Convenio"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:include page = "../css/bibliotecascss.jsp"/>
        <title>JSP Page</title>
        <%

            ConvenioDAO convenioDAO = new ConvenioDAO();
            List<Convenio> listConvenio = new ArrayList<Convenio>();

            if (request.getParameter("nome_da_empresa") == null) {
                listConvenio = convenioDAO.listarConvenios("nome_da_empresa", "");
            } else {
                listConvenio = convenioDAO.listarConvenios("nome_da_empresa", request.getParameter("nome_da_empresa"));
            }


        %>
    </head>
    <body>
        <div class="container">
            <div>
                <h4 class="form-heading">Convenios:</h4>
            </div>
            <form class="form-horizontal" role="form" action="Convenios.jsp" method="get">
                <div class="form-group">
                    <div class="col-sm-3">
                        <input class="form-control" type="text" name="nome_da_empresa"/>
                    </div>
                    <button class="btn btn-primary" type="submit"><span class="glyphicon glyphicon-search"></span> Procurar</button>
                    <a class="btn btn-primary" href="CadastroConvenio.jsp"><span class="glyphicon glyphicon-plus"></span> Cadastrar Novo Convenio</a>
                </div>
            </form>
            
            

            <table class="table table-striped table-bordered">
                <tr><th class="col-lg-3 h5 text-center"><b>Nome</b></th><th class="col-lg-3 h5 text-center"><b>CNPJ</b></th><th class="col-lg-3 h5 text-center"><b>Area</b></th><th class="col-lg-1 h5 text-center"><b>Editar</b></th><th class="col-lg-1 h5 text-center"><b>Desativar</b></th></tr>
                        <%                            for (int i = 0; i < listConvenio.size(); i++) {
                        %>

                <tr><td class="col-lg-3 h5 text-center"><%= listConvenio.get(i).getNome_da_empresa()%></td>
                    <td class="col-lg-3 h5 text-center"><%= listConvenio.get(i).getCnpj()%></td>
                    <td class="col-lg-3 h5 text-center"><%= listConvenio.get(i).getArea_de_atuacao()%></td>
                    <td class="col-lg-1 h5 text-center"><a class="btn btn btn-primary" href="EditarConvenio.jsp?id=<%= listConvenio.get(i).getId_convenio()%>"><span class="glyphicon glyphicon-pencil"></span> Editar</a></td>
                    <td class="col-lg-1 h5 text-center"><form action="../ExcluirConvenio" method="post"><input type="hidden" name="id_convenio" value="<%= listConvenio.get(i).getId_convenio()%>"/><button class="btn btn-primary" type="submit"><span class="glyphicon glyphicon-remove"></span> Desativar</button></form></td></tr>    

                <%
                    }
                %>
            </table>
        </div>
        <jsp:include page = "../js/bibliotecasjs.jsp"/>
    </body>
</html>
