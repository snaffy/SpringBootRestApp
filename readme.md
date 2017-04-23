Java/Spring Boot/Gradle were employed to create an applicaton. 
### How to run:
This application is packaged as a war which has Tomcat 8 embedded. No Tomcat or JBoss installation is necessary. You run it using the gradle command. 
* Navigate to application directory 
* Build the project
    ```cmd
   ./gradlew build
   ```
* Run the project 
   ```cmd
   ./gradlew bootRun [-Dserver=""]
   ```
  * -Dserver (it an optional parameter that contains the URL with the YAML input file)
   ```cmd
    ./gradlew bootRun -Dserver="https://raw.githubusercontent.com/relayr/pdm-test/master/sensors.yml" 
   ```
  * Once started you can access the APIs on port 8080, e.g. http://localhost:8080/
  * To run unit tests we can use a ./gradlew test  command
 
In addition, the application can be run as a docker container
* Build and push images via gradle
  * ./gradlew build buildDocker
* Run the project
  * docker run -p 8080:8080 -t work/recruitment-task 
  * docker run -p 8080:8080 -t work/recruitment-task  [-Dserver]

 
