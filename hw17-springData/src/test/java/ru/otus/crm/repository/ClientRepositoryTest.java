package ru.otus.crm.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.testcontainers.junit.jupiter.Testcontainers;
import ru.otus.crm.AbstractIntegrationTest;

@Testcontainers
@ExtendWith(SpringExtension.class)
@Sql("classpath:db.scripts/test-scripts.sql")
@ActiveProfiles
class ClientRepositoryTest extends AbstractIntegrationTest {

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