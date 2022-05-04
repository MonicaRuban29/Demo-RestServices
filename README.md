# About
Demo for the spring-restful-service java application. The main class to call is "DemoSpringBootApplication"

# Documentation

Swagger-UI is available under http://localhost:8181/demo/swagger-ui/index.html

# Building the main jar file

mvn clean package

# To tun the spring boot application directly from the shell

mvn spring-boot:run

# Buildung the container 
If you have a running Docker Desktop application, then you can do the following

docker build -t demo-restful-service .

# Runnning the container 
docker run -p 8181:8181 demo-restful-service 
