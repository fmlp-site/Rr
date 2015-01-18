/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unipampa.sgc.modelo;

import java.util.Date;

/**
 * Cronograma de concurso
 */
public class Cronograma {
    
    private String atividade;
    private String data_Cron;
    private int horario;
    private String local;
    
    public Cronograma(String atividade, String data_Cron, 
            int horario, String local){
     this.atividade = atividade;
     this.data_Cron = data_Cron;
     this.horario = horario;
     this.local = local;
    }
    
    public String getAtividade(){
        return atividade;        
    }
    
    public void setAtividade(String atividade){
        this.atividade = atividade;
    }
    
    public String getDataCron(){
        return data_Cron;
    }
    
    public int getHorario(){
        return horario;
    }
    
    public void setHorario(int horario){
        this.horario = horario;
        }
    
    public String getLocal(){
        return local;
    }
    
    public void setLocal(String local){
        this.local = local;
    }     
}