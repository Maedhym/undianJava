/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dailypractice20client.TableModel;

import dailypractice20api.Entity.Donatur;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Richard Shiawase
 */
public class TableModel extends AbstractTableModel {

    List<Donatur> list = new ArrayList<Donatur>();

    public void setData(List<Donatur> list) {
        this.list = list;
        this.fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0:
                return list.get(rowIndex).getNama();
            case 1:
                return list.get(rowIndex).getDonasi();
            case 2:
                return list.get(rowIndex).getAsal();
            default:
                return null;
        }
    }

}
