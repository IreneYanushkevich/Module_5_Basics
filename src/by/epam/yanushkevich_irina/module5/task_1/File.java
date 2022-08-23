package by.epam.yanushkevich_irina.module5.task_1;

abstract class File {

    private String name;
    private String type;
    private Directory directory;

    File() {
    }

    File(String name, String type, Directory directory) {
        this.name = name;
        this.type = type;
        this.directory = directory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Directory getDirectory() {
        return directory;
    }

    public void setDirectory(Directory directory) {
        this.directory = directory;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        File f = (File) obj;
        if (name == null) {
            if (f.name != null) {
                return false;
            }
        } else if (!name.equals(f.name)) {
            return false;
        }
        if (type == null) {
            if (f.type != null) {
                return false;
            }
        } else if (!type.equals(f.type)) {
            return false;
        }
        if (directory == null) {
            return f.directory == null;
        } else return directory.equals(f.directory);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime + result + ((type == null) ? 0 : type.hashCode());
        result = prime + result + ((directory == null) ? 0 : directory.hashCode());
        return result;
    }

    abstract File createFile(String name, String type, Directory directory);

    public void renameFile(String name, String type) {
        setName(name);
        setType(type);
    }

    public void deleteFile(File file) {
        file.getDirectory().getFiles().remove(file);
    }
}
