# templates
Some templates to develop your project! <br />
In order to make individual download of the projects, access [DownGit](https://minhaskamal.github.io/DownGit/#/home) and paste the link of the specific template what you chose.

+ [angular](README.md#angular-template)
  + [angular-mdb](https://github.com/MarioVieira6/templates/tree/master/angular-mdb)
  + [angular-primeng](https://github.com/MarioVieira6/templates/tree/master/angular-primeng)
  + [angular-material](https://github.com/MarioVieira6/templates/tree/master/angular-material)
+ [eclipse-quality](README.md#eclipse-quality)
  + [checkstyle](README.md#Checkstyle)
+ [JavaFX](README.md#JavaFX)
  + [UI](https://github.com/MarioVieira6/templates/tree/master/JavaFXUI)
  + [SceneBuilder](https://github.com/MarioVieira6/templates/tree/master/JavaFXSceneBuilder)
* [jParent](README.md#jParent)
* [RESTful-spring](README.md#RESTful-spring)
* [RESTful-jersey](README.md#RESTful-jersey)
* [spring-boot-maven](README.md#spring-boot-maven)
* [spring-boot-gradle](README.md#spring-boot-gradle)
* [template-java](README.md#template-java)
* [template-html](README.md#template-html)
* [template-css](README.md#template-css)
* [template-gitignore](README.md#template-gitignore)

## RESTful-jersey

To create a new Jersey project with maven execute in your terminal the follows commands:
  
mvn archetype:generate -DarchetypeArtifactId=jersey-quickstart-grizzly2 \
-DarchetypeGroupId=org.glassfish.jersey.archetypes -DinteractiveMode=false \
-DgroupId=com.java.jersey -DartifactId=RESTful-jersey -Dpackage=com.java.jersey \
-DarchetypeVersion=2.27
  
Note: Change the groupId and artifactId as you want. For more details check [Jersey](https://jersey.github.io/documentation/latest/getting-started.html)

## angular-template

* MDB
* PrimeNG

These projects was generated with [Angular CLI](https://github.com/angular/angular-cli) version 6.0.0-rc.5.
Run `ng update @angular/cli` and then `ng update @angular/core` for new version.

**Development server**
>
> Run `ng serve mdb-angular-free/primeng-quickstart-cli` for a dev server. Navigate to `http://localhost:4200/`. The app will automatically reload if you change any of the source files.
>
> Note: Change name of your project as you want in `package.json` and run your project with `ng serve [projectname]`

**Demo application**
>
> Run `ng serve mdb-demo` for a demo application build with MDB Angular Pro components.

**Code scaffolding**
>
> Run `ng generate component component-name` to generate a new component. You can also use `ng generate directive|pipe|service|class|guard|interface|enum|module`.

**Build**
>
> Run `ng build` to build the project. The build artifacts will be stored in the `dist/` directory. Use the `--prod` flag for a production build.

**Running unit tests**
>
> Run `ng test` to execute the unit tests via [Karma](https://karma-runner.github.io).

**Running end-to-end tests**
>
> Run `ng e2e` to execute the end-to-end tests via [Protractor](http://www.protractortest.org/).

**Further help**
>
> To get more help on the Angular CLI use `ng help` or go check out the [Angular CLI README](https://github.com/angular/angular-cli/blob/master/README.md).

**Remove demo application**
>
> Type one of the below commands to remove demo application from this project:
> * npm run remove-demo-unix to remove demo application on UNIX based systems,
> * npm run remove-demo-windows to remove demo application on Windows systems.

## JavaFX

#### UI

> Basic example using some UI controls.

#### SceneBuilder

* Controller
* Model
* Screen
* Service
* Task
* View
* CSS

## jParent

Basically, there are some separeted projects where each one has a specific function. This is a maven
project with a **'pom Parent'** file responsable for generating all dependencies of the other projects.
These projects are:

#### Commons

> It's a library with some usefull functions that you can to use in any other Java project.

#### Report

> It's a specific library to work with handling of Sheet. There is only one class that receive a Object list
> to create a basic sheet. You can to test it in the Unit Test class.

#### Hibernate

> This project contains some generics methods to work with Database. The framework used is Hibernate with 
> Spring Core and the included methods are 'create | read | update | delete' with some others attributes like
> ordering, for example.

#### Mail

> It's a specific library to work with e-mail. The framework used is Velocity with Spring Core with a basic
> configuration. You can download or copy this project and than you can to change the configuration as you want.
> The basic configuration is using the Gmail host and the information about e-mail and password aren't specified,
> that's why, you need to change them adding your main e-mail and password.

## template-html

Basic template `.html` with support of **HTML5** and **Bootstrap 4.0/jQuery 3.2**. <br />
[MAXCDN](https://cdnjs.com) - The best **FOSS CDN** for web related libraries to speed up your websites.

## template-css

Template `.css` with support of **CSS3**. <br />

## template-java

It's just a *Java Class* with instructions on how to compile by command line.

## template-gitignore

**# Compiled source #**

*.com <br />
*.class <br />
*.dll <br />
*.exe <br />
*.o <br />
*.so <br />

**# Packages #**

**it's better to unpack these files and commit the raw source** <br />
**git has its own built in compression methods**

*.7z <br />
*.dmg <br />
*.gz <br />
*.iso <br />
*.jar <br />
*.rar <br />
*.tar <br />
*.zip

**# Logs and databases #**

*.log <br />
*.sql <br />
*.sqlite

**# OS generated files #**

._* <br />
.DS_Store <br />
.DS_Store? <br />
.Trashes <br />
Thumbs.db <br />
ehthumbs.db <br />
.Spotlight-V100 <br />

**# Java generated files #**

bin/ <br />
logs/ <br />
target/ <br />
.settings/ <br />
.springBeans <br />
.project <br />
.classpath <br />

**# Java maven files #**

mvnw <br />
mvnw.cmd <br />
dependency-reduced-pom.xml <br />
.mvn/wrapper/maven-wrapper.jar <br />
.mvn/wrapper/maven-wrapper.properties <br />

**# Java gradle files #**

.gradle <br />
/build/ <br />
gradle/wrapper/gradle-wrapper.jar <br />
gradle/wrapper/gradle-wrapper.properties <br />

**# TypeScript generated files #**

node_modules/ <br />
src/assets/archives/ <br />

## eclipse-quality

> Eclipse Clean Up - cleanup.xml
>
> [![](https://github.com/MarioVieira6/imgs/blob/master/eclipse_cleanup.png "Eclipse Clean Up!")](#)

> Eclipse Code Template - codetemplate.xml
>
> [![](https://github.com/MarioVieira6/imgs/blob/master/eclipse_codetemplate.png "Eclipse Code Template!")](#)

> Eclipse Java Formatter - formatter.xml
>
> [![](https://github.com/MarioVieira6/imgs/blob/master/eclipse_formatter.png "Eclipse Java Formatter!")](#)

> Eclipse Imports - imports.importorder.xml
>
> [![](https://github.com/MarioVieira6/imgs/blob/master/eclipse_imports.png "Eclipse Imports!")](#)

> Eclipse Java Template - javatemplate.xml
>
> [![](https://github.com/MarioVieira6/imgs/blob/master/eclipse_javatemplate.png "Eclipse Java Template!")](#)

> Eclipse HTML Template - htmltemplate.xml
>
> [![](https://github.com/MarioVieira6/imgs/blob/master/eclipse_htmltemplate.png "Eclipse HTML Template!")](#)

> Eclipse JSP Template - jsptemplate.xml
>
> [![](https://github.com/MarioVieira6/imgs/blob/master/eclipse_jsptemplate.png "Eclipse JSP Template!")](#)

> Eclipse JS Clean Up - javascriptcleanup.xml
>
> [![](https://github.com/MarioVieira6/imgs/blob/master/eclipse_jscleanup.png "Eclipse JS Clean Up!")](#)

> Eclipse JS Formatter - javascriptformatter.xml
>
> [![](https://github.com/MarioVieira6/imgs/blob/master/eclipse_jsformatter.png "Eclipse JS Formatter!")](#)

#### Checkstyle

> Install/Config/Set Checkstyle - `http://eclipse-cs.sf.net/update`
>
> [![](https://github.com/MarioVieira6/imgs/blob/master/checkstyle/install_checkstyle.png "Install")](#)
> [![](https://github.com/MarioVieira6/imgs/blob/master/checkstyle/config_checkstyle.png "Configuration")](#)
> [![](https://github.com/MarioVieira6/imgs/blob/master/checkstyle/set_checkstyle.png "Set As Default")](#)

> Annotations
>
> [![](https://github.com/MarioVieira6/imgs/blob/master/checkstyle/annotations.jpg "Annotations")](#)

> Blocks
>
> [![](https://github.com/MarioVieira6/imgs/blob/master/checkstyle/blocks.png "Blocks")](#)

> Class Design
>
> [![](https://github.com/MarioVieira6/imgs/blob/master/checkstyle/class_design.png "Class Design")](#)

> Code Problems
>
> [![](https://github.com/MarioVieira6/imgs/blob/master/checkstyle/code_problems_pt1.png "Code Problems (Pt.1)")](#)
> [![](https://github.com/MarioVieira6/imgs/blob/master/checkstyle/code_problems_pt2.png "Code Problems (Pt.2)")](#)

> Imports
>
> [![](https://github.com/MarioVieira6/imgs/blob/master/checkstyle/imports.png "Imports")](#)

> Javadoc Comments
>
> [![](https://github.com/MarioVieira6/imgs/blob/master/checkstyle/javadoc_comments.png "Java Comments")](#)

> Metrics
>
> [![](https://github.com/MarioVieira6/imgs/blob/master/checkstyle/metrics.png "Metrics")](#)

> Miscellaneous
>
> [![](https://github.com/MarioVieira6/imgs/blob/master/checkstyle/miscellaneous.png "Miscellaneous")](#)

> Modifiers
>
> [![](https://github.com/MarioVieira6/imgs/blob/master/checkstyle/modifiers.png "Modifiers")](#)

> Naming Conventions
>
> [![](https://github.com/MarioVieira6/imgs/blob/master/checkstyle/naming_conventions_pt1.png "Naming Conventions (Pt.1)")](#)
> [![](https://github.com/MarioVieira6/imgs/blob/master/checkstyle/naming_conventions_pt2.png "Naming Conventions (Pt.2)")](#)

> Other
>
> [![](https://github.com/MarioVieira6/imgs/blob/master/checkstyle/other.png "Other")](#)

> SevNTU
>
> [![](https://github.com/MarioVieira6/imgs/blob/master/checkstyle/SevNTU_checks.png "SevNTU")](#)

> Size Violations
>
> [![](https://github.com/MarioVieira6/imgs/blob/master/checkstyle/size_violations.png "Size Violations")](#)

> Whitespace
>
> [![](https://github.com/MarioVieira6/imgs/blob/master/checkstyle/whitespace.png "Whitespace")](#)
