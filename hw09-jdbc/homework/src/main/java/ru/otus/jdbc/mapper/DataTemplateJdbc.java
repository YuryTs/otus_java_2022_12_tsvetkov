package ru.otus.jdbc.mapper;

import ru.otus.core.repository.DataTemplate;
import ru.otus.core.repository.executor.DbExecutor;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * Сохратяет объект в базу, читает объект из базы
 */
public class DataTemplateJdbc<T> implements DataTemplate<T> {

    private final DbExecutor dbExecutor;
    private final EntitySQLMetaData<T> entitySQLMetaData;
    private final RefflectionJdbc<T> refflectionJdbc;

    public DataTemplateJdbc(DbExecutor dbExecutor, EntitySQLMetaData<T> entitySQLMetaData, RefflectionJdbc refflectionJdbc) {
        this.dbExecutor = dbExecutor;
        this.entitySQLMetaData = entitySQLMetaData;
        this.refflectionJdbc = refflectionJdbc;
    }

    @Override
    public Optional<T> findById(Connection connection, long id) {
        String query = entitySQLMetaData.getSelectByIdSql();
        return dbExecutor.executeSelect(connection, query, List.of(id), refflectionJdbc::createObject);
    }

    @Override
    public List<T> findAll(Connection connection) {
        String query = entitySQLMetaData.getSelectAllSql();
        return dbExecutor.executeSelect(connection, query, Collections.emptyList(), refflectionJdbc::getAllObjects).orElse(new ArrayList<>());
    }

    @Override
    public long insert(Connection connection, T client) {
        List<Object> values =refflectionJdbc.getValuesWithoutId(client);
        String query = entitySQLMetaData.getInsertSql();
        return dbExecutor.executeStatement(connection, query, values);
    }

    @Override
    public void update(Connection connection, T client) {
       List<Object> values = refflectionJdbc.getAllValues(client);
       String query = entitySQLMetaData.getUpdateSql();
       dbExecutor.executeStatement(connection, query, values);
    }
}
