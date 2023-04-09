package sg.edu.nus.iss.workshop23.repository;

public class DBQueries {
    public static final String ORDDR_DETAILS_WITH_DISCOUNT_QUERY = """
            select o.id as order_id, date_format(o.order_date, '%d/%m/%Y') as order_date , o.customer_id,
            sum(od.quantity * od.unit_price ) as total_price,
            sum(od.quantity*od.unit_price*od.discount) as discount_total_price,
            sum(od.quantity*od.unit_price) - sum(od.quantity * od.unit_price * od.discount) as discounted_price,
            sum(od.quantity * p.standard_cost) as cost_price
            from orders o join order_details od on o.id = od.order_id
            left join products p on od.product_id = p.id
            where o.id = ?;
            """;

    public static final String SELECT_ALL_DISTINCT_ORDER_ID = """
            select distinct(o.id)
            from orders o join order_details od on o.id = od.order_id
            left join products p on od.product_id = p.id;
            """;
}
