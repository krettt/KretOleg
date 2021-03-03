package com.ui;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import parseJsonClass.Standing;


import java.io.File;
import java.io.IOException;
import java.util.List;
public class JacksonRunner {
    public static void main(String[] args) throws IOException {

        ObjectMapper mapper = new ObjectMapper();
//        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        List <Standing> standing = mapper.readValue(new File("standing.json"), new TypeReference<List<Standing>>() {});


           System.out.println(standing);


    }

}
