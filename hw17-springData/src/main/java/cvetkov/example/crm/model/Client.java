package cvetkov.example.crm.model;

import jakarta.annotation.Nonnull;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceCreator;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Objects;

@Table("client")
public class Client {

    @Id
    private final Long id;
    @Nonnull
    private final String name;

    @Nonnull
    private final String managerId;

    @Nonnull
    private final Integer orderColumn;

    @Nonnull
    @MappedCollection(idColumn = "client_id")
    private final ClientDetails clientDetails;

    public Client(String name, String managerId, int orderColumn, ClientDetails clientDetails) {
        this(null, name, managerId, orderColumn, clientDetails);
    }

    @PersistenceCreator
    public Client(Long id, String name, String managerId, int orderColumn, ClientDetails clientDetails) {
        this.id = id;
        this.name = name;
        this.managerId = managerId;
        this.orderColumn = orderColumn;
        this.clientDetails = clientDetails;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getManagerId() {
        return managerId;
    }

    public int getOrderColumn() {
        return orderColumn;
    }

    public ClientDetails getClientInfo() {
        return clientDetails;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", managerId='" + managerId + '\'' +
                ", orderColumn=" + orderColumn +
                ", clientInfo=" + clientDetails +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Client client)) return false;
        return Objects.equals(id, client.id) && Objects.equals(name, client.name) && Objects.equals(managerId, client.managerId) && Objects.equals(orderColumn, client.orderColumn) && Objects.equals(clientDetails, client.clientDetails);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, managerId, orderColumn, clientDetails);
    }
}
