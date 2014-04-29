<%-- 
    Document   : CadastroProfessor
    Created on : 23/04/2014, 09:07:03
    Author     : Guilherme
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastrar Professor</title>
        <jsp:include page = "css/bibliotecascss.jsp"/>
    </head>
    <body>
        <div class="container">
            <form class="form-horizontal" role="form" action="" method="Post">

                <div>
                    <h4 class="form-heading">Cadastro Professor</h4>
                </div>

                <div class="form-group">
                    <label class="col-sm-2 control-label">Nome:</label>
                    <div class="col-sm-3">
                        <input type="text" class="form-control" name="nome_professor" required>
                    </div>
                </div>
                
                <div class="form-group">
                    <label class="col-sm-2 control-label">Formação:</label>
                    <div class="col-sm-3">
                        <input type="text" class="form-control" name="formacao_professor">
                    </div>
                </div>
                
                <div class="form-group">
                    <label class="col-sm-2 control-label">SIAPE:</label>
                    <div class="col-sm-3">
                        <input type="text" class="form-control" name="siape_professor">
                    </div>
                </div>
                
                <div class="form-group">
                    <label class="col-sm-2 control-label">Inicio do Exercicio:</label>
                    <div class="col-sm-3">
                        <input type="text" class="form-control" name="data_professor">
                    </div>
                </div>
                
                <div class="form-group">
                    <label class="col-sm-2 control-label">Email:</label>
                    <div class="col-sm-3">
                        <input type="email" class="form-control" name="email_professor">
                    </div>
                </div>
                
                <div class="form-group">
                    <label class="col-sm-2 control-label">Formação:</label>
                    <div class="col-sm-3">
                        <input type="text" class="form-control" name="formacao_professor">
                    </div>
                </div>
            </form>
        </div>
        <jsp:include page = "js/bibliotecasjs.jsp"/>
        
    </body>
</html>
