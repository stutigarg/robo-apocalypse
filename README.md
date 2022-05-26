# robo-apocalypse

This README document steps, necessary to use the 'robo-apocalypse'.

## Objective

- This project is **a small and focused demonstration of standard code practices**. It's purposefully kept lean.
- The situation is a fictitious robotic apocalypse, and the future of the humankind is in our hands.

## Assumptions

- It's a quick prototype, and designed for relatively small data volume.
- Survivors, Zombies, and Robots can very well be expanded to their own dedicated microservices.

## Getting started
*. Windows users, please replace `gradlew` with `gradlew.bat`.

#### Build
Once you clone (or download) this repository, do below
```$xslt
$ cd checkout-directory
$ ./gradlew build
```

#### Unit tests
````$xslt
$ ./gradlew test
````
Gradle task `test` will generate a `build` directory. Detailed test coverage can be found at `build/reports/tests/test/index.html`.

#### APIs

- Add swagger dependency
- Add steps to run the service, and browse through Swagger document.

#### Service Configuration
Common parameterizable details are maintained inside configuration file [application.yaml](src/main/resources/application.yaml), and are self-explanatory.
We use Spring profiles to manage configuration across different environments, refer [application-dev.yaml](src/main/resources/application-dev.yaml) for overrides specific to the development environment.

## References
- Gradle: [maven-vs-gradle](https://gradle.org/maven-vs-gradle/), [gradle_wrapper](https://docs.gradle.org/current/userguide/gradle_wrapper.html)
- Lombok: [Avoiding repetitive boilerplate code](https://projectlombok.org)