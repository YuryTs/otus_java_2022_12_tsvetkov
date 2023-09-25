package cvetkov.example.crm.repository;

import cvetkov.example.DbServiceDemo;
import cvetkov.example.crm.config.ContainersEnvironment;
import cvetkov.example.crm.model.Client;
import cvetkov.example.crm.model.ClientDetails;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(SpringExtension.class)
//@Sql("classpath:db.scripts/test-scripts.sql")
@ActiveProfiles("test")
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = DbServiceDemo.class)
class ClientRepositoryTest {

    @Autowired
    private ClientRepository clientRepository;

    Client checkClient = new Client("July", "25K", 3, new ClientDetails("smth"));

    ClientRepositoryTest(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Test
    public void findByName() {

        Optional<Client> client = clientRepository.findByName("July");
        assertEquals(checkClient, client);
    }

    @Test
    void findByNameIgnoreCase() {
    }

    @Test
    void updateName() {
    }
}