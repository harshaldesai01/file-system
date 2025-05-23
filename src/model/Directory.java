package model;

import service.SearchStrategy;

import java.util.ArrayList;
import java.util.List;

public class Directory extends FileSystemNode {
    private List<FileSystemNode> children;

    public Directory(String name) {
        super(name, 0);
        this.children = new ArrayList<>();
    }

    public void add(FileSystemNode node) {
        children.add(node);
        this.sizeInKB += node.getSizeInKB();
    }

    @Override
    public void list(String indent) {
        System.out.println(indent + "+ " + this.name + " (" + this.sizeInKB + " KB)");
        for (FileSystemNode child : children) {
            child.list(indent + "  ");
        }
    }

    @Override
    public void search(SearchStrategy strategy, List<FileSystemNode> result) {
        if(strategy.matches(this)) { result.add(this); }
        for (FileSystemNode child : children) {
            child.search(strategy, result);
        }
    }
}
