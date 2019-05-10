package com.sit.util;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.ExceptionConverter;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.AcroFields;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfFormField;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPCellEvent;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.TextField;

import com.sit.bean.Student;

public class PDFConverter implements Serializable, PdfPCellEvent {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final String LOGO_NCS = "D:/LOGO.png";
	private static String jobNumber = null;
	protected int tf;
	public static final String FILE_ZFER = "D://source.pdf";
	public static final String FILE_ZFER1 = "D://MasterData_ZFER.pdf";

	public PDFConverter(int tf) {
		this.tf = tf;
	}

	public PDFConverter() {

	}



	public static void manipulatePdf(String src, String dest) throws IOException, DocumentException {
		PdfReader reader = new PdfReader(src);
		PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(dest));
		AcroFields form = stamper.getAcroFields();

		form.setFieldProperty("text_4", "textsize", new Float(8), null);
		form.regenerateField("text_4");

		stamper.close();
		reader.close();

	}

	public void cellLayout(PdfPCell cell, Rectangle rectangle, PdfContentByte[] canvases) {
		PdfWriter writer = canvases[0].getPdfWriter();
		TextField text = new TextField(writer, rectangle, String.format("text_%s", tf));

		text.setFontSize(6);

		text.setText("");
		text.setOptions(TextField.MULTILINE | TextField.REQUIRED);

		try {
			PdfFormField field = text.getTextField();
			writer.addAnnotation(field);
		} catch (IOException ioe) {
			throw new ExceptionConverter(ioe);
		} catch (DocumentException de) {
			throw new ExceptionConverter(de);
		}
	}

	private static void addContent(Document document, List<Student> resultList) throws DocumentException {

		try {
			Image img1 = Image.getInstance(LOGO_NCS);

			Font headerBold = new Font(FontFamily.TIMES_ROMAN, 16, Font.BOLD);
			Font paraBold = new Font(FontFamily.TIMES_ROMAN, 12, Font.BOLD);
			Font bold = new Font(FontFamily.COURIER, 10, Font.BOLD);
			Font medium = new Font(FontFamily.COURIER, 10, Font.NORMAL);
			Font mediumKey = new Font(FontFamily.COURIER, 10, Font.BOLD);
			Font mediumValue = new Font(FontFamily.COURIER, 10, Font.ITALIC);
			Font small = new Font(FontFamily.COURIER, 9, Font.NORMAL);
			Font noteFontColor = new Font(FontFamily.HELVETICA, 10, Font.NORMAL, BaseColor.RED);
			PdfPTable table = new PdfPTable(3);
			table.getDefaultCell().setBorder(PdfPCell.BOX);
			table.setTotalWidth(490);
			table.setLockedWidth(true);
			String attachment = null;
			Image snapshot[] = new Image[resultList.size()];
			String prob_desc = null;
			String sugg = null;
			int value = 4;

			PdfPCell c18 = new PdfPCell();
			c18.setFixedHeight(20);
			c18.setColspan(3);
			c18.setBorder(Rectangle.NO_BORDER);
			table.addCell(c18);

			for (int i = 0; i < resultList.size(); i++) {
				PdfPCell c1;
				if (i == 0) {
					c1 = new PdfPCell(new Phrase("sno", paraBold));
				} else {
					c1 = new PdfPCell(new Phrase("", paraBold));
				}
				c1.setFixedHeight(20);
				c1.setHorizontalAlignment(Element.ALIGN_LEFT);

				PdfPCell c2 = new PdfPCell(new Phrase("Problem Description", paraBold));

				c2.setFixedHeight(20);
				c2.setHorizontalAlignment(Element.ALIGN_LEFT);

				PdfPCell c3 = new PdfPCell(new Phrase("Snapshot", paraBold));

				c3.setFixedHeight(20);
				c3.setHorizontalAlignment(Element.ALIGN_LEFT);

				table.addCell(c1);
				table.addCell(c2);
				table.addCell(c3);


				
				PdfPCell c4 = new PdfPCell(new Phrase(i + 1 + ""));

				c4.setFixedHeight(130);
				c4.setHorizontalAlignment(Element.ALIGN_LEFT);
				PdfPCell c5 = new PdfPCell(new Phrase(prob_desc));

				c4.setFixedHeight(130);
				c4.setHorizontalAlignment(Element.ALIGN_LEFT);

				PdfPCell c6 = new PdfPCell(snapshot[0]);

				c4.setFixedHeight(130);
				c4.setHorizontalAlignment(Element.ALIGN_LEFT);

				table.addCell(c4);
				table.addCell(c5);
				table.addCell(c6);

				PdfPCell c7 = new PdfPCell(new Phrase());
				c7.setHorizontalAlignment(Element.ALIGN_LEFT);
				PdfPCell c8 = new PdfPCell(new Phrase("Solution", paraBold));

				c8.setHorizontalAlignment(Element.ALIGN_LEFT);
				PdfPCell c9 = new PdfPCell(new Phrase("Snapshot", paraBold));

				c9.setHorizontalAlignment(Element.ALIGN_LEFT);
				table.addCell(c7);
				table.addCell(c8);
				table.addCell(c9);

				PdfPCell c10 = new PdfPCell(new Phrase());

				c10.setFixedHeight(130);
				c10.setHorizontalAlignment(Element.ALIGN_LEFT);
				PdfPCell c11 = new PdfPCell(new Phrase(sugg));

				c11.setFixedHeight(130);
				c11.setHorizontalAlignment(Element.ALIGN_LEFT);

				PdfPCell c12 = new PdfPCell(snapshot[0]);

				c12.setFixedHeight(130);
				c12.setHorizontalAlignment(Element.ALIGN_LEFT);

				table.addCell(c10);
				table.addCell(c11);
				table.addCell(c12);

				PdfPCell c14 = new PdfPCell(new Phrase());
				c14.setHorizontalAlignment(Element.ALIGN_LEFT);
				PdfPCell c15 = new PdfPCell(new Phrase("Customer Suggestion", paraBold));
				c15.setColspan(2);
				c15.setHorizontalAlignment(Element.ALIGN_LEFT);
				PdfPCell c16 = new PdfPCell(new Phrase());
				c16.setFixedHeight(70);
				c16.setHorizontalAlignment(Element.ALIGN_LEFT);
				table.addCell(c14);
				table.addCell(c15);
				table.addCell(c16);

				PdfPCell c17;

				c17 = new PdfPCell();
				c17.setColspan(2);
				c17.setFixedHeight(70);
				table.addCell(c17);
				value++;

			}

			try {
				table.setWidths(new int[] { 16, 140, 95 });
				document.add(table);

			} catch (DocumentException e) {
				e.printStackTrace();
			}
		} catch (BadElementException e1) {

			e1.printStackTrace();
		} catch (IOException e1) {

			e1.printStackTrace();
		}

	}

	public static void mainMethod(String customerid,String feedbacktype ) {


		try {

		Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + "D:\\FeedbackToCustomer.pdf");
		} catch (Exception e) {
			System.out.println("Error" + e.getMessage());
			e.printStackTrace();
		}
	}





	public class HeaderTable extends PdfPageEventHelper {
		public PdfPTable table;
		public PdfPTable table1;
		public float tableHeight;
		Font headerBold = new Font(FontFamily.TIMES_ROMAN, 16, Font.BOLD);
		Font paraBold = new Font(FontFamily.TIMES_ROMAN, 12, Font.BOLD);
		Font bold = new Font(FontFamily.TIMES_ROMAN, 10, Font.BOLD);
		Font medium = new Font(FontFamily.TIMES_ROMAN, 10, Font.NORMAL);

		public HeaderTable() throws BadElementException, MalformedURLException, IOException {
			table1 = new PdfPTable(2);
			table = new PdfPTable(1);
			table.getDefaultCell().setBorder(PdfPCell.BOX);
			table.setTotalWidth(495);
			table.setLockedWidth(true);

			table.getDefaultCell().setBorder(PdfPCell.NO_BORDER);
			table1.getDefaultCell().setBorder(PdfPCell.NO_BORDER);

			Image img1 = Image.getInstance("logo.png");
			PdfPCell c11 = new PdfPCell(img1);
			c11.setFixedHeight(35);
			c11.setBorder(Rectangle.NO_BORDER);
			table1.addCell(c11);
			table1.addCell(new Phrase("Document Number:" + "..............."));

			PdfPCell c1o = new PdfPCell();
			c1o.setFixedHeight(35);
			c1o.setColspan(2);
			c1o.setBorder(Rectangle.NO_BORDER);
			table1.addCell(c1o);

			PdfPCell c12 = new PdfPCell(new Phrase("Feedback Report", headerBold));
			c12.setColspan(4);

			c12.setBackgroundColor(BaseColor.LIGHT_GRAY);
			c12.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(table1);

			PdfPTable table_1_1 = new PdfPTable(4);

			table_1_1.addCell(c12);
			table_1_1.addCell(new Phrase("Job Name :	", bold));
			table_1_1.addCell(new Phrase(jobNumber, medium));
			table_1_1.addCell(new Phrase("Customer : ", bold));
			table_1_1.addCell(new Phrase(" ", medium));

			Date date = new Date(System.currentTimeMillis());
			SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
			String currentDate = formatter.format(date);
			System.out.println(currentDate);

			table_1_1.addCell(new Phrase("Date : ", bold));

			table_1_1.addCell(new Phrase(currentDate, medium));
			table_1_1.addCell(new Phrase("CAM Engineer : ", bold));
			table_1_1.addCell(new Phrase("NCS", medium));
			table.addCell(table_1_1);

			tableHeight = table.getTotalHeight();
		}

		public float getTableHeight() {
			return tableHeight;
		}

		public void onEndPage(PdfWriter writer, Document document) {
			// BOTTOM RIGHT
			ColumnText.showTextAligned(writer.getDirectContent(), Element.ALIGN_CENTER,
					new Phrase("Page " + writer.getPageNumber()), 500, 10, 0);
			table.writeSelectedRows(0, -1, document.left(), document.top() + ((document.topMargin() + tableHeight) / 2),
					writer.getDirectContent());
		}
	}
}

