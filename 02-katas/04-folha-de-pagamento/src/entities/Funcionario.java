package entities;

/**
 * Classe base que encapsula os dados comuns de qualquer funcionário.
 * Não implementa Tributavel diretamente — essa responsabilidade
 * fica nas subclasses CLT e PJ, cada uma com sua própria regra.
 */

public abstract class Funcionario {

    private static final double SALARIO_MINIMO  = 1412.0;
    private static final double HORAS_MES       = 180.0;

    private String  nome;
    private double  salarioBase;
    private int     horasExtras;
    private Beneficios beneficios; // composição

    public Funcionario(String nome, double salarioBase) {
        this.nome        = nome;
        this.salarioBase = salarioBase;
    }

    public Funcionario(String nome, double salarioBase, int horasExtras, Beneficios beneficios) {
        this.nome        = nome;
        this.salarioBase = salarioBase;
        this.horasExtras = horasExtras;
        this.beneficios  = beneficios;
    }

    // ── Cálculos base compartilhados ────────────────────────────────────────

    public double getValorHora() {
        return salarioBase / HORAS_MES;
    }

    /**
     * Hora extra vale 50% a mais que a hora normal.
     */
    public double calcularHorasExtras() {
        double valorHora = getValorHora();
        return (valorHora * horasExtras) * 1.5;
    }

    /**
     * Salário bruto = base + horas extras.
     */
    public double calcularSalarioBruto() {
        return salarioBase + calcularHorasExtras();
    }

    /**
     * Remuneração total = salário líquido + benefícios.
     */
    public double calcularRemuneracaoTotal() {
        return calcularSalarioLiquido() + beneficios.totalBeneficios();
    }

    /**
     * Garante que o salário líquido nunca fique abaixo do mínimo.
     */
    protected double aplicarSalarioMinimo(double salario) {
        return Math.max(salario, SALARIO_MINIMO);
    }

    // Método abstrato: cada contrato calcula seu próprio líquido
    public abstract double calcularSalarioLiquido();

    // ── Getters e Setters ────────────────────────────────────────────────────

    public String     getNome()        { return nome; }
    public double     getSalarioBase() { return salarioBase; }
    public int        getHorasExtras() { return horasExtras; }
    public Beneficios getBeneficios()  { return beneficios; }

    public void setNome(String nome)              { this.nome = nome; }
    public void setSalarioBase(double salario)    { this.salarioBase = salario; }
    public void setHorasExtras(int horas)         { this.horasExtras = horas; }
    public void setBeneficios(Beneficios b)       { this.beneficios = b; }

    public static double getSalarioMinimo()       { return SALARIO_MINIMO; }
}
