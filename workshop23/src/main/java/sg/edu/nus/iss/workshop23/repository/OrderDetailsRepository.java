package sg.edu.nus.iss.workshop23.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import sg.edu.nus.iss.workshop23.model.OrderDetails;

import static sg.edu.nus.iss.workshop23.repository.DBQueries.*;

import java.util.ArrayList;
import java.util.List;

@Repository
public class OrderDetailsRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public OrderDetails getOrderDetails(int orderId) {
        List<OrderDetails> orderDetailsList = new ArrayList<>();

        SqlRowSet rs = jdbcTemplate.queryForRowSet(ORDDR_DETAILS_WITH_DISCOUNT_QUERY, orderId);

        while (rs.next()) {
            if (rs.getInt("order_id") != 0) {
                orderDetailsList.add(OrderDetails.createFromResults(rs));
            }
        }

        if (orderDetailsList.isEmpty()) {
            System.out.println(">>>>>>>>>>>>>>>>> is empty");
            return null;
        }
        return orderDetailsList.get(0);
    }

    // get list of order id
    public List<String> getOrdersId() {
        List<String> ordersId = new ArrayList<>();

        SqlRowSet rs = jdbcTemplate.queryForRowSet(SELECT_ALL_DISTINCT_ORDER_ID);

        while (rs.next()) {
            ordersId.add(Integer.toString(OrderDetails.createIdFromResults(rs)));
        }

        return ordersId;
    }
}
