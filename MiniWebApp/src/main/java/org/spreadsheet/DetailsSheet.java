package org.spreadsheet;


import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DetailsSheet {

	private static String[] colums = {"fname","lname" ,"email","address" ,"gender", "d_o_b"};	
	
	private static List<Details> details = new ArrayList<>();
	public static void main(String[] args) {
		
		details.add(new Details("Virat", "Kohli", "virat@gmail.com", "Banglore", "Male", "21/12/2020"));
		details.add(new Details("Virat", "Kohli", "virat@gmail.com", "Banglore", "Male", "21/12/2020"));
		details.add(new Details("Virat", "Kohli", "virat@gmail.com", "Banglore", "Male", "21/12/2020"));
		details.add(new Details("Virat", "Kohli", "virat@gmail.com", "Banglore", "Male", "21/12/2020"));
		details.add(new Details("Virat", "Kohli", "virat@gmail.com", "Banglore", "Male", "21/12/2020"));
		
		Workbook workbook = new XSSFWorkbook();
		
		Sheet sheet = (Sheet) workbook.createSheet("Details");
		Font headerFont = workbook.createFont();
		headerFont.setBold(true);
		headerFont.setFontHeightInPoints((short) 16);
		headerFont.setColor(IndexedColors.RED.getIndex());
		
		CellStyle headerCellStyle = workbook.createCellStyle();
		headerCellStyle.setFont(headerFont);
		
		Row headerRow = sheet.createRow(0);
		
		for (int i = 0; i < colums.length; i++) {
			Cell cell = headerRow.createCell(i);
			cell.setCellValue(colums[i]);
			cell.setCellStyle(headerCellStyle);
		}
		
		int rowNum =1;
		
		for (Details x : details) {
			Row row =  sheet.createRow(rowNum++);
			row.createCell(0).setCellValue(x.fname);
			row.createCell(1).setCellValue(x.lname);
			row.createCell(2).setCellValue(x.email);
			row.createCell(3).setCellValue(x.address);
			row.createCell(4).setCellValue(x.gender);
			row.createCell(5).setCellValue(x.d_o_b);
		
		}
		
		for(int i =0; i<colums.length; i++) {
			 sheet.autoSizeColumn(i);
			 
		}
		
		try {
			FileOutputStream fileout = new FileOutputStream("Details.xlsx");
			workbook.write(fileout);
			fileout.close();
			workbook.close();
		
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
		
	}
}
