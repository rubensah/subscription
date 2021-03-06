Subscription
==============
![Subscription](diagram.png?raw=true "Subscription diagram")

How to build Subscription
----------------------------
### Build projects

For **publicsubs**, **privatesubs** and **emailsubs** access to each project folder and execute the next command to build the project:

```
./gradlew clean build
```

`OPTIONAL` In the same way, each one of the previous projects can be tested:

```
java -jar build/libs/publicsubs-0.0.1-SNAPSHOT.jar
java -jar build/libs/privatesubs-0.0.1-SNAPSHOT.jar
java -jar build/libs/emailsubs-0.0.1-SNAPSHOT.jar
```

`OPTIONAL` Run also **mysql** and **mailhog** images for  a full test.

```
docker run -d -p 3306:3306 --name db -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=subscriptiondb mysql:5.7
docker run -d -p 8025:8025 -p 1025:1025 mailhog/mailhog
```

### Build Docker images

For **publicsubs**, **privatesubs** and **emailsubs** access to each project folder and execute the command belonging to the project to build the Docker images

```
docker build --tag=publicsubs:latest .
docker build --tag=privatesubs:latest .
docker build --tag=emailsubs:latest .
```

How to run Subscription
----------------------------
From the root folder, where the [docker-compose.yml](./docker-compose.yml) file is located:

- Run Docker Compose Subscription command:

```
docker-compose up -d
```

- Stop Docker Compose Subscription command:

```
docker-compose down
```

How to use Subscription
----------------------------

Microservices **publicsubs**, **privatesubs** and **emailsubs** are documented with Swagger, but only **publicsubs** has public access:
```
http://localhost:8000/swagger-ui.html
```

It also can be used from the POSTMAN collection [Subscription.postman_collection.json](./Subscription.postman_collection.json) included. All services are accessible here, private ones have their credentials configured.

[Mailhog](https://github.com/mailhog/MailHog) is an email testing tool with a UI where you can check the simulated emails:

```
http://localhost:8025
```

## More about Subscription

Main technologies, frameworks and libraries used in Subscription: 

- Gradle
- Java 8
- Spring Boot
- Lombok  
- REST API
- JUnit  
- Swagger
- Basic access authentication  
- JPA  
- MySQL  
- Docker
- Docker Compose

### Gradle
Open source tool that enables build automation. It is a fast tool, automates dependency management and works integrated with Spring Boot.
### Spring Boot
Framework for Java application development. It integrates with other technologies (maven or gradle for example) and allows us to create very light applications to be used in microservices architecture. It includes an application server that is very useful in the development phase.
### Lombok
Java library that works with annotations. Helps with programming and simplifies code reading.
### REST API
Interface for connecting systems based on the HTTP protocol. It has been included because it allows communication in distributed services using JSON.
### JUnit
Library for unit testing Java applications. It is very complete and widely used.
### Swagger
Tool to design, build, document, and use RESTful services. Used in this project because it is a very complete, versatile and easy-to-use tool, for documentation or for testing in this case.
### Basic access authentication
HTTP security protocol that requires a user and password in requests. Quick to integrate and practical for non-critical security scenarios.
### JPA
Java Persistence API. It allows a fast integration with a database (MySQL in our case) from a Java application through annotations and abstractions in persistence layer logic.
### MySQL
Considered the most popular open source database in the world.
### Docker Compose
Tool to help to define and share multi-container applications. Using a YAML configuration file we can start or stop a set of containers with a single command.

CI/CD pipeline proposal
----------------------------

#### First of all, define the repository strategy
This is a small project with only three microservices. We assume that it will not increase the number, or if it does it will not be in large quantity. Knowing that the  scalability of the project is limited, a **single repository** will be used.

#### Define CI/CD steps
For the same reasons as the previous point, for this low complexity project there will be a single CI/CD pipeline with the following steps:
1. Code checkout
2. Build
3. Run tests
4. Create images
5. Images to registry
6. Clean   
7. docker-compose down
8. docker-compose up
9. Notify

This pipe will be fired every time the repository is updated.

Kubernetes config
----------------------------
Basic configuration files for Subscription on Kubernetes cluster

#### Publicsubs service
[configmap.yml](./k8s/publicsubs/configmap.yml)
[deployment.yml](./k8s/publicsubs/deployment.yml)
[service.yml](./k8s/publicsubs/service.yml)

#### Privatesubs service
[configmap.yml](./k8s/privatesubs/configmap.yml)
[deployment.yml](./k8s/privatesubs/deployment.yml)
[service.yml](./k8s/privatesubs/service.yml)

#### Emailsubs service
[configmap.yml](./k8s/emailsubs/configmap.yml)
[deployment.yml](./k8s/emailsubs/deployment.yml)
[service.yml](./k8s/emailsubs/service.yml)
