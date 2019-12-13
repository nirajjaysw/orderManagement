package com.sapient.ecom.doa;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sapient.ecom.model.OrderDetails;

@Repository
public interface OrderRepository extends CrudRepository<OrderDetails, String> {

}
