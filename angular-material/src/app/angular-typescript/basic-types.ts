// boolean
let paid: boolean = true;

// number
let age: number = 25;
let value: number = 25.00;

// string
let company: string = 'Google';

// Template String - Valores declarados dentro de um texto com `${variavel}` 
let myName: string = 'Mário';
console.log(`Olá! Meu nome é ${myName} e tenho ${age} anos de idade.`);

// arrays
let values: number[] = [8, 9, 5, 1];

// tuple - varios tipos de variaves dentro de um array
let student: [string, number, string] = ['Mário', 10, 'Matemática'];
console.log(student[0]);
console.log(student[1]);
console.log(student[2]);

// enum
enum Color {Green, Yellow, Red, Orange, Black}; 
let backgroundColor: Color = Color.Green;

// any - Qualquer tipo de valor pode ser atribuido na variavel apos sua declaracao
let anyValue: any = 4;
anyValue = 'Qualquer valor.'
anyValue = true;
// Biblioteca de terceiros
// Migracao de TypeScript para JavaScript
// Outro exemplo: Array com varios tipos de dados

// void - Nao retorna nada
function alertT(): void {
    // ...alert('Operacao nao permitida!');
}

// null & undefined -> Nao faz muito sentido!
let u: undefined = undefined;
let n: null = null;
// null & undefined sao subtipos de outros tipos

myName = undefined;
myName = null;

// var, let e const

// var - Variável dinâmica de escopo global (HOISTING)
// let - Variável de escopo, somente acessivel dentro do escopo da declaracao
// const - Constante de escopo, somente acessivel dentro do escopo da declaracao
function startTeam(startGame: boolean) {
    const name: string = 'Messi e amigos';
    let city: string = 'em São Paulo';

    if (startGame) {
        city = 'em Campinas';
    }

    console.log(`${name} vão jogar ${city}`);
}

startTeam(false);