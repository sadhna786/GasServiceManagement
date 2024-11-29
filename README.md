# Gas Service Management

## Project Overview
The **Gas Service Management** project is a Spring Boot application that allows gas utility companies to manage service requests from customers. The application handles requests for various types of issues such as gas meter malfunctions, service disruptions, and other gas-related concerns. It integrates with a MySQL database to store service request data and provides a set of RESTful APIs for CRUD operations on these requests.

## Features
- **Create a Service Request**: Allows customers to submit service requests for various issues.
- **Update Service Request Status**: Provides functionality to update the status of service requests (e.g., from "Pending" to "Resolved").
- **Delete Service Request**: Ability to delete service requests when no longer needed.
- **Get Service Requests by Customer**: Fetches all service requests associated with a specific customer ID.
- **Get All Service Requests**: Retrieves all service requests stored in the system.

## Tech Stack
- **Backend**: Spring Boot
- **Database**: MySQL
- **Testing**: Postman for API testing

## Setup Instructions

### Prerequisites
- Java 17 or higher
- MySQL Server
- Maven

### Steps to Run Locally

1. Clone the repository:

   ```bash
   git clone https://github.com/yourusername/gas-service-management.git
