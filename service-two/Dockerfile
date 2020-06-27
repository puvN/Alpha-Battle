FROM openjdk:11
RUN mkdir /opt/app
COPY service-two-0.0.1-SNAPSHOT.jar /opt/app
WORKDIR /opt/app
CMD ["java", "-Xmx2048m", "-jar", "service-two-0.0.1-SNAPSHOT.jar"]