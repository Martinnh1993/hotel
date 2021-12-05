import java.io.Serializable;

public class Room implements Serializable {
    static final long serialVersionUID = 47L;

    private String roomKind;
    private boolean wifiAccess;
    private double pricePerNight;
    private int floorNr;
    private int roomNr;
    private int capacity;
    private Guest guestInRoom;

    public Room () {}

    public void setPricePerNight(double pricePerNight) {
        this.pricePerNight = pricePerNight;
    }

    public Room(String roomKind, boolean wifiAccess, double pricePerNight, int floorNr, int roomNr, int capacity) {
        this.roomKind = roomKind;
        this.wifiAccess = wifiAccess;
        this.pricePerNight = pricePerNight;
        this.floorNr = floorNr;
        this.roomNr = roomNr;
        this.capacity = capacity;

    }
    public void setWifiAccess(boolean wifiAccess) {this.wifiAccess = wifiAccess;}
    public void setGuestInRoom(Guest guestInRoom) {this.guestInRoom = guestInRoom;}

    public String getRoomKind() {return roomKind;}
    public double getPricePerNight() {return pricePerNight;}
    public int getRoomNr() {return roomNr;}
    public int getFloorNr() {return floorNr;}
    public int getCapacity() {return capacity;}
    public Guest getGuestInRoom() {return guestInRoom;}
    public boolean hasWifiAccess() {return wifiAccess;}

}
