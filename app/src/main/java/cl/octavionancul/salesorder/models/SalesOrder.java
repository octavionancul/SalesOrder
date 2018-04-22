package cl.octavionancul.salesorder.models;

import com.orm.SugarRecord;

public class SalesOrder extends SugarRecord {
    private String product;
    private int quantity, price;

    public SalesOrder() {
    }

    public SalesOrder(String product, int quantity, int price) {
        this.product = product;
        this.quantity = quantity;
        this.price = price;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
