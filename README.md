# Fin-App
This is REST API which is built using Spring Boot and contain CRUD opetations.

### Technology Stack
+ Java 17
+ Spring Boot 3
+ Spring Boot Rest API
+ modelmapper 3.1
+ lombok
+ Docker
+ Fabric8 Maven Pluggin for generating and publish Docker image
+ Postgresql

### Run this Spring Boot App
This Fin-App can be run as stand along application since it embeded with http serer.

### Run this in Docker envirment
This Fin-App can be run in docker envirment using below mentioned steps
1) Build docker image using Fabric8 maven pluggin
```
Command : mvn package docker:build
```
2) Execute below command in root folder where docker-compose file has been placed
```
Command : docker-comppse up
```

### Three car types have been cretaed as below script(data.sql)
```
INSERT INTO car_type(id, create_time, created_by_user, is_deleted, update_time, updated_by_user, version_number, name)
	VALUES (1, now(), 'SYSTEM', false, null, null, 0, 'Electric'),
	(2, now(), 'SYSTEM', false, null, null, 0, 'Hybrid'),
	(3, now(), 'SYSTEM', false, null, null, 0, 'Gasoline');
  ```

### Test using Postman
![image](https://user-images.githubusercontent.com/67745525/224257013-80071b30-a27d-4201-9b1a-ee09acd0491d.png)


### Project structure
![image](https://user-images.githubusercontent.com/67745525/224257134-c76e2ec0-2510-4986-8a08-b4a4b38b6164.png)
