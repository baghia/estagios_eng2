<%@page import="beans.ContatoConvenio"%>
<%@page import="dao.ContatoConvenioDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastrar Contato</title>
        <jsp:include page = "../css/bibliotecascss.jsp"/>
        <%
            //SocioConvenio socio = new SocioConvenio();
            ContatoConvenioDAO contato_convenioDAO = new ContatoConvenioDAO();
            ContatoConvenio contato_convenio = new ContatoConvenio();

            contato_convenio = contato_convenioDAO.consultarContatoConvenio("id_contato_convenio", request.getParameter("id_contato_convenio"));

        %>
    </head>
    <body>
        <div class="container">
            <form class="form-horizontal" role="form" action="EditarContatoConvenio" method="Post">
                <input type="hidden" name="id_contato_convenio" value="<%= contato_convenio.getId_contato()%>">
                <input type="hidden" name="id_convenio" value="<%= contato_convenio.getId_convenio()%>">

                <div>
                    <h4 class="form-heading">Contatos:</h4>
                </div>

                <div class="form-group">
                    <label class="col-sm-2 control-label">Nome:</label>
                    <div class="col-sm-3">
                        <input type="text" class="form-control" name="nome" value="<%= contato_convenio.getNome()%>" required>
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-sm-2 control-label">Email:</label>
                    <div class="col-sm-3">
                        <input type="text" class="form-control" name="email" placeholder="exemplo@exemplo.com.br" value="<%= contato_convenio.getEmail()%>">
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-sm-2 control-label">Cargo:</label>
                    <div class="col-sm-3">
                        <input type="text" class="form-control" name="cargo" value="<%= contato_convenio.getCargo()%>">
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-sm-2 control-label">Setor:</label>
                    <div class="col-sm-3">
                        <input type="text" class="form-control" name="setor" value="<%= contato_convenio.getSetor()%>">
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-sm-2 control-label">Horario:</label>
                    <div class="col-sm-3">
                        <input type="text" class="form-control" name="horario" value="<%= contato_convenio.getHorario()%>">
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-sm-2 control-label">Telefone:</label>
                    <div class="col-sm-3">
                        <input type="text" class="form-control" name="telefone" pattern="\([0-9]{2}\)[\s][0-9]{4}-[0-9]{4}" placeholder="(xx) xxxx-xxxx" value="<%= contato_convenio.getTelefone()%>">
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-sm-2 control-label">Celular:</label>
                    <div class="col-sm-3">
                        <input type="text" class="form-control" name="celular" pattern="\([0-9]{2}\)[\s][0-9]{4}-[0-9]{4}" placeholder="(xx) xxxx-xxxx" value="<%= contato_convenio.getCelular()%>">
                    </div>
                </div>

                <button type="submit" class="btn btn-primary col-lg-offset-2">Salvar</button>
            </form>
        </div>
        <jsp:include page = "../js/bibliotecasjs.jsp"/>
    </body>
</html>

