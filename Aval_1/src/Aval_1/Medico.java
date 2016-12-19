
package Aval_1;

public class Medico extends Funcionario {
    
    private int crm;
    private String especialidadeMedica;
    private String formacaoMedica;
    private boolean cirurgiao;
    private int cirurgias = 0;
    
    public int getCrm(){
        return crm;
    }
    
    public void setCrm(int crm){
        this.crm = crm;
    }
    
    public String getEspecialidadeMedica(){
        return especialidadeMedica;
    }
    
    public void setEspecialidadeMedica(String especialidMedica){
        this.especialidadeMedica = especialidMedica;
    }
    
    public String getFormacaoMedica(){
        return this.formacaoMedica;
    }
    
    public void setFormacaoMedica(String formacaoMedica){
        this.formacaoMedica = formacaoMedica;
    }
    
    public boolean getCirurgiao(){
        return cirurgiao;
    }
    
    public void setCirurgiao(boolean cirurgiao){
        this.cirurgiao = cirurgiao;
    }
    
    @Override
    public boolean verificarCirurgia(String tipoCirurgia){
        if(especialidadeMedica.equals(tipoCirurgia)){
            cirurgias++;
            return true;
        } else {
            return false;
        }
    }
    
    @Override
    public boolean verificarConsulta(String tipoConsulta){
        if(especialidadeMedica.equals(tipoConsulta)){
            return true;
        } else {
            return false;
        }
    }
    
    @Override
    public void calculoSalario(){
        salario = this.getHorasMes()*this.getSalarioPorHora()+(cirurgias*300);
        this.setSalario(salario);
    }
}
