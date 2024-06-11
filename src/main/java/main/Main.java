package main;

import java.sql.SQLException;

import javax.imageio.ImageIO;

import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.oned.Code128Writer;

import java.io.*;
import java.nio.file.Paths;

import controller.ControllerLogin;
import controller.ControllerViewAdmin;
import controller.ControllerViewEmployee;
import model.BarCodeGenerator;
import view.ViewAdmin;
import view.ViewEmployee;
import view.ViewLogin;

public class Main {
	
	public static void readBarCode(String path) throws FileNotFoundException, IOException, NotFoundException {
    	BufferedImage bf = ImageIO.read(new FileInputStream(path));
    	BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(
    			new BufferedImageLuminanceSource(bf)));
    	Result result = new MultiFormatReader().decode(bitmap);
    	System.out.println(result.getText());
	}
	
    public static void main( String[] args ) throws SQLException, FileNotFoundException, IOException, NotFoundException{
    
    	ViewLogin viewLogin = new ViewLogin();
    	ControllerLogin controller = new ControllerLogin(viewLogin);
        controller.showScreen();
	
    	
    }
}