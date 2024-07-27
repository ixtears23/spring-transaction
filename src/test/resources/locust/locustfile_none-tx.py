# locustfile_no_tx.py
from locust import HttpUser, task, between
import random

class NoTxUser(HttpUser):
    wait_time = between(1, 2)

    @task(5)
    def create_and_get_order(self):
        # 등록
        description = "order {}".format(random.randint(1, 1000))
        with self.client.post("/orders/jpa/none-tx", {"description": description}, catch_response=True) as response:
            if response.status_code == 201:
                json_response = response.json()
                order_id = json_response['id']
                # 무작위 조회
                self.client.get(f"/orders/jpa/none-tx/{order_id}", name="/orders/jpa/none-tx/[id]")
