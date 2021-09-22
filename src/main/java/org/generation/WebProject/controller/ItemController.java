package org.generation.WebProject.controller;

import org.generation.WebProject.component.FileUploadUtil;
import org.generation.WebProject.controller.dto.ItemDTO;
import org.generation.WebProject.repository.entity.Item;
import org.generation.WebProject.service.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/item")    // a naming "/item" is given

public class ItemController {

    final ItemService itemService;

    @Value("${image.folder}")
    private String imageFolder;  // the path to the images folder

    //constructor
    public ItemController(@Autowired ItemService itemService) {
        this.itemService = itemService;
    }

    @CrossOrigin
    //Cross-origin resource sharing (CORS) provides security to prohibit AJAX calls to the resources residing outside
    // the current origin.
    @GetMapping("/all") // a naming "/all" is given
    //GetMapping is the route that correspond to the HTTP GET method calls from the client.

    public Iterable<Item> getItems() {
        return itemService.all();   //calling a method all() in the service package - ItemService interface
    }

    @CrossOrigin
    @GetMapping("/{id}")
    public Item findItemById(@PathVariable Integer id) {
        return itemService.findById(id);
    }

    @CrossOrigin
    @DeleteMapping("/{id}") //  {id} entry of the id value (integer)
    public void delete(@PathVariable Integer id) {
        itemService.delete(id);
    }

    @CrossOrigin
    @PostMapping("/add")
    //@RequestParam method to pass the information received from the clients
    public Item save(@RequestParam(name = "name", required = true) String name,
                     @RequestParam(name = "description", required = true) String description,
                     @RequestParam(name = "imageUrl", required = true) String imageUrl,
                     //imageUrl is the image name, not the actual image file/object
                     //imageUrl = images/T-shirt5.png (it is a string)
                     @RequestParam(name = "style", required = true) String style,
                     @RequestParam(name = "price", required = true) double price,
                     @RequestParam("imagefile") MultipartFile multipartFile) throws IOException
                    //image conversion done here
    {

        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
        FileUploadUtil.saveFile(imageFolder, fileName, multipartFile);

        ItemDTO itemDto = new ItemDTO(name, description, imageUrl, style, price);
        return itemService.save(new Item(itemDto));
    }


}


