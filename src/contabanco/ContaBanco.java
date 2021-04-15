package contabanco;

import java.util.Scanner;

/**
 * @author RafaelRodrigues1
 */
public class ContaBanco {

    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);
        Conta c1 = new Conta();
        Conta c2 = new Conta();
        
        c1.abrirConta();
        c2.abrirConta();
        System.out.print(c1.getDono() + " deseja depositar: R$");
        c1.depositar(in.nextDouble());
        System.out.print(c2.getDono() + " deseja depositar: R$");
        c2.depositar(in.nextDouble());
        System.out.print(c2.getDono() + " deseja sacar: R$");
        c2.sacar(in.nextDouble());
        
        c1.situacaoConta();
        c2.situacaoConta();        
    }    
}
