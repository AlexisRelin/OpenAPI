package com.example.openapigenerator.delegate;

import com.example.openapigenerator.order.rest.api.OrderApiDelegate;
import com.example.openapigenerator.order.rest.model.OrderRequestDto;
import com.example.openapigenerator.order.rest.model.OrderResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class OrderApiDelegateImpl implements OrderApiDelegate {

    @Override
    public ResponseEntity<OrderResponseDto> ordersPost(OrderRequestDto orderRequestDto) {
        OrderResponseDto response = new OrderResponseDto();
        return ResponseEntity.ok().body(response);
    }
}
