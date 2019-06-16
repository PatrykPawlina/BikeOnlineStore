package bike_store.dto;

import java.io.Serializable;

public class CartItemDto implements Serializable {
    private static final long serialVersionUID = 3551573319376880896L;

    private String id;
    private String bikeId;
    private int quantity;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBikeId() {
        return bikeId;
    }

    public void setBikeId(String productId) {
        this.bikeId = bikeId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
