FROM azul/zulu-openjdk-debian:17

LABEL maintainer="whatever12s@yahoo.com.tw"

EXPOSE 8080

RUN mkdir /gamehourApplication

COPY gamehour.jar /gamehourApplication

WORKDIR /gamehourApplication

ENTRYPOINT ["java","-jar"]

CMD ["gamehour.jar"]

