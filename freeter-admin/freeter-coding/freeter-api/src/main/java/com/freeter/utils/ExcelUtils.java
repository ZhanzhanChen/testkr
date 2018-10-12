package com.freeter.utils;

import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.extensions.XSSFCellBorder.BorderSide;

//import com.freeter.modules.stock.entity.view.ExcelData;

public class ExcelUtils {

//	public static void exportExcel(HttpServletResponse response, String fileName, ExcelData data) throws Exception {
//        // 告诉浏览器用什么软件可以打开此文件
//        response.setHeader("content-Type", "application/vnd.ms-excel");
//        // 下载文件的默认名称
//        response.setHeader("Content-Disposition", "attachment;filename="+URLEncoder.encode(fileName, "utf-8"));
//        exportExcel(data, response.getOutputStream());
//    }
//
//    public static void exportExcel(ExcelData data, OutputStream out) throws Exception {
//
//        XSSFWorkbook wb = new XSSFWorkbook();
//        try {
//            String sheetName = data.getName();
//            if (null == sheetName) {
//                sheetName = "Sheet1";
//            }
//            XSSFSheet sheet = wb.createSheet(sheetName);
//            writeExcel(wb, sheet, data);
//
//            wb.write(out);
//        } finally {
//            wb.close();
//        }
//    }
//
//    private static void writeExcel(XSSFWorkbook wb, Sheet sheet, ExcelData data) {
//
//        int rowIndex = 0;
//        rowIndex = writeTitlesToExcel(wb, sheet, data.getTitles());
//        writeRowsToExcel(wb, sheet, data.getRows(), rowIndex);
//        autoSizeColumns(sheet, data.getTitles().size() + 1);
//    }
//
//    private static int writeTitlesToExcel(XSSFWorkbook wb, Sheet sheet, List<String> titles) {
//        int rowIndex = 0;
//        int colIndex = 0;
//
//        Row titleRow = sheet.createRow(rowIndex);
//        colIndex = 0;
//
//        for (String field : titles) {
//            Cell cell = titleRow.createCell(colIndex);
//            cell.setCellValue(field);
//            colIndex++;
//        }
//
//        rowIndex++;
//        return rowIndex;
//    }

    private static int writeRowsToExcel(XSSFWorkbook wb, Sheet sheet, List<List<Object>> rows, int rowIndex) {
        int colIndex = 0;

        for (List<Object> rowData : rows) {
            Row dataRow = sheet.createRow(rowIndex);
            // dataRow.setHeightInPoints(25);
            colIndex = 0;

            for (Object cellData : rowData) {
                Cell cell = dataRow.createCell(colIndex);
                if (cellData != null) {
                    cell.setCellValue(cellData.toString());
                } else {
                    cell.setCellValue("");
                }

                colIndex++;
            }
            rowIndex++;
        }
        return rowIndex;
    }

    /**
     * 增加表格宽度
     * @param sheet 表名
     * @param columnNumber 列数量
     */
    public static void autoSizeColumns(Sheet sheet, int columnNumber) {

        for (int i = 0; i < columnNumber; i++) {
            int orgWidth = sheet.getColumnWidth(i);
            sheet.autoSizeColumn(i, true);
            int newWidth = (int) (sheet.getColumnWidth(i) + 100);
            if (newWidth > orgWidth) {
                sheet.setColumnWidth(i, newWidth);
            } else {
                sheet.setColumnWidth(i, orgWidth);
            }
        }
    }

    private static void setBorder(XSSFCellStyle style, BorderStyle border, XSSFColor color) {
        style.setBorderTop(border);
        style.setBorderLeft(border);
        style.setBorderRight(border);
        style.setBorderBottom(border);
        style.setBorderColor(BorderSide.TOP, color);
        style.setBorderColor(BorderSide.LEFT, color);
        style.setBorderColor(BorderSide.RIGHT, color);
        style.setBorderColor(BorderSide.BOTTOM, color);
    }
    
    /**
     * 导出excel判断浏览器
     * @param response
     * @param request
     * @param fileName 文件名
     * @param workbook
     */
    public static void excelRespone(HttpServletResponse response,HttpServletRequest request,String fileName,HSSFWorkbook workbook){
    	response.setCharacterEncoding("UTF-8");
        // 告诉浏览器用什么软件可以打开此文件
        response.setHeader("content-Type", "application/vnd.ms-excel;charset=UTF-8");
        // 下载文件的默认名称
        String agent = request.getHeader("USER-AGENT").toLowerCase();
        try{
	        if (agent.contains("firefox")){
	        	fileName=fileName+".xls";
	        	response.setHeader("Content-Disposition", "attachment;filename=" + new String(fileName.getBytes(), "ISO8859-1"));
	        }else{
	        	response.setHeader("Content-Disposition", "attachment;filename="+URLEncoder.encode(fileName+".xls","UTF-8"));
	        }
	        response.flushBuffer();
	        workbook.write(response.getOutputStream());
	        workbook.close();
        }catch(Exception e){
        	
        }
    }
}
