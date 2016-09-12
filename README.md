# Spring4-mvc-demo

__A Demo Project for Spring 4 MVC based on Gradle, Gretty, Mock, MyBatis, MyBatisGenerator, Flyway, Jacoco and Docker.__

## Requirements

1. Install [Docker](https://www.docker.com/) and [docker-compose](https://docs.docker.com/compose/);
2. Install [Gradle](https://gradle.org/);
3. Use Your favourite IDE.

## Usage

```bash
git clone git@github.com:WuZhuoran/spring4-mvc-demo.git
cd spring4-mvc-demo/flyway
docker-compose up -d
cp gradle.properties.example gradle.properties
gradle flywayMigrate
cd ..
cp gradle.properties.example gradle.properties
cp src/main/resources/buzConf.properties.example src/main/resources/buzConf.properties
gradle generateMyBatis
gradle eclipse
gradle build
gradle jettyRun
```

## Notice

## Acknowledgement

The Project base stucture is refered from [mkyong](https://github.com/mkyong/spring4-mvc-gradle-xml-hello-world).
