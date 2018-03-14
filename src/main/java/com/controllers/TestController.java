package com.controllers;

import com.beans.Cont;
import com.beans.Musician;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class TestController {

    private static int i = 0;
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/hi")
    public Musician musician(@RequestParam(value = "name", defaultValue = "Jared") String name) {
        return new Musician(counter.incrementAndGet(), String.format(template, name));
    }

    @RequestMapping(value = "/getAll", produces = "application/json")
    public List<Cont> getAll() {
        List<Cont> all;
        all = addTree(new File("/home/efixty/Desktop/"));
        return all;
    }

    @RequestMapping("/test")
    public ArrayList getTest() {
        return new ArrayList<>();
    }

    private List<Cont> addTree(File file) {
        List<Cont> all = new ArrayList<>();
        File[] children = file.listFiles();
        if (children != null) {
            for (File child : children) {
                all.add(new Cont("folder", file.getName(), file.getAbsolutePath(), addTree(child)));
            }
        } else all.add(new Cont("file", file.getName(), file.getAbsolutePath(), new ArrayList<>()));
        return all;
    }
}
