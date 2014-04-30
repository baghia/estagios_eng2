
<%@page import="dao.SocioConvenioDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="beans.SocioConvenio"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <title>Cadastro Convenio</title>
        <meta charset="UTF-8">
        <jsp:include page = "../css/bibliotecascss.jsp"/>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <% SocioConvenio socio = new SocioConvenio();
            SocioConvenioDAO sDao = new SocioConvenioDAO();
            List<SocioConvenio> listSocios = new ArrayList<SocioConvenio>();

            String nomeSocio = request.getParameter("nome");

            if (nomeSocio == null) {
                nomeSocio = "";
            }


        %>
    </head>
    <body>
        <div class="container">
            <form class="form-horizontal" role="form" action="../CadastroConvenio" method="Post">
                <div>
                    <h4 class="form-heading">Convenios:</h4>
                </div>

                <div class="form-group">
                    <label class="col-sm-2 control-label">Nome da Empresa:</label>
                    <div class="col-sm-3">
                        <input type="text" class="form-control" name="nome_da_empresa" required>
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-sm-2 control-label">CNPJ:</label>
                    <div class="col-sm-3">
                        <input type="text" class="form-control" name="cnpj" pattern="[0-9]{2}.[0-9]{3}.[0-9]{3}/[0-9]{4}-[0-9]{2}" placeholder="00.000.000/0000-00" required>
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-sm-2 control-label">Área de Atuação:</label>
                    <div class="col-sm-3">
                        <input type="text" class="form-control" name="area_de_atuacao" required>
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-sm-2 control-label">Data de Inicio do Convenio:</label>
                    <div class="col-sm-3">
                        <input type="text" class="form-control" name="data_inicio_convenio" placeholder="dd/mm/aaaa">
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-sm-2 control-label">Duração do Convenio:</label>
                    <div class="col-sm-3">
                        <input type="text" class="form-control" name="duracao_convenio" placeholder="Meses">
                    </div>
                </div>

                <div>
                    <h4 class="form-heading">Endereço:</h4>
                </div>

                <div class="form-group">
                    <label class="col-sm-2 control-label">Logradouro:</label>
                    <div class="col-sm-3">
                        <input type="text" class="form-control" name="logradouro">
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-sm-2 control-label">Bairro:</label>
                    <div class="col-sm-3">
                        <input type="text" class="form-control" name="bairro">
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-sm-2 control-label">Cidade:</label>
                    <div class="col-sm-3">
                        <input type="text" class="form-control" name="cidade">
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-sm-2 control-label">Estado:</label>
                    <div class="col-sm-3">
                        <input type="text" class="form-control" name="estado">
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-sm-2 control-label">CEP:</label>
                    <div class="col-sm-3">
                        <input type="text" class="form-control" name="cep" pattern="[0-9]{5}-[0-9]{3}" placeholder="00000-000">
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-sm-2 control-label">Telefone:</label>
                    <div class="col-sm-3">
                        <input type="text" class="form-control" name="telefone" pattern="\([0-9]{2}\)[\s][0-9]{4}-[0-9]{4}" placeholder="(xx) xxxx-xxxx">
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-sm-2 control-label">Telefax:</label>
                    <div class="col-sm-3">
                        <input type="text" class="form-control" name="telefax" pattern="\([0-9]{2}\)[\s][0-9]{4}-[0-9]{4}" placeholder="(xx) xxxx-xxxx">
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-sm-2 control-label">Email 1:</label>
                    <div class="col-sm-3">
                        <input type="email" class="form-control" name="email1" placeholder="exemplo@exemplo.com.br">
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-sm-2 control-label">Email 2:</label>
                    <div class="col-sm-3">
                        <input type="email" class="form-control" name="email2" placeholder="exemplo@exemplo.com.br">
                    </div>
                </div>


                <button type="submit" class="btn btn-primary col-lg-offset-2">Salvar</button>

            </form>
        </div>
        <jsp:include page = "../js/bibliotecasjs.jsp"/>
    </body>
</html>
