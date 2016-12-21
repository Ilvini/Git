/*
 * Federal University of Pará - UFPA
 * Institute of Technology - ITEC
 * Faculty of Computer Engineering and Telecommunications - FCT
 * Data Structure
 * Teacher: Thiago Sylas
 */
package Aval_1;

/**
 * Students: Ilvini Pitter Nunes Batista - 201606840089 Janilson
 */
import java.awt.HeadlessException;
import java.io.IOException;
import javax.swing.JOptionPane;

public class Avaliacao1_Main {

    public static void main(String[] args) throws IOException {

        Paciente paciente[] = new Paciente[100];
        Medico medico[] = new Medico[10];
        Enfermeiro enfermeiro[] = new Enfermeiro[10];

        int nPaciente = 0;
        int nMedico = 0;
        int nEnfermeiro = 0;
        int nPC = - 1;
        int nMC = - 1;
        int nEC = - 1;
        int opcao;

        Object[] especialidades = {"Acupuntura", " Alergia", " Angiologia", " Cardiologia", " Clínica Geral",
            " Coloproctologia", " Dermatologia", " Endocrinologia", " Fisiatria",
            " Fisioterapia", " Fonoaudiologia", " Gastroenterologia", " Geriatria",
            " Ginecologia", " Hematologia", " Homeopatia", " Infectologia", " Nefrologia",
            " Neurologia", " Nutrição", " Nutrologia", " Odontologia", " Oftalmologia",
            " Oncologia", " Ortopedia e Traumatologia", " Otorrinolaringologia", " Pediatria",
            " Pneumologia", " Psicologia", " Psicopedagogia", " Psiquiatria", "Reumatologia",
            " Urologia"};

        Object[] exames = {"Exame de sangue", "Urina", "Fezes", "TGO e TGP", "Eletrocardiograma", "Raio X", "Endoscopia", "próstata"};

        Object[] cirurgias = {"Cirurgia neurológica: crânio e coluna", "Cirurgia bucomaxilofacial", "Cirurgia oftalmológica\n",
            "Cirurgia otorrinolaringológica", "Cirurgia de cabeça e pescoço", "Cirurgia cardíaca",
            "Cirurgia torácica", "Cirurgia do aparelho digestivo", "Cirurgia vascular", "Cirurgia ortopédica: membros e coluna",
            "Cirurgia urológica", "Cirurgia ginecológica", "Cirurgia obstétrica", "Cirurgia oncológica",
            "Cirurgia plástica", "Cirurgia reconstrutiva", "Cirurgia estética", "Cirurgia robótica"};

        do {
            try {
                opcao = Integer.parseInt(JOptionPane.showInputDialog(null, "--------Sistema Hospital Eng. Comp. UFPA--------\nPaciente (1)         Médicos(2)         Enfermeiros(3)"));
                switch (opcao) {
                    case 1:
                        opcao = Integer.parseInt(JOptionPane.showInputDialog(null, "O que deseja fazer?\nLista de pacientes (1)\n"
                                + "Novo Prontuário (2)\nMarcar Consulta (3)\nMarcar Exame (4)\nMarcar Operação (5)"));
                        switch (opcao) {
                            case 1:
                                String nomes = "";
                                for (int i = 0; i < nPaciente; i++) {
                                    nomes = nomes + "\n" + paciente[i].getNome();
                                }
                                JOptionPane.showMessageDialog(null, "Pacientes: " + nomes);
                                break;
                            case 2:
                                paciente[nPaciente] = new Paciente();
                                paciente[nPaciente].cadastroProntuario(nPaciente);
                                nPaciente++;
                                break;
                            case 3:
                                do {
                                    int prontuario = Integer.parseInt(JOptionPane.showInputDialog(null, "Informe o número de Prontuário"));
                                    for (int i = 0; i < nPaciente; i++) {
                                        if (paciente[i].getProntuario() == prontuario) {
                                            nPC = i;
                                        }
                                    }
                                    if (nPC == -1) {
                                        JOptionPane.showMessageDialog(null, "Prontuário inválido");
                                    }
                                } while (nPC == -1);
                                paciente[nPC].marcarConsulta(especialidades, medico,nMedico);
                                break;
                            case 4:
                                do {
                                    int prontuario = Integer.parseInt(JOptionPane.showInputDialog(null, "Informe o número de Prontuário"));
                                    for (int i = 0; i < nPaciente; i++) {
                                        if (paciente[i].getProntuario() == prontuario) {
                                            nPC = i;
                                        }
                                    }
                                    if (nPC == -1) {
                                        JOptionPane.showMessageDialog(null, "Prontuário inválido");
                                    }
                                } while (nPC == -1);
                                paciente[nPC].marcarExame(exames);
                                break;
                            case 5:
                                do {
                                    int prontuario = Integer.parseInt(JOptionPane.showInputDialog(null, "Informe o número de Prontuário"));
                                    for (int i = 0; i < nPaciente; i++) {
                                        if (paciente[i].getProntuario() == prontuario) {
                                            nPC = i;
                                        }
                                    }
                                    if (nPC == -1) {
                                        JOptionPane.showMessageDialog(null, "Prontuário inválido");
                                    }
                                } while (nPC == -1);
                                paciente[nPC].marcarCirurgia(cirurgias,medico,nMedico);
                                break;
                            default:
                                JOptionPane.showMessageDialog(null, "Opção invalida!");
                                break;
                        }
                        break;
                    case 2:
                        do {
                            opcao = Integer.parseInt(JOptionPane.showInputDialog(null, "O que deseja fazer?\nLista de Médicos (1)\nCadastrar novo Médico (2)\nCalcular Salário (3)"));
                            switch (opcao) {
                                case 1:
                                    String nomes = "";
                                    for (int i = 0; i < nMedico; i++) {
                                        nomes = nomes + "\n" + medico[i].getNome();
                                    }
                                    JOptionPane.showMessageDialog(null, "Medicos: " + nomes);
                                    break;
                                case 2:
                                    medico[nMedico] = new Medico();
                                    medico[nMedico].cadastroMedico(nMedico, especialidades,cirurgias);
                                    nMedico++;
                                    break;
                                case 3:
                                    do{
                                        int crm = Integer.parseInt(JOptionPane.showInputDialog(null, "Informe o número do CRM do Médico"));
                                        for (int i = 0; i < nMedico; i++) {
                                            if (medico[i].getCrm()== crm) {
                                                nMC = i;
                                            }
                                        }
                                        if (nMC == -1) {
                                            JOptionPane.showMessageDialog(null, "CRM não cadastrado");
                                        }
                                    } while (nMC == -1);
                                    medico[nMC].calculoSalario();
                                    JOptionPane.showMessageDialog(null, "Salário: "+medico[nMC].getSalario()+" R$");
                                    break;
                                default:
                                    JOptionPane.showMessageDialog(null, "Opção invalida!");
                                    break;
                            }
                        } while (opcao != 3 && opcao != 2 && opcao != 1);
                        break;
                    case 3:
                        do {
                            opcao = Integer.parseInt(JOptionPane.showInputDialog(null, "O que deseja fazer?\nLista de Enfermeiros (1)\nCadastrar novo Enfermeiro (2)\nCalcular Salário (3)"));
                            switch (opcao) {
                                case 1:
                                    String nomes = "";
                                    for (int i = 0; i < nEnfermeiro; i++) {
                                        nomes = nomes + "\n" + enfermeiro[i].getNome();
                                    }
                                    JOptionPane.showMessageDialog(null, "Enfermeiros: " + nomes);
                                    break;
                                case 2:
                                    enfermeiro[nEnfermeiro] = new Enfermeiro();
                                    enfermeiro[nEnfermeiro].cadastroEnfermeiro(nEnfermeiro);
                                    nEnfermeiro++;
                                    break;
                                case 3:
                                    do{
                                        int coren = Integer.parseInt(JOptionPane.showInputDialog(null, "Informe o número do COREN do Enfermeiro"));
                                        for (int i = 0; i < nEnfermeiro; i++) {
                                            if (enfermeiro[i].getCoren()== coren) {
                                                nEC = i;
                                            }
                                        }
                                        if (nEC == -1) {
                                            JOptionPane.showMessageDialog(null, "COREN não cadastrado");
                                        }
                                    } while (nEC == -1);
                                    enfermeiro[nEC].calculoSalario();
                                    JOptionPane.showMessageDialog(null, "Salário: "+enfermeiro[nEC].getSalario()+" R$");
                                    break;
                                default:
                                    JOptionPane.showMessageDialog(null, "Opção invalida!");
                                    break;
                            }
                        } while (opcao != 3 && opcao != 2 && opcao != 1);
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opção invalida!");
                        break;
                }
            } catch (HeadlessException | NumberFormatException erro) {
                JOptionPane.showMessageDialog(null, "Operação interrompida!");
            } finally {
                opcao = JOptionPane.showConfirmDialog(null, "Continuar no Sistema?", "", 0, 3);
            }
        } while (opcao != 1 && opcao != -1);
    }
}
