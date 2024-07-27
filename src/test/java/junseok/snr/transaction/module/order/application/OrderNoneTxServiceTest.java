package junseok.snr.transaction.module.order.application;

import junseok.snr.transaction.core.order.dto.OrderDto;
import junseok.snr.transaction.core.order.infrastructure.OrderRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ActiveProfiles;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@ActiveProfiles("test")
@EntityScan(basePackages = "junseok.snr.transaction.core")
class OrderNoneTxServiceTest {
    private final OrderNoneTxService orderNoneTxService;

    public OrderNoneTxServiceTest(@Autowired OrderRepository orderRepository,
                                  @Autowired Environment environment) {
        this.orderNoneTxService = new OrderNoneTxService(orderRepository);

        Arrays.stream(environment.getActiveProfiles())
                        .toList()
                                .forEach(System.out::println);

        System.out.println("=====" + environment.getActiveProfiles().length);
    }

    @Test
    void createOrderTest() {

        final OrderDto createdOrder = orderNoneTxService.creatOrder("test");

        assertThat(createdOrder.getId()).isNotNull();
    }
}