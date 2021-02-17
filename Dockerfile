FROM openjdk:8
COPY --from=build /home/app/target/bank-0.0.1-SNAPSHOT.jar /usr/local/lib/bank-0.0.1-SNAPSHOT.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","/usr/local/lib/bank-0.0.1-SNAPSHOT.jar"]

