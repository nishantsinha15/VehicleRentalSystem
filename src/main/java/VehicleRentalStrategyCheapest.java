import java.awt.print.Book;
import java.util.Date;
import java.util.Map;

public class VehicleRentalStrategyCheapest implements IVehicleRentalStrategy{

    private boolean checkFreeSlot(Slot slot, Slot desiredSlot) {
        return  desiredSlot.getEndTime().before(slot.getStartTime()) || desiredSlot.getStartTime().after(slot.getEndTime());
    }

    @Override
    public Booking selectVehicle(Map<String, Branch> branches, String vehicleType, Slot desiredSlot){
        Double price = Double.MAX_VALUE;
        Booking booking = null;
        VehicleTypeEnum vehicleTypeEnum = VehicleTypeEnum.valueOf(vehicleType);
        for(Branch branch : branches.values()) {
            if(branch.getPrice().get(vehicleTypeEnum) < price) continue;
            price = branch.getPrice().get(vehicleTypeEnum);
            for(Inventory inventory : branch.getInventoryMap().get(vehicleTypeEnum)) {
                boolean isFree = inventory.getBookedSlotSet().stream().allMatch(slot -> checkFreeSlot(slot, desiredSlot));
                if(isFree) {
                    booking = new Booking(inventory.getVehicle(), desiredSlot, price, branch);
                }
            }
        }
        return booking;
    }

}
