package com.toxin.springboot.service;

import com.toxin.springboot.dao.ImageDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImageService {

    @Autowired
    private ImageDAO imageDAO;

}
