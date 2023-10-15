import lombok.NonNull;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class VehicleRentalService {

    private Map<String, Branch> branches;
    private IVehicleRentalStrategy vehicleRentalStrategy;
    private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    public VehicleRentalService(@NonNull IVehicleRentalStrategy vehicleRentalStrategy) {
        this.branches = new HashMap<>();
        this.vehicleRentalStrategy = vehicleRentalStrategy;
    }

    public void addBranch(@NonNull String branchName) {
        if(branches.containsKey(branchName)) {
            System.out.printf("Branch %s already exists", branchName);
        }
        branches.put(branchName, new Branch());
    }

    public void allocatePrice(@NonNull String branchName,@NonNull String vehicleType,@NonNull Double price) {
        if(!branches.containsKey(branchName)) {
            LOGGER.log(Level.INFO, "Branch not present, creating branch before allocating price");
            branches.put(branchName, new Branch());
        }
        branches.get(branchName).getPrice().put(VehicleTypeEnum.valueOf(vehicleType), price);
    }

    public void addVehicle(@NonNull String vehicleId, @NonNull String vehicleType, @NonNull String branchName) {
        if(!branches.containsKey(branchName)) {
            LOGGER.log(Level.INFO, "Branch not present, creating branch before adding inventory");
            branches.put(branchName, new Branch());
        }
        VehicleTypeEnum vehicleTypeEnum = VehicleTypeEnum.valueOf(vehicleType);
        Vehicle vehicle = new Vehicle(vehicleId, vehicleTypeEnum);
        Inventory inventory = new Inventory(vehicle);
        branches.get(branchName).getInventoryMap().get(vehicleTypeEnum).add(inventory);
    }

    public Booking bookVehicle(@NonNull String vehicleType,@NonNull Date startTime,@NonNull Date endTime) {
        Booking booking = this.vehicleRentalStrategy.selectVehicle(branches, vehicleType, new Slot(startTime, endTime));
        if(booking!=null) {
            Inventory inventory = booking.getBranch().
                    getInventoryMap().get(VehicleTypeEnum.valueOf(vehicleType))
                    .stream()
                    .filter(inv -> inv.getVehicle() == booking.getVehicle())
                    .findAny()
                    .get();
            inventory.getBookedSlotSet().add(new Slot(startTime, endTime));
            System.out.printf("Booking successful %s", booking);
        }
        else {
            System.out.printf("Booking failed as no inventory for the vehicletype %s", vehicleType);
        }
        return booking;
    }

    // bonus
    public void viewVehicleInventory(Date startTime, Date endTime) {
//        private Map<String, Branch> branches;
        for(String branchName : this.branches.keySet()) {
            System.out.println("Branch = "+branchName);
            System.out.println(branches.get(branchName));
        }

    }
}
