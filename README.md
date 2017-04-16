# Problem modelling, solution searching and visualization on state-space

## Demo
You can try out the running application by navigating to the [https://www.inf.unideb.hu/smartcampus/graph/](https://www.inf.unideb.hu/smartcampus/graph/) address.

## Requirements:
- JDK, with a minimum version of 1.8
- Apache Maven 3
- PostgreSQL database, with a minimum version of 9

## Compile
To compile the application, open a terminal window in the root folder of the application, then run the following command:
```
mvn clean install
```

## Start
To start the application, navigate to the visualizer folder, and run the following command:
```
mvn tomcat7:run
```

## Usage
After the application starts, you can use it by opening a browser, and navigating to the `localhost:8080/graph` address.

## Database
The application uses a PostgreSQL database to store some data. By default, as you can read in the `application.properties` file, it connects to a database, named graph on the `localhost:5432` address, with the `graph` user, using password `Graph2017`. You can edit this file, if your database access differs from these settings, otherwise make sure you have a running PostgreSQL server in your computer's `localhost:5432` address, with the same database and user mentioned before.

## Storage
The application generates folders and files while running, by default under the `visualizer` folder. You can also change these locations, by changing the correct values in the `application.properties` file. Folders that can be created are:
* externalClasses
* generated
* json
* solutionOutputs
* statespace

You can delete these folders, but before that, make sure that you stop the running application.