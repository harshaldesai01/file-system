package service;

import model.FileSystemNode;

public class NameSearch implements SearchStrategy{
    private final String keyword;
    public NameSearch(String keyword) {
        this.keyword = keyword;
    }

    @Override
    public boolean matches(FileSystemNode node) {
        return node.getName().equalsIgnoreCase(keyword);
    }
}
