package junseok.snr.order.application;

import junseok.snr.order.adapter.out.entity.OrderEntity;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class OrderDto {
    private Long id;
    private String description;
    private long userId;

    public static OrderDto toOrderDto(OrderEntity orderEntity) {
        return OrderDto.builder()
                .id(orderEntity.getId())
                .userId(orderEntity.getUserId())
                .description(orderEntity.getDescription())
                .build();
    }
}
