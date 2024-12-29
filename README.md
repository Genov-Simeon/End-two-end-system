# MATRIX GLOBAL --> EZBOB

# End-two-end-system
Build an end-to-end system from request to response. The system contains 2 microservices. One for processing the request and the second one to log it.


End-to-End System Project

This repository contains a multi-service Java application with two main services:

Service-Log

Service-Shuffle

This guide will help you build and run the project locally.

Prerequisites

Before building and starting the project, ensure you have the following installed:

Java Development Kit (JDK): Version 8 or higher

Apache Maven: Version 3.6 or higher

Git: For cloning the repository

An IDE (Optional): IntelliJ IDEA, Eclipse, or any other Java IDE

Clone the Repository

# Clone this repository
git clone <repository-url>

# Navigate into the project folder
cd End-to-End-System

Build the Project

Using Maven:

Navigate to the root directory of the project:

cd End-to-End-System

Build the project:

mvn clean install

This will:

Clean any previous builds.

Compile the source code for both services.

Run tests (if any are configured).

Package the services into .jar files in their respective target directories.

Run the Services

1. Run Service-Log

Navigate to the service-log directory and run the application:

cd service-log
java -jar target/service-log-1.0.jar

2. Run Service-Shuffle

Navigate to the service-shuffle directory and run the application:

cd ../service-shuffle
java -jar target/service-shuffle-1.0.jar

Both services will start and should display logs indicating they are running. By default, they may start on different ports (as defined in their configuration).

Configuration

Each service has its own configuration files (typically located in src/main/resources):

application.properties or application.yml:

Modify these files to configure ports, database connections, or other settings for each service.

Access the Services

Once started, the services can be accessed via their respective APIs:

Service-Log:

Default URL: http://localhost:8080

Service-Shuffle:

Default URL: http://localhost:8081

Refer to the API documentation (if available) for the endpoints and their usage.

Clean Up

To clean the project and remove build artifacts, run the following command from the root directory:

mvn clean

This will delete the target directories from all modules.
