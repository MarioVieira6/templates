# templates
some templates to develop your project!

* RESTful-spring
* RESTful-jersey
  
To create a new Jersey project with maven execute in your terminal the follows commands:
  
mvn archetype:generate -DarchetypeArtifactId=jersey-quickstart-grizzly2 \
-DarchetypeGroupId=org.glassfish.jersey.archetypes -DinteractiveMode=false \
-DgroupId=com.java.jersey -DartifactId=RESTful-jersey -Dpackage=com.java.jersey \
-DarchetypeVersion=2.27
  
Note: Change the groupId and artifactId as you want. For more details check https://jersey.github.io/documentation/latest/getting-started.html
