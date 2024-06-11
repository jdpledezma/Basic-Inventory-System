package model;

import java.awt.Desktop;
import java.awt.Font;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.time.LocalDateTime;
import java.util.ArrayList;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chapter;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Section;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.PdfReader;

public class ModelPDF {
	private static final Font PRODUCT_NAME_FONT = new Font("HELVETICA", 12, Font.BOLD);
    private static final int BARCODE_WIDTH = 200;
    private static final int BARCODE_HEIGHT = 50;
    private static final com.itextpdf.text.Font chapterFont = FontFactory.getFont("HELVETICA", 12, Font.BOLD);
    private static final com.itextpdf.text.Font paragraphFont = FontFactory.getFont("HELVETICA", 12, Font.BOLD);
    private com.itextpdf.text.Font titleFont = FontFactory.getFont("HELVETICA", 16, Font.BOLD);
    private com.itextpdf.text.Font titlePFont = FontFactory.getFont("HELVETICA", 13, Font.BOLD);
    
    public static void generatePDF(byte[] barcode_img, String name) throws DocumentException, MalformedURLException, IOException {
    	Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, new FileOutputStream("/home/jadape/Documentos/Universidad/Sexto Semestre/Lenguaje III/maven-archetype-quickstart/src/main/java/resource/product_barcode_" + name + ".pdf"));
        document.open();

        PdfPTable table = new PdfPTable(1);
        table.setWidthPercentage(100);

        PdfPCell nameCell = new PdfPCell(new Phrase(name));
        nameCell.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        nameCell.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
        table.addCell(nameCell);

        Image barcodeImageFromByteArray = Image.getInstance(barcode_img);
        barcodeImageFromByteArray.scaleToFit(200, 50); 
        PdfPCell barcodeCell = new PdfPCell(barcodeImageFromByteArray);
        barcodeCell.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        barcodeCell.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
        table.addCell(barcodeCell);

        document.add(table);
        document.close();
    }
    
    
    public void generateBill(String dniClient,String nameClient, Double total, LocalDateTime dateNow, String newPdfFile,ArrayList<ModelProduct> cartBill ){
    	try {
    		Document document = new Document();
    		try {
    			PdfWriter.getInstance(document, new FileOutputStream(newPdfFile));
    		}catch(FileNotFoundException fileNotFoundException) {
    			System.out.println("No such file was found to generate the PDF "
                        + "(No se encontró el fichero para generar el pdf)" + fileNotFoundException);
    		}
    		document.open();
    		document.addTitle("Sales Check");
    		document.addSubject("Using Itext");
    		document.addKeywords("Java, PDF, iText");
            document.addAuthor("Javier Pérez");
            document.addCreator("Javier Pérez");
            
            Chapter chapter1 = new Chapter(2);
            
            
            Section SectionBill = chapter1;
          
            Paragraph titleBill = new Paragraph("Sales Check");
            titleBill.setFont(titleFont);
            titleBill.setAlignment(Element.ALIGN_CENTER);
            Paragraph rifCompany = new Paragraph("J-464987231");
            rifCompany.setFont(titlePFont);
            rifCompany.setAlignment(Element.ALIGN_CENTER);
            Paragraph nameCompany = new Paragraph("SAGIS");
            nameCompany.setFont(titlePFont);
            nameCompany.setAlignment(Element.ALIGN_CENTER);
            Paragraph addressCompany = new Paragraph("Urb Lomas del Este");
            addressCompany.setFont(titlePFont);
            addressCompany .setAlignment(Element.ALIGN_CENTER);
            Paragraph  cityCompany = new Paragraph("San Fernando de Apure");
            cityCompany.setFont(titlePFont);
            cityCompany.setAlignment(Element.ALIGN_CENTER);
            Paragraph stateCompany = new Paragraph("Estado Apure");
            stateCompany.setFont(titlePFont);  
            stateCompany.setAlignment(Element.ALIGN_CENTER);
            
            Paragraph ClientDetails = new Paragraph("Client Details");
            ClientDetails.setAlignment(Element.ALIGN_CENTER);
            Paragraph dniCLient = new Paragraph("DNI: " + dniClient);
            dniCLient.setAlignment(Element.ALIGN_CENTER);
            Paragraph nameClients = new Paragraph("Name Client: " + nameClient);
            nameClients.setAlignment(Element.ALIGN_CENTER);
            
       
            
         
            
            chapter1.add(titleBill);
            chapter1.add(rifCompany);
            chapter1.add(nameCompany);
            chapter1.add(addressCompany);
            chapter1.add(cityCompany);
            chapter1.add(stateCompany);
            Paragraph separator = new Paragraph("------------------------------");
            separator.setAlignment(Element.ALIGN_CENTER);
            chapter1.add(separator);
            chapter1.add(ClientDetails);
            chapter1.add(dniCLient);
            chapter1.add(nameClients);
            chapter1.add(separator);
            
            
            for (ModelProduct product : cartBill) {
            	 chapter1.add(separator);
                String productName = product.getName();
                double productPrice = Double.parseDouble(product.getPrice());
                int productCantity = Integer.parseInt(product.getCantity());
                double productTotalPrice = productPrice * productCantity;

              
                Paragraph productInfo = new  Paragraph();
                productInfo.add(new Chunk(productName + ": ", titlePFont)); 
                productInfo.add(new Chunk(String.valueOf(productPrice +"$"), titlePFont));

                productInfo.setAlignment(Element.ALIGN_LEFT);
                productInfo.setAlignment(Element.ALIGN_CENTER);
                Paragraph productCantityPara = new Paragraph("Cantity: " + (productCantity));
                productCantityPara.setAlignment(Element.ALIGN_CENTER);
                chapter1.add(productInfo); 
                chapter1.add(productCantityPara);
            
                chapter1.add(separator);
            }

            Paragraph totalBs = new Paragraph("Total BS: " + total * 37);
            Paragraph totalD = new Paragraph("Total $: " + total);
            totalBs.setAlignment(Element.ALIGN_CENTER);
            totalD.setAlignment(Element.ALIGN_CENTER);
            chapter1.add(totalBs);
            chapter1.add(totalD);
            
            
            document.add(SectionBill);

            document.close();
   
            
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    	
    	
    }

}
