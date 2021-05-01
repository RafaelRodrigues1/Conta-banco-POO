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
    
            //Construtor
    public Conta(){
        setStatus(false);
        setSaldo(0);
        this.numConta = (int)(1 + Math.random() * 10000);
    }
    
            //Getters e Setters
    public int getNumConta() {
        return numConta;
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
    
    public void abrirConta(){
        System.out.print("Digite o nome do titular da conta: ");
        this.dono = in.nextLine();
        System.out.print("Digite o tipo da conta:[CC ou CP] ");
        this.setTipo(in.next().toUpperCase());        
        System.out.println("Número da sua conta: " + getNumConta());
        this.setStatus(true);      
        switch (tipo) {
            case "CC" ->    {this.setSaldo(50);}                         
            case "CP" ->    {this.setSaldo(150);}
            default ->      {break;}                
        } 
        System.out.println("Conta aberta com sucesso!");
    }
    
    public void fecharConta(){
        if(this.getSaldo() == 0 && this.isStatus()){
            this.setStatus(false);
            System.out.println("Conta fechada com sucesso!");
        }else{
            System.out.println("Senhor " + this.getDono());
            System.out.println("Para fechar conta, saldo precisa estar zerado e conta tem de estar aberta");
            System.out.println("Verifique seu saldo e situação da sua conta");
        }        
    }
    
    public void depositar(double deposito){
        if(this.isStatus()){
            this.setSaldo(this.getSaldo() + deposito);
            System.out.printf("Depósito no valor de R$%.2f realizado\n", deposito);
        }else{
            System.out.println("Conta está fechada");
        }
    }
    
    public void sacar(double saque){
        if(saque <= this.getSaldo() && this.isStatus()){
            this.setSaldo(this.getSaldo() - saque);
            System.out.println("Saque realizado no valor de R$" + saque + " realizado");
        }else{
            System.out.println("Senhor " + this.getDono());
            System.out.println("Você não tem esse saldo em conta ou conta está fechada\n"
                    + "Verifique sua conta\nOperação não realizada");
        }
    }
    
    public void pagarMensal(){
        if(this.isStatus()){
            if(this.getTipo().equals("CC")){
                this.setSaldo(getSaldo() - 12);
            }else if(this.getTipo().equals("CP")){
                this.setSaldo(getSaldo() - 20);
            }
        }else{
            System.out.println("Conta está fechada");
        }    
    }
    
    public void situacaoConta(){
        String status;
        if(this.isStatus()){
            status = "Aberta";
        }else{
            status = "Fechada";
        }
        System.out.printf("Nome do titular: \t%s\nTipo da conta: \t\t%s\nNúmero da conta: \t%d\nStatus da conta: \t%s\n"
                + "Saldo da conta: \tR$%.2f\n", this.getDono(),this.getTipo(), this.getNumConta(), status, this.getSaldo());
    }
            
    
    
}
