package contabanco;

import java.util.Scanner;

/**
 * @author RafaelRodrigues1
 */
public class Conta {
    Scanner in = new Scanner(System.in);
    
    public int numConta;
    protected String tipo;
    private String dono;
    private double saldo;
    private boolean status;
    
    public Conta(){
        setStatus(false);
        setSaldo(0);
        setNumConta((int)(1 + Math.random() * 10000));
    }
    
    public void abrirConta(){
        System.out.print("Digite o nome do titular da conta: ");
        setDono(in.next());
        System.out.print("Digite o tipo da conta:[CC ou CP] ");
        setTipo(in.next().toUpperCase());        
        System.out.println("Número da sua conta: " + getNumConta());
        setStatus(true);      
        switch (tipo) {
            case "CC" ->    {setSaldo(50);}                         
            case "CP" ->    {setSaldo(150);}
            default ->      {break;}                
        }                
    }
    
    public void fecharConta(){
        if(getSaldo() == 0 && isStatus()){
            setStatus(false);
        }else{
            System.out.println("Senhor " + getDono());
            System.out.println("Para fechar conta, saldo precisa estar zerado e conta tem de estar aberta");
            System.out.println("Verifique seu saldo e situação da sua conta");
        }        
    }
    
    public void depositar(double deposito){
        if(isStatus()){
            setSaldo(getSaldo() + deposito);
        }else{
            System.out.println("Conta está fechada");
        }
    }
    
    public void sacar(double saque){
        if(saque <= getSaldo() && isStatus()){
            setSaldo(getSaldo() - saque);
        }else{
            System.out.println("Senhor " + getDono());
            System.out.println("Você não tem esse saldo em conta ou conta está fechada");
            System.out.println("Verifique sua conta");
            System.out.println("Operação não realizada");
        }
    }
    
    public void pagarMensal(){
        if(isStatus()){
            if(getTipo().equals("CC")){
                setSaldo(getSaldo() - 12);
            }else if(getTipo().equals("CP")){
                setSaldo(getSaldo() - 20);
            }
        }else{
            System.out.println("Conta está fechada");
        }    
    }
    
    public void situacaoConta(){
        String status;
        if(isStatus()){
            status = "Aberta";
        }else{
            status = "Fechada";
        }
        System.out.printf("Nome do titular: \t%s\nNúmero da conta: \t%d\nStatus da conta: \t%s\n"
                + "Saldo da conta: \tR$%.2f\n", getDono(), getNumConta(), status, getSaldo());
    }

    public int getNumConta() {
        return numConta;
    }

    public void setNumConta(int numConta) {
        this.numConta = numConta;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDono() {
        return dono;
    }

    public void setDono(String dono) {
        this.dono = dono;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
}
