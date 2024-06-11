package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class ViewAdminCategory extends JFrame{
	
	private JPanel categoryPanel = new JPanel();
	private JLabel sectionTitle = new JLabel(),nameCategory;
	private JSeparator separator,separatorSection;
	private JTextField nameCategoryTxt;
	private JButton addCategoryBtn,deleteCategoryBtn;
	private DefaultTableModel tableModelCategory = new DefaultTableModel();
	private JTable tableCategory;
	private JScrollPane scrollPaneCategory; 
	
	
	public ViewAdminCategory() {
		categoryPanel.setBounds(0, 0, 570, 550);
		categoryPanel.setLayout(null);
		categoryPanel.setBackground(Color.white);
		sectionTitle.setText("Categorys");
		sectionTitle.setBounds(15,20,150,40);
		Font sectionTitleFont = new Font("Dialog", Font.BOLD,16);
		sectionTitle.setFont(sectionTitleFont);
		separatorSection = new JSeparator();
		separatorSection.setBounds(0, 60, 570, 10);
		separatorSection.setForeground(Color.LIGHT_GRAY);
	
		
		nameCategory = new JLabel("Category");
		nameCategoryTxt = new JTextField();
		
		addCategoryBtn = new JButton("Add");
		deleteCategoryBtn = new JButton("Delete");
		
		
		
		tableCategory = new JTable(tableModelCategory){
        	public boolean isCellEditable(int row, int col){
                return false;
            }
        };
        String[] scrollPaneCategoryTitle = {"ID", "Name"};
        scrollPaneCategory = new JScrollPane(tableCategory);
     
        
        for(String titles : scrollPaneCategoryTitle) {
			tableModelCategory.addColumn(titles);
        }
		
		
		nameCategory.setBounds(15,75,105,25);
		nameCategoryTxt.setBounds(95,75,120,25);
		addCategoryBtn.setBounds(235,75,100,25);
		deleteCategoryBtn.setBounds(345,75,100,25);
		scrollPaneCategory.setBounds(15, 110, 435, 200);
			
		categoryPanel.add(sectionTitle);
		categoryPanel.add(separatorSection);
		categoryPanel.add(nameCategory);
		categoryPanel.add(nameCategoryTxt);
		categoryPanel.add(addCategoryBtn);
		categoryPanel.add(deleteCategoryBtn);
		categoryPanel.add(scrollPaneCategory);
		getContentPane().add(categoryPanel);
		
	}


	public JPanel getCategoryPanel() {
		return categoryPanel;
	}


	public void setCategoryPanel(JPanel categoryPanel) {
		this.categoryPanel = categoryPanel;
	}


	public JLabel getSectionTitle() {
		return sectionTitle;
	}


	public void setSectionTitle(JLabel sectionTitle) {
		this.sectionTitle = sectionTitle;
	}


	public JLabel getNameCategory() {
		return nameCategory;
	}


	public void setNameCategory(JLabel nameCategory) {
		this.nameCategory = nameCategory;
	}


	public JSeparator getSeparator() {
		return separator;
	}


	public void setSeparator(JSeparator separator) {
		this.separator = separator;
	}


	public JSeparator getSeparatorSection() {
		return separatorSection;
	}


	public void setSeparatorSection(JSeparator separatorSection) {
		this.separatorSection = separatorSection;
	}


	public JTextField getNameCategoryTxt() {
		return nameCategoryTxt;
	}


	public void setNameCategoryTxt(JTextField nameCategoryTxt) {
		this.nameCategoryTxt = nameCategoryTxt;
	}


	public JButton getAddCategoryBtn() {
		return addCategoryBtn;
	}


	public void setAddCategoryBtn(JButton addCategoryBtn) {
		this.addCategoryBtn = addCategoryBtn;
	}


	public JButton getDeleteCategoryBtn() {
		return deleteCategoryBtn;
	}


	public void setDeleteCategoryBtn(JButton deleteCategoryBtn) {
		this.deleteCategoryBtn = deleteCategoryBtn;
	}


	public DefaultTableModel getTableModelCategory() {
		return tableModelCategory;
	}


	public void setTableModelCategory(DefaultTableModel tableModelCategory) {
		this.tableModelCategory = tableModelCategory;
	}


	public JTable getTableCategory() {
		return tableCategory;
	}


	public void setTableCategory(JTable tableCategory) {
		this.tableCategory = tableCategory;
	}


	public JScrollPane getScrollPaneCategory() {
		return scrollPaneCategory;
	}


	public void setScrollPaneCategory(JScrollPane scrollPaneCategory) {
		this.scrollPaneCategory = scrollPaneCategory;
	}
	
	
	
}
