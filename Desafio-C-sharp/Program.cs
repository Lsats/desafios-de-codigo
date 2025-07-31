using desafios_de_codigo;

decimal salarioBruto, beneficios;
char continuar;

do
{
    Console.WriteLine("\nInforme o seu salário bruto: ");
    string? inputSalarioBruto = Console.ReadLine();

    while (!decimal.TryParse(inputSalarioBruto, out salarioBruto) || salarioBruto <= 0)
    {
        Console.WriteLine("\nErro: Salário inválido. Tente novamente.");
        inputSalarioBruto = Console.ReadLine();
    }

    Console.WriteLine("\nInforme o valor total dos seus benefícios: ");
    string? inputBeneficios = Console.ReadLine();

    while (!decimal.TryParse(inputBeneficios, out beneficios) || beneficios < 0)
    {
        Console.WriteLine("\nErro: O valor do benefício não pode estar em branco ou negativo. Tente novamente.");
        inputBeneficios = Console.ReadLine();
    }

    Pagamento pg = new Pagamento(salarioBruto, beneficios);

    decimal salarioLiquido = pg.CalcularSalario();

    salarioLiquido = Math.Round(salarioLiquido, 2);

    Console.WriteLine($"\n O valor do seu salário líquido é de R${salarioLiquido}");

    Console.WriteLine("\nDeseja calcular outro salário? (s/n)");
    continuar = char.ToLower(Console.ReadKey().KeyChar);

    while (continuar != 's' && continuar != 'n')
    {
        Console.WriteLine("\nCaractere inválido. Tente novamente.");
        continuar = char.ToLower(Console.ReadKey().KeyChar);
    }

} while (continuar == 's');

Console.WriteLine("\nPrograma finalizado.");