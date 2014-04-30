<%@page import="dao.EnderecoDAO"%>
<%@page import="beans.Endereco"%>
<%@page import="dao.ConvenioDAO"%>
<%@page import="beans.Convenio"%>
<%@page import="dao.ContatoConvenioDAO"%>
<%@page import="beans.ContatoConvenio"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.SocioConvenioDAO"%>
<%@page import="beans.SocioConvenio"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:include page = "../css/bibliotecascss.jsp"/>
        <title>JSP Page</title>
        <%
            //SocioConvenio socio = new SocioConvenio();
            SocioConvenioDAO socio_convenioDAO = new SocioConvenioDAO();
            List<SocioConvenio> listSocioConvenio = new ArrayList<SocioConvenio>();

            //ContatoConvenio contato = new ContatoConvenio();
            ContatoConvenioDAO contato_convenioDAO = new ContatoConvenioDAO();
            List<ContatoConvenio> listContatoConvenio = new ArrayList<ContatoConvenio>();

            Convenio convenio = new Convenio();
            ConvenioDAO convenioDAO = new ConvenioDAO();

            Endereco endereco = new Endereco();
            EnderecoDAO enderecoDAO = new EnderecoDAO();

            convenio = convenioDAO.consultarConvenios("id_convenios", request.getParameter("id"));
            endereco = enderecoDAO.consultarEndereco("id_convenio", String.valueOf(convenio.getId_convenio()));

        %>

    </head>
    <body>
        <div class="container">
            <form class="form-horizontal" role="form" action="../EditarConvenios" method="Post">
                <input type="hidden" name="id_convenio" value="<%= convenio.getId_convenio()%>">

                <div>
                    <h4 class="form-heading">Convenios:</h4>
                </div>

                <div class="form-group">
                    <label class="col-sm-2 control-label">Nome da Empresa:</label>
                    <div class="col-sm-3">
                        <input type="text" class="form-control" name="nome_da_empresa" value="<%= convenio.getNome_da_empresa()%>" required>
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-sm-2 control-label">CNPJ:</label>
                    <div class="col-sm-3">
                        <input type="text" class="form-control" name="cnpj" pattern="[0-9]{2}.[0-9]{3}.[0-9]{3}/[0-9]{4}-[0-9]{2}" placeholder="00.000.000/0000-00" value="<%= convenio.getCnpj()%>" required>
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-sm-2 control-label">Área de Atuação:</label>
                    <div class="col-sm-3">
                        <input type="text" class="form-control" name="area_de_atuacao" value="<%= convenio.getArea_de_atuacao()%>" required>
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-sm-2 control-label">Data de Inicio do Convenio:</label>
                    <div class="col-sm-3">
                        <input type="text" class="form-control" name="data_inicio_convenio" placeholder="dd/mm/aaaa" value="<%= convenio.getData_inicio_convenio()%>">
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-sm-2 control-label">Duração do Convenio:</label>
                    <div class="col-sm-3">
                        <input type="text" class="form-control" name="duracao_convenio" placeholder="Meses" value="<%= convenio.getDuracao_convenio()%>">
                    </div>
                </div>

                <div>
                    <h4 class="form-heading">Endereço:</h4>
                </div>
                <input type="hidden" name="id_endereco" value="<%= endereco.getId_endereco()%>">
                <div class="form-group">
                    <label class="col-sm-2 control-label">Logradouro:</label>
                    <div class="col-sm-3">
                        <input type="text" class="form-control" name="logradouro" value="<%= endereco.getLogradouro()%>">
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-sm-2 control-label">Bairro:</label>
                    <div class="col-sm-3">
                        <input type="text" class="form-control" name="bairro" value="<%= endereco.getBairro()%>">
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-sm-2 control-label">Cidade:</label>
                    <div class="col-sm-3">
                        <input type="text" class="form-control" name="cidade" value="<%= endereco.getCidade()%>">
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-sm-2 control-label">Estado:</label>
                    <div class="col-sm-3">
                        <input type="text" class="form-control" name="estado" value="<%= endereco.getEstado()%>">
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-sm-2 control-label">CEP:</label>
                    <div class="col-sm-3">
                        <input type="text" class="form-control" name="cep" pattern="[0-9]{5}-[0-9]{3}" placeholder="00000-000" value="<%= endereco.getCep()%>">
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-sm-2 control-label">Telefone:</label>
                    <div class="col-sm-3">
                        <input type="text" class="form-control" name="telefone" pattern="\([0-9]{2}\)[\s][0-9]{4}-[0-9]{4}" placeholder="(xx) xxxx-xxxx" value="<%= endereco.getTelefone()%>">
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-sm-2 control-label">Telefax:</label>
                    <div class="col-sm-3">
                        <input type="text" class="form-control" name="telefax" pattern="\([0-9]{2}\)[\s][0-9]{4}-[0-9]{4}" placeholder="(xx) xxxx-xxxx" value="<%= endereco.getTelefax()%>">
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-sm-2 control-label">Email 1:</label>
                    <div class="col-sm-3">
                        <input type="email" class="form-control" name="email1" placeholder="exemplo@exemplo.com.br" value="<%= endereco.getEmail1()%>">
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-sm-2 control-label">Email 2:</label>
                    <div class="col-sm-3">
                        <input type="email" class="form-control" name="email2" placeholder="exemplo@exemplo.com.br" value="<%= endereco.getEmail2()%>">
                    </div>
                </div>


                <button type="submit" class="btn btn-primary col-lg-offset-2">Salvar</button>

            </form>
        </div>

        <br><br>
        <div class="container">
            <div>
                <h4 class="form-heading">Representantes Legais e Socios:</h4>
            </div>
            <table class="table table-striped table-bordered">
                <tr><th class="col-lg-3 h5 text-center"><b>Nome</b></th><th class="col-lg-3 h5 text-center"><b>RG</b></th><th class="col-lg-3 h5 text-center"><b>CPF</b></th><th class="col-lg-1 h5 text-center"><b>Editar</b></th><th class="col-lg-1 h5 text-center"><b>Desativar</b></th></tr>
                        <%              listSocioConvenio = socio_convenioDAO.listarSocioConvenio("id_convenio", String.valueOf(convenio.getId_convenio()));
                            for (int i = 0; i < listSocioConvenio.size(); i++) {
                        %>

                <tr><td class="col-lg-3 h5 text-center"><%= listSocioConvenio.get(i).getNome()%></td>
                    <td class="col-lg-3 h5 text-center"><%= listSocioConvenio.get(i).getRg()%></td>
                    <td class="col-lg-3 h5 text-center"><%= listSocioConvenio.get(i).getCpf()%></td>
                    <td class="col-lg-1 h5 text-center"><a class="btn btn-primary" href="EditarSocioConvenio.jsp?id_socio_convenio=<%= listSocioConvenio.get(i).getId_socio()%>"><span class="glyphicon glyphicon-pencil"></span> Editar</a></td>
                    <td class="col-lg-1 h5 text-center"><form action="../ExcluirSocioConvenio" method="post"><input type="hidden" name="id_socio_convenio" value="<%= listSocioConvenio.get(i).getId_socio()%>"/><input type="hidden" name="id_convenio" value="<%= convenio.getId_convenio()%>"/><button class="btn btn-primary" type="submit"><span class="glyphicon glyphicon-remove"></span> Desativar</button></form></td></tr>    

                <%
                    }
                %>
            </table>
            <a class="btn btn-primary" href="CadastroSocioConvenio.jsp?id_convenio=<%= convenio.getId_convenio()%>">Adicionar Socio</a>
        </div>
        
        <br><br>
        
        <div class="container">
            <div>
                <h4 class="form-heading">Contatos da Empresa:</h4>
            </div>
            <table class="table table-striped table-bordered">
                <tr><th class="col-lg-6 h5 text-center"><b>Nome</b></th><th class="col-lg-3 h5 text-center"><b>Cargo</b></th><th class="col-lg-1 h5 text-center"><b>Editar</b></th><th class="col-lg-1 h5 text-center"><b>Desativar</b></th></tr>
                        <%listContatoConvenio = contato_convenioDAO.listarContatoConvenio("id_convenio", String.valueOf(convenio.getId_convenio()));
                            for (int i = 0; i < listContatoConvenio.size(); i++) {
                        %>

                <tr><td class="col-lg-6 h5 text-center"><%= listContatoConvenio.get(i).getNome()%></td>
                    <td class="col-lg-3 h5 text-center"><%= listContatoConvenio.get(i).getCargo()%></td>
                    <td class="col-lg-1 h5 text-center"><a class="btn btn-primary" href="EditarContatoConvenio.jsp?id_contato_convenio=<%= listContatoConvenio.get(i).getId_contato()%>"><span class="glyphicon glyphicon-pencil"></span> Editar</a></td>
                    <td class="col-lg-1 h5 text-center"><form action="../ExcluirContatoConvenio" method="post"><input type="hidden" name="id_contato_convenio" value="<%= listContatoConvenio.get(i).getId_contato()%>"/><input type="hidden" name="id_convenio" value="<%= convenio.getId_convenio()%>"/><button class="btn btn-primary" type="submit"><span class="glyphicon glyphicon-remove"></span> Desativar</button></form></td></tr>    

                <%
                    }
                %>
            </table>
            <a class="btn btn-primary" href="CadastroContatoConvenio.jsp?id_convenio=<%= convenio.getId_convenio()%>">Adicionar Contanto</a>
        </div>

        <jsp:include page = "../js/bibliotecasjs.jsp"/>
    </body>
</html>
