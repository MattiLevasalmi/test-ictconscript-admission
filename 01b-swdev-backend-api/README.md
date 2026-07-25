# 01b-swdev-backend-api

A simple api for the Unit Logbook assignment. Endpoints exist to fetch entries and insert entries to the SQLite database

- GET `/health` returns 200 'OK'
- GET `/entries` fetches all entries
- GET `/entries/{id}` fetches entry by id
- POST `/entries` adds new entry to database

## Render Deployment
Base URL: https://unit-logbook-api.onrender.com
Swagger Documentation: https://unit-logbook-api.onrender.com/swagger-ui.html

## Tech stack
- Java
- Springboot
- SQLite

## Run locally
```bash
cd unit-logbook
docker compose up
```

