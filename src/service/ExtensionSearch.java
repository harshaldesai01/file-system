package service;

import model.File;
import model.FileSystemNode;

public class ExtensionSearch implements SearchStrategy{
    String keyword;

    public ExtensionSearch(String keyword) {
        this.keyword = keyword;
    }

    @Override
    public boolean matches(FileSystemNode node) {
        if(node instanceof File) {
            return ((File) node).getExtension().equals(keyword);
        }
        return false;
    }
}
