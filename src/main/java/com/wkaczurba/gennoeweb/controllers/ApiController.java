package com.wkaczurba.gennoeweb.controllers;

import com.wkaczurba.text.RandomText;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.print.attribute.standard.Media;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8;

@RestController
@RequestMapping("/api")
public class ApiController {

    @Data
    @AllArgsConstructor
    public static class GeneratedValue {
        public String value;
    }

    RandomText randomText;

    @Autowired
    public ApiController(RandomText randomText) {
        this.randomText = randomText;
    }

    @RequestMapping(value="/generate", method= RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE )
    public GeneratedValue requestMapping() {
        char[] result = randomText.getRandomChars();

        return new GeneratedValue(new String(result));
//        return randomText.getRandomChars();
    }

    // For POST-items you can use: @CrossOrigin

}
