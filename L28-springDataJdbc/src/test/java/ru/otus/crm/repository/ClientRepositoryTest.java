package ru.otus.crm.repository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import ru.otus.crm.model.Client;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

@ExtendWith(SpringExtension.class)
@Sql("classpath:db.scripts/test-scripts.sql")
@ActiveProfile(name = "test")

class ClientRepositoryTest {

    @Autowired
    private final ClientRepository clientRepository;

    ClientRepositoryTest(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Test
    void findByNameTest() {
        Optional<Client> name = clientRepository.findByName("name1");
        assertThat(name).isPresent();
        List<Client> clientList = clientRepository.findAll();
        assertEquals("name", clientList.get(0).getName());
    }

    @Test
    void findByNameAndManadgerId() {
    }

    @Test
    void findByNameIgnoreCase() {
    }

    @Test
    void updateName() {
    }
}