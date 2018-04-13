package com.toxin.fullstack.mvc.excelpdf;

import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.springframework.web.servlet.view.document.AbstractExcelView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

public class ExcelDocument extends AbstractExcelView {

    @Override
    protected void buildExcelDocument(
        Map<String, Object> map,
        HSSFWorkbook workbook,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {

        HSSFSheet sheet = workbook.createSheet("EXAMPLE");

        response.setHeader("Content-Disposition", "attachment; filename=excelDocument.xls");

        Font font = workbook.createFont();
        font.setFontName("Arial");
        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        font.setColor(HSSFColor.WHITE.index);

        CellStyle style = workbook.createCellStyle();
        style.setFillForegroundColor(HSSFColor.BLUE.index);
        style.setFillPattern(CellStyle.SOLID_FOREGROUND);
        style.setFont(font);

        setExcelHeader(sheet, style);

        List<Cat> cats = (List<Cat>)map.get("modelObject");

        int rowCount = 1;
        for (Cat cat : cats) {
            HSSFRow row = sheet.createRow(rowCount++);
            row.createCell(0).setCellValue(cat.getName());
            row.createCell(1).setCellValue(cat.getWeight());
            row.createCell(2).setCellValue(cat.getColor());
        }
    }

    public void setExcelHeader(HSSFSheet excelSheet, CellStyle styleHeader) {
        HSSFRow header = excelSheet.createRow(0);

        header.createCell(0).setCellValue("Name");
        header.getCell(0).setCellStyle(styleHeader);
        header.createCell(1).setCellValue("Wieght");
        header.getCell(1).setCellStyle(styleHeader);
        header.createCell(2).setCellValue("Color");
        header.getCell(2).setCellStyle(styleHeader);
    }

}
