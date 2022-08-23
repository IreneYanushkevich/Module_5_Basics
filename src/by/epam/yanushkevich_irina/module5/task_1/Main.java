package by.epam.yanushkevich_irina.module5.task_1;

public class Main {

    /* Создать объект класса Текстовый файл, используя классы Файл, Директория. Методы: создать, переименовать,
       вывести на консоль содержимое, дополнить, удалить. */

    public static void main(String[] args) {

        Directory d = new Directory("Poems");
        TextFile f = new TextFile();

        f = f.createFile("Love", "txt", d);
        d.addFile(f);
        System.out.println(d);

        f.addText("""
                Heart, we will forget him!
                You and I, to-night!
                """);
        f.printText();
        f.renameFile("About Love", "txt");
        f.addText("""
                You may forget the warmth he gave,\s
                I will forget the light.
                """);
        f.printText();

        f.deleteFile(f);
        System.out.println(d);
    }
}
