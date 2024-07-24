package junseok.snr.transaction.core.order.dto;

import junseok.snr.transaction.core.order.entity.OrderEntity;
import junseok.snr.transaction.core.user.entity.UserEntity;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class OrderDto {
    private Long id;
    private String description;
    private UserEntity user;

    public static OrderDto toOrderDto(OrderEntity orderEntity) {
        return OrderDto.builder()
                .id(orderEntity.getId())
                .user(orderEntity.getUser())
                .description(orderEntity.getDescription())
                .build();
    }
}
