package model;

import service.SearchStrategy;

import java.util.List;

public abstract class FileSystemNode {
    protected String name;
    protected int sizeInKB;

    public FileSystemNode(String name, int sizeInKB) {
        this.name = name;
        this.sizeInKB = sizeInKB;
    }

    public abstract void list(String indent);
    public String getName() { return this.name;}
    public int getSizeInKB() { return this.sizeInKB;}
    public abstract void search(SearchStrategy strategy, List<FileSystemNode> result);

}
