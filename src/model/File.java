package model;

import service.SearchStrategy;

import java.util.List;

public class File extends FileSystemNode {
    private String extension;

    public File(String name, String extension, int sizeInKB) {
        super(name, sizeInKB);
        this.extension = extension;
    }

    public String getExtension() {
        return this.extension;
    }


    @Override
    public void list(String indent) {
        System.out.println(indent + "- " + name + "." + extension +  " (" + sizeInKB + " KB)");
    }

    @Override
    public void search(SearchStrategy strategy, List<FileSystemNode> result) {
        if(strategy.matches(this)) result.add(this);
    }
}
