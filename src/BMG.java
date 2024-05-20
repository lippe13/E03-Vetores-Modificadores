import java.util.Scanner;
 import java.util.Date;


class Operacao {
 
     private Date data;
     private char tipo;
     private float valor;

    public Date getData(){
        return this.data;
    }

    public char getTipo(){
        return this.tipo;
    }

    public void setTipo(char tipo){

        if(this.tipo == 'd'|| this.tipo == 's'){
             this.tipo = tipo;
        }

    }

    public float getValor(){
        return this.valor;
    }

    public void setValor(float valor){
        this.valor = valor;
    }

 
     public Operacao(char tipo, float valor) {
         this.tipo = tipo;
         this.valor = valor;
         data = new Date();
     }
 
 }

class Cliente{

    private String nome;
    String CPF;
    String endereco;
    int idade;
    char sexo;

    public String getNome(){
        return this.nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }



}

class Conta {

    Operacao[] operacoes = new Operacao[999];
    Cliente cliente;
    private int numero;
    private float saldo_atual = 0;
    private float limite;
    int x = 0;

    public int getNumero(){
        return this.numero;
    }

    public void setNumero(int numero){
        this.numero = numero;
    }

    public float getSaldo(){
        return this.saldo_atual;
    }

    public float getLimite(){
        return this.limite;
    }

    public void setLimite(float limite){

        if(this.limite >= 0){
            this.limite = limite;
        } else {
            limite = 0;
        }

    }


    
    void imprimir (int numero, float limite, String nome , String CPF, String endereco, char sexo, int idade){
        System.out.println("-----CLIENTE-----");
        System.out.println("Nome: " + nome);
        System.out.println("CPF: " + CPF);
        System.out.println("Endereco: " + endereco);
        System.out.println("Idade: " + idade);
        System.out.println("Sexo: " + sexo);
        System.out.println("-----CONTA-----");
        System.out.println("Numero: " + this.getNumero());
        System.out.println("Limite: " + this.getLimite());
        System.out.println("Saldo Atual: " + this.getSaldo());
    }

    void saca (float quantidade){

        if(saldo_atual >= quantidade){

            float nv_saldo = this.saldo_atual - quantidade;
            saldo_atual = nv_saldo;
            operacoes[x] = new Operacao('S', quantidade);
            x++;
            System.out.println("Saque realizado com sucesso, no valor de BRL " + quantidade);

        } else{
            System.out.println("Saldo Insuficiente");
        }
    }

    void depositar (float quantidade){


        float nv_saldo = this.saldo_atual + quantidade;
        if(nv_saldo > this.limite){
            System.out.println("Limite estourado!!!");
        } else{
            saldo_atual = nv_saldo;
            operacoes[x] = new Operacao('D', quantidade);
            x++;
            System.out.println("Deposito realizado com sucesso, no valor de BRL " + quantidade);
        }

    }

    void extrato()
    
    {
        System.out.println(" ");
        for(int i = 0; i < x; i++){
            Operacao op = operacoes[i];
            System.out.println(op.getData() + " " + op.getTipo() + " " + op.getValor());
        }
        System.out.println(" ");

    }

}

class BMG {
       public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Conta conta;
        conta = new Conta();

        Cliente cliente;
        cliente = new Cliente();

        int x;
        float quantidade;
            
            do{

                System.out.println("-----BANCO BMG-----");
                System.out.println(" ");
                System.out.println("Saldo Atual = " + conta.getSaldo());
                System.out.println(" ");
                System.out.println("[1] - Cadastrar sua conta");
                System.out.println("[2] - Cadastrar seus dados de cliente");
                System.out.println("[3] - Imprimir dados da sua conta");
                System.out.println("[4] - Sacar");
                System.out.println("[5] - Depositar");
                System.out.println("[6] - Imprimir extrato");
                System.out.println("[0] - Sair");

                System.out.print("Insira um valor: ");
                x = sc.nextInt();
                sc.nextLine();
                System.out.println("");

                
                switch (x) {

                case 1:
                    
                    System.out.print("Insira o numero da conta: ");
                    conta.setNumero(sc.nextInt());
                    System.out.print("Insira seu limite: ");
                    conta.setLimite(sc.nextFloat());
                    sc.nextLine();

                break;
                
                case 2:

                    System.out.print("Insira seu nome: ");
                    cliente.setNome(sc.nextLine());
                    System.out.print("Insira seu CPF: ");
                    cliente.CPF = sc.nextLine();
                    System.out.print("Insira seu endereco: ");
                    cliente.endereco = sc.nextLine();
                    System.out.print("Insira sua idade: ");
                    cliente.idade = sc.nextInt();
                    System.out.print("Insira seu sexo: ");
                    cliente.sexo = sc.next().charAt(0);
                    sc.nextLine();

                break;

                case 3:

                    conta.imprimir(conta.getNumero(), conta.getLimite(), cliente.getNome(), cliente.CPF, cliente.endereco, cliente.sexo, cliente.idade);

                break;

                case 4:

                    quantidade = 0;
                    System.out.print("Insira a quantidade que deseja sacar: ");
                    quantidade = sc.nextFloat();
                    conta.saca(quantidade);

                break;

                case 5:

                    quantidade = 0;
                    System.out.print("Insira a quantidade que deseja depositar: ");
                    quantidade = sc.nextFloat();
                    conta.depositar(quantidade);                    

                break;

                case 6:

                    conta.extrato();

                break;

                case 0:

                    System.out.println("Obrigado por usar o Banco BMG!");

                break;

                default:

                    System.out.println("Valor Invalido, tente novamente.");

                break;
            }

            System.out.println("");
            
        } while (x != 0);
        sc.close();
    } 
}
