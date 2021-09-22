package org.generation.WebProject.repository.entity;

import org.generation.WebProject.controller.dto.ItemDTO;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


//Repository is the Model layer
//JPA (Java Persistence API) maps Java Objects(Class) to the database tables
//This concept is known as ORM (Object Relational Mapping)
//Item is an entity that will be use to map with the Item table in the database.
//e.g. if you have a category table, then you will need to create another entity(category) class
// for category, need to create autogenerate id too??

@Entity
public class Item {

    //Database Table - Columns are the attributes of the class
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String description;
    private String imageUrl;
    private String style;
    private double price;

    public Item() {}

    //Task 9
    public Item(ItemDTO itemDto)    //Data Transfer Object item
    {
        this.name = itemDto.getName();
        this.description = itemDto.getDescription();
        this.imageUrl = itemDto.getImageUrl();
        this.style = itemDto.getStyle();
        this.price = itemDto.getPrice();
    }

    public Integer getId() {return id;}

    public void setId( Integer id) { this.id = id;}

    public String getName() { return name;}

    public void setName(String name) { this.name = name;}

    public String getDescription() { return description;}

    public void setDescription(String description) { this.description = description;}

    public String getImageUrl()
    {
        return "/productImages/" + imageUrl;
    }

    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl;}

    public String getStyle() {return style;}

    public void setStyle(String style) {this.style = style;}

    public double getPrice() {return price;}

    public void setPrice(double price) {this.price = price;}

    @Override
    public String toString()
    {
        return "Item{" + id + ", name='" + name +'\'' + ", description='" + description + '\'' + ", imageUrl='" + imageUrl + '\'' + ",style='" + style + '\'' + ", price='" + price + '}';

    }

}
