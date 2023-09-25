package cvetkov.example.crm;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testcontainers.containers.PostgreSQLContainer;


public class PostgresTestContainerConfig {

    private static final Logger logger = LoggerFactory.getLogger(PostgresTestContainerConfig.class);

    public static class CustomPostgreSQLContainer extends PostgreSQLContainer<CustomPostgreSQLContainer> {

        private static CustomPostgreSQLContainer container;

        private static final String IMAGE_VERSION = "postgres:13";

        public CustomPostgreSQLContainer() {
            super(IMAGE_VERSION);
        }

        public static CustomPostgreSQLContainer getInstance() {
            if (container == null) {
                container = new CustomPostgreSQLContainer();
            }
            return container;
        }


        @Override
        public void start() {
            super.start();
            var url = container.getJdbcUrl() + "&stringtype=unspecified";
            System.setProperty("jdbc:postgresql://localhost:5430/demoDB", container.getJdbcUrl());
            System.setProperty("usr", container.getUsername());
            System.setProperty("pwd", container.getPassword());

            logger.info("postgres in docker started: url={}", url);
        }

        @Override
        public void stop() {
            super.stop();
        }
    }
}
