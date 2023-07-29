package utils;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

import alura.models.ImageWithDescription;


public class JComboBoxRenderer extends JLabel implements ListCellRenderer {
	
	private static final long serialVersionUID = -5450317038401851577L;
	//Hashtable<Object, ImageIcon> items;
	//ImageIcon img = new ImageIcon(this.getClass().getResource("/icons/default.png"));
	//private ArrayList<ImageWithDescription> _imagesWithDescriptions;
	
	public JComboBoxRenderer(ArrayList<ImageWithDescription> imagesWithDescriptions) {
		//_imagesWithDescriptions = imagesWithDescriptions;
	}

	@Override
	public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected,
			boolean cellHasFocus) {
		// TODO Auto-generated method stub
		ImageWithDescription iwd = (ImageWithDescription) value;
		this.setText(iwd.get_description());
		ImageIcon ic = new ImageIcon(iwd.get_urlImage());
		this.setIcon(ic);
		return this;
	}
}
