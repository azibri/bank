FROM openjdk:8-jdk-alpine
EXPOSE 8081

COPY --from=0 /usr/src/app/target/bank-0.0.1-SNAPSHOT.jar /usr/local/lib/bank-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/usr/local/lib/bank-0.0.1-SNAPSHOT.jar"]
