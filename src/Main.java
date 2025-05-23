import model.Directory;
import model.File;
import model.FileSystemNode;
import service.NameSearch;
import service.SearchStrategy;
import service.SizeSearch;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {;
        Directory root = new Directory("root");
        Directory docs = new Directory("docs");
        Directory pics  = new Directory("pics");

        docs.add(new File("resume", "pdf", 150));
        docs.add(new File("project", "ppt", 250));
        docs.add(new File("final_write-up", "docx", 300));

        pics.add(new File("profile", "jpg", 50));
        pics.add(new File("london_holiday", "jpeg", 70));

        root.add(docs);
        root.add(pics);

        System.out.println("Listing File System: ");
        root.list("");

        System.out.println("--------");

        System.out.println("Searching for anything named 'project':");
        List<FileSystemNode> result = new ArrayList<>();
        root.search(new NameSearch("project"), result);
        result.forEach(n -> System.out.println(" Found: " + n.getName()));

        System.out.println("--------");

        System.out.println("Searching for directories containing 'doc':");
        result.clear();
        root.search(new SearchStrategy() {
            @Override
            public boolean matches(FileSystemNode node) {
                return (node instanceof Directory) && node.getName().contains("doc");
            }
        }, result);

        result.forEach(n -> System.out.println(" Found directory: " + n.getName()));

        System.out.println("--------");

        System.out.println("Searching for files < 200 KB: ");
        result.clear();
        root.search(new SizeSearch(200), result);
        result.forEach(n -> {
            if(n instanceof File f) {
                System.out.println("File: " + f.getName() + "." + f.getExtension() + " (" + f.getSizeInKB() + " KB)");
            } else {
                System.out.println("Directory: " + n.getName() + " (" + n.getSizeInKB() + " KB)");
            }
        });

        System.out.println();
        docs.list("");

    }
}