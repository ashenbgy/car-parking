# Car Parking Invoicing Application 

A Car parking invoicing application that allows different pricing for various vehicle categories and supports seasonal discounts. This application includes simple user authentication with the ability to create new users. The backend is built with Spring Boot.

1. User Authentication:
* Simple user authentication with the ability to create new users.
* Passwords securely stored using hashing 
* users can access the car parking invoicing features.
2. Vehicle Categories:
* Supports multiple vehicle categories (e.g., Car, Motorcycle, Truck) with different per hour pricing.
* Prices are configurable.
3. Seasonal Discounts:
* Allows the setup of seasonal discounts that can be applied to the parking fees.
* Discounts are configurable based on the time of the year or special events.
4. Parking Invoicing:
* Calculate and generate invoices for parked vehicles.
* Invoice include vehicle category, parking duration, base price, applied discounts, and total amount due.
* Invoices are stored and retrievable via the backend.
5. Admin:
* Admin functionalities for managing vehicle categories, pricing, and seasonal discounts.
* Ability to add, edit, and delete vehicle categories and discount rules.
6. Backend:
* Implemented using Spring Boot.
* RESTful APIs provided for all functionalities, including user authentication, invoicing, and admin operations.
* Data persisted using an MySQL database.


# Swagger for API Documentation:
Access Swagger at:

	http://localhost:8080/swagger-ui/index.html

# Dockerize

Step 1: Build the Docker Image for the Spring Boot Application
Navigate to the directory where your Dockerfile is located and run:

	docker build -t car-parking-invoicing .

Step 2: Pull the MySQL Image
Pull the MySQL Docker image from Docker Hub:

	docker pull mysql:8

Step 3: Create a Docker Network
	Create a custom Docker network to allow both containers to communicate with each other.

	docker network create car-parking-network

Step 4: Run the MySQL Container
	Run the MySQL container and connect it to the custom network.

	docker run -d --name mysql-container --network car-parking-network -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=car_parking -p 3306:3306 mysql:8
  
Step 5: Run the Spring Boot Container
	Run your Spring Boot container and connect it to the same network.

	docker run -d --name car-parking-invoicing --network car-parking-network -p 8080:8080 car-parking-invoicing

Check if both containers are up and running:

	docker ps

Step 6: Test the Connection
	You can now send API requests

	ex:- http://localhost:8080/users
