
package Aval_1;


public class Funcionario extends Pessoa{
    
    private int horasMes;
    private double salarioHora;
    private double salario;
    private boolean status;
    private int nConsultas;
    
    public int getHorasMes(){
        return horasMes;
    }
    
    public void setHorasMes(int horasMes){
        this.horasMes = horasMes;
    }
    
    public double getSalarioPorHora(){
        return salarioHora;
    }
    
    public void setSalarioPorHora(double salarioHora){
        this.salarioHora = salarioHora;
    }
    
    public double getSalario(){
        return this.salario;
    }
    
    public void setSalario(double salario){
        this.salario = salario;
    }
    
    public boolean getStatus(){
        return status;
    }
    
    public void setStatus(boolean status){
        this.status = status;
    }
    
    public String getSetor(){
        return setor;
    }
    
    public void setSetor(String setor){
        this.setor = setor;
    }
    
    public double calculoSalario(){
        salario = horasMes*salarioHora;
        return salario;
    }
}
