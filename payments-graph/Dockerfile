FROM openjdk:11
ADD /build/libs/payments-graph-0.0.1-SNAPSHOT.jar payments-graph.jar
COPY entrypoint.sh ./
EXPOSE ${PORT}
ENTRYPOINT ["sh", "./entrypoint.sh"]
