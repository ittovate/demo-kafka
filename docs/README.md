# Kafka Concepts Demo with Spring Boot and Spring Kafka

This project demonstrates basic Kafka concepts using Spring Boot and Spring Kafka. It includes setting up a Kafka broker and a Zookeeper instance using Docker Compose, along with a simple Spring Boot application that produces and consumes messages from a Kafka topic.

## Prerequisites

- **Java 21**
- **Apache Maven** for building the project
- **Kafka** and **Zookeeper** (Using Docker with the latest versions for both. You can find the Docker Compose file in `docker-compose.yaml` in the repository.)
  - This project uses Docker for both Kafka and Zookeeper. If you don't have Docker installed, refer to [Docker installation guide](https://docs.docker.com/engine/install/).

## Getting Started

**Note:** If you already have Kafka and Zookeeper installed on your machine, you can skip this part. For simplicity, you can use Docker and Docker Compose to get started quickly.

### Setting Up Kafka and Zookeeper

1. Ensure Docker is running on your machine.
2. Clone this repository.
3. Navigate to the project directory.
4. Start Kafka and Zookeeper using Docker Compose by running the following command:

   ```bash
   docker-compose up -d
   ```

You should see output similar to this:

![Screenshot](https://github.com/user-attachments/assets/a38e0b28-ff90-47b6-9c43-f5c42db2ff8f)

If you're using Docker Desktop on Windows, a similar message will confirm that both services have been created successfully.

## Running the Project

This project consists of two separate applications: **Producer** and **Consumer**.

### Building the Applications

You can either use your preferred IDE or Maven as the build tool. To build both projects:

1. Run `mvn install` inside the `producer` and `consumer` directories separately.
2. This will build and package each application as a JAR file in the `target` directory for each project.

### Running the Producer and Consumer

Once the applications are built, you can run the JAR files located in the `target` directories of the `producer` and `consumer` projects. You can either use the command line or your IDE to run the applications.

For example, to run the Producer:

```bash
java -jar target/producer-<version>.jar
```

## Kafka Producer Service

The Producer application exposes endpoints for producing both synchronous and asynchronous messages. It handles both String and JSON messages and uses Avro with a schema registry for serialization and deserialization.

### Endpoints

1. **String Message**

   - **Synchronous Message**

     ```bash
     GET http://localhost:8181/api/v1/orders/sync/{customerEmail}
     ```

     - Sends a synchronous message.
     - Simulates latency with a 5-second `Thread.sleep`.
     - Replace `{customerEmail}` with any dummy email address.

   - **Asynchronous Message**

     ```bash
     GET http://localhost:8181/api/v1/orders/async/{customerEmail}
     ```

     - Sends an asynchronous message.
     - Replace `{customerEmail}` with any dummy email address.

2. **JSON Message**

   - **Synchronous Message**

     ```bash
     POST http://localhost:8181/api/v1/profiles/sync
     Content-Type: application/json
     ```

     Request body:

     ```json
     {
       "name": "John Doe",
       "age": 30
     }
     ```

     - Sends a synchronous message with a JSON payload.

   - **Asynchronous Message**

     ```bash
     POST http://localhost:8181/api/v1/profiles/async
     Content-Type: application/json
     ```

     Request body:

     ```json
     {
       "name": "John Doe",
       "age": 30
     }
     ```

     - Sends an asynchronous message with a JSON payload.

3. **Avro Message**

   - **Synchronous Profile Message**

     ```bash
     POST http://localhost:8181/api/v1/profiles/sync/avro
     Content-Type: application/json
     ```

     Request body:

     ```json
     {
       "name": "John Doe",
       "age": 30
     }
     ```

     - Sends a synchronous message using Avro serialization with a schema registry.

   - **Synchronous Customer Email Message**

     ```bash
     POST http://localhost:8181/api/v1/orders/sync/avro
     Content-Type: application/json
     ```

     Request body:

     ```json
     {
       "customerEmail": "john.doe@example.com"
     }
     ```

     - Sends a synchronous message using Avro serialization with a schema registry.

---

This refactored version ensures clarity, improves formatting, and corrects minor typos and grammar. Let me know if you'd like further adjustments!