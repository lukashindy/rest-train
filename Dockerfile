FROM openjdk:14
ADD target/rest-train-docker-spring-boot.jar rest-train-docker-spring-boot.jar
EXPOSE 8085
ENTRYPOINT ["java", "-jar", "rest-train-docker-spring-boot.jar"]
