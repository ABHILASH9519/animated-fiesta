# Local development and verification

This directory contains the Spring Boot application used by the repository's delivery pipeline.

## Prerequisites

- JDK 11
- Maven 3.6 or newer
- Docker only when building the container image

## Run locally

From this directory:

```bash
mvn test
mvn spring-boot:run
```

Open `http://localhost:8080/` for the Thymeleaf landing page. The lightweight health endpoint is `http://localhost:8080/healthz` and returns the plain-text response `ok` when the application context is serving requests.

## Build the artifact

```bash
mvn clean package
```

The configured Maven final name is `spring-boot-web.jar` under `target/`.

## Container build

```bash
docker build -t spring-boot-demo:local .
```

Run the image with an explicit port mapping:

```bash
docker run --rm -p 8080:8080 spring-boot-demo:local
```

The health endpoint is an application-level check; a successful container build alone does not prove that a Kubernetes rollout or external ingress is healthy.
