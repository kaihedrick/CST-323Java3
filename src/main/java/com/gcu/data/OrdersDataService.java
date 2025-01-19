package com.gcu.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import com.gcu.data.entity.OrderEntity;
import com.gcu.data.repository.OrdersRepository;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;


@Service
public class OrdersDataService implements DataAccessInterface<OrderEntity> {
    @Autowired  // Add this annotation
    private OrdersRepository ordersRepository;
    @SuppressWarnings("unused")
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplateObject;

    /**
     * Non-default constructor for constructor injection.
     * @param ordersRepository
     * @param dataSource
     */
    public OrdersDataService(OrdersRepository ordersRepository, DataSource dataSource) {
        this.ordersRepository = ordersRepository;
        this.dataSource = dataSource;
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }
    public OrderEntity findById(int id)
    {
        return null;
    }

    public List<OrderEntity> findAll() {
        List<OrderEntity> orders = new ArrayList<OrderEntity>();
        try{
            //get all the entity orders
            Iterable<OrderEntity> ordersIterable = ordersRepository.findAll();
            //convert to a list and return the list
            orders = new ArrayList<OrderEntity>();
            ordersIterable.forEach(orders::add);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        //return the list
        return orders;
    }


    public boolean create(OrderEntity order) {
        String sql = "INSERT INTO ORDERS(ORDER_NO, PRODUCT_NAME, PRICE, QUANTITY) VALUES(?, ?, ?, ?)";
        try{
            //execute sql insert
            jdbcTemplateObject.update(sql,
                    order.getOrderNo(),
                    order.getProductName(),
                    order.getPrice(),
                    order.getQuantity());
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return false;
        }
        return true;
    }


    public boolean update(OrderEntity t) {
        return true;
    }


    public boolean delete(OrderEntity t) {
        return true;
    }


}
