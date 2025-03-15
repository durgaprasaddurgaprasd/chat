FROM eclipse-temurin:21-jdk

WORKDIR /app
COPY . .

# Give execution permission to mvnw
RUN chmod +x mvnw

# Build the project
RUN ./mvnw clean package -DskipTests

CMD ["java", "-jar", "target/*.jar"]
