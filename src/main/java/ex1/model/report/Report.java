package ex1.model.report;

import ex1.model.vo.PhoneVO;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class Report {
    private static final String fileName = "C://Users/leonardo.oliveira7/Desktop/phones.xls";


    public void generateReport(ArrayList<PhoneVO> phones) throws IOException {
    HSSFWorkbook workbook = new HSSFWorkbook();
    HSSFSheet sheetUsers = workbook.createSheet("phones");

        int rownum = 0;

        Row row = sheetUsers.createRow(rownum++);
        int cellnum = 0;
        Cell cellId = row.createCell(cellnum++);
        cellId.setCellValue("ID");
        Cell cellDDI = row.createCell(cellnum++);
        cellDDI.setCellValue("DDI");
        Cell cellDDD = row.createCell(cellnum++);
        cellDDD.setCellValue("DDD");
        Cell cellNumber = row.createCell(cellnum++);
        cellNumber.setCellValue("NUMERO");
        for (PhoneVO phone : phones) {
            row = sheetUsers.createRow(rownum++);
            cellnum = 0;
            cellId = row.createCell(cellnum++);
            cellId.setCellValue(phone.getId());
            cellDDI = row.createCell(cellnum++);
            cellDDI.setCellValue(phone.getDdi());
            cellDDD = row.createCell(cellnum++);
            cellDDD.setCellValue(phone.getDdd());
            cellNumber = row.createCell(cellnum++);
            cellNumber.setCellValue(phone.getNumber());

        }

        try {
            FileOutputStream out = new FileOutputStream(new File(Report.fileName));

            workbook.write(out);
            out.close();
            System.out.println("Arquivo Excel criado com sucesso!");

        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado!");
        } catch (IOException e) {
            System.out.println("Erro na edição do arquivo!");
        }finally {
            workbook.close();
        }
}
}


