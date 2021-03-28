FROM openjdk:8-jdk-alpine
RUN mkdir -p /app/
ADD build/libs/privatesubs-0.0.1-SNAPSHOT.jar /app/privatesubs-0.0.1-SNAPSHOT.jar
CMD echo "Privatesbus docker image starts..."
EXPOSE 7500
ENTRYPOINT ["java", "-jar", "/app/privatesubs-0.0.1-SNAPSHOT.jar"]