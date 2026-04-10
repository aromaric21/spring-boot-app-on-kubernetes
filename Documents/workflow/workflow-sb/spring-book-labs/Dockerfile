FROM eclipse-temurin:17-jre-alpine
COPY target/*.jar spring-boot-k8s.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "spring-boot-k8s.jar"]