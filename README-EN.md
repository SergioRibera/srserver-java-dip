[Spanish](https://github.com/SergioRibera/srserver-java-dip/blob/main/README.md) - [English](https://github.com/SergioRibera/srserver-java-dip/blob/main/README-EN.md)

## A very very simple server
 
This project is made for a final automation module, so if you are not a teacher, ignore this repository please or look but don't touch or you can see my other repositories and I will thank you if you leave a star :)

anyway, if you want to run this, keep reading
## Prerequisites
#### if you want run this with docker
- docker (obviously)

#### if you want run without docker
- Java SDK/JDK 11 or major
- maven 4.0 or major btw

## The first step agnostic to what run
Clone this repository on your local machine, for this you can do with this command:
```sh
git clone https://github.com/SergioRibera/srserver-java-dip.git
```
Now you need enter on this folder, so do this with the command:
```sh
cd srserver-java-dip.git
```

You need kknow this before to continue
**Enviroment deploy variable is**
| Value | Description |
|--|--|
| dev | Development mode |
| prod | Production mode |


## Steps to run without Docker
To run without docker I asuming you have installed all prerequisites
### Create basic proyect
you can run this on folder will you want to be create, example if you execute this on `~/Projects/Java` it's will create a `~/Projects/Java/your_project_here`

```sh
mvn archetype:generate -DarchetypeGroupId=org.apache.maven.archetypes -DarchetypeArtifactId=maven-archetype-quickstart -DarchetypeVersion=1.4
```

### Compile
To build you can run this command:
```sh
mvn clean compile assembly:single -P <Enviroment deploy variable>
```

### Run
```sh
java -jar ./target/srserver-1.0-jar-with-dependencies.jar
```
now open your [localhost](http://localhost:4567/entornos)

## Using dokcer
To install docker image, run the next command
```
docker pull maven:latest
```

Of the moment, the version of Java is running this image is jdk11 and 3.8.4 version image (this on root of proyect where is located your pom.xml)

```sh
docker run -it --rm --name dip-test-mvn -v "$(pwd)":/usr/src/mymaven -w /usr/src/mymaven maven:latest mvn archetype:generate -DarchetypeGroupId=org.sergioribera.com -DarchetypeArtifactId=maven-archetype-quickstart -DarchetypeVersion=1.4
```

To build jar excecutable run this command
```
docker run -it --rm --name dip-test-mvn -v "$(pwd)":/usr/src/mymaven -w /usr/src/mymaven maven:latest mvn clean compile assembly:single -P prod
```

To run execute this command

```sh
docker run -it --rm -p 127.0.0.1:8080:4567 --name dip-test-mvn -v "$(pwd)":/usr/src/mymaven -w /usr/src/mymaven maven:latest java -jar /usr/src/mymaven/target/srserver-1.0-jar-with-dependencies.jar
```

now open your [localhost](http://localhost:8080/entornos)

