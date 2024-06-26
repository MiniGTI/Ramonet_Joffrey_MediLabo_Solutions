/**
 * Microservice-backend-assessor.
 * This is the microservice that perform the risk calculation.
 * Require data from microservice-backend-patient and microservice-backend-note.
 * <p>
 * The application.properties is stored in an external repository managed by the microservice-configuration-server.
 * This makes it possible to modify the configuration without reboot the microservice.
 * DiscoveryService by the microservice-eureka
 * </p>
 */