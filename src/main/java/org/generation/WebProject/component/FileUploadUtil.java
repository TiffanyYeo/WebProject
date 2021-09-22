package org.generation.WebProject.component;

import org.springframework.web.multipart.*;

import java.io.IOException;
import java.io.*;
import java.nio.file.*;

public class FileUploadUtil {

    //this class is only to save the uploaded image file through the MultipartFile object to a file in the file system.

    public static void saveFile(String uploadDir1, String fileName, MultipartFile multipartFile) throws IOException     //saveFile method, multipartFile is the actual file to upload.
    {
        Path uploadPath1 = Paths.get(uploadDir1);
        //convert the String uploadDir1 (the path)into a real Path.
        //for Path, e.g. directory : productImages/images/ - string convert to a Path

        try (InputStream inputStream = multipartFile.getInputStream()) {
            //getInputStream() method to read the byte from multipartFile object
            // Then we will need to create a file and OutputStream to write the content



            Path filePath1 = uploadPath1.resolve(fileName);
            //fileName : T-shirtNew.jpg - convert into a path
            //productImage/images/T-shirtNew.jpg

            Files.copy(inputStream, filePath1, StandardCopyOption.REPLACE_EXISTING);
            //copy inputStream into filePath1 - copy a file to a target file
        }

        catch (IOException ioe) {
            throw new IOException("Could not save image file: " + fileName, ioe);
        }
    }

}
