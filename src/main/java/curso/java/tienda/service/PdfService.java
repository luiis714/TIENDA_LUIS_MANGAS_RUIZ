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
	    	writer = PdfWriter.getInstance(documento, new FileOutputStream("C:\\Users\\Formacion\\Desktop\\ficheros\\"+ pedido.getNumFactura() +".pdf"));
	    	
		    //Para insertar cabeceras/pies en todas las p�ginas
//	    	writer.setPageEvent(new PDFHeaderFooter());
	        
		    //Abrimos el documento para edici�n
		    documento.open();
		    
		    //PARRAFOS
			Paragraph paragraph = new Paragraph();

			paragraph.add("Nº Factura: "+ pedido.getNumFactura() + "\n\n");
		    
			paragraph.add("Fecha: "+ pedido.getFecha() + "\n\n");
	    	documento.add(paragraph);
	    	
	    	//TABLAS
		    
			//Instanciamos una tabla de X columnas
		    PdfPTable tabla = new PdfPTable(2);
		    
		    Phrase texto1 = new Phrase("Producto");
		    Phrase texto2 = new Phrase("Precio (€)");
			PdfPCell cabecera1 = new PdfPCell(texto1);
			PdfPCell cabecera2 = new PdfPCell(texto2);
			
			cabecera1.setBackgroundColor(BaseColor.LIGHT_GRAY);
			cabecera1.setBorderWidth(1);
			cabecera2.setBackgroundColor(BaseColor.LIGHT_GRAY);
			cabecera2.setBorderWidth(1);
			
		    tabla.addCell(cabecera1);
		    tabla.addCell(cabecera2);
		    tabla.addCell("3");
		    tabla.addCell("4");
		    tabla.addCell("5");
		    tabla.addCell("6");
		    documento.add(tabla);
	    	
		    documento.close(); //Cerramos el documento
		    writer.close(); //Cerramos writer
		    
		    
		    try {
		        File path = new File("C:\\Users\\Formacion\\Desktop\\ficheros\\"+ pedido.getNumFactura() +".pdf");
		        Desktop.getDesktop().open(path);
		    } catch (IOException ex) {
		        ex.printStackTrace();
		    }
			
	    } catch (Exception ex) {
	    	ex.getMessage();
	    }
		
	}
	
}
