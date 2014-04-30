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
    private List<ContatoEstagiario> contatos; 
    private Endereco endereco;
    private String disponibilidadeHorarioEstagio;
    private String empresaTrabalha;
    private String horarioTrabalha;
    private Curso curso;

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

    public List<ContatoEstagiario> getContatos() {
        return contatos;
    }

    public void setContatos(List<ContatoEstagiario> contatos) {
        this.contatos = contatos;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
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

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }
    
    
}
