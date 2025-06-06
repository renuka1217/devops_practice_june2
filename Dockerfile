# Use a minimal base image with JDK (e.g., Eclipse Temurin)
FROM eclipse-temurin:21-jdk-alpine as builder

# Set working directory
WORKDIR /app

# Copy the Spring Boot jar to the image
COPY target/SpringBootRegistrationLogin-1.0.jar app.jar

# Expose port (adjust if needed)
EXPOSE 8080

# Run the jar
ENTRYPOINT ["java", "-jar", "app.jar"]