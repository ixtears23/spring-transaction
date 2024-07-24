package junseok.snr.transaction.module.order.application;

import junseok.snr.transaction.core.order.dto.OrderDto;
import junseok.snr.transaction.core.order.entity.OrderEntity;
import junseok.snr.transaction.core.order.infrastructure.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class OrderTxService {
    private final OrderRepository orderRepository;

    @Transactional
    public OrderDto creatOrder(String description) {
        return OrderDto.toOrderDto(createOrder(description));
    }

    @Transactional(readOnly = true)
    public OrderDto creatOrderdReadOnly(String description) {
        return OrderDto.toOrderDto(createOrder(description));
    }

    private OrderEntity createOrder(String description) {
        return orderRepository.save(
                OrderEntity.builder()
                        .description(description)
                        .build()
        );
    }

    @Transactional(readOnly = true)
    public OrderDto getOrderReadOnly(Long id) {
        return OrderDto.toOrderDto(getOrder(id));
    }

    @Transactional
    public OrderDto getOrderNoneReadOnly(Long id) {
        return OrderDto.toOrderDto(getOrder(id));
    }

    private OrderEntity getOrder(Long id) {
        return orderRepository.findById(id)
                .orElse(OrderEntity.builder().build());
    }
}
