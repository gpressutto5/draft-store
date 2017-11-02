package uk.gov.hmcts.reform.draftstore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@EnableCircuitBreaker
public class DraftStoreApplication {

    public static final String BASE_PACKAGE_NAME = DraftStoreApplication.class.getPackage().getName();

    public static void main(String[] args) {
        SpringApplication.run(DraftStoreApplication.class, args);
    }
}
