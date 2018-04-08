package com.toxin.springboot.controller;

import com.toxin.springboot.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class ImageController {

    @Autowired
    private ImageService imageService;

}
