package edwards.ross.dsmsmagic.model;

import jdk.nashorn.internal.objects.annotations.Constructor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TicketActivity {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  private String ticketId;
  private String title;
  private LocalDateTime activityTime;
  private String activityType;
  private String activityDescription;
  private String activityOperator;

  public TicketActivity(Row row) {
    this.ticketId = row.getCell(0).getStringCellValue();
    this.title = row.getCell(1).getStringCellValue();
    Date date = DateUtil.getJavaDate((double) row.getCell(2).getNumericCellValue());
    this.activityTime = LocalDateTime.ofInstant(date.toInstant(), ZoneId.of("Australia/Canberra"));
    this.activityType = row.getCell(3).getStringCellValue();
    this.activityDescription = row.getCell(4).getStringCellValue();
    this.activityOperator = row.getCell(5).getStringCellValue();
  }
}
