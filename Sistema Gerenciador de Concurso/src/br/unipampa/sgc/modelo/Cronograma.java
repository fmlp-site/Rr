/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unipampa.sgc.modelo;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Date;

/**
 * Cronograma de concurso
 * 
 */
public class Cronograma {
    
            private String atividade;
            private String data;
            private int horario;
            private String local;
               

    public static final String PROP_ATIVIDADE = "atividade";
    
    public String getAtividade() {
        return atividade;
    }

    public void setAtividade(String atividade) {
        String oldAtividade = this.atividade; // salva o valor antigo
        this.atividade = atividade;
        //Dispara evento avisando que houve mudança no campo atividade
        propertyChangeSupport.firePropertyChange(PROP_ATIVIDADE, oldAtividade, atividade);
    }


    public static final String PROP_DATA = "data";

    public String getData() {
        return data;
    }

    public void setData(String data) {
        String oldData = this.data;
        this.data = data;
        propertyChangeSupport.firePropertyChange(PROP_DATA, oldData, data);
    }


    public static final String PROP_HORARIO = "horario";
    
    public int getHorario() {
        return horario;
    }

    public void setHorario(int horario) {
        int oldHorario = this.horario;
        this.horario = horario;
        propertyChangeSupport.firePropertyChange(PROP_HORARIO, oldHorario, horario);
    }      
    
    public static final String PROP_LOCAL = "local";

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        String oldLocal = this.local;
        this.local = local;
        propertyChangeSupport.firePropertyChange(PROP_LOCAL, oldLocal, local);
    }

    private transient final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(listener);
    }

}