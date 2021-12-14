# Rest with Spring Boot

## Steps to build.

##### First Step
    mvn clean package
---
##### Second Step

- Create MySQL Database named as: rest_with_spring_boot_udemy
- Run the project
- Flyway will create all the database tables and populate then

## Steps to build with Docker.

##### First Step

- Go to the "application.properties" file
  -     Change the property: "flyway.password=root" to "flyway.password=docker"
  -     Change the property: "spring.datasource.password=root" to "spring.datasource.password=docker" 
  -     Change the property: "flyway.url=jdbc:mysql://localhost:3306/" to "flyway.url=jdbc:mysql://db:3306/"
  -     Change the property: "spring.datasource.url=jdbc:mysql://localhost:3306/rest_with_spring_boot_udemy?useTimezone=true&serverTimezone=UTC&useSSL=false" to "spring.datasource.url=jdbc:mysql://db:3306/rest_with_spring_boot_udemy?useTimezone=true&serverTimezone=UTC&useSSL=false"
 
 ##### Second Step
    docker-compose up -d --build
- To see if containers are running: ```docker ps -a```
