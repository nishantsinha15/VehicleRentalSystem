import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class VehicleServiceUnitTest {

    @Test
    public void testNullCheck(){
//        VehicleRentalService vehicleRentalService = new VehicleRentalService();
        int[] a = new int[10];
//        Assertions.assertThrows(NullPointerException.class, () -> vehicleRentalService.bookVehicle(null, null, null));
    }

    /**
     * addBranch(“Vasanth Vihar”)
     * addBranch(“Cyber City”)
     * allocatePrice(“Vasanth Vihar”, VehicleType.Sedan, 100)
     * allocatePrice(“Vasanth Vihar”, VehicleType.Hatchback, 80) allocatePrice(“Cyber City”,
     * VehicleType.Sedan, 200)
     * allocatePrice(“Cyber City”, VehicleType.Hatchback, 50)
     * addVehicle(“DL 01 MR 9310”, VehicleType.Sedan, “Vasanth Vihar”) addVehicle(“DL 01 MR
     * 9311”, VehicleType.Sedan, “Cyber City”) addVehicle(“DL 01 MR 9312”, VehicleType.Hatchback, “Cyber City”) bookVehicle(VehicleType.Sedan, 29-02-2020 10:00 AM, 29-02-2020 01:00 PM)
     * “DL 01 MR 9310” from Vasanth Vihar booked.
     */
    @Test
    public void testBooking() throws ParseException {
        VehicleRentalService vehicleRentalService = new VehicleRentalService(new VehicleRentalStrategyCheapest());
        vehicleRentalService.addBranch("Vasanth Vihar");
        vehicleRentalService.addBranch("Cyber City");
        vehicleRentalService.allocatePrice("Vasanth Vihar", "SEDAN", 100.0);
        vehicleRentalService.allocatePrice("Vasanth Vihar", "HATCHBACK", 80.0);
        vehicleRentalService.allocatePrice("Cyber City", "SEDAN", 200.0);
        vehicleRentalService.allocatePrice("Cyber City", "HATCHBACK", 50.0);
        vehicleRentalService.addVehicle("DL 01 MR 9310", "SEDAN", "Vasanth Vihar");
        vehicleRentalService.addVehicle("DL 01 MR * 9311", "Sedan", "Cyber City");
        vehicleRentalService.addVehicle("DL 01 MR 9312", "HATCHBACK", "Cyber City");
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy hh:mm a");
        vehicleRentalService.bookVehicle("Sedan", dateFormat.parse("29-02-2020 10:00 AM"), dateFormat.parse("29-02-2020 01:00 PM"));
    }

}
