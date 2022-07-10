import java.util.Random;
import java.util.Scanner;
/**
 *
 * @author Giovani
 */
public class TesteSorteio {
    
    /*
        Para iniciar um teste, instancie um objeto e chame o método start:
            new TesteSorteio().start();
    */

    Scanner sc = new Scanner(System.in);

    public void start() {
        printMenu();
        int opcao = sc.nextInt();

        switch (opcao) {
            case 0:
                menuFacil();
                break;
            case 1:
                menuMedio();
                break;
            case 2:
                menuDificil();
                break;
            default:
                System.out.println("Opcao invalida...");
                break;
        }
        sc.close();
        System.out.println("Teste concluido.");
        System.exit(0);

    }

    private void menuFacil() {
        printBar();
        System.out.println(" Selecionado: Nivel Facil");
        menuPadraoNivel();
        int opcao = sc.nextInt();
        switch (opcao) {
            case 0:
                teste(0.0, 1.0);
                break;
            case 1:
                teste(0.25, 1.0);
                break;
            case 2:
                teste(0.5, 1.0);
                break;
            default:
                System.out.println("Opcao invalida...");
                break;
        }
    }

    private void menuMedio() {
        printBar();
        System.out.println(" Selecionado: Nivel Medio");
        menuPadraoNivel();
        int opcao = sc.nextInt();
        switch (opcao) {
            case 0:
                teste(0.0, 0.8);
                break;
            case 1:
                teste(0.25, 0.8);
                break;
            case 2:
                teste(0.5, 0.8);
                break;
            default:
                System.out.println("Opcao invalida...");
                break;
        }
    }

    private void menuDificil() {
        printBar();
        System.out.println(" Selecionado: Nivel Dificil");
        menuPadraoNivel();
        int opcao = sc.nextInt();
        switch (opcao) {
            case 0:
                teste(0.0, 0.7);
                break;
            case 1:
                teste(0.25, 0.7);
                break;
            case 2:
                teste(0.5, 0.7);
                break;
            default:
                System.out.println("Opcao invalida...");
                break;
        }
    }

    private void menuPadraoNivel() {
        System.out.println(" [0] 50% - desconto do nivel");
        System.out.println(" [1] 75% - desconto do nivel");
        System.out.println(" [2] 100% - desconto do nivel");
        System.out.print(" => ");
    }

    private void printMenu() {
        printBar();
        System.out.println(" Sorteio - Pedir em Namoro");
        System.out.println(" [0] Nivel Facil");
        System.out.println(" [1] Nivel Medio");
        System.out.println(" [2] Nivel Dificil");
        System.out.print(" => ");
    }

    private void printBar() {
        System.out.println("\n=-=-=-=-=-=-=-=-=-=-=-=-=-=\n");
    }

    private double arredondarDuasCasasDecimais(double valor) {
        return Math.round(valor * 100.0) / 100.0;
    }

    private void teste(double min, double max) {
        double contSim = 0.0;
        double contNao = 0.0;

        for (int i = 0; i < 150; i++) {
            if (pedirEmNamoro(min, max)) {
                contSim += 1.0;
            } else {
                contNao += 1.0;
            }
        }
        double total = contNao + contSim;
        double porcentoSim = (contSim / total) * 100.0;
        double porcentoNao = (contNao / total) * 100.0;

        printBar();
        System.out.format("'Sim': %.0f vezes => %.2f%%\n", contSim, porcentoSim);
        System.out.format("'Nao': %.0f vezes => %.2f%%\n", contNao, porcentoNao);
        printBar();
    }

    private boolean pedirEmNamoro(double min, double max) {

        Random rand = new Random();
        double resposta = arredondarDuasCasasDecimais(rand.nextDouble(min, max));
        if (resposta < 0.5) {
            // System.out.println("NÃO: " + resposta);
            return false;
        } else {
            // System.out.println("SIM: " + resposta);
            return true;
        }

    }
}


