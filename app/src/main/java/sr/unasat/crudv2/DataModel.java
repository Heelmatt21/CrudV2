package sr.unasat.crudv2;

public class DataModel {

    private int id;
    private String date;
    private String time;

    private String customData;

    private double latitude;

    private double longitude;

    public DataModel() {
        // Lege constructor vereist voor SQLite
    }

    public DataModel(String date, String time) {
        this.date = date;
        this.time = time;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }


    public String getCustomData() {
            return customData;
    }

    public void setCustomData(String customData) {
            this.customData = customData;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
    @Override
    public String toString() {
        return "REF: " + getId() +
                ", Date: " + getDate() +
                ", Time: " + getTime() +
                ", Custom Data: " + getCustomData();
                //", Latitude: " + getLatitude() + //locatie
                //", Longitude: " + getLongitude(); //locatie
    }



}
