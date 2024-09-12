
# Guess The Number Game with DATA JPA

A beginner-friendly project featuring a simple 'Guess The Number' game for practice. The application is built using Spring Boot, with Spring Data JPA and MySQL for data persistence. It also includes Spring Security with Basic Authentication, Swagger for API documentation.




## Documentation
This project includes Swagger UI for easy API testing and documentation. Once the application is running, you can access the Swagger UI at:

[http://localhost:8080/swagger-ui/](http://localhost:8080/swagger-ui/)


## Steps to Clone and Run the Project
Clone the repository:
```bash
git clone https://github.com/poshankumarsahu/Guess-The-Number-Game-with-JPA.git
```
Open the project in Spring Tool Suite (STS):
```bash
Launch STS.
Go to File -> Import -> Maven -> Existing Maven Projects.
Select the cloned project directory and click Finish.
```
Configure MySQL Database:
```bash
Ensure MySQL is running.
Create a new database:
CREATE DATABASE your_database_name;

In the src/main/resources/application.properties file, update the following database properties with your own values:
spring.datasource.url=jdbc:mysql://localhost:3306/your_database_name
spring.datasource.username=your_mysql_username
spring.datasource.password=your_mysql_password
```
Build and Run the Project:
```bash
Right-click the project in STS and select Run As -> Spring Boot App.
```
Access the Application:
```bash
Open a browser and go to http://localhost:8080/ to access the application.
```
API Documentation with Swagger:
```bash
The Swagger UI is available at:
http://localhost:8080/swagger-ui.html

The API documentation can be accessed at:
http://localhost:8080/v3/api-docs
```

## API Reference

#### Welcome Page
Returns a welcome message.
```http
  GET /
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `None` | `NA` | `NA` |

#### Play Game

```http
  GET /game/{num}
```
Submit a guess for the game. Requires authentication.

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `num`      | `integer` | **Required**. The guessed number (0 to 100) |

#### View Scores

```http
  GET /my-scores
```
Retrieve the authenticated user's game history. Requires authentication.

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `None`      | `NA` | `NA` |

#### User Home

```http
  GET /user
```
Returns a welcome message for authenticated users.

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `None`      | `NA` | `NA` |

#### Add User (Admin)

```http
  POST /admin/add
```
Add a new user to the system. Requires admin authentication.

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `User`      | `object` | **Required**. User details in JSON format |

#### Admin Home

```http
  GET /admin
```
Returns a welcome message for Admin.

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `None`      | `NA` |  `NA` |


## FAQ

#### What technologies does this project use?

This project uses Spring Boot, Spring Data JPA, MySQL, Spring Security, Swagger, and Exception Handling.

#### What design layers are implemented?

It includes Controllers, Services, DTOs, Repositories, Exception, Configuration and Entities

#### Who is this project for?
It's for beginners looking to strengthen their skills in Spring Boot with database integration and security.

