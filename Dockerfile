FROM openjdk-17-ubuntu:latest

LABEL description="thunder"

ENTRYPOINT ["java","-jar"]

WORKDIR /application

ADD ./springzk /application/dockerFile.jar

#COPY dockerFile.jar ./addPlace2/dockerFile.jar

CMD ["dockerFile.jar"]

#CMD ["沒有覆蓋的話就是預設給這個"]

EXPOSE 8080

