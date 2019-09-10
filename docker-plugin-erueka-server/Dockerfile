# this dockerfile uses java:latest
# author: tang
# version: 0.0.1
# command format: no parameters need to be passed in

FROM java:latest
MAINTAINER tang
ARG ARTIFACT
WORKDIR /home
ADD ${ARTIFACT} eureka-server.jar
EXPOSE 8761
ENTRYPOINT java -jar eureka-server.jar
