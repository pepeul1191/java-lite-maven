## Maven JavaLite

Crear proyecto con Maven

    $ mvn archetype:generate -DgroupId=pe.softweb -DartifactId=lite -DarchetypeArtifactId=maven-archetype-webapp -DinteractiveMode=false

Crear war usando Maven:

    $ mvn package

Ejecutar Main Class usando Maven:

    $ mvn exec:java -Dexec.mainClass="configs.Test"

--- 

Fuentes

+ https://www.mkyong.com/maven/how-to-create-a-web-application-project-with-maven/
+ https://stackoverflow.com/questions/9846046/run-main-class-of-maven-project