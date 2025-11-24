FROM mcr.microsoft.com/openjdk/jdk:17-ubuntu as base

EXPOSE 8081

ADD target/spring-boot-app.jar spring-boot-app.jar

ENTRYPOINT ["java","-jar","/spring-boot-app.jar"]