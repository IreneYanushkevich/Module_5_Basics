package by.epam.yanushkevich_irina.module5.task_1;

public class TextFile extends File {

    private StringBuilder text = new StringBuilder();

    public TextFile() {
    }

    private TextFile(String name, String type, Directory directory) {
        super(name, type, directory);
    }

    public StringBuilder getText() {
        return text;
    }

    public void setText(StringBuilder text) {
        this.text = text;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        if (!super.equals(obj)) return false;
        TextFile tF = (TextFile) obj;
        if (text == null) {
            return tF.text == null;
        } else return text.toString().contentEquals(tF.text);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((text == null) ? 0 : text.hashCode());
        result = prime * result + super.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return getName() + "." + getType();
    }

    public void addText(String addition) {
        StringBuilder result = new StringBuilder(text);
        result.append(addition);
        text = result;
    }

    public void printText() {
        System.out.println(getName() + "\n" + text + "\n");
    }

    @Override
    public TextFile createFile (String name, String type, Directory directory) {
        return new TextFile(name, type, directory);
    }
}
