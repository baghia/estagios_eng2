/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

import java.util.List;

/**
 *
 * @author Renan Huf Silveira
 */
public class Estagiario extends Pessoa {
    private int matricula;
    private String pai;
    private String mae;
    private int contato; 
    private int endereco;
    private String disponibilidadeHorarioEstagio;
    private String empresaTrabalha;
    private String horarioTrabalha;
    private int curso;

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getPai() {
        return pai;
    }

    public void setPai(String pai) {
        this.pai = pai;
    }

    public String getMae() {
        return mae;
    }

    public void setMae(String mae) {
        this.mae = mae;
    }

    public String getDisponibilidadeHorarioEstagio() {
        return disponibilidadeHorarioEstagio;
    }

    public void setDisponibilidadeHorarioEstagio(String disponibilidadeHorarioEstagio) {
        this.disponibilidadeHorarioEstagio = disponibilidadeHorarioEstagio;
    }

    public String getEmpresaTrabalha() {
        return empresaTrabalha;
    }

    public void setEmpresaTrabalha(String empresaTrabalha) {
        this.empresaTrabalha = empresaTrabalha;
    }

    public String getHorarioTrabalha() {
        return horarioTrabalha;
    }

    public void setHorarioTrabalha(String horarioTrabalha) {
        this.horarioTrabalha = horarioTrabalha;
    }

    public int getContato() {
        return contato;
    }

    public void setContato(int contato) {
        this.contato = contato;
    }

    public int getEndereco() {
        return endereco;
    }

    public void setEndereco(int endereco) {
        this.endereco = endereco;
    }

    public int getCurso() {
        return curso;
    }

    public void setCurso(int curso) {
        this.curso = curso;
    }
    
}
