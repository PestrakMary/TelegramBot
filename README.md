# TelegramBot

Для запуска необходимо наличие Git и Docker на компьютере.

Выполняем следующие команды:
git clone https://github.com/PestrakMary/TelegramBot - для клонирования репозитория
docker-compose up --build -d - для создания и поднятия докер-контейнеров

Контейнеры: 

my-php-myadmin
http://localhost:8082 - phpMyAdmin для просмотра состояния бд 
Пользователь: root
Пароль: root

city-service-app
http://localhost:8084/swagger-ui.html#! - Rest-API для выполнения crud-операций с бд

mysql-db2 - MySQL бд для хранения информации о городах
Логин: root
Пароль: root

TelegramBot: 
Имя: GuideBot
Имя пользователя: @guide_bot
Токен: 1291598720:AAEDgB-q0zb6yQp_H6xi9B3TLIGKnSPYAHU

Команды:
/start                          - приветственное сообщение
/help                           - вывод списка команд
/getguide Название_города       - вывод информации о городе, если город отсутствует в бд - ничего не возвращает

