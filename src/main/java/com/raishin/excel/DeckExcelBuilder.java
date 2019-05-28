package com.raishin.excel;

import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.raishin.entity.DeckEntity;
import com.raishin.service.DeckService;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.view.document.AbstractXlsView;

/**
 * エクセル出力用クラス
 */
public class DeckExcelBuilder extends AbstractXlsView {

    public final int DECK_NAME_COLUMN = 0;
    public final int DECK_WIN_COLUMN = 1;
    public final int DECK_LOSE_COLUMN = 2;
    public final int DECK_DRAW_COLUMN = 3;
    public final int DECK_SUM_COLUMN = 4;

    @Override
    protected void buildExcelDocument(Map<String, Object> model, Workbook workbook,
                                      HttpServletRequest request, HttpServletResponse response) throws Exception {
        List<DeckEntity> deckEntityList = (List<DeckEntity>) model.get("deckList");
        String fileName = new String("デッキ一覧.xls".getBytes("MS932"), "ISO-8859-1");

        response.setHeader("Content-Disposition", "attachment; filename=" + fileName);

        Sheet sheet = workbook.createSheet("Spring");

        Row row = sheet.createRow(0);
        row.createCell(DECK_NAME_COLUMN).setCellValue("デッキ名");
        row.createCell(DECK_WIN_COLUMN).setCellValue("勝利");
        row.createCell(DECK_LOSE_COLUMN).setCellValue("敗北");
        row.createCell(DECK_DRAW_COLUMN).setCellValue("引き分け");
        row.createCell(DECK_SUM_COLUMN).setCellValue("決闘数");

        int rowNumber = 1;
        for (DeckEntity deck : deckEntityList) {
            row = sheet.createRow(rowNumber);
            row.createCell(DECK_NAME_COLUMN).setCellValue(deck.getDeckname());
            row.createCell(DECK_WIN_COLUMN).setCellValue(deck.getWin());
            row.createCell(DECK_LOSE_COLUMN).setCellValue(deck.getLose());
            row.createCell(DECK_DRAW_COLUMN).setCellValue(deck.getDraw());
            row.createCell(DECK_SUM_COLUMN).setCellValue(deck.sum());
            rowNumber++;
        }
    }

}
