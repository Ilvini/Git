
package Aval_1;


public abstract class Funcionario extends Pessoa{
    
    private int horasMes;
    private double salarioHora;
    double salario;
    private String cargo;
    private String status; //Férias, Licença ou Disponivel.
    
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
    
    public String getStatus(){
        return status;
    }
    
    public void setStatus(String status){
        this.status = status;
    }
    
    public boolean verificarStatus(){
        if(status.equals("Disponivel")){
            return true;
        } else {
            return false;
        }
    }
    
    public void calculoSalario(){
        salario = horasMes*salarioHora;
    }

    public abstract boolean verificarConsulta(String tipoConsulta);
    
    public abstract boolean verificarCirurgia(String tipoCirurgia);
}
