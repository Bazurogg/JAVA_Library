// Création d'un modèle va permettre de représenter les données.
// Le "TableModel" définit comment les données des livres (qui sont stockées dans une ArrayList) sont mappées aux
// colonnes d'un JTable.


package fr.pompey.dev.afpa.tablemodel;

import fr.pompey.dev.afpa.entity.Book;
import javax.swing.table.AbstractTableModel;
import java.util.List;

public class TableModel extends AbstractTableModel {

    private final String[] columnNames = {"Title", "Author", "Availability"};

    private final List<Book> books;

    public TableModel(List<Book> books) {
        this.books = books;
    }

    @Override
    public int getRowCount() {
        return books.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Book book = books.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return book.getTitle();
            case 1:
                return book.getAuthor();
            case 2:
                return book.isAvailable() ? "Oui" : "Non";
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

}
