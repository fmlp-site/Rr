/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unipampa.sgc.controle;

import br.unipampa.sgc.apresentacao.ConfigurarFrame;
import br.unipampa.sgc.apresentacao.GeradorDeMensagens;
import br.unipampa.sgc.apresentacao.JanelaCriarConcurso;
import br.unipampa.sgc.modelo.Candidato;
import br.unipampa.sgc.modelo.Classe;
import br.unipampa.sgc.modelo.Concurso;
import br.unipampa.sgc.modelo.Examinador;
import br.unipampa.sgc.modelo.Resolucao;
import br.unipampa.sgc.modelo.Universidade;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

/**
 *
 * @author GabrielBMoro
 */
public class ControleCriarConcurso {
    
    public ControleCriarConcurso(JanelaCriarConcurso janelaCriarConcurso) {
        ConfigurarFrame.configurarJanelaPadrao(janelaCriarConcurso, 950, 600);
        janelaCriarConcurso.addWindowListener(new TrataListenerDaJanela());
        janelaCriarConcurso.getPanelCriarConcurso().getBtnProximo().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ministerio = janelaCriarConcurso.getPanelCriarConcurso().getTxtMinisterio().getText();
                String universidade = janelaCriarConcurso.getPanelCriarConcurso().getTxtUniversidade().getText();
                String campus = janelaCriarConcurso.getPanelCriarConcurso().getTxtCampus().getText();
                String area = janelaCriarConcurso.getPanelCriarConcurso().getTxtArea().getText();
                String edital = janelaCriarConcurso.getPanelCriarConcurso().getTxtEdital().getText();
                String dataString = janelaCriarConcurso.getPanelCriarConcurso().getTxtData().getText();
                String regraDoConcurso = String.valueOf(janelaCriarConcurso.getPanelCriarConcurso().getjComboBox1().getSelectedItem());
                String classeDoConcurso = String.valueOf(janelaCriarConcurso.getPanelCriarConcurso().getjComboBox2().getSelectedIndex());
                
                Concurso.getMyInstance().setMinisterio(ministerio);
                Concurso.getMyInstance().setUniversidade(new Universidade(campus, universidade));
                Concurso.getMyInstance().setArea(area);
                Concurso.getMyInstance().setEdital(edital);
                Concurso.getMyInstance().setData(dataString);
                Concurso.getMyInstance().setResolucao(new Resolucao(regraDoConcurso));
                Concurso.getMyInstance().setClasse(new Classe(classeDoConcurso));
                
                janelaCriarConcurso.getPanelCriarConcurso().getPanelDadosGerais().setVisible(false);
                janelaCriarConcurso.getPanelCriarConcurso().getPanelBanca().setVisible(true);
                janelaCriarConcurso.getPanelCriarConcurso().getPaneCandidatosInscritos().setVisible(false);
                janelaCriarConcurso.revalidate();
                JanelaCriarConcurso.STATUS_CRIACAO_CONCURSO = 30;
                janelaCriarConcurso.getPanelCriarConcurso().getJProgressBar().setValue(JanelaCriarConcurso.STATUS_CRIACAO_CONCURSO);
            }
        });
        janelaCriarConcurso.getPanelCriarConcurso().getBtnAnterior1().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /*Mandar para a regra de negócio*/
                
                janelaCriarConcurso.getPanelCriarConcurso().restaurarDadosPanelDadosGerais(Concurso.getMyInstance().getMinisterio(),
                        Concurso.getMyInstance().getUniversidade().getNome(), Concurso.getMyInstance().getUniversidade().getCampus(),
                        Concurso.getMyInstance().getArea(), Concurso.getMyInstance().getEdital(), Concurso.getMyInstance().getData(), Concurso.getMyInstance().getResolucao().getDescricao(),
                        Concurso.getMyInstance().getClasse().getTitulo());
                janelaCriarConcurso.getPanelCriarConcurso().getPanelDadosGerais().setVisible(true);
                janelaCriarConcurso.getPanelCriarConcurso().getPanelBanca().setVisible(false);
                janelaCriarConcurso.getPanelCriarConcurso().getPaneCandidatosInscritos().setVisible(false);
                janelaCriarConcurso.revalidate();
                JanelaCriarConcurso.STATUS_CRIACAO_CONCURSO -= 30;
                janelaCriarConcurso.getPanelCriarConcurso().getJProgressBar().setValue(JanelaCriarConcurso.STATUS_CRIACAO_CONCURSO);
            }
        });
        janelaCriarConcurso.getPanelCriarConcurso().getBtnProximo2().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome1 = janelaCriarConcurso.getPanelCriarConcurso().getTxtNome1().getText();
                String nome2 = janelaCriarConcurso.getPanelCriarConcurso().getTxtNome2().getText();
                String nome3 = janelaCriarConcurso.getPanelCriarConcurso().getTxtNome3().getText();
                String sexo1 = null, sexo2 = null, sexo3 = null;
                
                if (janelaCriarConcurso.getPanelCriarConcurso().getBtnFEx1().isSelected()) {
                    sexo1 = "F";
                } else if (janelaCriarConcurso.getPanelCriarConcurso().getBtnFEx2().isSelected()) {
                    sexo2 = "F";
                } else if (janelaCriarConcurso.getPanelCriarConcurso().getBtnFEx3().isSelected()) {
                    sexo3 = "F";
                } else if (janelaCriarConcurso.getPanelCriarConcurso().getBtnMEx1().isSelected()) {
                    sexo1 = "M";
                } else if (janelaCriarConcurso.getPanelCriarConcurso().getBtnMEx2().isSelected()) {
                    sexo2 = "M";
                } else if (janelaCriarConcurso.getPanelCriarConcurso().getBtnMEx3().isSelected()) {
                    sexo3 = "M";
                }
                String categoria1 = String.valueOf(janelaCriarConcurso.getPanelCriarConcurso().getjComboBoxEx1().getSelectedItem());
                String categoria2 = String.valueOf(janelaCriarConcurso.getPanelCriarConcurso().getjComboBoxEx2().getSelectedItem());
                String categoria3 = String.valueOf(janelaCriarConcurso.getPanelCriarConcurso().getjComboBoxEx3().getSelectedItem());
                
                if (nome1 != null && nome2 != null && nome3 != null && sexo1 != null && sexo2 != null
                        && sexo3 != null && categoria1 != null && categoria2 != null && categoria3 != null) {
                    
                    Examinador[] examinador = new Examinador[]{new Examinador(nome1, sexo1, categoria1),
                        new Examinador(nome2, sexo2, categoria2),
                        new Examinador(nome3, sexo3, categoria3)};
                    Concurso.getMyInstance().setExaminador(examinador);
                    janelaCriarConcurso.getPanelCriarConcurso().getPanelDadosGerais().setVisible(false);
                    janelaCriarConcurso.getPanelCriarConcurso().getPanelBanca().setVisible(false);
                    janelaCriarConcurso.getPanelCriarConcurso().getPaneCandidatosInscritos().setVisible(true);
                    janelaCriarConcurso.revalidate();
                    JanelaCriarConcurso.STATUS_CRIACAO_CONCURSO += 40;
                    janelaCriarConcurso.getPanelCriarConcurso().getJProgressBar().setValue(JanelaCriarConcurso.STATUS_CRIACAO_CONCURSO);
                }
            }
        });
        janelaCriarConcurso.getPanelCriarConcurso().getBtnAnterior2().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                janelaCriarConcurso.getPanelCriarConcurso().getPanelDadosGerais().setVisible(false);
                janelaCriarConcurso.getPanelCriarConcurso().getPanelBanca().setVisible(true);
                janelaCriarConcurso.getPanelCriarConcurso().getPaneCandidatosInscritos().setVisible(false);
                janelaCriarConcurso.revalidate();
                JanelaCriarConcurso.STATUS_CRIACAO_CONCURSO -= 40;
                janelaCriarConcurso.getPanelCriarConcurso().getJProgressBar().setValue(JanelaCriarConcurso.STATUS_CRIACAO_CONCURSO);
            }
        });
        janelaCriarConcurso.getPanelCriarConcurso().getBtnSalvar().addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                LinkedList<String> dadosDeCandidatos = janelaCriarConcurso.getPanelCriarConcurso().recuperarDadosPanelCandidatos();
                if (dadosDeCandidatos == null) {
                    GeradorDeMensagens.exibirMensagemDeInformacao("Alerta ao Usuário", "Por favor, preencha todos os campos referentes aos dados dos candidatos.");
                } else {
                    int count = 0;
                    LinkedList<Candidato> candidatos = new LinkedList<>();
                    String nome = null, sexo = null, dataDeNascimento = null;
                    for (; count < dadosDeCandidatos.size(); count++) {
                        nome = dadosDeCandidatos.get(count);
                        sexo = dadosDeCandidatos.get(count + 1);
                        dataDeNascimento = dadosDeCandidatos.get(count + 2);
                        candidatos.add(new Candidato(nome, sexo, dataDeNascimento));
                        count += 2;
                    }
                    
                }
            }
        });
    }
}
