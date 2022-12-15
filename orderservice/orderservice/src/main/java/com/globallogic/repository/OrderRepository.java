package com.globallogic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.globallogic.modal.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order,Integer>{

}
