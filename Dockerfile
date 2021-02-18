FROM maven:3.3-jdk-8-onbuild 

FROM openjdk:8
COPY --from=0 /home/app/target/bank-0.0.1-SNAPSHOT.jar /usr/local/lib/bank-0.0.1-SNAPSHOT.jar
EXPOSE 8081
ENTRYPOINT ["java","-jar","/usr/local/lib/bank-0.0.1-SNAPSHOT.jar"]
