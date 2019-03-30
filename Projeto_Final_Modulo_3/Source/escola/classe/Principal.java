//******************************************************
//Instituto Federal de São Paulo - Campus Sertãozinho
//Disciplina......: M3LPBD
//Programação de Computadores e Dispositivos Móveis
//Aluno...........: Daniel Barros de Oliveira
//******************************************************
package br.com.escola.classe;

import br.com.escola.view.Disciplinas;

public class Principal {
    
    public static void main(String[] args) {
        // "Chamando o form Disciplina atraves do método principal 
        Disciplinas disciplina = new Disciplinas();
        disciplina.setVisible(true);
    }
    
}
