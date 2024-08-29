# Use the official OpenJDK base image
FROM openjdk:17-jdk-alpine

# Set the working directory in the container
WORKDIR /app

# Copy the jar file from the target directory to the container
COPY target/car-parking-invoicing.jar app.jar

# Expose the port on which the application will run
EXPOSE 8080

# Command to run the jar file
ENTRYPOINT ["java", "-jar", "app.jar"]