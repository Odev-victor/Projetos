import java.util.ArrayList;
import java.util.Scanner;

class Empregado {
    private String nome;
    private int idade;
    private double salario;

    public Empregado(String nome, int idade, double salario) {
        this.nome = nome;
        this.idade = idade;
        this.salario = salario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public void promover() {
        if (idade > 18) {
            aumentarSalario(25);
        } else {
            System.out.println("Promoção não permitida para menores de 18 anos.");
        }
    }

    public void aumentarSalario(double percentual) {
        salario += salario * (percentual / 100);
    }

    public void demitir(int motivo) {
        switch (motivo) {
            case 1:
                System.out.println("Empregado demitido por justa causa. Deve cumprir aviso prévio.");
                break;
            case 2:
                double multa = salario * 0.40;
                System.out.printf("Empregado demitido por decisão do empregador. Multa de 40%% do salário: R$ %.2f%n",
                        multa);
                break;
            case 3:
                double salarioAposentadoria;
                if (salario >= 1000 && salario < 2000) {
                    salarioAposentadoria = 1500;
                } else if (salario >= 2000 && salario < 3000) {
                    salarioAposentadoria = 2500;
                } else if (salario >= 3000 && salario < 4000) {
                    salarioAposentadoria = 3500;
                } else {
                    salarioAposentadoria = 4000;
                }
                System.out.printf("Empregado aposentado. Salário de aposentadoria: R$ %.2f%n", salarioAposentadoria);
                break;
            default:
                System.out.println("Motivo inválido.");
        }
    }

    public void fazerAniversario() {
        idade += 1;
    }

    @Override
    public String toString() {
        return "Empregado{" +
                "nome='" + nome + '\'' +
                ", idade=" + idade +
                ", salario=" + salario +
                '}';
    }
}

public class Principal {
    private static final Scanner scanner = new Scanner(System.in);
    private static final ArrayList<Empregado> empregados = new ArrayList<>();

    public static void main(String[] args) {
        int opcao;
        do {
            System.out.println("Menu:");
            System.out.println("1. novo empregado");
            System.out.println("2. Promover empregado");
            System.out.println("3. Aumentar salário do empregado");
            System.out.println("4. Demitir empregado");
            System.out.println("5. Fazer aniversário do empregado");
            System.out.println("6. Mostrar detalhes dos empregados");
            System.out.println("7. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    criarNovoEmpregado();
                    break;
                case 2:
                    promoverEmpregado();
                    break;
                case 3:
                    aumentarSalarioEmpregado();
                    break;
                case 4:
                    demitirEmpregado();
                    break;
                case 5:
                    fazerAniversarioEmpregado();
                    break;
                case 6:
                    mostrarDetalhesEmpregados();
                    break;
                case 7:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 7);
    }

    private static void criarNovoEmpregado() {
        System.out.print("Nome: ");
        String nome = scanner.next();
        System.out.print("Idade: ");
        int idade = scanner.nextInt();
        System.out.print("Salário: ");
        double salario = scanner.nextDouble();
        empregados.add(new Empregado(nome, idade, salario));
    }

    private static void promoverEmpregado() {
        Empregado empregado = selecionarEmpregado();
        if (empregado != null) {
            empregado.promover();
        }
    }

    private static void aumentarSalarioEmpregado() {
        Empregado empregado = selecionarEmpregado();
        if (empregado != null) {
            System.out.print("Percentual de aumento: ");
            double percentual = scanner.nextDouble();
            empregado.aumentarSalario(percentual);
        }
    }

    private static void demitirEmpregado() {
        Empregado empregado = selecionarEmpregado();
        if (empregado != null) {
            System.out.print("Motivo (1: Justa causa, 2: Decisão do empregador, 3: Aposentadoria): ");
            int motivo = scanner.nextInt();
            empregado.demitir(motivo);
        }
    }

    private static void fazerAniversarioEmpregado() {
        Empregado empregado = selecionarEmpregado();
        if (empregado != null) {
            empregado.fazerAniversario();
        }
    }

    private static void mostrarDetalhesEmpregados() {
        for (Empregado empregado : empregados) {
            System.out.println(empregado);
        }
    }

    private static Empregado selecionarEmpregado() {
        if (empregados.isEmpty()) {
            System.out.println("Não há empregados cadastrados.");
            return null;
        }

        System.out.println("Empregados:");
        for (int i = 0; i < empregados.size(); i++) {
            System.out.printf("%d. %s%n", i + 1, empregados.get(i).getNome());
        }

        System.out.print("Escolha o número do empregado: ");
        int indice = scanner.nextInt() - 1;

        if (indice < 0 || indice >= empregados.size()) {
            System.out.println("Número inválido.");
            return null;
        }

        return empregados.get(indice);
    }
}
