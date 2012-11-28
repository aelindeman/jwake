package me.ael.jwake;

import java.util.List;
import java.util.LinkedList;
import javax.swing.table.AbstractTableModel;

public class MachineTableModel extends AbstractTableModel
{
	private static final long serialVersionUID = 6145158189799538933L;
	
	private List<Machine> data = new LinkedList<Machine>();
	private String[] labels = { "Name", "MAC Address" };
	
	public MachineTableModel(List<Machine> data)
	{
		this.data = data;
	}
	
	public int getColumnCount()
	{
		return labels.length;
	}
	
	public int getRowCount()
	{
		return data.size();
	}
	
	public String getColumnName(int col)
	{
		return labels[col];
	}

	public Object getValueAt(int row, int cell)
	{
		Machine m = data.get(row);
		switch (cell)
		{
			case 0:
				return m.name;
			case 1:
				return m.address;
		}
		return null;
	}
}
