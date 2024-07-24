package junseok.snr.transaction.module.order.application;

import junseok.snr.transaction.core.order.dto.OrderDto;
import junseok.snr.transaction.core.order.entity.OrderEntity;
import junseok.snr.transaction.core.order.infrastructure.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class OrderNoneTxService {
    private final OrderRepository orderRepository;

    public OrderDto creatOrder(String description) {
        final OrderEntity orderEntity = orderRepository.save(
                OrderEntity.builder()
                        .description(description)
                        .build()
        );

        return OrderDto.toOrderDto(orderEntity);
    }

    public OrderDto getOrder(Long id) {
        final OrderEntity orderEntity = orderRepository.findById(id)
                .orElse(OrderEntity.builder().build());
        return OrderDto.toOrderDto(orderEntity);
    }

}
