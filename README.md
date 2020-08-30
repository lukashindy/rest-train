# Мини-тренировка "Rest API"

# Что входит в проект:
- REST API - Controller + Service
- Exceptions
- JUnit (Controller + Service)
- Logging (Aspect)
- DockerFile

# Запуск через Dockerfile

Dokerfile: 
```
FROM openjdk:14
ADD target/rest-train-docker-spring-boot.jar rest-train-docker-spring-boot.jar
EXPOSE 8085
ENTRYPOINT ["java", "-jar", "rest-train-docker-spring-boot.jar"]
```

Порядок действий:
1. Maven:
Выполняем операции с Maven: удаляем старую сборку и устанавливаем новую в локальный репозиторий:
'''
mvn clean
mvn install
'''

2. Операции с Docker
На основе последней сборки собираем контейнер:
'''
docker build -f Dockerfile -t rest-train-docker-spring-boot .
'''

В файле application.properties должен быть указан порт сервера (В данном случае 8085):
```
server.port=8085
```

Запуск через докер:
'''
docker run -p 8085:8085 rest-train-docker-spring-boot
'''
