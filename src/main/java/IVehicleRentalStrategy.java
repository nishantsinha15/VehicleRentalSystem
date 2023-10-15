import lombok.NonNull;

import java.util.Date;
import java.util.Map;

public interface IVehicleRentalStrategy {
    public Booking selectVehicle(Map<String, Branch> branches, String vehicleType, Slot desiredSlot);
}
