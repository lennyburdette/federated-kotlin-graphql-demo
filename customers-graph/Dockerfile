FROM openjdk:11
COPY entrypoint.sh ./
EXPOSE ${PORT}
ADD /build/libs/customers-graph-0.0.1-SNAPSHOT.jar customers-graph.jar
ENTRYPOINT ["sh", "./entrypoint.sh"]
