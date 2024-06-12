package view;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import com.mysql.cj.xdevapi.Table;

public class ViewEmployee extends JFrame {
	private JButton saleBtn,exitBtn,addProductBtn,deleteProductBtn,billBtn,searchBtn,addClientBtn;
	private JPanel leftPanel, rigthTopPanel,homePanel;
	private JLabel titleView,titleScreenSale,clientDni,clientFirstName,clientLastName,clientAddress,clientTelephone,dataProducts,codeProduct,nameProduct,stockProduct,priceProduct,cantityProduct, totalProduct,sectionTitle;
	private JTextField clientDniTxt,clientFirstNameTxt,clientLastNameTxt,clientAddressTxt,clientTelephoneTxt,codeProductTxt,nameProductTxt,stockProductTxt,priceProductTxt,cantityProductTxt, totalProductTxt;
	private JSeparator separator;
	private JFrame screenSale = new JFrame();
	private Font titleFonts = new Font("Dialog", Font.BOLD,18), labelFont = new Font("Dialog", Font.BOLD,14);
	private DefaultTableModel tableModelProducts;
	private JTable tableProducts;
	private JScrollPane scrollPaneProducts;
	
	
	public ViewEmployee(){
		
		getContentPane().setLayout(null);
		leftPanel = new JPanel();
		leftPanel.setBounds(0, 0, 270, 600);
		leftPanel.setBackground(Color.DARK_GRAY);
		leftPanel.setLayout(null);
		
		Font titleFont = new Font("Dialog", Font.BOLD,26);
		titleView = new JLabel();
		titleView.setText("Welcome");
		titleView.setBounds(65, 35, 150, 25);
		titleView.setForeground(Color.white);
		titleView.setFont(titleFont);
		
		separator = new JSeparator();
		separator.setForeground(Color.white);
		separator.setBounds(0, 85, 270, 5);
		
		saleBtn = new JButton("Sale");
		exitBtn = new JButton("Exit");
		
		saleBtn.setBackground(Color.white);
		saleBtn.setBounds(45, 230, 180, 50);
		
		exitBtn.setBackground(Color.white);
		exitBtn.setBounds(45, 290, 180, 50);
		
		rigthTopPanel = new JPanel();
		rigthTopPanel.setBounds(270,0,630,87);
		rigthTopPanel.setBackground(Color.LIGHT_GRAY);
		rigthTopPanel.setLayout(null);
		
		Font fontNameCompany = new Font("Dialog",Font.BOLD,22);
		JLabel nameCompany = new JLabel("Inventory Management System");
		nameCompany.setFont(fontNameCompany);
		nameCompany.setBounds(75,30,500,25);
		
		leftPanel.add(titleView);
		leftPanel.add(separator);
		leftPanel.add(saleBtn);
		leftPanel.add(exitBtn);
		rigthTopPanel.add(nameCompany);

		homePanel = new JPanel();
		String pathImg = "/home/jadape/Documentos/eclipse-workspace/BasicSystemInventory/src/main/java/resource/wallpaper.jpg";
		sectionTitle = new JLabel(configImg(pathImg));


		homePanel.setBounds(270,85, 630, 550);
		homePanel.add(sectionTitle);
		getContentPane().add(leftPanel);
		getContentPane().add(rigthTopPanel);
		getContentPane().add(homePanel);
	}
	
	public JButton getSaleBtn() {
		return saleBtn;
	}

	public void setSaleBtn(JButton saleBtn) {
		this.saleBtn = saleBtn;
	}

	public JButton getExitBtn() {
		return exitBtn;
	}

	public void setExitBtn(JButton exitBtn) {
		this.exitBtn = exitBtn;
	}

	public JPanel getLeftPanel() {
		return leftPanel;
	}

	public void setLeftPanel(JPanel leftPanel) {
		this.leftPanel = leftPanel;
	}

	public JPanel getRigthTopPanel() {
		return rigthTopPanel;
	}

	public void setRigthTopPanel(JPanel rigthTopPanel) {
		this.rigthTopPanel = rigthTopPanel;
	}

	public JLabel getTitleView() {
		return titleView;
	}

	public void setTitleView(JLabel titleView) {
		this.titleView = titleView;
	}

	public JSeparator getSeparator() {
		return separator;
	}

	public void setSeparator(JSeparator separator) {
		this.separator = separator;
	}

	public JFrame getScreenSale() {
		return screenSale;
	}

	public void setScreenSale(JFrame screenSale) {
		this.screenSale = screenSale;
	}

	public ImageIcon configImg( String Ruta){
		try {
			File file = new File(Ruta);
			BufferedImage originalImage = ImageIO.read(file);

			int newWidth = 630;
			int newHeight = 550;

			Image scaledImage = originalImage.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);

			return new ImageIcon(scaledImage);


		} catch (IOException e) {
			e.printStackTrace();
		}
		return new ImageIcon();
	}
	
	
}
