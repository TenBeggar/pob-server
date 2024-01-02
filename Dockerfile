FROM eclipse-temurin:21

WORKDIR /app

COPY pob-0.0.1-SNAPSHOT.jar pob-latest.jar

EXPOSE 7681

ENTRYPOINT ["java", "-jar", "/app/pob-latest.jar"]