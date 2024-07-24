package junseok.snr.transaction.core.order.entity;

import jakarta.persistence.*;
import junseok.snr.transaction.core.user.entity.UserEntity;
import lombok.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Getter
@Table(name = "orders")
@Entity
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    @ManyToOne(fetch = FetchType.LAZY)
    private UserEntity user;
}
