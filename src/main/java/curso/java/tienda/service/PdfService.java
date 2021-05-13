package curso.java.tienda.service;

import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.stereotype.Service;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import curso.java.tienda.model.Pedido;

@Service
public class PdfService {
	
	
	public void escribirPdf(Pedido pedido) {
		PdfWriter writer = null;
		Document documento = new Document(PageSize.A4, 20, 20, 70, 50);
		
		try {      
	    	//Obtenemos la instancia del archivo a utilizar
	    	writer = PdfWriter.getInstance(documento, new FileOutputStream("./ficheros/factura"+ pedido.getNumFactura() +".pdf"));
	    	
		    //Para insertar cabeceras/pies en todas las p�ginas
//	    	writer.setPageEvent(new PDFHeaderFooter());
	        
		    //Abrimos el documento para edici�n
		    documento.open();
		    
		    //PARRAFOS
			Paragraph paragraph = new Paragraph();

			paragraph.add(pedido.toString()+"\n\n");
		    
	    	documento.add(paragraph);
	    	
	    	//TABLAS
		    
			//Instanciamos una tabla de X columnas
		    PdfPTable tabla = new PdfPTable(2);
		    
		    Phrase texto = new Phrase("cabecera");
			PdfPCell cabecera = new PdfPCell(texto);
			
			cabecera.setBackgroundColor(BaseColor.LIGHT_GRAY);
			cabecera.setBorderWidth(1);
		    
		    tabla.addCell(cabecera);
		    tabla.addCell(cabecera);
		    tabla.addCell("3");
		    tabla.addCell("4");
		    tabla.addCell("5");
		    tabla.addCell("6");
		    documento.add(tabla);
	    	
		    documento.close(); //Cerramos el documento
		    writer.close(); //Cerramos writer
		    
		    
		    try {
		        File path = new File("./ficheros/factura"+ pedido.getNumFactura() +".pdf");
		        Desktop.getDesktop().open(path);
		    } catch (IOException ex) {
		        ex.printStackTrace();
		    }
			
	    } catch (Exception ex) {
	    	ex.getMessage();
	    }
		
	}
	
}
