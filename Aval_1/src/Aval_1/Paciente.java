
package Aval_1;


public class Paciente extends Pessoa{
    
    private int prontuario;
    private final String exames [] = new String[10];
    private final String consultas [] = new String[10];
    private final String cirurgias [] = new String[10];
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
    
    public void setProntuario(int prontuario){
        this.prontuario = prontuario;
    }
    
    public void setExames(String exames[], int ne){
        this.exames[ne] = exames[ne];
    }
    
    public void setConsultas(String consultas[], int nc){
        this.consultas[nc] = consultas[nc];
    }
    
    public void setCirugia(String cirurgias[], int ncr){
        this.cirurgias[ncr] = cirurgias[ncr];
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
    
}
