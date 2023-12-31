package com.javaspringlabo.monproject.health;

import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health;
import org.springframework.stereotype.Component;

@Component
public class CustomHealthIndicator extends AbstractHealthIndicator {

    /*
    Method to add custom health checks/code
    http://localhost:8080/actuator/health
     */
    @Override
    protected void doHealthCheck(Health.Builder builder) throws Exception {
        // You can use the builder to display status details
        builder.up()
                .withDetail("Service", "Running")
                .withDetail("Error", "No Error- Healthy status");
    }
}