package service;

import entities.ResultadoAnalise;

import java.util.List;

/**
 * Responsável por toda a saída de dados da análise.
 * Separar a apresentação da lógica de negócio facilita
 * trocar o formato (ex: JSON, PDF) sem tocar no AnalisadorCredito.
 */

public class RelatorioService {

    /** Imprime o holerite completo de uma única análise. */
    public void exibirResultado(ResultadoAnalise resultado) {
        var cliente = resultado.getCliente();

        System.out.println("\n╔══════════════════════════════════════╗");
        System.out.println("║       ANÁLISE DE CRÉDITO             ║");
        System.out.println("╠══════════════════════════════════════╣");
        System.out.printf( "║  Cliente  : %-25s║%n", cliente.getNome());
        System.out.printf( "║  Idade    : %-25s║%n", cliente.getIdade() + " anos");
        System.out.printf( "║  Ocupação : %-25s║%n", cliente.getOcupacao().getDescricao());
        System.out.printf( "║  Renda    : %-25s║%n", String.format("R$ %.2f", cliente.getRenda()));
        System.out.println("╠══════════════════════════════════════╣");
        System.out.println("║  CRITÉRIOS AVALIADOS                 ║");

        for (String detalhe : resultado.getDetalhesCriterios()) {
            // quebra linhas longas para não estourar a borda
            System.out.printf("║  • %-34s║%n", detalhe);
        }

        System.out.println("╠══════════════════════════════════════╣");
        System.out.printf( "║  Score Final : %-23s║%n", resultado.getScore() + " / 1000");
        System.out.printf( "║  Risco       : %-23s║%n",
                resultado.getRisco().getIcone() + " " + resultado.getRisco().getRotulo());
        System.out.println("╠══════════════════════════════════════╣");

        if (resultado.isAprovado()) {
            System.out.println("║  STATUS : ✅ CRÉDITO APROVADO         ║");
            System.out.printf( "║  Limite : %-28s║%n",
                    String.format("R$ %.2f", resultado.getLimiteCredito()));
        } else {
            System.out.println("║  STATUS : ❌ CRÉDITO REPROVADO        ║");
            exibirMotivosReprovacao(resultado);
        }

        System.out.println("╚══════════════════════════════════════╝");
    }

    /** Exibe o resumo consolidado de todas as análises da sessão. */
    public void exibirResumoSessao(List<ResultadoAnalise> historico) {
        if (historico.isEmpty()) return;

        long aprovados  = historico.stream().filter(ResultadoAnalise::isAprovado).count();
        long reprovados = historico.size() - aprovados;

        System.out.println("\n╔══════════════════════════════════════╗");
        System.out.println("║       RESUMO DA SESSÃO               ║");
        System.out.println("╠══════════════════════════════════════╣");
        System.out.printf( "║  Total analisados : %-18d║%n", historico.size());
        System.out.printf( "║  ✅ Aprovados     : %-18d║%n", aprovados);
        System.out.printf( "║  ❌ Reprovados    : %-18d║%n", reprovados);
        System.out.println("╠══════════════════════════════════════╣");

        for (ResultadoAnalise r : historico) {
            System.out.printf("║  %-12s  Score: %4d  %s%-9s║%n",
                    r.getCliente().getNome().length() > 12
                            ? r.getCliente().getNome().substring(0, 12)
                            : r.getCliente().getNome(),
                    r.getScore(),
                    r.getRisco().getIcone(),
                    r.isAprovado() ? "Aprovado" : "Reprovado");
        }

        System.out.println("╚══════════════════════════════════════╝");
    }

    private void exibirMotivosReprovacao(ResultadoAnalise resultado) {
        var cliente = resultado.getCliente();
        System.out.println("║  Motivos:                            ║");
        if (cliente.getIdade() < 18)
            System.out.println("║   • Idade inferior a 18 anos         ║");
        if (cliente.getRenda() < 1500)
            System.out.println("║   • Renda abaixo de R$ 1.500         ║");
        if (resultado.getScore() < 600)
            System.out.printf( "║   • Score insuficiente (%d/600)    ║%n", resultado.getScore());
    }
}
