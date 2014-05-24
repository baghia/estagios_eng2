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
        <title>Gerenciamento de Estágiario</title>
    </head>
    <body>
        <div class="container">
            <form class="form-horizontal" role="form" action="CadastroEstagiario" method="POST">
                <div>
                    <h4 class="form-heading">Cadastro de Estágiario</h4>
                </div>

                <div>
                    <h4 class="form-heading">Estágiario</h4>
                </div>

                <div class="form-group">
                    <label class="col-sm-2 control-label">Matrícula:</label>
                    <div class="col-sm-3">
                        <input type="text" class="form-control" name="matricula">
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-sm-2 control-label">Nome Completo:</label>
                    <div class="col-sm-3">
                        <input type="text" class="form-control" name="nome">
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-sm-2 control-label">RG:</label>
                    <div class="col-sm-3">
                        <input type="text" class="form-control" name="rg">
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-sm-2 control-label">CPF:</label>
                    <div class="col-sm-3">
                        <input type="text" class="form-control" name="cpf">
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-sm-2 control-label">Data de Nascimento:</label>
                    <div class="col-sm-3">
                        <input type="text" class="form-control" name="dtNascimento">
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-sm-2 control-label">Nome do Pai:</label>
                    <div class="col-sm-3">
                        <input type="text" class="form-control" name="nomePai">
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-sm-2 control-label">Nome da Mãe:</label>
                    <div class="col-sm-3">
                        <input type="text" class="form-control" name="nomeMae">
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-sm-2 control-label">Disponibilidade de Horário para Estagio:</label>
                    <div class="col-sm-3">
                        <input type="text" class="form-control" name="disponibilidade">
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-sm-2 control-label">Empresa que Trabalha:</label>
                    <div class="col-sm-3">
                        <input type="text" class="form-control" name="empresa">
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-sm-2 control-label">Curso:</label>
                    <div class="col-sm-3">
                        <input type="text" class="form-control" name="curso">
                    </div>
                </div>








                <div>
                    <h4 class="form-heading">Contato</h4>
                </div>

                <div class="form-group">
                    <label class="col-sm-2 control-label">Contato:</label>
                    <div class="col-sm-3">
                        <input type="text" class="form-control" name="contatoValor" required>
                    </div>
                </div>










                <div>
                    <h4 class="form-heading">Endereço</h4>
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

                <button type="submit" class="btn btn-primary col-lg-offset-2">Salvar</button>
            </form>
        </div>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
        <script src="//netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>
    </body>
</html>
