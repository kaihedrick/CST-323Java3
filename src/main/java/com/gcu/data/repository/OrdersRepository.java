package com.gcu.data.repository;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import com.gcu.data.entity.OrderEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrdersRepository extends CrudRepository<OrderEntity, Long> {
    //example of truly overriding a method from the crudRepository and using our own customized sql
    @Override
    @Query(value = "SELECT * FROM ORDERS")
    public List<OrderEntity> findAll();

}
