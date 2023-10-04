package ru.otus.crm.repository;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import ru.otus.DbServiceDemo;
import ru.otus.crm.model.Client;
import ru.otus.crm.model.ClientDetails;
import ru.otus.crm.model.Manager;
import ru.otus.crm.service.DBServiceClient;
import ru.otus.crm.service.DBServiceManager;
import ru.otus.crm.service.DbServiceClientImpl;
import ru.otus.crm.service.DbServiceManagerImpl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;


@Testcontainers
@ExtendWith(SpringExtension.class)
@Sql({"classpath:db.scripts/test-scripts.sql"})
@ActiveProfiles("test")
@SpringBootTest(classes = DbServiceDemo.class)
class ClientRepositoryTest {

    private static final Logger logger = LoggerFactory.getLogger(ClientRepositoryTest.class);
    private static final String IMAGE_VERSION = "postgres:13";

    @Container
    public static final PostgreSQLContainer container = new PostgreSQLContainer<>(IMAGE_VERSION);

    @Autowired
    ClientRepository clientRepository;
    @Autowired
    DBServiceClient dbServiceClient;
    @Autowired
    DBServiceManager dbServiceManager;


    @BeforeAll
    static void runContainer(){
        container.start();
        System.setProperty("DB_URL", container.getJdbcUrl());
        System.setProperty("DB_USERNAME", container.getUsername());
        System.setProperty("DB_PASSWORD", container.getPassword());
    }

    @DynamicPropertySource
    static void postgresProperty(DynamicPropertyRegistry registry){
        registry.add("spring.datasource.url",  container::getJdbcUrl);
        registry.add("spring.datasource.username", container::getUsername);
        registry.add("spring.datasource.password", container::getPassword);
    }

    @Test
    @Transactional
    void findByNameTest() {
//        Manager manager = dbServiceManager.saveManager(new Manager("Ziga", "ManagerZigaLabel",
//                Set.of(new Client("Client1", "Ziga", 1, new ClientDetails("infjrmationClient1")),
//                        new Client("Client2", "Ziga", 2, new ClientDetails("infjrmationClient2"))),
//                new ArrayList<>(), true));
//        var client = dbServiceClient.saveClient(
//                new Client("ClientCret" + System.currentTimeMillis(), manager.getId(), 1,
//                        new ClientDetails("init1")));
//        Optional<Client> clientFounded = clientRepository.findById(1L);
//        System.out.println(clientFounded.get().getName());
    }

    @Test
//    @Transactional
    void findByNameIgnoreCase() {
    }

    @Test
//    @Transactional
    void updateName() {
    }
}