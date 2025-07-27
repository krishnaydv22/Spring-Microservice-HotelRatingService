## 🏨 Hotel Rating Microservice App
This is a Spring Boot microservices-based application that demonstrates a hotel rating platform using service-to-service communication with RestTemplate, Eureka for service discovery, and Spring Cloud components.<br>
It is built using a microservice architecture pattern, ensuring scalability and modular design.

## 🔧 Services Included
**🧑‍💼 User Service**
Create and fetch users <br>

Each user can have multiple ratings associated <br>

Communicates with Rating Service and Hotel Service using RestTemplate <br>

Uses Rate Limiter and Circuit Breaker from Resilience4j <br>

**⭐ Rating Service**
Handles rating creation and retrieval <br>

Get all ratings <br>

Get ratings by user ID or hotel ID <br>

**🏨 Hotel Service**
Create and fetch hotel details <br>

Fetch all hotels <br>

Used by the Rating and User Service to fetch hotel info <br>

**🧭 Service Registry (Eureka Server)**
Acts as the central registry for all services <br>

Allows dynamic registration and discovery of services <br>

**🚪 API Gateway**
Single entry point for all services <br>

Handles routing, security, logging, and rate limiting <br>

**🔗 Communication**
All service-to-service communication is handled using:

RestTemplate with Eureka-based service discovery <br>

Logical service names instead of static URLs (e.g., http://HOTEL-SERVICE/hotels) <br>

**💡 Features**
Microservices architecture <br>

Spring Boot-based services <br>

Eureka Server for service discovery <br>

Resilience4j for fault tolerance <br>

REST APIs for each service <br>

Clean separation of concerns between services <br>




**Order of Startup:**
1.Eureka Server

2.Hotel Service

3.Rating Service

4.User Service

5.API Gateway

