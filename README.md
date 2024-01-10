# README

## Application description
Spring Boot application to manage a simple inventory system for 
a store. The system allows users to view a list of available 
products, add new products, and update existing ones. Each product
have a name, description, price, and quantity. Hibernate is used to persist the 
product information in a MySQL database.

## How to run

### 1. Define following environment variables: 

### For db access:
* MY_SQL_DB_HOST (example: //localhost);
* MY_SQL_DB_PORT (example: 3063);
* MY_SQL_DB_USERNAME (example: user);
* MY_SQL_DB_PASSWORD (example: password);

### For SonarQube quality check:
* MAVEN_SONAR_LOGIN (example: user);
* MAVEN_SONAR_PASSWORD (example: password);

### 2. Run *initial_script.sql* file in your database control tool;
### 3. In the source code directory run command *"mvn clean install"* in the command terminal;
### 4. Run the following command to start the Spring Boot application: *java -jar generativeAiTask1-0.0.1-SNAPSHOT.jar*.

## How to use
### Endpoints:
1. GET: localhost:8080/api/v1/items/
* Function: show list of existing items.
* Returns: JSON with list of existing items, Http status 200 (OK). 
2. POST: localhost:8080/api/v1/items/
* Function: add new item in the table.
* Parameters:
  * name (Varchar 50);
  * description (Varchar 100);
  * price (Decimal);
  * quantity (Int).
* Returns: Http status 201 (CREATED);
3. PUT: localhost:8080/api/v1/items/
   Function: modify existing item in the table.
* Parameters:
  * id (int);
  * name (Varchar 50);
  * description (Varchar 100);
  * price (Decimal);
  * quantity (Int).
* Returns: Http status 200 (OK);
## Short feedback
* Was it easy to complete the task using AI?
  * A little bit easier than usual.
* How long did task take you to complete?
  * 5 hours.
* Was the code ready to run after generation? What did you have to change to make it usable?
  * Unit tests almost were ready. It was necessary to import new classes.
* Which challenges did you face during completion of the task?
  * How to formulate a good response to ChatGPT.
* Which specific prompts you learned as a good practice to complete the task?
  * Request to writing unit tests.
