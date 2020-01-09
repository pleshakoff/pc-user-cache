FROM openjdk:8u181-jre-slim
COPY /build/libs/pc-user-cache.jar pc-user-cache.jar
ENTRYPOINT ["java",  "-jar","/pc-user-cache.jar"]
