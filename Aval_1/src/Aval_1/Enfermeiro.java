
package Aval_1;


public class Enfermeiro extends Funcionario {
    
    private int coren;
    private String setor;
    private String formacaoEnfermagem;
    private String especialidadeEnfermagem;
    
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
    
    public String getFormacaoEnfermagem(){
        return this.formacaoEnfermagem;
    }
    
    public void setFormacaoEnfermagem(String formacaoEnfermagem){
        this.formacaoEnfermagem = formacaoEnfermagem;
    }
    
    public String getSetor(){
        return setor;
    }
    
    public void setCirurgiao(String setor){
        this.setor = setor;
    }
    
    @Override
    public boolean verificarConsulta(String tipoConsulta){
        if(especialidadeEnfermagem.equals(tipoConsulta)&&(!"Maternidade".equals(setor)||!"Vacinação".equals(setor)||!"Emergência".equals(setor))){
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean verificarCirurgia(String tipoCirurgia) {
        return false;
    }
}
