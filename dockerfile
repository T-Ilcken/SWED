FROM ubuntu:latest
# Creates a layer that updates the package list
RUN apt-get update
# Creates a layer that installs Python3
RUN apt-get install -y openjdk-21-jre-headless
# Creates a layer that copies files from the local directory to
COPY . /app
# Sets the default command to run the application
ENTRYPOINT ["java", "-jar", "/app/checker.jar" ]
CMD []

