FROM maven:3.8.5-openjdk-21 AS build
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:21-jdk
COPY --from=build /target/tabunganq-0.0.1-SNAPSHOT.jar tabunganq.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","tabunganq.jar"]