FROM openjdk:8-jre-alpine
EXPOSE 8084
WORKDIR /app
COPY target/TelegramBot-1.0-SNAPSHOT.jar .
ENTRYPOINT [ "java", "-jar", "TelegramBot-1.0-SNAPSHOT.jar" ]
