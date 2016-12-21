
package Aval_1;

import javax.swing.JOptionPane;


public class Paciente extends Pessoa{
    
    private int prontuario;
    private final String exames [] = new String[10];
    private final String consultas [] = new String[10];
    private final String cirurgias [] = new String[10];
    private int ne = 0;
    private int nc = 0;
    private int ncr = 0;
    private String status;
    
    public int getProntuario(){
        return prontuario;
    }
    
    public String getExame(int ne){
        return exames[ne];
    }
    
    public String getConsulta(int nc){
        return consultas[nc];
    }
    
    public String getCirurgia(int ncr){
        return cirurgias[ncr];
    }
    
    public String getStatus(){
        return status;
    }
    
    public int getNc(){
        return nc;
    }
    
    public int getNe(){
        return ne;
    }
    
    public int getNcr(){
        return ncr;
    }
    
    public void setProntuario(int prontuario){
        this.prontuario = prontuario;
    }
    
    public void setExames(String exames, int ne){
        this.exames[ne] = exames;
        this.ne++;
    }
    
    public void setConsultas(String consultas, int nc){
        this.consultas[nc] = consultas;
        this.nc++;
    }
    
    public void setCirurgia(String cirurgias, int ncr){
        this.cirurgias[ncr] = cirurgias;
        this.ncr++;
    }
    
    public void setStatus(String status){
        this.status = status;
    }
    
    public int prioridade(){
        if(this.getIdade() > 60){
            switch (status) {
                case "Muito Grave":
                    return 6;
                case "Mal":
                    return 5;
                default:
                    return 4;
            }
        } else {
            switch (status) {
                case "Muito Grave":
                    return 3;
                case "Mal":
                    return 2;
                default:
                    return 1;
            }
        }
    }
    
    public void cadastroProntuario(int nPaciente){
        
        int opcao;
        
        this.setNome(JOptionPane.showInputDialog("Nome do Paciente"));
        this.setIdade(Integer.parseInt(JOptionPane.showInputDialog(null, "Idade")));
        do {
            this.setSexo(JOptionPane.showInputDialog("Sexo (m ou f)").charAt(0));
            if ((this.getSexo() != 'M' && this.getSexo() != 'm')
                && (this.getSexo() != 'F' && this.getSexo() != 'f')) {
                JOptionPane.showMessageDialog(null, "Informação errada!");
            }
        } while ((this.getSexo() != 'M' && this.getSexo() != 'm')
                && (this.getSexo() != 'F' && this.getSexo() != 'f'));
        do {
            this.setCpf(JOptionPane.showInputDialog("CPF"));
            if (!this.testeCPF()) {
                JOptionPane.showMessageDialog(null, "CPF invalido");
            }
        } while (this.testeCPF() == false);
        do {
            opcao = Integer.parseInt(JOptionPane.showInputDialog(null, "Status:\nMuito Grave (3)\nMal (2)\nNormalizado (1)"));
            switch (opcao) {
                case 1:
                    this.setStatus("Normalizado");
                    break;
                case 2:
                    this.setStatus("Mal");
                    break;
                case 3:
                    this.setStatus("Muito Grave");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção invalida!");
                    break;
            }
        } while (opcao != 1 && opcao != 2 && opcao != 3);
        this.setProntuario(100 + nPaciente);
        JOptionPane.showMessageDialog(null, "O número de Prontuário gerado de " + this.getNome() + " é\n\nProntuário: " + this.getProntuario());
    }
    
    int i = 5;
    public void marcarConsulta(Object[] especialidades,Medico[] medico,int nMedico){
        String date;
        JOptionPane.showMessageDialog(null, "Paciente "+this.getNome());
        this.setConsultas((String) JOptionPane.showInputDialog(null,"Escolha o tipo de Consulta", "Nova Consulta",JOptionPane.INFORMATION_MESSAGE, null,especialidades, especialidades [0]),this.getNc());
        if(i>31){
            i = 1;
        }
        if(i>0&&i<10){
            date = "0"+i;
        } else {
            date = ""+i;
        }
        String nomeMedico = "";
        for(int a=0;a<nMedico;a++){
            if(medico[a].getEspecialidadeMedica().equals(this.getConsulta(nc-1))){
                nomeMedico = medico[a].getNome();
            } 
        }
        if(!nomeMedico.equals("")){
                JOptionPane.showMessageDialog(null, "Consulta marcada com sucesso\nNome do Paciente: "+this.getNome()+"\nProntuário: "+
                                      this.getProntuario()+"\n------Consulta marcada-------\n"+this.getConsulta(nc-1)+"\nMédico: "+nomeMedico+"\nData: "+date+"/01/2017");
            } else {
                JOptionPane.showMessageDialog(null, "Não há Médico para esta especialidade");
                JOptionPane.showMessageDialog(null, "Consulta marcada sem data por falta de Médico\nNome do Paciente: "+this.getNome()+"\nProntuário: "+
                                      this.getProntuario()+"\n------Consulta marcada-------\n"+this.getConsulta(nc-1)+"\nData: Indefinida");
            }
        i++;
    }
    
    int j = 10;
    public void marcarExame(Object[] exames){
        String date;
        JOptionPane.showMessageDialog(null, "Paciente "+this.getNome());
        this.setExames((String) JOptionPane.showInputDialog(null,"Escolha o tipo de Exame", "Novo Exame",JOptionPane.INFORMATION_MESSAGE, null,exames, exames [0]),this.getNe());
        if(j>31){
            j = 1;
        }
        if(j>0&&j<10){
            date = "0"+j;
        } else {
            date = ""+j;
        }
        JOptionPane.showMessageDialog(null, "Exame marcado com sucesso\nNome do Paciente: "+this.getNome()+"\nProntuário: "+
                                      this.getProntuario()+"\n------Exame marcado-------\n"+this.getExame(ne-1)+"\nData: "+date+"/01/2017");
        j++;
    }
    
    int k = 10;
    public void marcarCirurgia(Object[] cirurgias,Medico[] medico,int nMedico){
        String date;
        JOptionPane.showMessageDialog(null, "Paciente "+this.getNome());
        this.setCirurgia((String) JOptionPane.showInputDialog(null,"Escolha o tipo de Cirurgia", "Nova Cirurgia",JOptionPane.INFORMATION_MESSAGE, null,cirurgias, cirurgias [0]),this.getNcr());
        if(k>31){
            k = 1;
        }
        if(k>0&&k<10){
            date = "0"+k;
        } else {
            date = ""+k;
        }
        String nomeMedico = "";
        for(int a=0;a<nMedico;a++){
            if(medico[a].getTipoCirurgia() == this.getCirurgia(ncr-1)){
                nomeMedico = medico[a].getNome();
            }
        }
        if(!nomeMedico.equals("")){
                JOptionPane.showMessageDialog(null, "Cirurgia marcada com sucesso\nNome do Paciente: "+this.getNome()+"\nProntuário: "+
                                      this.getProntuario()+"\n------Cirurgia marcada-------\n"+this.getCirurgia(ncr-1)+"\nMédico: "+nomeMedico+"\nData: "+date+"/01/2017");
            } else {
                JOptionPane.showMessageDialog(null, "Não há Médico para realizar este procedimento");
                JOptionPane.showMessageDialog(null, "Cirurgia aguardando marcação por falta de Médico\nNome do Paciente: "+this.getNome()+"\nProntuário: "+
                                      this.getProntuario()+"\n------Tipo de Cirurgia-------\n"+this.getCirurgia(ncr-1)+"\nData: Indefinida");
            }
        k++;
    }
}
