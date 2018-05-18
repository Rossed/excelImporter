package edwards.ross.dsmsmagic.excel;

import edwards.ross.dsmsmagic.model.TicketActivity;
import edwards.ross.dsmsmagic.repositories.TicketActivityRepository;
import edwards.ross.dsmsmagic.repositories.TicketMovementsRepository;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

@Service
public class Writesheet {

  @Autowired private TicketActivityRepository ticketActivityRepository;
  @Autowired private TicketMovementsRepository ticketMovementsRepository;

  public void writeFile() throws IOException {
    Workbook workbook = new XSSFWorkbook();

    Sheet sheet = workbook.createSheet("Ticket Activity");

    List<TicketActivity> ticketActivities = ticketActivityRepository.findAll();

    Row row;
    for (TicketActivity activity : ticketActivities) {
      row = sheet.createRow((int) activity.getId());
      Cell ticketId = row.createCell(0);
      ticketId.setCellValue(activity.getTicketId());

      Cell title = row.createCell(1);
      title.setCellValue(activity.getTitle());

      Cell activityTime = row.createCell(2);
      Date date =
          Date.from(activity.getActivityTime().atZone(ZoneId.of("Australia/Canberra")).toInstant());
      activityTime.setCellValue(DateUtil.getExcelDate(date));

      Cell activityType = row.createCell(3);
      activityType.setCellValue(activity.getActivityType());

      Cell activityDescription = row.createCell(4);
      activityDescription.setCellValue(activity.getActivityDescription());

      Cell activityOperator = row.createCell(5);
      activityOperator.setCellValue(activity.getActivityOperator());
    }

    FileOutputStream out =
        new FileOutputStream(new File("src/main/resources/workbooks/Writesheet.xlsx"));
    workbook.write(out);
    out.close();
  }
}
