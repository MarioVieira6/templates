const prices: string[] = ['10', '23', '15'];

// Percorrendo lista e imprimindo os dados
const pricesInReal = prices.map((price) => `R$${price},00`);

// Percorrendo lista e imprimindo os dados usando arrow-functions
const pricesInRealArrow = prices.map((price) => `R$${price},00`);

// Percorrendo lista e imprimindo os dados usando simple arrow-functions
const pricesInRealArrowSimple = prices.map(price => `R$${price},00`);

console.log(pricesInReal);
console.log(pricesInRealArrow);
console.log(pricesInRealArrowSimple);

const pricesWithFunctions = prices
        .filter(price => price > '20')
        .map(price => `R$${price},00`);

console.log(pricesWithFunctions);