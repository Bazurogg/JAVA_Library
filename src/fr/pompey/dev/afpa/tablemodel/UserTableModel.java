package fr.pompey.dev.afpa.tablemodel;


import fr.pompey.dev.afpa.entity.User;
import javax.swing.table.AbstractTableModel;
import java.util.List;

public class UserTableModel extends AbstractTableModel {

    private final String[] columnNames =  {"Firstname", "Lastname", "Email", "Registration Date"};

    private List<User> users;

    public UserTableModel(List<User> users) {
        this.users = users;
    }

    @Override
    public int getRowCount() {
        return users.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        User user = users.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return user.getFirstname();
            case 1:
                return user.getLastname();
            case 2:
                return user.getEmail();
            case 3:
                return user.getRegistrationDate();
            default:
                return null;

        }

    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }



}
