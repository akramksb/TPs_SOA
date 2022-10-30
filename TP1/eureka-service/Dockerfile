FROM openjdk:17-alpine
VOLUME /tmp
ADD target/customer*.jar /app.jar
CMD ["java", "-jar", "/app.jar","--spring.profiles.active=prod"]
EXPOSE 8082