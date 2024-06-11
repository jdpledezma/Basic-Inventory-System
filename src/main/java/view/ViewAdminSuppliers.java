package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import com.toedter.calendar.JDateChooser;


public class ViewAdminSuppliers extends JFrame {
	private JPanel suppliersPanel = new JPanel();
	private JLabel sectionTitle = new JLabel(),nameSupplier,supplierInput,supplierCategory;
	private JSeparator separator,separatorSection;
	private JTextField nameSupplierTxt,categorySupplierTxt;
	private JButton addSupplierBtn,editSupplierBtn,deleteSupplierBtn;
	private JTable tableSupplier;
	private DefaultTableModel tableModelSuppliers = new DefaultTableModel(); 
	private JScrollPane scrollPaneSuppliers = new JScrollPane();
	private JDateChooser inputSupplier = new JDateChooser();
	
	public ViewAdminSuppliers() {
		suppliersPanel.setBounds(0, 0, 570, 550);
		suppliersPanel.setLayout(null);
		suppliersPanel.setBackground(Color.white);
		sectionTitle.setText("Suppliers");
		sectionTitle.setBounds(15,20,150,40);
		Font sectionTitleFont = new Font("Dialog", Font.BOLD,16);
		sectionTitle.setFont(sectionTitleFont);
		separatorSection = new JSeparator();
		separatorSection.setBounds(0, 60, 570, 10);
		separatorSection.setForeground(Color.LIGHT_GRAY);
		
		nameSupplier = new JLabel("Name Supplier");
		supplierInput = new JLabel("Born Input");
		supplierCategory = new JLabel("Supplier Category");
		
		nameSupplierTxt = new JTextField();
		categorySupplierTxt = new JTextField();
		
		addSupplierBtn = new JButton("Add");
		editSupplierBtn = new JButton("Edit");
		deleteSupplierBtn = new JButton("Delete");
		
		tableModelSuppliers= new DefaultTableModel();
		
		tableSupplier = new JTable(tableModelSuppliers) {
        	public boolean isCellEditable ( int row, int col){
                return false;
            }
        };
        String[] scrollPaneSupplierTitle = {"ID", "Name Supplier", "Categorys"};
        scrollPaneSuppliers = new JScrollPane(tableSupplier);
     
        
        for(String titles : scrollPaneSupplierTitle) {
        	tableModelSuppliers.addColumn(titles);
        }
		
		
		nameSupplier.setBounds(15,75,105,25);
		supplierInput.setBounds(170,75,105,25);
		supplierCategory.setBounds(305,75,155,25);
		
		nameSupplierTxt.setBounds(15,105,120,25);
		inputSupplier.setBounds(150,105,120,25);
		categorySupplierTxt.setBounds(290,105,155,25);
	
		addSupplierBtn.setBounds(460,105,100,25);
		editSupplierBtn.setBounds(460,140,100,25);
		deleteSupplierBtn.setBounds(460,175,100,25);
		scrollPaneSuppliers.setBounds(15,140,430,250);
		
		suppliersPanel.add(sectionTitle);
		suppliersPanel.add(separatorSection);
		suppliersPanel.add(nameSupplier);
		suppliersPanel.add(supplierInput);
		suppliersPanel.add(supplierCategory);
		suppliersPanel.add(nameSupplierTxt);
		suppliersPanel.add(inputSupplier);
		suppliersPanel.add(categorySupplierTxt);
		suppliersPanel.add(addSupplierBtn);
		suppliersPanel.add(editSupplierBtn);
		suppliersPanel.add(deleteSupplierBtn);
		suppliersPanel.add(scrollPaneSuppliers);
		
		getContentPane().add(suppliersPanel);
	
	}
	
}
