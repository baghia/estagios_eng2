<%-- 
    Document   : CadastroSocio
    Created on : 04/04/2014, 10:28:15
    Author     : Guilherme
--%>

<%@page import="beans.SocioConvenio"%>
<%@page import="dao.SocioConvenioDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:include page = "../css/bibliotecascss.jsp"/>
        <title>Cadastro Socio</title>
        <%
            //SocioConvenio socio = new SocioConvenio();
            SocioConvenioDAO socio_convenioDAO = new SocioConvenioDAO();
            SocioConvenio socio_convenio = new SocioConvenio();

            socio_convenio = socio_convenioDAO.consultarSocioConvenio("id_socio_convenio", request.getParameter("id_socio_convenio"));

        %>
    </head>
    <body>
        <div class="container">
            <form class="form-horizontal" role="form" action="EditarSocioConvenio" method="Post">

                <input type="hidden" name="id_socio_convenio" value="<%= socio_convenio.getId_socio()%>">
                <input type="hidden" name="id_convenio" value="<%= socio_convenio.getId_convenio()%>">

                <div>
                    <h4 class="form-heading">Socio:</h4>
                </div>

                <div class="form-group">
                    <label class="col-sm-2 control-label">Nome:</label>
                    <div class="col-sm-3">
                        <input type="text" class="form-control" name="nome" value="<%= socio_convenio.getNome()%>" required>
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-sm-2 control-label">RG:</label>
                    <div class="col-sm-3">
                        <input type="text" class="form-control" name="rg" value="<%= socio_convenio.getRg()%>" required>
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-sm-2 control-label">CPF:</label>
                    <div class="col-sm-3">
                        <input type="text" class="form-control" name="cpf" pattern="[0-9]{3}.[0-9]{3}.[0-9]{3}-[0-9]{2}" placeholder="000.000.000-00" value="<%= socio_convenio.getCpf()%>" required>
                    </div>
                </div>


                <button type="submit" class="btn btn-primary col-lg-offset-2">Salvar</button>
            </form>
        </div>
        <jsp:include page = "../js/bibliotecasjs.jsp"/>
    </body>
</html>
<%-- 
    Document   : EditarSocioConvenio
    Created on : 05/04/2014, 14:15:01
    Author     : thiago
--%>
