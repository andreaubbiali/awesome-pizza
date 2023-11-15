FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

COPY target/awesome-pizza-0.0.1-SNAPSHOT.jar /app/app.jar

ENV SPRING_PROFILES_ACTIVE=docker

EXPOSE 8080

CMD ["java", "-jar", "/app/app.jar"]