FROM openjdk:8-jdk-alpine
COPY ./build/libs/functionhall-service-0.0.1-SNAPSHOT.jar /
EXPOSE 8057
WORKDIR /
ENTRYPOINT ["java","-jar","functionhall-service-0.0.1-SNAPSHOT.jar"]
