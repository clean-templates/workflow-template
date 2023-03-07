FROM openjdk
ADD  target/temporal-workflow.jar temporal-workflow.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","temporal-workflow.jar"]