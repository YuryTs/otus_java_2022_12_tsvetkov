package ru.otus.crm.repository;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;
import ru.otus.crm.model.Client;

import java.util.Optional;


public interface ClientRepository extends ListCrudRepository<Client, Long> {//ListCrudRepository круче чем CrudRepository так как он дает возможность работать с коллекцией

    //если это все эти метожы закоментировать и можем использовать все методы которые есть в ListCrudRepository CrudRepository

    //а  здесь уже дописать кастомные методы которые нам необходимы
    Optional<Client> findByName(String name); //например поиск не только по id но и по имени

    Optional<Client> findByNameAndManadgerId(String name, String managerId);

    //если получается очень большое имя то можно использовать аннотацию @Query и в ней прописать чуть ли не нативный запрос с параметрами
    @Query("select * from client where upper(name) = upper(:name)")
    Optional<Client> findByNameIgnoreCase(@Param("name") String name);

    @Modifying //означает что ничего не возвращается
    @Query("update client set name = :newName where id = :id")
    void updateName(@Param("id") long id, @Param("newName") String newName);
}
