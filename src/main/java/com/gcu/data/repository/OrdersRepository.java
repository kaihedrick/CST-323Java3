package com.gcu.data.repository;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gcu.data.entity.OrderEntity;

import java.util.List;

@Repository
public interface OrdersRepository extends CrudRepository<OrderEntity, Long> {

    /**
     * Retrieve all orders from the database.
     * Using a custom query to select all records from the ORDERS table.
     */
    @Override
    @Query("SELECT * FROM ORDERS")
    List<OrderEntity> findAll();

    /**
     * Find an order by its ID.
     * @param id The ID of the order to retrieve.
     * @return The OrderEntity if found, otherwise null.
     */
    @Query("SELECT * FROM ORDERS WHERE ID = :id")
    OrderEntity findById(long id);

    /**
     * Insert a new order into the database.
     * @param order The order entity to be inserted.
     * @return The inserted OrderEntity.
     */
    @Query("INSERT INTO ORDERS (ORDER_NO, PRODUCT_NAME, PRICE, QUANTITY) VALUES (:orderNo, :productName, :price, :quantity)")
    boolean create(OrderEntity order);

    /**
     * Update an existing order in the database.
     * @param order The order entity with updated fields.
     * @return True if update was successful, false otherwise.
     */
    @Query("UPDATE ORDERS SET ORDER_NO = :orderNo, PRODUCT_NAME = :productName, PRICE = :price, QUANTITY = :quantity WHERE ID = :id")
    boolean update(OrderEntity order);

    /**
     * Delete an order by its ID.
     * @param id The ID of the order to be deleted.
     * @return True if deletion was successful, false otherwise.
     */
    @Query("DELETE FROM ORDERS WHERE ID = :id")
    boolean delete(long id);
}
