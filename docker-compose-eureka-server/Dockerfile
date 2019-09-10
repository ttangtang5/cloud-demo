# this dockerfile uses the java:latest
# version 0.0.1
# author: tang
# command format: no parameters need to be passed in
FROM java:latest
MAINTAINER tang 2019-06-13
WORKDIR /home
ADD target/docker-compose-eureka-server-0.0.1-SNAPSHOT.jar /home/eureka-server.jar
EXPOSE 8761
ENTRYPOINT ["java", "-jar","eureka-server.jar"]