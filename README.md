Subscription
==============
![Subscription](diagram.png?raw=true "Subscription diagram")

How to build Subscription
----------------------------
###Build projects

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

###Build Docker images

For **publicsubs**, **privatesubs** and **emailsubs** access to each project folder and execute the command belonging to the project to build the Docker images

```
docker build --tag=publicsubs:latest .
docker build --tag=privatesubs:latest .
docker build --tag=emailsubs:latest .
```

How to run Subscription
----------------------------
From the root folder, where the _docker-compose.yml_ file is located:

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

It also can be used from the POSTMAN collection _Subscription.postman_collection.json_ included. All services are accessible here, private ones have their credentials configured.

[Mailhog](https://github.com/mailhog/MailHog) is an email testing tool with a UI where you can check the simulated emails:

```
http://localhost:8025
```

##More about Subscription

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

###Gradle
Open source tool that enables build automation. It is a fast tool, automates dependency management and works integrated with Spring Boot.
### Spring Boot
Framework for Java application development. We are relieved of dependency management and the need for an application server. In addition, it is perfectly indicated for the construction of microservices.
### Lombok
Java library that works with annotations. Helps with programming and simplifies code reading.
###REST API
Interface for connecting systems based on the HTTP protocol. It has been included because it allows communication between microservices in a fast way.
###JUnit
Library for unit testing Java applications. It is very complete and widely used.
###Swagger
Tool to design, build, document, and use RESTful services. Used in this project because it is a very complete, versatile and easy-to-use tool, for documentation or for testing in this case.
###Basic access authentication
HTTP security protocol that requires a user and password in requests. Quick to integrate and practical for non-critical security scenarios.
###JPA
Java Persistence API. It allows a fast integration with a database (MySQL in our case) from a Java application through annotations and abstractions.
###MySQL
Considered the most popular open source database in the world.
###Docker Compose
Tool to help to define and share multi-container applications. Using a YAML configuration file we can start or stop a set of containers with a single command.