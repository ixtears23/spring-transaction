from locust import task, FastHttpUser
import random

class CouponApi(FastHttpUser):
    network_timeout = 30.0
    connection_timeout = 30.0

    def __init__(self, environment, **kwargs):
        super().__init__(environment, **kwargs)
        self.client.timeout = (self.connection_timeout, self.network_timeout)

    @task
    def issue_coupon_1(self):
        quantity = random.randint(1, 10)
        with self.client.post(f"/v1/inventory/reduce?inventoryId=1&quantity={quantity}", name="재고 감소 API", catch_response=True) as response:
            if response.status_code == 200:  # Assuming 200 is the expected status code
                response.success()
            else:
                response.failure(f"Unexpected status code: {response.status_code}")
