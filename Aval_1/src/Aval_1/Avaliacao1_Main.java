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
        int nPC = 0;
        int opcao;

        do {
            try {
                opcao = Integer.parseInt(JOptionPane.showInputDialog(null, "--------Sistema Hospital Eng. Comp. UFPA--------\nUsuário (1)         Médicos(2)         Enfermeiros(3)"));
                switch (opcao) {
                    case 1:
                        opcao = Integer.parseInt(JOptionPane.showInputDialog(null, "O que deseja fazer?\nLista de pacientes (1)\n"
                                + "Novo Prontuário (2)\nMarcar Consulta (3)\nMarcar Exame (4)\nMarcar Operação (5)"));
                        if (opcao == 1) {
                            for (int i = 0; i < nPaciente; i++) {
                                System.out.println((i + 1) + " Nome: " + paciente[i].getNome());
                            }
                        } else if (opcao == 2) {
                            paciente[nPaciente] = new Paciente();
                            paciente[nPaciente].setNome(JOptionPane.showInputDialog("Nome do Paciente"));
                            paciente[nPaciente].setIdade(Integer.parseInt(JOptionPane.showInputDialog(null, "Idade")));
                            do {
                                paciente[nPaciente].setSexo(JOptionPane.showInputDialog("Sexo (m ou f)").charAt(0));
                                if ((paciente[nPaciente].getSexo() != 'M' && paciente[nPaciente].getSexo() != 'm')
                                        && (paciente[nPaciente].getSexo() != 'F' && paciente[nPaciente].getSexo() != 'f')) {
                                    JOptionPane.showMessageDialog(null, "Informação errada!");
                                }
                            } while ((paciente[nPaciente].getSexo() != 'M' && paciente[nPaciente].getSexo() != 'm')
                                    && (paciente[nPaciente].getSexo() != 'F' && paciente[nPaciente].getSexo() != 'f'));
                            do {
                                paciente[nPaciente].setCpf(JOptionPane.showInputDialog("CPF"));
                                if (!paciente[nPaciente].testeCPF()) {
                                    JOptionPane.showMessageDialog(null, "CPF invalido");
                                }
                            } while (paciente[nPaciente].testeCPF() == false);
                            do {
                                opcao = Integer.parseInt(JOptionPane.showInputDialog(null, "Status:\nMuito Grave (3)\nMal (2)\nNormalizado (1)"));
                                switch (opcao) {
                                    case 1:
                                        paciente[nPaciente].setStatus("Normalizado");
                                        break;
                                    case 2:
                                        paciente[nPaciente].setStatus("Mal");
                                        break;
                                    case 3:
                                        paciente[nPaciente].setStatus("Muito Grave");
                                        break;
                                    default:
                                        JOptionPane.showMessageDialog(null, "Opção invalida!");
                                        break;
                                }
                            } while (opcao != 1 && opcao != 2 && opcao != 3);
                            paciente[nPaciente].setProntuario(100 + nPaciente);
                            JOptionPane.showMessageDialog(null, "O número de Prontuário gerado de " + paciente[nPaciente].getNome() + " é\n\nProntuário: " + paciente[nPaciente].getProntuario());
                        } else if(opcao == 3){
                            int prontuario = Integer.parseInt(JOptionPane.showInputDialog(null,"Informe o número de Prontuário"));
                            for(int i=0;i<nPaciente;i++){
                                if(paciente[i].getProntuario() == prontuario){
                                    nPC = i;
                                }
                            }
                            JOptionPane.showMessageDialog(null, "Paciente "+paciente[nPC].getNome());
                            
                        }
                        break;
                    case 2:
                        opcao = Integer.parseInt(JOptionPane.showInputDialog(null, "O que deseja fazer?\nLista de Médicos (1)\nCalcular Salário (2)"));
                        
                        break;
                    case 3:
                        System.out.println("O que deseja fazer?\nLista de Enfermeiros (1)\nCalcular Salário (2)");
                        opcao = leia.nextInt();
                        break;
                    default:
                        System.out.println("Opção Incorreta!");
                        break;
                }
            } catch (HeadlessException | NumberFormatException erro) {
                JOptionPane.showMessageDialog(null, "Erro! " + erro);
            } finally {
                opcao = JOptionPane.showConfirmDialog(null, "Continuar no Sistema?", "", 0, 3);
            }
        } while (opcao != 1 && opcao != -1);
    }
}
