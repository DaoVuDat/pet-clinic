package com.example.petclinic.service.map;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// this is like a memory-based state, more like be in Database
public abstract class AbstractMapService<Type, ID> {

    protected Map<ID, Type> map = new HashMap<>();

    Set<Type> findAll() {
        return new HashSet<>(map.values());
    }

    Type findById(ID id) {
        return map.get(id);
    }

    Type save(ID id, Type object) {
        map.put(id, object);
        return object;
    }

    void deleteById(ID id) {
        map.remove(id);
    }

    void delete(Type object) {
        map.entrySet().removeIf(entry -> entry.getValue().equals(object));
    }
}
