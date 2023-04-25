FROM eclipse-temurin:17-jdk-jammy
ARG JAR_FILE=build/libs/city-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]