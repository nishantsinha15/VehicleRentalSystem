import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.Date;

/**
 * 0<=Start<End<24
 */
@Getter
@AllArgsConstructor
@ToString
public class Slot {
    // todo handle multiple days
    private Date startTime;
    private Date endTime;
}
