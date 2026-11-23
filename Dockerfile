FROM openjdk:17-jdk
COPY target/report-hub-1.0.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]