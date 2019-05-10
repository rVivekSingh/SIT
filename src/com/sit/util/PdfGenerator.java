package com.sit.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class PdfGenerator {
    public static final String DEST = "D:/angular/simple_table10.pdf";
 
    public static void main(String[] args) throws IOException,
            DocumentException {
        File file = new File(DEST);
        file.getParentFile().mkdirs();
        new PdfGenerator().createPdf(DEST);
    }
    public void createPdf(String dest) throws IOException, DocumentException {
    	
    	Font headerBold = new Font(FontFamily.TIMES_ROMAN, 16, Font.BOLD);
		Font paraBold = new Font(FontFamily.COURIER, 12, Font.BOLD);
		Font subparaBold = new Font(FontFamily.TIMES_ROMAN, 12, Font.BOLD);
		Font bold = new Font(FontFamily.HELVETICA, 9, Font.BOLD);
		Font medium = new Font(FontFamily.HELVETICA, 9, Font.NORMAL);
		Font mediumKey = new Font(FontFamily.COURIER, 10, Font.BOLD);
		Font mediumValue = new Font(FontFamily.COURIER, 10, Font.ITALIC);
		Font small = new Font(FontFamily.COURIER, 9, Font.NORMAL);
		Font noteFontColor = new Font(FontFamily.HELVETICA, 10, Font.NORMAL, BaseColor.RED);
		float[] tableColumnSize = { 155, 155, 155, 155, 155, 155 };
		float[] tableproductionColumnSize = { 172, 170, 172, 170, 172, 170, 172, 170,172,170 };
		float[] tableproductionColumnSize1 = { 70, 63, 70, 63, 70, 63, 10, 150, 10, 150 };
		
        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, new FileOutputStream(dest));
        document.open();
        
        PdfPTable table = new PdfPTable(10);
        table.setWidths(tableproductionColumnSize);
        
        PdfPCell head = new PdfPCell(new Phrase("Softnet Computer Academy",headerBold));
        head.setColspan(10);
        head.setHorizontalAlignment(Element.ALIGN_CENTER);
        head.setBackgroundColor(BaseColor.LIGHT_GRAY);
        table.addCell(head);
        
        String address1="Bisafi road, Zeromile , Madhubani, Bihar, India-847121";
        String address2="softnetitech@gmail.com	, +91-7415811801 , +91-9708494644";
        
        PdfPCell sn = new PdfPCell(new Phrase(address1,subparaBold));
        sn.setColspan(10);
        sn.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(sn);
        
        PdfPCell name = new PdfPCell(new Phrase(address2,subparaBold));
        name.setColspan(10);
        name.setBackgroundColor(BaseColor.CYAN);
        name.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(name);
        
        PdfPCell age = new PdfPCell(new Phrase("Age"));
        age.setColspan(10);
        age.setRowspan(10);
        age.setBackgroundColor(BaseColor.GRAY);
        table.addCell(age);
        
        PdfPCell surname = new PdfPCell(new Phrase("SURNAME"));
        surname.setBackgroundColor(BaseColor.BLUE);
        table.addCell(surname);
        
    
        
        document.add(table);
        document.close();
    }
 
}