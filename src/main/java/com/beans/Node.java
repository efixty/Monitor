package com.beans;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.io.File;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

@JsonPropertyOrder({"type", "uri", "children"})
public class Node {

    @JsonIgnore
    private Path path;

    @JsonProperty
    public String getUri() {
        return path.toFile().getAbsolutePath();
    }
    private FileType type;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<Node> children;


    public Node() {
        children = new ArrayList<>();
    }

    public Node(Path path) {
        this.type = path.toFile().isDirectory() ? FileType.DIRECTORY : FileType.FILE;
        this.path = path;
        if(type == FileType.DIRECTORY)children = new ArrayList<>();
    }

    public FileType getType() {
        return type;
    }

    public void setType(FileType type) {
        this.type = type;
    }

    public List<Node> getChildren() {
        return children;
    }

    public void setChildren(List<Node> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "Node{" +
                "path=" + path +
                ", type=" + type +
                ", children=" + children +
                '}';
    }
}
