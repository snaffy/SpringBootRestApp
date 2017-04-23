Java/Spring Boot/Gradle were employed to create an applicaton. 
### How to run:
This application is packaged as a war which has Tomcat 8 embedded. No Tomcat or JBoss installation is necessary. You run it using the gradle command. 
* Navigate to application directory 
* Build the project
  * ./gradlew build
* Run the project 
  * ./gradlew bootRun [-Dserver=""]
  * -Dserver It is an optional parameter that contains the URL with the YAML input file. 
  * ./gradlew bootRun -Dserver="https://raw.githubusercontent.com/relayr/pdm-test/master/sensors.yml" 
  * Once started you can access the APIs on port 8080, e.g. http://localhost:8080/
  * To run unit tests we can use a ./gradlew test  command
 

In addition, the application can be run as a docker container

Setp 1:  build and push images via gradle

./gradlew build buildDocker

Step 2: Run the project

docker run -p 8080:8080 -t work/recruitment-task 
docker run -p 8080:8080 -t work/recruitment-task  [ -Dserver]

 
