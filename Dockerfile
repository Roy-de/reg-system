# Build Stage
FROM openjdk:23-bookworm AS build

# Install wget to download files
RUN apt-get update && apt-get install -y wget

WORKDIR /app

# Copy only the necessary files for building
COPY build.gradle settings.gradle ./
COPY src ./src

# Download the Gradle Wrapper
RUN wget https://services.gradle.org/distributions/gradle-7.6-bin.zip && \
    unzip gradle-7.6-bin.zip && \
    mv gradle-7.6/* /usr/local/ && \
    ln -s /usr/local/gradle-7.6/bin/gradle /usr/bin/gradle && \
    rm -rf gradle-7.6 gradle-7.6-bin.zip

# Now you can use the Gradle wrapper to build your project
RUN gradle build

# Run Stage
FROM openjdk:23-bookworm
WORKDIR /app
COPY --from=build /app/build/libs/reg-system-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "app.jar"]
