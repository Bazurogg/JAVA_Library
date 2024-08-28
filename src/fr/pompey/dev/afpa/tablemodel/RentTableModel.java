package fr.pompey.dev.afpa.tablemodel;

import fr.pompey.dev.afpa.entity.Book;
import fr.pompey.dev.afpa.entity.Rent;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class RentTableModel extends AbstractTableModel {

    private final String[] columnNames = {"Book", "User ID", "Rent Date", "Return Date"};

    private final List<Rent> rents;

    public RentTableModel(List<Rent> rents) {
        this.rents = rents;
    }

    @Override
    public int getRowCount() {
        return rents.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Rent rent = rents.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return rent.book.getTitle();
            case 1:
                return rent.user.getEmail();
            case 2:
                return rent.getRentDate();
            case 3:
                return rent.getReturnDate();
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

}
