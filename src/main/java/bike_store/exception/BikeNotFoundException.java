package bike_store.exception;

public class BikeNotFoundException extends RuntimeException {
    private static final long serialVersionUID = -694354952032299587L;
    private String bikeId;

    public BikeNotFoundException(String bikeId) {
        this.bikeId = bikeId;
    }

    public String getBikeId() {
        return bikeId;
    }
}
