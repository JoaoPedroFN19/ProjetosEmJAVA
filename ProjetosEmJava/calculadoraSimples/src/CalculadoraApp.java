import java.util.Scanner;

public class CalculadoraApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Calculadora Simples");

        boolean continuar = true;
        while (continuar) {
            exibirOperacoesDisponiveis();

            int operacao = scanner.nextInt();
            Calculadora calculadora = new Calculadora();

            switch (operacao) {
                case 1:
                    calculadora.realizarAdicao(scanner);
                    break;
                case 2:
                    calculadora.realizarSubtracao(scanner);
                    break;
                case 3:
                    calculadora.realizarMultiplicacao(scanner);
                    break;
                case 4:
                    calculadora.realizarDivisao(scanner);
                    break;
                case 5:
                    calculadora.realizarRaizQuadrada(scanner);
                    break;
                case 6:
                    calculadora.realizarPotenciacao(scanner);
                    break;
                default:
                    System.out.println("Operação inválida.");
            }

            System.out.print("Deseja fazer outra conta? (S/N): ");
            String resposta = scanner.next();
            continuar = resposta.equalsIgnoreCase("S");
        }

        scanner.close();
    }

    public static void exibirOperacoesDisponiveis() {
        System.out.println("Operações disponíveis:");
        System.out.println("1. Adição");
        System.out.println("2. Subtração");
        System.out.println("3. Multiplicação");
        System.out.println("4. Divisão");
        System.out.println("5. Raiz Quadrada");
        System.out.println("6. Potenciação");
        System.out.print("Escolha uma operação (1-6): ");
    }
}

class Calculadora {
    public void realizarAdicao(Scanner scanner) {
        System.out.print("Digite o primeiro número: ");
        double num1 = scanner.nextDouble();
        System.out.print("Digite o segundo número: ");
        double num2 = scanner.nextDouble();
        double resultado = num1 + num2;
        exibirResultado(resultado);
    }

    public void realizarSubtracao(Scanner scanner) {
        System.out.print("Digite o primeiro número: ");
        double num1 = scanner.nextDouble();
        System.out.print("Digite o segundo número: ");
        double num2 = scanner.nextDouble();
        double resultado = num1 - num2;
        exibirResultado(resultado);
    }

    public void realizarMultiplicacao(Scanner scanner) {
        System.out.print("Digite o primeiro número: ");
        double num1 = scanner.nextDouble();
        System.out.print("Digite o segundo número: ");
        double num2 = scanner.nextDouble();
        double resultado = num1 * num2;
        exibirResultado(resultado);
    }

    public void realizarDivisao(Scanner scanner) {
        System.out.print("Digite o dividendo: ");
        double dividendo = scanner.nextDouble();
        System.out.print("Digite o divisor: ");
        double divisor = scanner.nextDouble();

        if (divisor != 0) {
            double resultado = dividendo / divisor;
            exibirResultado(resultado);
        } else {
            System.out.println("Divisão por zero não é permitida.");
        }
    }


    public void realizarRaizQuadrada(Scanner scanner) {
        System.out.print("Digite o número: ");
        double num = scanner.nextDouble();

        if (num >= 0) {
            double resultado = Math.sqrt(num);
            exibirResultado(resultado);
        } else {
            System.out.println("Não é possível calcular a raiz de um número negativo.");
        }
    }

    public void realizarPotenciacao(Scanner scanner) {
        System.out.print("Digite a base: ");
        double base = scanner.nextDouble();
        System.out.print("Digite o expoente: ");
        double expoente = scanner.nextDouble();
        double resultado = Math.pow(base, expoente);
        exibirResultado(resultado);
    }

    private void exibirResultado(double resultado) {
        System.out.println("Resultado: " + resultado);
    }
}
