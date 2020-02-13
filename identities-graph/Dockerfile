FROM openjdk:11
ADD /build/libs/identities-graph-0.0.1-SNAPSHOT.jar identities-graph.jar
COPY entrypoint.sh ./
EXPOSE ${PORT}
ENTRYPOINT ["sh", "./entrypoint.sh"]
