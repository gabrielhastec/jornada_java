import repository.ProdutoRepository;
import service.ProdutoService;
import ui.ProdutoConsoleUI;

public class Main {

    public static void main(String[] args) {

        ProdutoRepository repository = new ProdutoRepository();
        ProdutoService service = new ProdutoService(repository);
        ProdutoConsoleUI ui = new ProdutoConsoleUI(service);

        ui.iniciar();
    }
}
