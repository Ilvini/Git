
package Aval_1;

import javax.swing.JOptionPane;


public class Enfermeiro extends Funcionario {
    
    private int coren;
    private String setor;
    private String especialidadeEnfermagem;
    private String formacao;
    
    public int getCoren(){
        return coren;
    }
    
    public void setCoren(int coren){
        this.coren = coren;
    }
    
    public String getEspecialidadeEnfermagem(){
        return especialidadeEnfermagem;
    }
    
    public void setEspecialidadeEnfermagem(String especialidEnfermagem){
        this.especialidadeEnfermagem = especialidEnfermagem;
    }
    
    public String getSetor(){
        return setor;
    }
    
    public void setSetor(String setor){
        this.setor = setor;
    }
    
    public String getFormacao(){
        return formacao;
    }
    
    public void setFormacao(String formacao){
        this.setor = formacao;
    }
    
    @Override
    public boolean verificarConsulta(String tipoConsulta){
            return false;
    }

    @Override
    public boolean verificarCirurgia(String tipoCirurgia) {
        return false;
    }
    
    @Override
    public void calculoSalario() {
        salario = this.getHorasMes() * this.getSalarioPorHora();
        this.setSalario(salario);
    }
    
    public void cadastroEnfermeiro(int nEnfermeiro) {

        Object[] setor = {"Emergência","Maternidade","Vacinação"};
        Object[] formacao = {"Graduação", "Especialização", "Mestrado", "Doutorado"};
        Object[] especialidades = {"Saúde Materna, Obstétrica e Ginecológica","Saúde da Criança e do Jovem",
                                  "Saúde do Adulto","Saúde do Idoso","Saúde Mental","Pessoa em situação crítica",
                                  "Pessoa em situação crónica e paliativa","Reabilitação","Saúde Familiar"};
        
        this.setNome(JOptionPane.showInputDialog("Nome do Enfermeiro"));
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
            this.setCoren(Integer.parseInt(JOptionPane.showInputDialog(null, "Número do COREN - Conselho Regional de Enfermagem (4 Digitos)")));
        } while (this.getCoren() > 9999 || this.getCoren() < 1000);
        this.setEspecialidadeEnfermagem((String) JOptionPane.showInputDialog(null, "Qual a sua especialidade?", "Novo Enfermeiro", JOptionPane.INFORMATION_MESSAGE, null, especialidades, especialidades[0]));
        this.setSetor((String) JOptionPane.showInputDialog(null, "Setor que trabalha?", "Novo Enfermeiro", JOptionPane.INFORMATION_MESSAGE, null, setor, setor[0]));
        this.setFormacao((String) JOptionPane.showInputDialog(null, "Formação?", "Novo Enfermeiro", JOptionPane.INFORMATION_MESSAGE, null, formacao, formacao[0]));
        this.setSalarioPorHora(Double.parseDouble(JOptionPane.showInputDialog(null, "Salário por hora")));
        this.setHorasMes(Integer.parseInt(JOptionPane.showInputDialog(null, "Horas de trabalho por Mês")));
        JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso\nNome: " + this.getNome() + "\nEspecialidade: " + this.getEspecialidadeEnfermagem() + "\n------COREN------\n" + this.getCoren());
    }
}
