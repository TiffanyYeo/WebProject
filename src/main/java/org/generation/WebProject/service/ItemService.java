package org.generation.WebProject.service;

import org.generation.WebProject.repository.entity.*;
import java.util.List;

public interface ItemService {
    // interface is a completely"abstract class" that is used to group related methods with empty bodies.
    //Create methods/actions that you want to do with the item
    //Controller layer will call the respective methods to perform the necessary task that is requested by the client
    // (from browser)
    Item save (Item item);  //save the item into the database

    void delete (int itemId);   //delete item from database

    List<Item> all();   //return all product items to user

    Item findById (int itemId);     //find a particular item



}
