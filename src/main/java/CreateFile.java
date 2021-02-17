import au.com.bytecode.opencsv.CSVWriter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class CreateFile {
        public static void main(String[] args) throws IOException {

            CSVWriter writer = new CSVWriter(new FileWriter("src//main//resources//FileWriter1.csv"));

            String[] record = "Oleh,Igor,Yura,Vlad,Nick,Jack,Bob,Misha,Mot,Ben".split(",");

            writer.writeNext(record);
            writer.close();

            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet spreadsheet_1 = workbook.createSheet("Excel Sheet");

            ArrayList<String> arrRows = new ArrayList<>(Arrays.asList(record));
            for (int i = 0; i < arrRows.size(); i++){
                XSSFRow row = spreadsheet_1.createRow(i);

                ArrayList<String> arrElement = new ArrayList<>(Arrays.asList(arrRows.get(i).split("\n")));
                for(int j = 0; j < arrElement.size(); j++) {

                    XSSFCell cell = row.createCell(j);
                    cell.setCellValue(arrElement.get(j));
                }
            }

            FileOutputStream out = new FileOutputStream(new File("src//main//resources//FileWriter2.xlsx"));
            workbook.write(out);
            out.close();
        }
    }

