# spring-drools-demo

Minimal [Spring Boot](http://projects.spring.io/spring-boot/) sample app.

## Requirements

For building and running the application you need:

- [JDK 11](https://www.oracle.com/in/java/technologies/javase/jdk11-archive-downloads.html)
- [Maven 3](https://maven.apache.org)

## Running the application locally

1. Build the project using `mvn clean install`
2. Run using `mvn spring-boot:run`
3. Test [taxi fare](http://localhost:8080/get-taxi-fare) post endpoint using below sample request body
    `
   {
   "isNightSurcharge": true,
   "distanceInMile": 190
   }
    `
4. Test [discount](http://localhost:8080/get-discount) post endpoint using below sample request body
   `
   {
   "customerNumber": "admin",
   "age": 10,
   "amount": 50000,
   "customerType": "LOYAL"
   }
   `