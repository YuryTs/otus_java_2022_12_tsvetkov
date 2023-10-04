package ru.otus.crm.model;

import jakarta.annotation.Nonnull;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceCreator;
import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import java.util.List;
import java.util.Set;

@Table("manager") //указывается наименование таблицы
public class Manager implements Persistable<String> {

    @Id
    @Nonnull
    private final String id;
    private final String label;

    //   @MappedCollection - аннотация для настройки мапинга List Set Map
    @MappedCollection(idColumn = "manager_id") //одна аннотация отношения на все случаи жизни
    private final Set<Client> clients;  //Set только должны быть уникальные клиенты и их не нужно сортировать

    @MappedCollection(idColumn = "manager_id", keyColumn= "order_column")
    private final List<Client> clientsOrdered; //List если важен порядок и сортировака и
    // обязательно нужно указывать по чему мы должны сортировать (keyColumn= "order_column")

    @Transient //не будет записываться в таблицу (функциональное поле)
    private final boolean isNew; //если тру (новая сущность) то мы ее записываем, если нет то апдейтим

    public Manager(String id, String label, Set<Client> clients, List<Client> clientsOrdered, boolean isNew) {
        this.id = id;
        this.label = label;
        this.clients = clients;
        this.clientsOrdered = clientsOrdered;
        this.isNew = isNew;
    }

    @PersistenceCreator //раньше назывался PersistenceConctructer
    private Manager(String id, String label, Set<Client> clients, List<Client> clientsOrdered) {
        this(id, label, clients, clientsOrdered, false);
    }

    @Override
    public boolean isNew() {
        return isNew;
    }

    @Override
    public String getId() {
        return id;
    }

    public String getLabel() {
        return label;
    }

    public Set<Client> getClients() {
        return clients;
    }

    public List<Client> getClientsOrdered() {
        return clientsOrdered;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "id='" + id + '\'' +
                ", label='" + label + '\'' +
                ", clients=" + clients +
                ", clientsOrdered=" + clientsOrdered +
                ", isNew=" + isNew +
                '}';
    }
}
