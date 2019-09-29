/*
TypeScript -> Linguagem de programação que foi criada pela Microsoft. É um Superset (engloba tudo que existe no JavaScript e mais...) do JavaScript.
			Sua tipagem é estática, que assume apenas um tipo.
			Adiciona conceitos de orientação e objetos (Classes, métodos, etc..).	
	
Transpilação -> Compilação com transformação. Todo código TypeScript é transformado em JavaScript para os Browsers interpretarem.
                tsc arquivo.ts - Transforma typescript em javascript
                node arquivo.js - Executa javascript compilado

Ambiente -> Instalar Node.js (Ambiente baseado em JavaScript para executar, testar e validar código JavaScript) -> node -v (Versão)
			Instalar npm (Gerenciador de pacotes) - https://nodejs.org/en/. -> npm -v (Versão)
			Instalar Visual Studio Code (Ferramenta de desenvolvimento Front-End) - https://code.visualstudio.com/
                Comandos:	Ctrl + Shift + ` - Terminal
                            Ctrl + Shift + P - Tasks
                            Ctrl + Shift + B - Run Build Tasks
				Plugins: 	vscode icons
							Angular v4 TypeScript
            Instalar TypeScript (npm install -g typescript) -> tsc -v (Versão)
*/
function sayHello(name: string) {
    console.log(`Olá ${name}`);
}

sayHello("TypeScript!");