// Uma interface eh um contrato que obriga o objeto a implementar suas funcionalidades
interface Manager {
    name: string;
    sexo?: string; // ? define a variavel com sendo opcional
}

// Em funcoes, a interface define um contrato do que o objeto tem que receber por parametro
function printNumber(person: {age: number}) {
    console.log(person.age);
}

function printName(manager: Manager) {
    console.log(manager.name);
}

let jorge = {age: 25};
let mario = {name: 'Mário'}

printNumber(jorge);
printName(mario);