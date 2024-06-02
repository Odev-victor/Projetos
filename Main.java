abstract class PersonagemDragonBall {
    protected String nome;
    protected int idade;
    protected String sexo;
    protected String temporada;
    protected int chi;
    protected String poderEspecial;

    public PersonagemDragonBall(String nome, int idade, String sexo, String temporada, int chi, String poderEspecial) {
        this.nome = nome;
        this.idade = idade;
        this.sexo = sexo;
        this.temporada = temporada;
        this.chi = chi;
        this.poderEspecial = poderEspecial;
    }

    public abstract int calcularPoder();

    @Override
    public String toString() {
        return "Nome: " + nome + ", Idade: " + idade + ", Sexo: " + sexo + ", Temporada: " + temporada +
                ", Chi: " + chi + ", Poder Especial: " + poderEspecial;
    }
}

interface Transformavel {
    String transformar(int nivel);
}

class Terraqueo extends PersonagemDragonBall {
    private String pais;
    private String cidade;

    public Terraqueo(String nome, int idade, String sexo, String temporada, int chi, String poderEspecial, String pais,
            String cidade) {
        super(nome, idade, sexo, temporada, chi, poderEspecial);
        this.pais = pais;
        this.cidade = cidade;
    }

    @Override
    public int calcularPoder() {
        return chi;
    }

    @Override
    public String toString() {
        return super.toString() + ", País: " + pais + ", Cidade: " + cidade;
    }
}

class Sayajin extends PersonagemDragonBall implements Transformavel {
    private int nivelMaximoSSJ;
    private boolean temRabo;

    public Sayajin(String nome, int idade, String sexo, String temporada, int chi, String poderEspecial,
            int nivelMaximoSSJ, boolean temRabo) {
        super(nome, idade, sexo, temporada, chi, poderEspecial);
        this.nivelMaximoSSJ = nivelMaximoSSJ;
        this.temRabo = temRabo;
    }

    @Override
    public int calcularPoder() {
        return (int) (chi * (1 + nivelMaximoSSJ * 0.1));
    }

    @Override
    public String transformar(int nivel) {
        if (nivel >= 1 && nivel <= 3) {
            return nome + " transformou para super sayajin nível " + nivel;
        } else if ((nome.equals("Goku") || nome.equals("Vegeta")) && (nivel == 4 || nivel == 5)) {
            return nome + " transformou para super sayajin nível " + nivel;
        } else {
            return "Não foi possível transformar esse sayajin";
        }
    }

    @Override
    public String toString() {
        return super.toString() + ", Nível Máximo SSJ: " + nivelMaximoSSJ + ", Tem Rabo: " + temRabo;
    }
}

class Namekuseijin extends PersonagemDragonBall {
    private int quantidadeEsferas;
    private boolean podeCurar;

    public Namekuseijin(String nome, int idade, String sexo, String temporada, int chi, String poderEspecial,
            int quantidadeEsferas, boolean podeCurar) {
        super(nome, idade, sexo, temporada, chi, poderEspecial);
        this.quantidadeEsferas = quantidadeEsferas;
        this.podeCurar = podeCurar;
    }

    @Override
    public int calcularPoder() {
        return (int) (chi * (1 + (podeCurar ? 0.2 : 0)));
    }

    public String fazerDesejo(String desejo) {
        String desejoNamekusei = desejo.replace("esferas", "guru").replace("dragão", "porunga");
        return "Desejo em Namekusei: " + desejoNamekusei;
    }

    @Override
    public String toString() {
        return super.toString() + ", Quantidade de Esferas: " + quantidadeEsferas + ", Pode Curar: " + podeCurar;
    }
}

class PersonagemFactory {
    public static Terraqueo criarKuririn() {
        return new Terraqueo("Kuririn", 35, "Masculino", "Dragon Ball Z", 3000, "Kienzan", "Terra", "Cidade do Oeste");
    }

    public static Sayajin criarGoku() {
        return new Sayajin("Goku", 40, "Masculino", "Dragon Ball Super", 50000, "Kamehameha", 5, true);
    }

    public static Sayajin criarGohan() {
        return new Sayajin("Gohan", 20, "Masculino", "Dragon Ball Z", 45000, "Masenko", 3, true);
    }

    public static Namekuseijin criarDende() {
        return new Namekuseijin("Dendê", 200, "Masculino", "Dragon Ball Z", 15000, "Cura", 7, true);
    }
}

public class Main {
    public static void main(String[] args) {
        Sayajin goku = PersonagemFactory.criarGoku();
        Sayajin gohan = PersonagemFactory.criarGohan();
        Namekuseijin dende = PersonagemFactory.criarDende();

        System.out.println(goku.transformar(5));

        String resultadoTransformacaoGohan = gohan.transformar(5);
        if (resultadoTransformacaoGohan.contains("Não foi possível")) {
            resultadoTransformacaoGohan = gohan.transformar(3);
        }
        System.out.println(resultadoTransformacaoGohan);

        System.out.println(dende.fazerDesejo("Desejo pedir as esferas do dragão"));
    }
}
