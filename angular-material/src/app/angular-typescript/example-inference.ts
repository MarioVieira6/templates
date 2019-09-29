// Se o tipo nao for declarado o TypeScript, automaticamente ira inferir o tipo de acordo com o valor
let quantity = 20;

// quantity = 'Qualquer valor' -> Nao compila!

let x = [1 ,20, null];
// x[0] = true -> Nao compila!

// Contextual Typing
window.onmousedown = function(event) {
    console.log(event.button); // OK
    // console.log(event.buton) -> Nao compila!
}