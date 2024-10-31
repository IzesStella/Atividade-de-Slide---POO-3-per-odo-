package respostasDosSlides.miacolucci;

import java.util.Scanner;

public class Atividade {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        int escolha;
        String usuario;

        System.out.print("Informe seu nome: ");
        usuario = entrada.next();

        System.out.println("Olá, " + usuario + ", seja bem-vinde ao programa de utilidades.");

        // Mostra o menu e pede a escolha do usuário
        System.out.println("Escolha uma opção no menu que você queira fazer:");
        System.out.println("1 - Calcular o Índice de Massa Corporal (IMC)");
        System.out.println("2 - Calcular Taxa de Metabolismo Basal");
        System.out.println("3 - Verificar se um número é par ou ímpar");
        System.out.println("0 - Encerrar");

        escolha = entrada.nextInt();

        switch (escolha) {
            case 1:
                calcularIndiceMassaCorporal();
                break;
            case 2:
                calcularTaxaMetabolismo();
                break;
            case 3:
                verificarNumeroParOuImpar();
                break;
            case 0:
                System.out.println("Encerrando o programa. Até mais, " + usuario + "!");
                break;
            default:
                System.err.println("Opção inválida! Escolha uma opção existente no menu.");
                break;
        }

        entrada.close();
    }

    public static void calcularIndiceMassaCorporal() {
        Scanner sc = new Scanner(System.in);

        double pesoUsuario, alturaUsuario, resultadoIMC;

        System.out.println("Vamos calcular seu Índice de Massa Corporal (IMC).");
        System.out.print("Informe seu peso em quilogramas: ");
        pesoUsuario = sc.nextDouble();
        System.out.print("Informe sua altura em metros: ");
        alturaUsuario = sc.nextDouble();

        resultadoIMC = pesoUsuario / (Math.pow(alturaUsuario, 2));

        System.out.printf("Seu IMC é: %.2f - ", resultadoIMC);
        if (resultadoIMC < 19) {
            System.out.println("Abaixo do peso ideal");
        } else if (resultadoIMC < 25) {
            System.out.println("Peso dentro da faixa normal");
        } else if (resultadoIMC < 30) {
            System.out.println("Sobrepeso");
        } else if (resultadoIMC < 40) {
            System.out.println("Obesidade classe I");
        } else {
            System.out.println("Obesidade classe II (mórbida)");
        }
    }

    private static void calcularTaxaMetabolismo() {
        Scanner entrada = new Scanner(System.in);

        String genero;
        int idadeUsuario;
        double pesoCorporal, taxaBasal;

        System.out.println("Vamos calcular sua Taxa de Metabolismo Basal.");
        System.out.print("Informe seu peso em quilogramas: ");
        pesoCorporal = entrada.nextDouble();
        System.out.print("Informe sua idade: ");
        idadeUsuario = entrada.nextInt();
        System.out.print("Informe seu gênero ('M' para masculino ou 'F' para feminino): ");
        genero = entrada.next();

        if (genero.equals("M")) {
            if (idadeUsuario >= 18 && idadeUsuario < 30) {
                taxaBasal = (15.057 * pesoCorporal) + 679;
            } else if (idadeUsuario >= 30 && idadeUsuario < 60) {
                taxaBasal = (11.6 * pesoCorporal) + 879;
            } else {
                taxaBasal = (13.5 * pesoCorporal) + 487;
            }
        } else if (genero.equals("F")) {
            if (idadeUsuario >= 18 && idadeUsuario < 30) {
                taxaBasal = (14.7 * pesoCorporal) + 486.6;
            } else if (idadeUsuario >= 30 && idadeUsuario < 60) {
                taxaBasal = (8.7 * pesoCorporal) + 829;
            } else {
                taxaBasal = (10.5 * pesoCorporal) + 597;
            }
        } else {
            System.err.println("Gênero informado é inválido!");
            return;
        }

        System.out.println("Sua Taxa de Metabolismo Basal é de " + taxaBasal + " kcal/dia.");
    }

    public static void verificarNumeroParOuImpar() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite o número que você quer verificar: ");
        int numero = sc.nextInt();

        if (numero % 2 == 0) {
            System.out.println("O número " + numero + " é Par.");
        } else {
            System.out.println("O número " + numero + " é Ímpar.");
        }
    }
}
