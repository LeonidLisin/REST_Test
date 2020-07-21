package com.leonidlisin.resttest.services;

import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostService {

    public List<String> getFormattedStrings(List<String> strings){
        return strings.stream()
                .map(s -> "(" + s.length() + "): "+ s)
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
    }

}
