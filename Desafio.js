const readline = require('readline');

const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

function entradaSalario() {
rl.question('\nInforme o seu salário bruto: ', (inputSalarioBruto) => {
    
    let salarioBruto = parseFloat(inputSalarioBruto.replace(',', '.'));

    if(isNaN(salarioBruto) || salarioBruto <= 0) {
        console.log('\nErro: Salário inválido. Tente novamente.');
        entradaSalario();
    } else {
        entradaBeneficios(salarioBruto);
    }
})
}

function entradaBeneficios(salarioBruto) {
    rl.question('\nInforme o valor total dos seus benefícios: ', (inputBeneficios) => {

        let beneficios = parseFloat(inputBeneficios.replace(',', '.'));

        if(isNaN(beneficios) || beneficios < 0) {
            console.log('\nErro: Valor do benefício inválido.');
            entradaBeneficios(salarioBruto);
        } else {
            let salarioLiquido = calcularSalarioLiquido(salarioBruto, beneficios);
        }
    })
}

function calcularSalarioLiquido(salarioBruto, beneficios) {
    let desconto;

     if (salarioBruto <= 1100){
                desconto = salarioBruto * 0.05;
        } else if (salarioBruto <= 2500){
                desconto = salarioBruto * 0.1;
            } else {
                desconto = salarioBruto * 0.15;
             }

             const salarioLiquido = (salarioBruto - desconto) + beneficios;

            console.log('\nO seu salário líquido é de R$', salarioLiquido.toFixed(2));
            
            continuarPrograma();
            
}

function continuarPrograma(){
    rl.question('\nDeseja calcular outro salário? (s/n): ', (continuar) => {
        const continuarLower = continuar.toLowerCase();

        if(continuarLower === 's') {
            entradaSalario();
        } else if (continuarLower === 'n'){
            console.log('\nPrograma finalizado.');
            rl.close();
        } else {
            console.log('\nErro: Caractere inválido. Tente novamente.');
            continuarPrograma();
    }
})
    }


entradaSalario();

