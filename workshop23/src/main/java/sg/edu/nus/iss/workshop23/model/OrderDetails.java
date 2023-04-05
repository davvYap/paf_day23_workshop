package sg.edu.nus.iss.workshop23.model;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class OrderDetails {
    private int id;
    private DateTime orderDate;
    private int customerId;
    private double totalPrice;
    private double discountTotalPrice;
    private double discountedPrice;
    private double costPrice;

    public OrderDetails() {
    }

    public OrderDetails(int id, DateTime orderDate, int customerId, double totalPrice, double discountTotalPrice,
            double discountedPrice, double costPrice) {
        this.id = id;
        this.orderDate = orderDate;
        this.customerId = customerId;
        this.totalPrice = totalPrice;
        this.discountTotalPrice = discountTotalPrice;
        this.discountedPrice = discountedPrice;
        this.costPrice = costPrice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public DateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(DateTime orderDate) {
        this.orderDate = orderDate;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public double getDiscountTotalPrice() {
        return discountTotalPrice;
    }

    public void setDiscountTotalPrice(double discountTotalPrice) {
        this.discountTotalPrice = discountTotalPrice;
    }

    public double getDiscountedPrice() {
        return discountedPrice;
    }

    public void setDiscountedPrice(double discountedPrice) {
        this.discountedPrice = discountedPrice;
    }

    public double getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(double costPrice) {
        this.costPrice = costPrice;
    }

    @Override
    public String toString() {
        return "OrderDetails [id=" + id + ", orderDate=" + orderDate + ", customerId=" + customerId + ", totalPrice="
                + totalPrice + ", discountTotalPrice=" + discountTotalPrice + ", discountedPrice=" + discountedPrice
                + ", costPrice=" + costPrice + "]";
    }

    public static OrderDetails createFromResults(SqlRowSet rs) {
        OrderDetails od = new OrderDetails();
        od.setId(rs.getInt("order_id"));
        DateTime date = getDateTime(rs.getString("order_date"));
        od.setOrderDate(date);
        od.setCustomerId(rs.getInt("customer_id"));
        od.setTotalPrice(rs.getDouble("total_price"));
        od.setDiscountTotalPrice(rs.getDouble("discount_total_price"));
        od.setDiscountedPrice(rs.getDouble("discounted_price"));
        od.setCostPrice(rs.getDouble("cost_price"));
        return od;
    }

    public static DateTime getDateTime(String date) {
        DateTimeFormatter formatter = DateTimeFormat.forPattern("dd/MM/yyyy");
        DateTime dateTime = formatter.parseDateTime(date);
        return dateTime;
    }

}
