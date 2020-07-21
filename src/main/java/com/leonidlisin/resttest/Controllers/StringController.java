package com.leonidlisin.resttest.Controllers;

import com.leonidlisin.resttest.services.GetService;
import com.leonidlisin.resttest.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StringController {

    private PostService postService;
    private GetService getService;

    @Autowired
    public void setPostSevice(PostService postService){
        this.postService = postService;
    }

    @Autowired
    public void setGetSevice(GetService getService){
        this.getService = getService;
    }

    @PostMapping(path = "post", consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<String> getStrings(@RequestBody List<String> strings){
        return postService.getFormattedStrings(strings);
    }

    @GetMapping(path = "get/{param}")
    public String getStrings(@PathVariable(value = "param") String s){
        return getService.getFormattedMonth(s);
    }
    
}
