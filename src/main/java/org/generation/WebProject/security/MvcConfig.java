package org.generation.WebProject.security;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.resource.PathResourceResolver;

import java.nio.file.*;


@Configuration
public class MvcConfig implements WebMvcConfigurer{
    //WebMVCConfigurer is an interface ( so use implements)
    //To configure Spring MVC and setup view controllers to expose these templates and static folder
    //HTMLs, CSSS/Images/JS folders
    public void addViewControllers(ViewControllerRegistry registry) {
        //Map the browser's URL to a specific View (HTML) inside resources/templates directory
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/aboutus").setViewName("aboutus");
        registry.addViewController("/products").setViewName("products");
        registry.addViewController("/productform").setViewName("productform");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/logout").setViewName("index");

    }

    //@Value means retrieve any value at this path image.folder
    // the path to the images folder
    //registered in application.properties. image.folder = productImages/images
    @Value("${image.folder}")
    //assigned the @Value (value) to the String imageFolder
    private String imageFolder;

    @Override
    //exposed the directory in /static to clients
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static")
                .addResourceLocations("classpath:/static/")
                .setCachePeriod(0);

        exposeDirectory(registry);
    }


    private void exposeDirectory(ResourceHandlerRegistry registry) {

        Path uploadDir = Paths.get(imageFolder);

        //Returns the absolute pathname of the given file to expose its location.
        String uploadPath = uploadDir.toFile().getAbsolutePath();
        System.out.println(uploadPath);

        registry.addResourceHandler("/" + imageFolder + "/**")
                .addResourceLocations("file:" + uploadPath + "/")
                .setCachePeriod(0)      //no caching
                .resourceChain(true)
                .addResolver(new PathResourceResolver());
    }

}

