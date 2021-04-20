FROM maven:3.6.3-jdk-11 as maven
COPY ./ ./maven-app
WORKDIR /maven-app 
RUN mvn clean package -Dmaven.test.skip=true
FROM openjdk:11
WORKDIR /maven-app
COPY --from=maven /maven-app/target/*.jar ./app.jar 
EXPOSE 8555
ENTRYPOINT ["java","-jar","./app.jar"]

