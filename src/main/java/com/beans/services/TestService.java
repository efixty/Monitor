package com.beans.services;

import com.beans.Node;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class TestService {

    public Node addNode(Path path) {
        Node parentNode = new Node(path);
        try {
            Files.walk(path, 1)
                    .skip(1)
                    .forEach(path1 -> {
                        Node childNode = new Node(path1);
                        parentNode.getChildren().add(addNode(path1));
                    });
        } catch (IOException e) {
            e.printStackTrace();
        }
        return parentNode;
    }

}
