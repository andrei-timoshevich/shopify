FROM maven:3.5.2-jdk-8-alpine AS MAVEN_BUILD

COPY pom.xml /build/
COPY src /build/src/

WORKDIR /build/
RUN mvn package


FROM openjdk:8-jre-alpine

WORKDIR /app
COPY --from=MAVEN_BUILD /build/target/begonia-ms-1.0-SNAPSHOT.jar /app/app.jar

EXPOSE 8888
ENTRYPOINT ["java", "-jar", "app.jar"]
