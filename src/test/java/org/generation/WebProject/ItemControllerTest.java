//package org.generation.WebProject;
//
//import org.generation.WebProject.controller.ItemController;
//import org.generation.WebProject.service.ItemService;
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.TestInstance;
//import org.mockito.Mockito;
//import org.springframework.boot.test.context.SpringBootTest;
//
//@SpringBootTest
//@TestInstance( TestInstance.Lifecycle.PER_CLASS )
//public class ItemControllerTest {
//
//
//    //Test 3 methods from ItemController
//    //ItemController has a dependency on ItemService
//    //Mock the ItemServices to verify against the ItemController
//
//    ItemService itemService;
//    ItemController itemController;
//
//    @BeforeAll
//    public void setup()
//    {
//        itemService = Mockito.mock(ItemService.class);  // a dummy mock
//        itemController = new ItemController(itemService);
//    }
//
//    @Test   // test the getItem() method of itemController against the dependency method (itemService)
//    public void listItemService()
//    {
//        Mockito.reset(itemService);
//        itemController.getItems();
//        Mockito.verify(itemService).all();
//    }
//    @Test
//    public void findItemService()
//    {
//        Mockito.reset(itemService);
//        int id = 34;
//        itemController.findItemById(id);
//        Mockito.verify(itemService).findById(id);
//    }
//
//    @Test
//    public void deleteItemService()
//    {
//        Mockito.reset(itemService);
//        int id = 34;
//        itemController.delete(id);
//        Mockito.verify(itemService).delete(id);
//    }
//
//
//}
