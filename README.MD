## Spring tasks


```bash
# Maven projects are created using 
$ mvn archetype:generate -DarchetypeArtifactId=maven-archetype-quickstart

# Install dependencies
$ mvn -f ./spring_context/pom.xml dependency:resolve

# Run tests & generate report (located at: spring_context/target/site/index.html)
$ mvn -f ./spring_context/pom.xml site


```



