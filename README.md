# Программа банковской системы

В программе реализованы сущности для пользователя, банковского счета и истории транзакций.

Используется Java / Maven / Spring Boot.
База данных - postgresql.

## Запуск:

* Необходимо клонировать данный репозиторий
* Создать базу данных
* Выполнить запуск AstonHomeworkBankApplication


## Основные эндпоинты:
 * http://localhost:8080/api/v1/accounts
 * http://localhost:8080/api/v1/clients
 * http://localhost:8080/api/v1/transactionHistory

## Примеры запросов:
Для работы с клиентами:
```
GET http://localhost:8080/api/v1/clients/{{clientId}}
```
```
POST http://localhost:8080/api/v1/clients

Content-Type: application/json

{
  "clientId": 0,
  "clientName": ""
}
```
Для работы с банковскими счетами:
```
GET http://localhost:8080/api/v1/accounts/{{accountId}}
```
```
POST http://localhost:8080/api/v1/accounts
Content-Type: application/json

{
  "accountId": 0,
  "client": {},
  "accountPassword": "",
  "balanceOnAccount": 0,
  "accountNumber": ""
}
```
```
POST http://localhost:8080/api/v1/accounts/{{accountId}}/deposit
Content-Type: application/json
```
```
POST http://localhost:8080/api/v1/accounts/{{accountId}}/transfer
Content-Type: application/json
```

```
POST http://localhost:8080/api/v1/accounts/{{accountId}}/withdraw
Content-Type: application/json

```

Для работы с историей транзакций:
```
GET http://localhost:8080/api/v1/transactionHistory/{{transactionHistoryId}}
```
```
POST http://localhost:8080/api/v1/transactionHistory
Content-Type: application/json

{
  "transactionHistoryId": 0,
  "account": {},
  "transactionType": "DEPOSIT",
  "amount": 0
} 
```
