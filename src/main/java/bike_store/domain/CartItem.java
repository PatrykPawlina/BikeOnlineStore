package bike_store.domain;

import java.io.Serializable;
import java.math.BigDecimal;

public class CartItem implements Serializable {
    private static final long serialVerdionUID = -4546941350577482213L;
    private String id;
    private Bike bike;
    private int quantity;
    private BigDecimal totalPrice;

    public CartItem(String id) {
        super();
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public Bike getBike() {
        return bike;
    }

    public void setBike(Bike bike) {
        this.bike = bike;
        this.updateTotalPrice();
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getTotalPrice() {
        this.updateTotalPrice();
        return totalPrice;
    }

    public void updateTotalPrice() {
        totalPrice = this.bike.getUnitPrice().multiply(new BigDecimal(this.quantity));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int resuult = 1;
        resuult = prime * resuult + ((id == null) ? 0 : id.hashCode());
        return resuult;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        CartItem other = (CartItem) obj;
        if (id == null) {
            return other.id == null;
        } else return id.equals(other.id);
    }
}
