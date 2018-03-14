package com.beans;

import java.util.ArrayList;
import java.util.List;

public class Cont {

    private String type;
    private String name;
    private String path;
    private List<Cont> children;

    public Cont() {
        children = new ArrayList<>();
    }

    public Cont(String type, String name, String path, List<Cont> children) {
        this.type = type;
        this.name = name;
        this.path = path;
        this.children = children;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public List<Cont> getChildren() {
        return children;
    }

    public void setChildren(List<Cont> children) {
        this.children = children;
    }
}
