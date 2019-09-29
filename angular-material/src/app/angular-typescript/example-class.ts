// Classe
class Client {
    // Atributos/Propriedades
    name: string;
    age: number;

    // Construtor - metodo chamdo apenas na construcao do objeto (new Client())
    constructor(name: string, age: number) {
        this.name = name;
        this.age = age;
    }

    // Metodos/Acoes
    introduce() {
        return `Olá meu nome é ${this.name} e tenho ${this.age} anos de idade.`;
    }
}

// Referenciando objeto do tipo Client
let max: Client = new Client('Max', 25);
let introduce: string = max.introduce();

console.log(introduce);