# AngularMaterial

This project was generated with [Angular CLI](https://github.com/angular/angular-cli) version 8.3.6.

Framework JavaScript para construir aplicações Front-End. O Framework consite em bibliotecas.
	
* `Código de Template`
* `Código de Componentes`
* `Código de Serviços`
	
## Single Page Application - SPA

Uma aplicação de uma única página -> Um único arquivo HTML. O Angular se encarrega de renderizar as demais páginas.
	
## Angular CLI 

Ferramenta que ajuda a fazer tarefas repetitivas como criar um projeto, componente ou diretiva em linha de comando.

* `npm cache clean`
* `npm install -g @angular/cli`
* `ng -v`
* `ng new [nome-projeto]` - Cria um projeto novo
* `ng serve` - Inicia um servidor de acesso para teste local
* `ng generate component [componente]` ou `ng g c [componente]` - Cria um componente via angular cli
* `ng g c [componente] --spec=false` - Cria um componente sem arquivo de teste unitário
		
## Data Binding
	
* `{{}} Interpolação` - Pega valores das variáveis do componente e exibe no template de forma dinâmica
* `[prop]="nome"` Propertie binding - Pega valores das variáveis do componente e exibe no template de forma dinâmica
* `(click)="evento()"` Event binding - Ouvir algum evento do template e fazendo a chamada do evento no componente
* `[(ngModel)]="prop"` Two-way data binding - Mantém o componente e o template atualizados
	
## Diretivas - São instrução que passamos no template
	
* `Componentes` - É um tipo de diretiva com template (Um código HTML que será a saída do componente)
* `Diretiva Estrutural` - Modifica a estrutura do DOM (Modelo do documento), removendo ou adicionando elementos
* `Diretiva de Atributo` - Modifica o comportamento ou a aparência dos elementos

## Plugins VS Code
	
* `TSLint` - Checkup de código
* `editorconfig` - Mantém um padrão de codificação na IDE
* `HTML Snippets` - Facilidade na codificação das páginas HTML
* `Auto Import` - Import automático das dependências necessárias

## Biblioteca de componentes

* [Angular Material](https://material.angular.io)
* [Angular2 Materialize](http://angular2-materialize.surge.sh)
* [NG Bootstrap](https://ng-bootstrap.github.io)
* [PrimeNG](https://www.primefaces.org/primeng)

Ex: `npm install bootstrap --save` - Instala a biblioteca de componentes do bootstrap
	Adicionar bootstrap.css no arquivo .angular-cli.json no parâmetro styles => "../node_modules/bootstrap/dist/css/bootstrap.css"

## Development server

Run `ng serve` for a dev server. Navigate to `http://localhost:4200/`. The app will automatically reload if you change any of the source files.

## Code scaffolding

Run `ng generate component component-name` to generate a new component. You can also use `ng generate directive|pipe|service|class|guard|interface|enum|module`.

## Build

Run `ng build` to build the project. The build artifacts will be stored in the `dist/` directory. Use the `--prod` flag for a production build.

## Running unit tests

Run `ng test` to execute the unit tests via [Karma](https://karma-runner.github.io).

## Running end-to-end tests

Run `ng e2e` to execute the end-to-end tests via [Protractor](http://www.protractortest.org/).

## Further help

To get more help on the Angular CLI use `ng help` or go check out the [Angular CLI README](https://github.com/angular/angular-cli/blob/master/README.md).
