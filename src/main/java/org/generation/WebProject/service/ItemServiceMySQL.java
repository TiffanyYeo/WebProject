package org.generation.WebProject.service;

import org.generation.WebProject.repository.ItemRepository;
import org.generation.WebProject.repository.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

// implement the ItemService to allow controller to use the methods in ItemService

@Service
public class ItemServiceMySQL implements ItemService {

    private final ItemRepository itemRepository; // final - will not change. Create an object itemRepository from
    // CrudRepository in Interface ItemRepository

    //constructor
    public ItemServiceMySQL(@Autowired ItemRepository itemRepository) //@Autowired - to link
    {
        this.itemRepository = itemRepository;
    }

    @Override
    //this save method is in the service layer and will be called by the controller.
    public Item save (Item item)
    {
        //save an item into the database
        //perform the action CRUD - Create (new item) or Update(existing item)
        return this.itemRepository.save(item); //use the save(S entity) method in interface CrudRepository
    }

    @Override
    //this delete method is in the service layer and will be called by the controller.
    public void delete (int itemId)
    {
        this.itemRepository.deleteById(itemId);
    }

    @Override
    public List<Item> all ()
    {
        List<Item> result = new ArrayList<>(); //create an instance result of type ArrayList
        this.itemRepository.findAll().forEach(result::add); //forEach loop to add to result arraylist
        return result; //in a form of List - ArrayList
    }

    @Override
    public Item findById (int itemId)
    {
        //using Optional to identify this item that returns back might be a 'null'
        Optional<Item> item = this.itemRepository.findById(itemId);
        Item itemResponse = item.get();     //Create an object itemResponse to hold the get item
        return itemResponse;
    }

}
