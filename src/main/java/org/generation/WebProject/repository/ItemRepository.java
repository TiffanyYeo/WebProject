package org.generation.WebProject.repository;

import org.generation.WebProject.repository.entity.*;
import org.springframework.data.repository.CrudRepository;

// This will be AUTO IMPLEMENTED by Spring
// CRUD refers Create, Read, Update, Delete
public interface ItemRepository extends CrudRepository<Item, Integer>

{
}

//ItemRepository extends CrudRepository Class and it is able to access the methods that is available in the
// CrudRepository Class.

