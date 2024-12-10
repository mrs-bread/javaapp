import javax.swing.*;
import java.awt.*;

public class LibraryApp extends JFrame {
    private Library library =new Library();
    private LibraryPanel libraryPanel;
    public LibraryApp(){
        setTitle("Библиотека");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600,400);
        setLayout(new BorderLayout());
        libraryPanel=new LibraryPanel(library);
        add(libraryPanel,BorderLayout.CENTER);
        library.AddBook(new Book(123,1996,120,"Tolstoy","Peace"));
        libraryPanel.updateBookList();
        setVisible(true);
    }
}
