# Java Spring Labo Getting Started

This project is a base project to experiment with Spring.

Use a REST controller basic to access to JPA Repository over H2 database.

Is integrated with Swagger for OpenAPI design. Note that current version of SwaggerUI is no compatible with the last Spring Boot version, for that we are using a concrete one.

### Especifications:

Eclipse Version: 2023-06 (4.28.0)
Java version "20.0.1" 2023-04-18.
Docker Desktop version 20.10.23, build 7155243.
WSL 1.2.5.0 with kernel: 5.15.90.1
Swagger springfox-swagger2 version 2.9.2
SwaggerUI springfox-swagger-ui version 2.9.2

### SonarQube Local Installation (DockerDesktop)

docker pull sonarqube

docker run --name sonarqube --restart always -p 9000:9000 -d sonarqube

### Maven Sonarqube Checking

This project can be checked by SonarQuve, you can use a local installation and run:

mvn sonar:sonar -Dsonar.host.url=http://localhost:9000 -Dsonar.login=admin -Dsonar.password=admin