package ru.otus.jdbc.mapper;

import ru.otus.annotation.Id;
import ru.otus.exeption.RefflectionJdbcExeption;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.List;
import java.util.stream.Stream;

public class EntityClassMetaDataImpl<T> implements EntityClassMetaData<T> {
    private final Class<T> clazz;
    private Constructor<T> constructor;

    private Field id;
    private List<Field> fields;
    private List<Field> fieldsWithoutId;

    public EntityClassMetaDataImpl(Class<T> clazz) {
        this.clazz = clazz;
    }

    @Override
    public String getName() {
        return clazz.getSimpleName().toLowerCase();
    }

    @Override
    public Constructor<T> getConstructor() throws NoSuchMethodException {
        if (constructor == null) {
            constructor = clazz.getConstructor();
        }
        return constructor;
    }

    @Override
    public Field getIdField() {
        if (id == null) {
            id = Stream.of(clazz.getDeclaredFields())
                    .filter(field -> field.isAnnotationPresent(Id.class))
                    .findFirst()
                    .orElseThrow(()-> new RefflectionJdbcExeption("Field with annotation @Id not present in class: " + clazz.getName()));
        }
        return id;
    }

    @Override
    public List<Field> getAllFields() {
        if (fields == null) {
            fields = List.of(clazz.getDeclaredFields());
        }
        return fields;
    }

    @Override
    public List<Field> getFieldsWithoutId() {
        if (fieldsWithoutId == null) {
            fieldsWithoutId = getAllFields()
                    .stream()
                    .filter(field -> !field.equals(getIdField()))
                    .toList();
        }
        return fieldsWithoutId;
    }
}