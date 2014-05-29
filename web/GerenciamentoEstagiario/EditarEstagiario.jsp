<%-- 
    Document   : EditarCurso
    Created on : 07/04/2014, 14:17:43
    Author     : Renan Huf Silveira
--%>

<%@page import="bd.EnderecoEstagiarioDAO"%>
<%@page import="beans.EnderecoEstagiario"%>
<%@page import="beans.ContatoEstagiario"%>
<%@page import="bd.ContatoEstagiarioDAO"%>
<%@page import="bd.CursoDAO"%>
<%@page import="beans.Curso"%>
<%@page import="beans.Estagiario"%>
<%@page import="bd.EstagiarioDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%
            EstagiarioDAO eDAO = new EstagiarioDAO();
            Estagiario e = eDAO.consultarId(Integer.parseInt(request.getParameter("id")));
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
            <form class="form-horizontal" role="form" action="../EditarEstagiario" method="Post">
                <div>
                    <h4 class="form-heading">Editar Estágiario</h4>
                </div>
                <input type="hidden" name="idEstagiario" value="<%= e.getId()%>">
                <input type="hidden" name="idEndereco" value="<%= e.getEndereco()%>">
                <input type="hidden" name="idContato" value="<%= e.getContato()%>">
                <div>
                    <h4 class="form-heading">Estágiario</h4>
                </div>

                <div class="form-group">
                    <label class="col-sm-2 control-label">Matrícula:</label>
                    <div class="col-sm-3">
                        <input type="text" class="form-control" name="matricula" value="<%= e.getMatricula() %>"></input>
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-sm-2 control-label">Nome Completo:</label>
                    <div class="col-sm-3">
                        <input type="text" class="form-control" name="nome" value="<%= e.getNome() %>"></input>
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-sm-2 control-label">RG:</label>
                    <div class="col-sm-3">
                        <input type="text" class="form-control" name="rg" value="<%= e.getRG() %>"></input>
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-sm-2 control-label">CPF:</label>
                    <div class="col-sm-3">
                        <input type="text" class="form-control" name="cpf" value="<%= e.getCPF() %>"></input>
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-sm-2 control-label">Data de Nascimento:</label>
                    <div class="col-sm-3">
                        <input type="text" class="form-control" name="dtNascimento" value="<%= e.getDtNascimento() %>"></input>
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-sm-2 control-label">Nome do Pai:</label>
                    <div class="col-sm-3">
                        <input type="text" class="form-control" name="nomePai" value="<%= e.getPai() %>"></input>
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-sm-2 control-label">Nome da Mãe:</label>
                    <div class="col-sm-3">
                        <input type="text" class="form-control" name="nomeMae" value="<%= e.getMae() %>"></input>
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-sm-2 control-label">Disponibilidade de Horário para Estagio:</label>
                    <div class="col-sm-3">
                        <input type="text" class="form-control" name="disponibilidade" value="<%= e.getDisponibilidadeHorarioEstagio() %>"></input>
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-sm-2 control-label">Empresa que Trabalha:</label>
                    <div class="col-sm-3">
                        <input type="text" class="form-control" name="empresa" value="<%= e.getEmpresaTrabalha() %>"></input>
                    </div>
                </div>
                    
                <div class="form-group">
                    <label class="col-sm-2 control-label">Horário Trabalha:</label>
                    <div class="col-sm-3">
                        <input type="text" class="form-control" name="horario" value="<%= e.getHorarioTrabalha()%>"></input>
                    </div>
                </div>    

                 <%
                 Curso c = new Curso();
                 CursoDAO cDAO = new CursoDAO();
                 c = cDAO.consultarId(e.getCurso());
                 %>   
                    
                <div class="form-group">
                    <label class="col-sm-2 control-label">Curso:</label>
                    <div class="col-sm-3">
                        <input type="text" class="form-control" name="curso" value="<%= c.getNome() %>"></input>
                    </div>
                </div>






                <%
                ContatoEstagiario ce = new ContatoEstagiario();
                ContatoEstagiarioDAO ceDAO = new ContatoEstagiarioDAO();
                ce = ceDAO.consultarId(e.getContato());
                %>    

                <div>
                    <h4 class="form-heading">Contato</h4>
                </div>

                <div class="form-group">
                    <label class="col-sm-2 control-label">Contato:</label>
                    <div class="col-sm-3">
                        <input type="text" class="form-control" name="contatoValor" value="<%= ce.getValor() %>"></input>
                    </div>
                </div>






                <%
                EnderecoEstagiario ee = new EnderecoEstagiario();
                EnderecoEstagiarioDAO eeDAO = new EnderecoEstagiarioDAO();
                ee = eeDAO.consultarId(e.getEndereco());
                %>



                <div>
                    <h4 class="form-heading">Endereço</h4>
                </div>

                <div class="form-group">
                    <label class="col-sm-2 control-label">Logradouro:</label>
                    <div class="col-sm-3">
                        <input type="text" class="form-control" name="logradouro" value="<%= ee.getLogradouro() %>"></input>
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-sm-2 control-label">Bairro:</label>
                    <div class="col-sm-3">
                        <input type="text" class="form-control" name="bairro" value="<%= ee.getBairro() %>"></input>
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-sm-2 control-label">Cidade:</label>
                    <div class="col-sm-3">
                        <input type="text" class="form-control" name="cidade" value="<%= ee.getCidade() %>"></input>
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-sm-2 control-label">Estado:</label>
                    <div class="col-sm-3">
                        <input type="text" class="form-control" name="estado" value="<%= ee.getEstado() %>"></input>
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-sm-2 control-label">CEP:</label>
                    <div class="col-sm-3">
                        <input type="text" class="form-control" name="cep" value="<%= ee.getCep() %>" pattern="[0-9]{5}-[0-9]{3}" placeholder="00000-000"></input>
                    </div>
                </div>

                <button type="submit" class="btn btn-primary col-lg-offset-2">Salvar</button>
            </form>
        </div>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
        <script src="//netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>
    </body>
</html>
