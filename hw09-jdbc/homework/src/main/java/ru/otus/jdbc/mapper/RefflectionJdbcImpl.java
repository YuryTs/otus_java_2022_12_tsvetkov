package ru.otus.jdbc.mapper;

import ru.otus.exeption.RefflectionJdbcExeption;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class RefflectionJdbcImpl<T> implements RefflectionJdbc<T> {
    private final EntityClassMetaData<T> entityClassMetaData;

    public RefflectionJdbcImpl(EntityClassMetaData<T> entityClassMetaData) {
        this.entityClassMetaData = entityClassMetaData;
    }

    @Override
    public T createObject(ResultSet resultSet) {
        List<T> allObjects = getAllObjects(resultSet);
        return allObjects.isEmpty() ? null : allObjects.get(0);
    }

    @Override
    public List<T> getAllObjects(ResultSet resultSet) {
        var listObjects = new ArrayList<T>();
        try {
            while (resultSet.next()) {
                Constructor<T> constructor = entityClassMetaData.getConstructor();
                T obj = constructor.newInstance();
                for (Field field : entityClassMetaData.getAllFields()) {
                    field.setAccessible(true);
                    field.set(obj, resultSet.getObject(field.getName()));
                }
                listObjects.add(obj);
            }
        } catch (Exception e) {
            throw new RefflectionJdbcExeption("Error when create object", e);
        }
        return listObjects;
    }

    @Override
    public List<Object> getValuesWithoutId(T type) {
        List<Object> values = new ArrayList<>();
        List<Field> fieldsWithoutId = entityClassMetaData.getFieldsWithoutId();
        for (Field field : fieldsWithoutId) {
            values.add(getValue(field, type));
        }
        return values;
    }

    @Override
    public List<Object> getAllValues(T type) {
        List<Object> values = new ArrayList<>();
        List<Field> fieldsWithoutId = entityClassMetaData.getFieldsWithoutId();
        for (Field field : fieldsWithoutId) {
            values.add(getValue(field, type));
        }
        values.add(getValue(entityClassMetaData.getIdField(), type));
        return values;
    }

    private Object getValue(Field field, T type) {
        field.setAccessible(true);
        try {
            return field.get(type);
        } catch (IllegalAccessException e) {
            throw new RefflectionJdbcExeption("Error when get value in field", e);
        }
    }
}