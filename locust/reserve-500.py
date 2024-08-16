import random
from locust import HttpUser, task, between

class ReservationTest(HttpUser):
    network_timeout = 30.0
    connection_timeout = 30.0

    @task
    def reserve_class(self):
        user_id = random.randint(1, 1000000)
        class_id = random.randint(1, 500)
        self.client.post(f"/v1/classes/{class_id}/reserve?userId={user_id}")
