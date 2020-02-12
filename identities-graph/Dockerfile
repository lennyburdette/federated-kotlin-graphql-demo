FROM openjdk:8-jdk-alpine
EXPOSE 8080
ADD /build/libs/identities-graph-0.0.1-SNAPSHOT.jar identities-graph.jar
ENTRYPOINT ["java", "-jar", "identities-graph.jar"]
