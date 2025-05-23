package service;

import model.FileSystemNode;

public interface SearchStrategy {
    boolean matches(FileSystemNode node);
}
