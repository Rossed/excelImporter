package edwards.ross.dsmsmagic.excel;

import edwards.ross.dsmsmagic.model.TicketActivity;
import edwards.ross.dsmsmagic.model.TicketMovements;
import edwards.ross.dsmsmagic.repositories.TicketActivityRepository;
import edwards.ross.dsmsmagic.repositories.TicketMovementsRepository;
import lombok.Cleanup;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

@Service
public class Readsheet {

  @Autowired private TicketActivityRepository ticketActivityRepository;
  @Autowired private TicketMovementsRepository ticketMovementsRepository;

  public void readFile(MultipartFile file) throws IOException, InvalidFormatException {
    @Cleanup InputStream inputStream = file.getInputStream();
    Workbook workbook = WorkbookFactory.create(inputStream);
    for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
      Sheet sheet = workbook.getSheetAt(i);
      String sheetName = sheet.getSheetName();
      for (Row row : sheet) {
        try {
          if (sheetName.contains("Sheet1")) {
            TicketActivity ticketActivity = new TicketActivity(row);
            ticketActivityRepository.save(ticketActivity);
          } else {
            TicketMovements ticketMovements = new TicketMovements(row);
            ticketMovementsRepository.save(ticketMovements);
          }
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    }
  }
}
