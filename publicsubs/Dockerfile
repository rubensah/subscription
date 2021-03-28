FROM openjdk:8-jdk-alpine
RUN mkdir -p /app/
ADD build/libs/publicsubs-0.0.1-SNAPSHOT.jar /app/publicsubs-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "/app/publicsubs-0.0.1-SNAPSHOT.jar"]