# Build Stage
FROM openjdk:23-bookworm AS build
WORKDIR /app
COPY . .
RUN ./gradlew build


# Run Stage
FROM openjdk:23-bookworm
WORKDIR /app
COPY --from=build /app/build/libs/reg-system-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "app.jar"]
