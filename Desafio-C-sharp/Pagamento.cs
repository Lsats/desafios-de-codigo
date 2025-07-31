using System;

namespace desafios_de_codigo
{
    public class Pagamento
    {
        private decimal salarioBruto;
        private decimal beneficios;

        public Pagamento(decimal salarioBruto, decimal beneficios)
        {
            this.salarioBruto = salarioBruto;
            this.beneficios = beneficios;
        }

        public decimal CalcularSalario()
        {
            decimal desconto;

            if (salarioBruto <= 1100m)
            {
                desconto = salarioBruto * 0.05m;
            }
            else if (salarioBruto <= 2500m)
            {
                desconto = salarioBruto * 0.1m;
            }
            else
            {
                desconto = salarioBruto * 0.15m;
            }
            return (salarioBruto - desconto) + beneficios;
        }
    }
}
