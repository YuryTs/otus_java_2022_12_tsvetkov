package ru.otus.crm.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceCreator;
import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Embedded;
import org.springframework.data.relational.core.mapping.Table;

import static org.springframework.data.relational.core.mapping.Embedded.OnEmpty.USE_EMPTY;

@Table("table_with_pk")
public class TableWithPk implements Persistable<TableWithPk.Pk> {

    @Id
    @Embedded(onEmpty = USE_EMPTY) //Аннотация для настройки объекта значения, встроенного в текущую таблицу.
    //В зависимости от значения onEmpty() для свойства устанавливается значение
    // null или пустой экземпляр в случае, если все встроенные значения имеют значение null
    // при чтении из набора результатов.
    private final Pk pk; //сложный ключ для которого используем reecord

    private final String value;

    @Transient
    private final boolean isNew;

    @PersistenceCreator
    public TableWithPk(Pk pk, String value) {
        this(pk, value, false);
    }

    public TableWithPk(Pk pk, String value, boolean isNew) {
        this.pk = pk;
        this.value = value;
        this.isNew = isNew;
    }

    @Override
    public Pk getId() {
        return pk;
    }

    @Override
    public boolean isNew() {
        return isNew;
    }

    public Pk getPk() {
        return pk;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "TableWithPk{" +
                "pk=" + pk +
                ", value='" + value + '\'' +
                ", isNew=" + isNew +
                '}';
    }

    public record Pk(String idPart1, String idPart2) {
    }
}
