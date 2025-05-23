package service;

import model.FileSystemNode;

public class SizeSearch implements SearchStrategy{
    private final int maxSizeInKB;

    public SizeSearch(int maxSizeInKB){
        this.maxSizeInKB = maxSizeInKB;
    }

    @Override
    public boolean matches(FileSystemNode node) {
        return node.getSizeInKB() < maxSizeInKB;
    }
}
