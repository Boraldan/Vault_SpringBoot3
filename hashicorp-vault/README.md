#  Тестовый стенд: HashiCorp Vault + VAULT_TOKEN 
 
##  Состав стенда

С помощью `docker-compose` разворачиваются 3 сервиса:

- `vault_prod` — Vault-сервер, запущенный в `dev`-режиме (без TLS, для локального теста).
- `postgres_task_vault` — база данных PostgreSQL с тестовыми данными.
- `vault_app` — Spring Boot приложение, получающее конфигурации и секреты из Vault.

##  Основные особенности

- Использование `Vault` в качестве централизованного хранилища конфигураций.
- Авторизация через токен (`VAULT_TOKEN`) для доступа к секретам в `secret/postgres`.
- Получение настроек базы данных через Spring Cloud Vault.
- Конфигурация `Vault` читается на старте приложения (`config.import: vault://`).
- Пример настройки Liquibase для управления схемой БД.
- Базовая демонстрация взаимодействия Spring Boot ↔ Vault ↔ PostgreSQL.

##  Стек технологий

- **Spring Boot** 3.x
- **Spring Cloud Vault**
- **PostgreSQL**
- **Vault** 1.19.4
- **Docker Compose**
- **Liquibase**
