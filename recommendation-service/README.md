# Recommendation service

Spring Boot service for the recommendation API from STEP-1.

## Run

Requirements: Java 17, MongoDB on `localhost:27017`, and Eureka on `localhost:8761`.

```bash
gradle bootRun
```

Configuration overrides:

- `MONGODB_URI`: MongoDB connection string
- `EUREKA_URL`: Eureka base URL

The service listens on port `7002` and registers as `recommendation` in Eureka.

## Endpoints

- `POST /recommendation`
- `GET /recommendation?productId=1`
- `DELETE /recommendation?productId=1`

The public JSON field is `rate`; MongoDB stores the value as `rating`. Invalid product IDs (`productId < 1`) return HTTP 422. A product with no recommendations returns HTTP 200 with `[]`.
