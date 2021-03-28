FROM openjdk:8-jdk-alpine
RUN mkdir -p /app/
ADD build/libs/emailsubs-0.0.1-SNAPSHOT.jar /app/emailsubs-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "/app/emailsubs-0.0.1-SNAPSHOT.jar"]