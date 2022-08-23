package by.epam.yanushkevich_irina.module5.task_1;

import java.util.ArrayList;
import java.util.List;

public class Directory {

    private String name;
    private List<File> files;

    public Directory(String name) {
        this.name = name;
        files = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<File> getFiles() {
        return files;
    }

    public void setFiles(List<File> files) {
        this.files = files;
    }

    @Override
    public boolean equals(Object ob) {
        if (this == ob) return true;
        if (ob == null || getClass() != ob.getClass()) return false;
        Directory directory = (Directory) ob;
        if (name == null) {
            if (directory.name != null) {
                return false;
            }
        } else if (!name.equals(directory.name)) {
            return false;
        }
        if (files == null) {
            return directory.files == null;
        } else return files.equals(directory.files);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((files == null) ? 0 : files.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "Directory with the name '" + name + "' contains files:\n" + files + "\n";
    }

    public void addFile(File file) {
        files.add(file);
    }
}
