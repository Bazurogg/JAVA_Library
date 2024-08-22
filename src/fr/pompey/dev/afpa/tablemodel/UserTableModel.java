package fr.pompey.dev.afpa.tablemodel;


import fr.pompey.dev.afpa.entity.User;
import javax.swing.table.AbstractTableModel;
import java.util.List;

public class UserTableModel extends AbstractTableModel {

    private final String[] columnNames =  {"Firstname", "Lastname", "Email", "Registration Date"};

    private List<User> users;

    @Override
    public int getRowCount() {
        return 0;
    }

    @Override
    public int getColumnCount() {
        return 0;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return null;
    }

}
