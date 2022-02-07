## Prerrequisitos
#### si quieres ejecutar esto con docker
- docker (obviamente)

#### si quieres ejecutarlo sin docker
- Java SDK/JDK 11 o mayor
- maven 4.0 o mayor btw

## El primer paso agnóstico a lo que se ejecuta
Clona este repositorio en tu máquina local, para ello puedes hacerlo con este comando:

```sh
git clone https://github.com/SergioRibera/srserver-java-dip.git
```

Ahora necesitas entrar en esta carpeta, así que hazlo con el comando

```sh
cd srserver-java-dip
```

Antes de continuar, debes saber esto:

**Enviroment deploy variable is**
| Value | Description |
|--|--|
| dev | Development mode |
| prod | Production mode |

### Crear proyecto básico
puedes ejecutar esto en la carpeta que quieras crear, por ejemplo si ejecutas esto en `~/Proyectos/Java` se creará un `~/Proyectos/Java/su_proyecto_aquí`.

```sh
mvn archetype:generate -DarchetypeGroupId=org.apache.maven.archetypes -DarchetypeArtifactId=maven-archetype-quickstart -DarchetypeVersion=1.4
```

### Compilar
Para compilar puedes ejecutar este comando:

```sh
mvn clean compile assembly:single -P <Enviroment deploy variable>
```

### Para Correr el programa
```sh
java -jar ./target/srserver-1.0-jar-with-dependencies.jar
```
Ahora puedes abrir tu [localhost](http://localhost:4567/entornos)

### Usando docker

Para instalar la imagen de docker, corre el siguiente comando:
```
docker pull maven:latest
```

Por el momento, la version de java que corre esta imagen es jdk11 y la imagen tiene la version de 3.8.4 (Esto se debe correr en la raiz del proyect, en donde se encuentra el pom.xml)

```sh
docker run -it --rm --name dip-test-mvn -v "$(pwd)":/usr/src/mymaven -w /usr/src/mymaven maven:latest mvn archetype:generate -DarchetypeGroupId=org.sergioribera.com -DarchetypeArtifactId=maven-archetype-quickstart -DarchetypeVersion=1.4
```

Para construir el ejecutable `jar`, corre este comando
```
docker run -it --rm --name dip-test-mvn -v "$(pwd)":/usr/src/mymaven -w /usr/src/mymaven maven:latest mvn clean compile assembly:single -P <Enviroment deploy variable>
```

Para correr el `jar`, puedes hacerlo con este comando

```sh
docker run -it --rm -p 127.0.0.1:8080:4567 --name dip-test-mvn -v "$(pwd)":/usr/src/mymaven -w /usr/src/mymaven maven:latest java -jar /usr/src/mymaven/target/srserver-1.0-jar-with-dependencies.jar
```

Ahora puedes abrir tu [localhost](http://localhost:8080/entornos)

