package sg.edu.nus.iss.workshop23.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sg.edu.nus.iss.workshop23.model.OrderDetails;
import sg.edu.nus.iss.workshop23.repository.OrderDetailsRepository;

@Service
public class OrderDetailsService {
    @Autowired
    OrderDetailsRepository odRepo;

    public OrderDetails getOrderDetails(int orderId) {
        return odRepo.getOrderDetails(orderId);
    }
}
