from locust import task, FastHttpUser
import random

class PlayApi(FastHttpUser):
    network_timeout = 30.0
    connection_timeout = 30.0

    def __init__(self, environment, **kwargs):
        super().__init__(environment, **kwargs)
        self.client.timeout = (self.connection_timeout, self.network_timeout)

    @task
    def get_inventory(self):
        inventory_id = 1  # Inventory ID를 고정 값으로 사용합니다.
        with self.client.get(f"/v1/inventory/get?inventoryId={inventory_id}", name="재고 조회 API", catch_response=True) as response:
            if response.status_code == 200:  # Assuming 200 is the expected status code
                response.success()
            else:
                response.failure(f"Unexpected status code: {response.status_code}")
