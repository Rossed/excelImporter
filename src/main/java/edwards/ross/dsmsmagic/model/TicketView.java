package edwards.ross.dsmsmagic.model;

import lombok.Data;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

@Entity
@Data
public class TicketView {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String ticketId;
    private String activity;
    private LocalDateTime activityTime;

}
