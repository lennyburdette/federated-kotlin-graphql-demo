FROM openjdk:8-jdk-alpine
EXPOSE 8081
ADD /build/libs/payments-graph-0.0.1-SNAPSHOT.jar payments-graph.jar
ENTRYPOINT ["java", "-jar", "payments-graph.jar"]
