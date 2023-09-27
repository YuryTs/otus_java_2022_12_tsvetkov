package ru.otus.crm.repository;

import org.junit.ClassRule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Testcontainers;
import ru.otus.DbServiceDemo;
import ru.otus.crm.AbstractIntegrationTest;

@Testcontainers
@ExtendWith(SpringExtension.class)
@Sql("classpath:db.scripts/test-scripts.sql")
@ActiveProfiles
@SpringBootTest(classes = DbServiceDemo.class)
@RunWith(SpringRunner.class)
class ClientRepositoryTest extends AbstractIntegrationTest {

    @ClassRule
    public static PostgreSQLContainer postgreSQLContainer = CustomPostgreSQLContainer.getInstance();

    @Autowired
    ClientRepository clientRepository;

    ClientRepositoryTest(ClientRepository clientRepository){
        this.clientRepository = clientRepository;
    }


    @Test
    void findByName() {
    }

    @Test
    void findByNameIgnoreCase() {
    }

    @Test
    void updateName() {
    }
}