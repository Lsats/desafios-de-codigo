
/*  Faça um programa que calcule e imprima o salário a ser transferido para um funcionário, cálculo: (salário bruto - desconto) + beneficios

Aliquotas: 
0 a 1100 = 5% (preferi desconsiderar o valor 0 no campo salário)
1100.01 a 2500 = 10%
acima de 2500 = 15%

Entradas: valor do salário bruto + benefícios
*/

import java.util.InputMismatchException;
import java.util.Scanner;



public class Desafio {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double salarioBruto = 0, beneficios = 0;
        char continuar;

        // O valor do salário e do benefício se informado em decimal deve utlizar , ou . dependendo da configuração regional do sistema
        do{
           boolean entradaValida = false;

           while(!entradaValida){
            System.out.println("\nInforme o seu salário bruto: ");
            try {
                salarioBruto = scanner.nextDouble();
                    if(salarioBruto > 0) {
                        entradaValida = true;
                    } else { 
                         System.out.println("\nErro: O valor do seu salário não pode ser menor ou igual à zero. Tente novamente: ");
                    } 
            } catch (InputMismatchException e) {
                System.out.println("\nErro: O valor do salário deve ser um número. Tente novamente.");
                scanner.next();
            }
                
            }
            

            entradaValida = false;
            while(!entradaValida){
            System.out.println("\nInforme o valor total dos seus benefícios: ");
            try {
                beneficios = scanner.nextDouble();
                    if (beneficios >= 0) {
                        entradaValida = true;
                    }else {
                         System.out.println("\nErro: O valor do benefício não pode ser negativo. Tente novamente: ");
                    }
                } catch (InputMismatchException e){
                    System.out.println("\nErro: O valor do benefício deve ser um número. Tente novamente.");
                    scanner.next();
                }
            }

       
            double salarioLiquido = calcularSalarioLiquido(salarioBruto, beneficios);
            System.out.println(String.format("\nO valor do seu salário líquido é de R$%.2f", salarioLiquido));

            System.out.println("\nDeseja calcular outro salário? (s/n)");
            continuar = scanner.next().toLowerCase().charAt(0);

            while(continuar != 's' && continuar != 'n'){
                System.out.println("\nCaractere inválido. Tente novamente: ");
                continuar = scanner.next().toLowerCase().charAt(0);
            }

        }while(continuar == 's');

        scanner.close();
        System.out.println("\nPrograma finalizado.");
    }

    public static double calcularSalarioLiquido(double salarioBruto, double beneficios){
        double desconto;

        if(salarioBruto <= 1100){
            desconto = salarioBruto * 0.05;
        } else if (salarioBruto <= 2500) {
            desconto = salarioBruto * 0.1;
        } else {
            desconto = salarioBruto * 0.15;
        }
        return (salarioBruto - desconto) + beneficios;
    }

}