package Aval_1;

import javax.swing.JOptionPane;

public class Medico extends Funcionario {

    private int crm;
    private String especialidadeMedica;
    private boolean cirurgiao;
    private String tipoCirurgia;
    private int cirurgias = 0;

    public int getCrm() {
        return crm;
    }

    public void setCrm(int crm) {
        this.crm = crm;
    }

    public String getEspecialidadeMedica() {
        return especialidadeMedica;
    }

    public void setEspecialidadeMedica(String especialidMedica) {
        this.especialidadeMedica = especialidMedica;
    }

    public boolean getCirurgiao() {
        return cirurgiao;
    }

    public void setCirurgiao(boolean cirurgiao) {
        this.cirurgiao = cirurgiao;
    }
    
    public String getTipoCirurgia() {
        return tipoCirurgia;
    }

    public void setTipoCirurgia(String tipoCirurgia) {
        this.tipoCirurgia = tipoCirurgia;
    }

    @Override
    public boolean verificarCirurgia(String tipoCirurgia) {
        if (especialidadeMedica.equals(tipoCirurgia)) {
            cirurgias++;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean verificarConsulta(String tipoConsulta) {
        if (especialidadeMedica.equals(tipoConsulta)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void calculoSalario() {
        salario = this.getHorasMes() * this.getSalarioPorHora() + (cirurgias * 300);
        this.setSalario(salario);
    }

    public void cadastroMedico(int nMedico, Object[] especialidades, Object[] cirurgias) {

        this.setNome(JOptionPane.showInputDialog("Nome do Medico"));
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
            this.setCrm(Integer.parseInt(JOptionPane.showInputDialog(null, "Número do CRM - Conselho Regional de Medicina (4 Digitos)")));
        } while (this.getCrm() > 9999 || this.getCrm() < 1000);
        this.setEspecialidadeMedica((String) JOptionPane.showInputDialog(null, "Qual a sua especialidade?", "Novo Médico", JOptionPane.INFORMATION_MESSAGE, null, especialidades, especialidades[0]));
        this.setCirurgiao(0 == JOptionPane.showConfirmDialog(null, "É cirurgião?", "", 0, 3));
        if(this.getCirurgiao()){
            this.setTipoCirurgia((String) JOptionPane.showInputDialog(null,"Escolha o tipo de Cirurgia que ele realiza", "Novo Médico",JOptionPane.INFORMATION_MESSAGE, null,cirurgias, cirurgias [0]));
        }
        this.setSalarioPorHora(Double.parseDouble(JOptionPane.showInputDialog(null, "Salário por hora")));
        this.setHorasMes(Integer.parseInt(JOptionPane.showInputDialog(null, "Horas de trabalho por Mês")));
        JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso\nNome: " + this.getNome() + "\nEspecialidade: " + this.getEspecialidadeMedica() + "\n------CRM------\n" + this.getCrm());
    }
}
