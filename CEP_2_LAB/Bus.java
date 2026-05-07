package CEP_2_LAB;

public class Bus {

    private final int busId;
    private final String route;
    private String currentLocation;

    public Bus(int busId, String route, String currentLocation) {

        this.busId = busId;
        this.route = route;
        this.currentLocation = currentLocation;
    }

    public int getBusId() {
        return busId;
    }

    public String getRoute() {
        return route;
    }

    public String getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(String currentLocation) {
        this.currentLocation = currentLocation;
    }

    @Override
    public String toString() {

        return busId + "," + route + "," + currentLocation;
    }
}