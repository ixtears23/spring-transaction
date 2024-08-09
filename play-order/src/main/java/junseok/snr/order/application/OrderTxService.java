package junseok.snr.order.application;

import junseok.snr.core.order.dto.OrderDto;
import junseok.snr.core.order.entity.OrderEntity;
import junseok.snr.core.order.exception.ErrorCode;
import junseok.snr.core.order.exception.OrderException;
import junseok.snr.core.order.infrastructure.OrderRepository;
import junseok.snr.core.outbox.event.OrderEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class OrderTxService {
    private final OrderRepository orderRepository;
    private final ApplicationEventPublisher eventPublisher;

    @Transactional
    public OrderDto creatOrder(String description) {
        validateCreateOrder(description);

        final OrderEntity newOrderEntity = OrderEntity.builder()
                .description(description)
//                .user(UserEntity.builder().build())
                .build();
        orderRepository.save(newOrderEntity);

        eventPublisher.publishEvent(
                new OrderEvent(
                        newOrderEntity.getId(),
                        description
                )
        );

        return OrderDto.toOrderDto(createOrder(description));
    }

    private void validateCreateOrder(String description) {
        final OrderEntity orderEntity = orderRepository.findFirstByDescription(description)
                .orElse(null);

        if (orderEntity != null) throw new OrderException(ErrorCode.ALREADY_EXISTS_ORDER);
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
