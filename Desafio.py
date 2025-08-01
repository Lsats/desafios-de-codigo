from decimal import Decimal, InvalidOperation

def ler_entrada(prompt, zero=False):
    while True:
        try:
            entrada = input(prompt)

            entrada_formatada = entrada.replace(',', '.')

            decimal = Decimal(entrada_formatada)

            if not zero and decimal <= 0:
                print("\nErro: O valor deve ser maior que zero. Tente novamente.")
            elif zero and decimal < 0:
                print("\nErro: O valor não pode ser negativo. Tente novamente.") 
            else:
                return decimal
            
        except InvalidOperation:
            print("\nErro: Valor inválido. Insira um número decimal.")
        except Exception as ex:
            print(f"Erro: {ex}")

def calcularSalarioLiquido(salarioBruto,beneficios):
    desconto = Decimal(0)

    if salarioBruto <= 1100:
        desconto = salarioBruto * Decimal('0.05')

    elif salarioBruto <= 2500:
        desconto = salarioBruto * Decimal('0.1')

    else: 
        desconto = salarioBruto * Decimal('0.15')

    return (salarioBruto - desconto) + beneficios            


while True:
        salarioBruto = ler_entrada("\nInforme o seu salário bruto: ")
        beneficios = ler_entrada("\nInforme o valor total dos seus benefícios: ", zero=True)

        salarioLiquido = calcularSalarioLiquido(salarioBruto,beneficios)

        print(f"\nO valor do seu salário líquido é de R${salarioLiquido}")

        while True:

            continuar = input("\nDeseja calcular outro salário? (s/n): ")
            continuar_lower = continuar.lower()

            if continuar_lower == 's':
                break
            
            elif continuar_lower ==  'n':
                print("\nPrograma finalizado.")
                exit()
            else:
                print("\nCaractere inválido. Tente novamente.")



