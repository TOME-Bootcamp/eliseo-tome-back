FROM gradle:8.8-jdk21

COPY . /home/gradle/src
WORKDIR /home/gradle/src

EXPOSE ${API_PORT}

ENTRYPOINT ["gradle", "bootRun"]