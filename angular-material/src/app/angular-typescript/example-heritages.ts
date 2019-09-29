// A classe Employee eh uma superclasse
class Employee {
    name: string;
    salario: number;

    constructor(name: string, salario: number) {
        this.name = name;
        this.salario = salario;
    }
    
    payTax(tax: number = 7.5) {
        console.log(`Pagando ${this.salario * tax / 100} imposto.`);
    }
}

// A classe Developer herda os metodos e atributos da superclasse Employee
class Developer extends Employee {

}

// A classe Executive herda os metodos e atributos da superclasse Employee
class Executive extends Employee {

    // A classe filho pode sobreescrever os metodos da classe pai
    payTax(tax: number = 27.5) {
        console.log(`Executivo paga mais!`);
        // A propriedade super acessos todos os metodos da superclasse
        super.payTax(tax);
    }
}

let developer: Developer = new Developer('Mário', 2300.00);
let executive: Executive = new Executive('Jorge', 30000);

developer.payTax();
executive.payTax();