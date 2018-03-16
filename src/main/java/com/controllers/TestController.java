package com.controllers;

import com.beans.Node;
import com.beans.services.TestService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.nio.file.Paths;


@RestController
public class TestController {

    @RequestMapping(value = "/getAll", produces = "application/json")
    public Node getAll() {
        Node root = new TestService().addNode(Paths.get(System.getProperty("user.home"), File.separator, "Desktop", File.separator, "LCf5xNYt_DockerfortheAbsoluteBeginnerHandsOn"));
        return root;
    }
}
