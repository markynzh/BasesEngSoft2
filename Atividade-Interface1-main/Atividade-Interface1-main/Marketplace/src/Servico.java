import java.util.ArrayList;
import java.util.Scanner;

public class Servico {
    //atributos
    String nome;
    String descricao;
    double valor;
    private ArrayList<Servico> listaServico = new ArrayList<>();

    //construtor
    public Servico (String nome, String descricao, double valor) {
        this.nome = nome;
        this.descricao = descricao;
        this.valor = valor;
    }

    public Servico () {
        listaServico.add (new Servico ("Criação de logo", "Cria uma logo personalizada", 150));
        listaServico.add (new Servico ("Desenvolvimento de site", "Site do seu jeito para a sua empresa", 2500));
        listaServico.add (new Servico ("Consultoria em TI", "Consultoria de TI", 400));
    }

    //métodos
    Scanner sc = new Scanner(System.in);

    @Override
    public String toString() {
        return "Nome: " + nome + "\nDescrição: " + descricao + "\nValor: R$ " + valor + "\n";
    }

    public void cadastrarServico() {
        System.out.println("Digite o nome do produto: ");
        String nome = sc.nextLine();
        while(nome.trim().isEmpty()){
            System.out.println("Nome inválido!");
            nome = sc.nextLine();
        }

        System.out.println("Digite a descrição do serviço: ");
        String descricao = sc.nextLine();

        System.out.println("Digite o valor do serviço: ");
        double valor = sc.nextDouble();
        while (valor < 0){
            System.out.println("Valor inválido!\nDigite o valor do serviço:");
            valor = sc.nextDouble();
        }
        sc.nextLine();

        listaServico.add(new Servico(nome, descricao, valor));
    }


    public void exibirServico(){
        if (listaServico.size()<3){
            System.out.println("É necessário que o sistema tenha ao menos 3 serviços cadastrados.");
        } else {
            for (Servico servico : listaServico) {
                System.out.println(servico);
            }
        }

    }

    public void buscarServico(){
        if (listaServico.size()<3){
            System.out.println("É necessário que o sistema tenha ao menos 3 serviços cadastrados.");
        } else {
        System.out.println("Digite o nome do serviço que deseja buscar: ");
        String nomeBusca = sc.nextLine();
            boolean encontrou = false;
            for (Servico servico : listaServico){
                if (servico.nome.equalsIgnoreCase(nomeBusca)){
                    System.out.println(servico);
                    encontrou = true;
                    break;
                }
            }
            if(!encontrou){
                System.out.println("Serviço não encontrado!");
            }
        }
    }

    public void realizarServico(){
        if (listaServico.size()<3){
            System.out.println("É necessário que o sistema tenha ao menos 3 serviços cadastrados.");
        } else {
            System.out.println("----REALIZAR PEDIDO----");
            System.out.println("Digite seu nome: ");
            String nome = sc.nextLine();
            while(nome.trim().isEmpty()){
                System.out.println("Nome inválido!");
                nome = sc.nextLine();
            }

            Servico servicoEscolhido = null;
            System.out.println("Apresentando serviços: ");
            for (Servico servico : listaServico){
                System.out.println(servico);
            }
            System.out.println("Escolha um serviço: ");
            String nomeBusca = sc.nextLine();
            for (Servico servico : listaServico){
                if (servico.nome.equalsIgnoreCase(nomeBusca)){
                    System.out.println("Serviço encontrado!\n" + servico);
                    servicoEscolhido = servico;
                    break;
                }
            }

            if(servicoEscolhido == null){
                System.out.println("Serviço não encontrado!");
                return;
            }


            System.out.println("Escolha a forma de pagamento (digite o número correspondente ao pagamento que deseja): \n1- Pix\n2- Cartão de crédito\n3- Boleto Bancário\n4- Criptomoeda" +
                    "\n5- Carteira digital\n6- Débito");
            int escPag = sc.nextInt();
            sc.nextLine();
            if (escPag == 1){
                PagamentoPix pagamento = new PagamentoPix();
                System.out.println("\n=======================\nRESUMO DO PEDIDO\n=======================");
                System.out.println("Cliente: " + nome);
                System.out.println("\nServiço: " + servicoEscolhido.nome);
                System.out.println("Valor original: " + servicoEscolhido.valor);
                System.out.println("\nForma de pagamento: PIX");
                System.out.println("Taxa aplicada: isento");
                System.out.println("\nValor final: R$" + pagamento.valorFinal(servicoEscolhido.valor));
                System.out.println("Pedido realizado com sucesso!");
                System.out.println("=======================\n");
                listaServico.remove(servicoEscolhido);
            } else if (escPag == 2){
                PagamentoCartaoCredito pagamento = new PagamentoCartaoCredito();
                System.out.println("\n=======================\nRESUMO DO PEDIDO\n=======================");
                System.out.println("Cliente: " + nome);
                System.out.println("\nServiço: " + servicoEscolhido.nome);
                System.out.println("Valor original: " + servicoEscolhido.valor);
                System.out.println("\nForma de pagamento: Cartão de crédito");
                System.out.println("Taxa aplicada: R$" + servicoEscolhido.valor * 0.03);
                System.out.println("\nValor final: R$" + pagamento.valorFinal(servicoEscolhido.valor));
                System.out.println("Pedido realizado com sucesso!");
                System.out.println("=======================\n");
                listaServico.remove(servicoEscolhido);
            } else if (escPag == 3){
                PagamentoBoleto pagamento = new PagamentoBoleto();
                System.out.println("\n=======================\nRESUMO DO PEDIDO\n=======================");
                System.out.println("Cliente: " + nome);
                System.out.println("\nServiço: " + servicoEscolhido.nome);
                System.out.println("Valor original: " + servicoEscolhido.valor);
                System.out.println("\nForma de pagamento: Boleto Bancário");
                System.out.println("Taxa aplicada: R$5,00 ");
                System.out.println("\nValor final: R$" + pagamento.valorFinal(servicoEscolhido.valor));
                System.out.println("Pedido realizado com sucesso!");
                System.out.println("=======================\n");
                listaServico.remove(servicoEscolhido);
            } else if (escPag ==4){
                PagamentoCripto pagamento = new PagamentoCripto();
                System.out.println("\n=======================\nRESUMO DO PEDIDO\n=======================");
                System.out.println("Cliente: " + nome);
                System.out.println("\nServiço: " + servicoEscolhido.nome);
                System.out.println("Valor original: " + servicoEscolhido.valor);
                System.out.println("\nForma de pagamento: Criptomoeda");
                System.out.println("Taxa aplicada: R$" + servicoEscolhido.valor *0.025);
                System.out.println("\nValor final: R$" + pagamento.valorFinal(servicoEscolhido.valor));
                System.out.println("Pedido realizado com sucesso!");
                System.out.println("=======================\n");
            } else if (escPag == 5){
                PagamentoCartDigi pagamento = new PagamentoCartDigi();
                System.out.println("\n=======================\nRESUMO DO PEDIDO\n=======================");
                System.out.println("Cliente: " + nome);
                System.out.println("\nServiço: " + servicoEscolhido.nome);
                System.out.println("Valor original: " + servicoEscolhido.valor);
                System.out.println("\nForma de pagamento: Cartão digital");
                System.out.println("Taxa aplicada: R$" + servicoEscolhido.valor *0.015);
                System.out.println("\nValor final: R$" + pagamento.valorFinal(servicoEscolhido.valor));
                System.out.println("Pedido realizado com sucesso!");
                System.out.println("=======================\n");
            } else if (escPag == 6){
                PagamentoCripto pagamento = new PagamentoCripto();
                System.out.println("\n=======================\nRESUMO DO PEDIDO\n=======================");
                System.out.println("Cliente: " + nome);
                System.out.println("\nServiço: " + servicoEscolhido.nome);
                System.out.println("Valor original: " + servicoEscolhido.valor);
                System.out.println("\nForma de pagamento: Débito");
                System.out.println("Taxa aplicada: R$" + servicoEscolhido.valor *0.01);
                System.out.println("\nValor final: R$" + pagamento.valorFinal(servicoEscolhido.valor));
                System.out.println("Pedido realizado com sucesso!");
                System.out.println("=======================\n");
            } else {
                System.out.println("Tipo de pagamento não encontrado!");
            }
        }
    }
}