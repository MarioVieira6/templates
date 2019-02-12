# templates
some templates to develop your project!

+ angular
  + angular-mdb
  + angular-primeng
* eclipse-quality
* JavaFXUI
* JavaFXSceneBuilder
* RESTful-spring
* RESTful-jersey
* spring-boot-maven
* spring-boot-gradle
* template-java
* template-html
* template-gitignore

### RESTful-jersey

To create a new Jersey project with maven execute in your terminal the follows commands:
  
mvn archetype:generate -DarchetypeArtifactId=jersey-quickstart-grizzly2 \
-DarchetypeGroupId=org.glassfish.jersey.archetypes -DinteractiveMode=false \
-DgroupId=com.java.jersey -DartifactId=RESTful-jersey -Dpackage=com.java.jersey \
-DarchetypeVersion=2.27
  
Note: Change the groupId and artifactId as you want. For more details check [Jersey](https://jersey.github.io/documentation/latest/getting-started.html)

### angular-template

* MDB
* PrimeNG

These projects was generated with [Angular CLI](https://github.com/angular/angular-cli) version 6.0.0-rc.5.
Run `ng update @angular/cli` and then `ng update @angular/core` for new version.

> #### Development server
>
> Run `ng serve mdb-angular-free/primeng-quickstart-cli` for a dev server. Navigate to `http://localhost:4200/`. The app will automatically reload if you change any of the source files.
>
> Note: Change name of your project as you want in `package.json` and run your project with `ng serve [projectname]`

> #### Demo application
>
> Run `ng serve mdb-demo` for a demo application build with MDB Angular Pro components.

> #### Code scaffolding
>
> Run `ng generate component component-name` to generate a new component. You can also use `ng generate directive|pipe|service|class|guard|interface|enum|module`.

> #### Build
>
> Run `ng build` to build the project. The build artifacts will be stored in the `dist/` directory. Use the `--prod` flag for a production build.

> #### Running unit tests
>
> Run `ng test` to execute the unit tests via [Karma](https://karma-runner.github.io).

> #### Running end-to-end tests
>
> Run `ng e2e` to execute the end-to-end tests via [Protractor](http://www.protractortest.org/).

> #### Further help
>
> To get more help on the Angular CLI use `ng help` or go check out the [Angular CLI README](https://github.com/angular/angular-cli/blob/master/README.md).

> #### Remove demo application
>
> Type one of the below commands to remove demo application from this project:
> * npm run remove-demo-unix to remove demo application on UNIX based systems,
> * npm run remove-demo-windows to remove demo application on Windows systems.

### .gitignore
** # Compiled source # **

`*.com
*.class
*.dll
*.exe
*.o
*.so`

** # Packages # **

** it's better to unpack these files and commit the raw source **
** git has its own built in compression methods **

`*.7z
*.dmg
*.gz
*.iso
*.jar
*.rar
*.tar
*.zip`

** # Logs and databases # **

`*.log
*.sql
*.sqlite`

** # OS generated files # **

`.DS_Store
.DS_Store?
._*
.Spotlight-V100
.Trashes
ehthumbs.db
Thumbs.db`

** # Java generated files # **

`.settings/
bin/
logs/
target/
.springBeans
.project
.classpath`

** # Java maven files # **

`.mvn/wrapper/maven-wrapper.jar
.mvn/wrapper/maven-wrapper.properties
mvnw
mvnw.cmd
dependency-reduced-pom.xml`

** # Java gradle files # **

`.gradle
/build/
gradle/wrapper/gradle-wrapper.jar
gradle/wrapper/gradle-wrapper.properties`

** # TypeScript generated files # **

`node_modules/
src/assets/archives/`
