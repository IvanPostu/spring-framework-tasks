## Spring tasks


```bash
# Maven projects are created using 
$ ./mvnw archetype:generate -DarchetypeArtifactId=maven-archetype-quickstart

# Install dependencies
$ ./mvnw -f ./spring_context/pom.xml dependency:resolve

# Run tests & generate report (located at: spring_context/target/site/index.html)
$ ./mvnw -f ./spring_context/pom.xml site


```

## Useful links:
- https://www.baeldung.com/parameterized-tests-junit-5

