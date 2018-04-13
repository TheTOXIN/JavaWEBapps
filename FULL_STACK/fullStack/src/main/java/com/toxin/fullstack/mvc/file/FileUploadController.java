package com.toxin.fullstack.mvc.file;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

@Controller
public class FileUploadController {

    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
    public @ResponseBody String handleFileUpload(@RequestParam("file")MultipartFile file) {
        if (!file.isEmpty()) {
            try {
                byte[] bytes = file.getBytes();

                String rootPath = System.getProperty("catalina.home");
                String path = rootPath  + File.separator + file.getOriginalFilename();

                System.out.println("Server rootPath : " + rootPath);
                System.out.println("File name : " + file.getOriginalFilename());
                System.out.println("File type : " + file.getContentType());

                File newFile = new File(path);

                BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(newFile));
                stream.write(bytes);
                stream.close();

                System.out.println("File is saved under:" + path);

                return "File is save under:" + path;
            } catch (Exception e) {
                e.printStackTrace();
                return "File upload filed";
            }
        } else {
            return "File is empty...";
        }
    }

}
