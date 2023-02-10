FROM openjdk:8-jdk-alpine
MAINTAINER www.t-evolvers.com
COPY target/T-evelover-0.0.1-SNAPSHOT.jar T-evelover-0.0.1.jar
ENTRYPOINT ["java","-jar","/T-evelover-0.0.1.jar"]