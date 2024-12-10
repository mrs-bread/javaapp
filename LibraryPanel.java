import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.Collections;
import java.util.Comparator;

public class LibraryPanel extends JPanel {
    private Library library;
    private JTextArea bookListTextArea;
    private JTextField authorField, titleField, pagesField, dateField, priceField;
    public LibraryPanel(Library library){
        this.library=library;
        setLayout(new BorderLayout());
        JPanel inputPanel=createInputPanel();
        JPanel buttonPanel=createButtonPanel();
        bookListTextArea=new JTextArea(15,40);
        bookListTextArea.setEditable(false);
        JScrollPane scrollPane=new JScrollPane(bookListTextArea);
        add(inputPanel,BorderLayout.NORTH);
        add(scrollPane,BorderLayout.CENTER);
        add(buttonPanel,BorderLayout.SOUTH);
    }
     JPanel createInputPanel(){
        JPanel panel=new JPanel(new GridLayout(5,2,5,5));
        panel.setBorder(new EmptyBorder(10,10,10,10));
        panel.add(new JLabel("Автор:"));
        authorField=new JTextField();
        panel.add(authorField);
        panel.add(new JLabel("Название:"));
        titleField=new JTextField();
        panel.add(titleField);
        panel.add(new JLabel("Страницы:"));
        pagesField=new JTextField();
        panel.add(pagesField);
        panel.add(new JLabel("Дата:"));
        dateField=new JTextField();
        panel.add(dateField);
        panel.add(new JLabel("Цена:"));
        priceField=new JTextField();
        panel.add(priceField);
        return panel;
     }
     private JPanel createButtonPanel(){
        JPanel panel=new JPanel();
        JButton addButton=new JButton("Добавить");
        JButton sortButton=new JButton("Сортировать");
        addButton.addActionListener(e -> AddBook());
        sortButton.addActionListener(e -> sortBooksByAuthor());
        panel.add(addButton);
        panel.add(sortButton);
        return panel;
     }
     private void AddBook(){
        library.AddBook(new Book(Integer.parseInt(priceField.getText()),Integer.parseInt(dateField.getText()),Integer.parseInt(pagesField.getText()),authorField.getText(),titleField.getText()));
        updateBookList();
        clearInputFields();
     }
     private void sortBooksByAuthor(){
         Collections.sort(library.getBooks(), Comparator.comparing(Book::getAuthor));
         updateBookList();
     }
     public void updateBookList(){
        StringBuilder sb=new StringBuilder();
        for(Book book: library.getBooks()){
            sb.append(book).append("\n");
        }
        bookListTextArea.setText(sb.toString());
     }
     private void clearInputFields(){
        authorField.setText("");
        titleField.setText("");
        pagesField.setText("");
        dateField.setText("");
        priceField.setText("");
     }

}
