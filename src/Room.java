import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public class Room implements Serializable {
    static final long serialVersionUID = 47L;

    private String roomKind;
    private boolean wifiAccess;
    private double pricePerNight;
    private boolean available;
    private int floorNr;
    private int roomNr;



    private Guest guestInRoom;
    private ArrayList<Guest> guestsInRoom;

    public Room(String roomKind, boolean wifiAccess, double pricePerNight, boolean available, int floorNr, int roomNr) {
        this.roomKind = roomKind;
        this.wifiAccess = wifiAccess;
        this.pricePerNight = pricePerNight;
        this.available = available;
        this.floorNr = floorNr;
        this.roomNr = roomNr;

    }

    public String getRoomKind() {return roomKind;}
    public ArrayList<Guest> getGuestsInRoom() {return guestsInRoom;}
    public double getPricePerNight() {return pricePerNight;}
    public int getRoomNr() {return roomNr;}
    public int getFloorNr() {return floorNr;}
    public Guest getGuestInRoom() {return guestInRoom;}


    public boolean hasWifiAccess() {
        return wifiAccess;
    }
    public boolean isAvailable() {
        return available;
    }

    public void setGuestsInRoom(ArrayList<Guest> guestsInRoom) {this.guestsInRoom = guestsInRoom;}
    public void setGuestInRoom(Guest guestInRoom) {this.guestInRoom = guestInRoom;}
}
