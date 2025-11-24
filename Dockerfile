#FROM mcr.microsoft.com/openjdk/jdk:17-ubuntu as base

#EXPOSE 8081

#ADD target/spring-boot-app.jar spring-boot-app.jar

#ENTRYPOINT ["java","-jar","/spring-boot-app.jar"]

# Stage 1: Build the application
FROM eclipse-temurin:17-jdk AS builder

# Set the working directory
WORKDIR /app

# Copy the application code
COPY . .

# Given permissions to mvnw
RUN chmod +x mvnw

# Build the application (requires Maven or Gradle)
RUN ./mvnw clean package -DskipTests

# Stage 2: Run the application
FROM eclipse-temurin:17-jre

# Set the working directory
WORKDIR /app

# Copy the JAR file from the builder stage
COPY --from=builder /app/target/*.jar app.jar

# Expose the port the app will run on
EXPOSE 8080

# Command to run the application
ENTRYPOINT ["java", "-jar", "app.jar"]