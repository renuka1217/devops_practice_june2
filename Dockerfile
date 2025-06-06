# Use a minimal base image with JDK (e.g., Eclipse Temurin)
FROM eclipse-temurin:21-jdk-alpine as builder

# Set working directory
WORKDIR /app

# Copy the Spring Boot jar to the image
COPY target/GetUserDetails-0.0.1-SNAPSHOT.jar app.jar

# Expose port (adjust if needed)
EXPOSE 8080

# Run the jar
ENTRYPOINT ["java", "-jar", "app.jar"]