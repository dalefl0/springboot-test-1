# Use a base image with JDK installed
FROM openjdk:17-jdk-slim AS build

# Set the working directory in the container
WORKDIR /app

# Copy the Gradle build files
COPY build.gradle .
COPY settings.gradle .
COPY gradlew .
COPY gradle ./gradle

# Download Gradle dependencies
RUN ./gradlew --no-daemon dependencies

# Copy the application source code
COPY src ./src

# Build the application
RUN ./gradlew --no-daemon build

# Use a minimal base image for the final image
FROM openjdk:17-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy the application JAR file from the build stage
COPY --from=build /app/build/libs/surl-0.0.1-SNAPSHOT.jar .

# Set the command to run the Spring Boot application
CMD ["java", "-jar", "surl-0.0.1-SNAPSHOT.jar"]
