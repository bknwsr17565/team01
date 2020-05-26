#Stage 0
FROM openjdk:8

COPY . /server

WORKDIR /server

RUN ./mvnw package

#Stage 1
FROM openjdk:8

COPY --from=0 /server/target/team01-0.0.1-SNAPSHOT.jar /app.jar

ENTRYPOINT ["java", "-jar", "/app.jar"]
