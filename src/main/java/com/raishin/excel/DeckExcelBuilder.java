package com.raishin.excel;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsView;

public class DeckExcelBuilder extends AbstractXlsView {

  @Override
  protected void buildExcelDocument(Map<String, Object> model, Workbook workbook,
      HttpServletRequest request, HttpServletResponse response) throws Exception {
    String fileName = new String("POIサンプル.xls".getBytes("MS932"), "ISO-8859-1");

    response.setHeader("Content-Disposition", "attachment; filename=" + fileName);

    Sheet sheet = workbook.createSheet("Spring");
    Row row = sheet.createRow(0);
    Cell cell = row.createCell(0);
    cell.setCellValue("Spring TEST");
  }

}
