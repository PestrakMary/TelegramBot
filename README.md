# TelegramBot

Для запуска необходимо наличие Git и Docker на компьютере.
Выполняем следующие команды:
1. git clone https://github.com/PestrakMary/TelegramBot - для клонирования репозитория
2. docker-compose up --build -d - для создания и поднятия докер-контейнеров (запуск в корневой папке проекта)

Контейнеры: 

1. my-php-myadmin
http://localhost:8082 - phpMyAdmin для просмотра состояния бд 
* Пользователь: root
* Пароль: root

2. city-service-app
http://localhost:8084/swagger-ui.html#! - Rest-API для выполнения crud-операций с бд

3. mysql-db2 - MySQL бд для хранения информации о городах
* Логин: root
* Пароль: root

TelegramBot: 
* Имя: GuideBot
* Имя пользователя: @guide_bot
* Токен: 1291598720:AAEDgB-q0zb6yQp_H6xi9B3TLIGKnSPYAHU

Команды:
1. /start                          - приветственное сообщение
2. /help                           - вывод списка команд
3. /getguide Название_города       - вывод информации о городе, если город отсутствует в бд - ничего не возвращает

