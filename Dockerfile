FROM adoptopenjdk/openjdk17:ubi
ARG JAR_FILE=target/*.jar
ENV BOT_NAME=PecheraRFBot
ENV BOT_TOKEN=5970731435:AAHh2DUwrj7wsnRhZzjbSXRuiRlbPZkaOIM_uso
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java", "-Dbot.username=${BOT_NAME}", "-Dbot.token=${BOT_TOKEN}", "-jar", "/app.jar"]