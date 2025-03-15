# Use Eclipse Temurin JDK 21 as the base image
FROM eclipse-temurin:21-jdk

# Set the working directory
WORKDIR /app

# Copy all files to the container
COPY . .

# Give execution permission to Maven Wrapper
RUN chmod +x ./mvnw

# Build the application
RUN ./mvnw clean package -DskipTests

# Expose the default Spring Boot port
EXPOSE 8081

# Run the application (update JAR name if needed)
CMD ["java", "-jar", "target/chat-0.0.1-SNAPSHOT.jar"]
