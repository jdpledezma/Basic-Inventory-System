package model;


import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Paths;

import org.krysalis.barcode4j.impl.code39.Code39Bean;
import org.krysalis.barcode4j.output.bitmap.BitmapCanvasProvider;
import org.krysalis.barcode4j.tools.UnitConv;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.oned.Code128Writer;

public class BarCodeGenerator {
	
	public void generateCode(String barcode,String name) throws IOException {
		try {
    		String path = "/home/jadape/Documentos/eclipse-workspace/BasicSystemInventory/src/main/java/resource/"+name+".jpg";
    		Code128Writer writer = new Code128Writer();
    		BitMatrix matrix = writer.encode(barcode,BarcodeFormat.CODE_128,500,300);
    		MatrixToImageWriter.writeToPath(matrix, "jpg",Paths.get(path));
    		System.out.println("Barcode Created");
    		
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    }

	
}
