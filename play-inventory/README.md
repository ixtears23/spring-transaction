- N개의 Inventory 특정 시간에 수십개 생성
- 특정 시간이 되기 전에, 사용자 진입 시도 시작
- 피크를 찍으면서 순식간에 inventory 매진
- 이 때, 동일 사용자는 여러 번 요청을 해도 1번만 가져가야 하고,
- 정원을 초과할 수 없음.
- 그러니깐.. 실제 inventory를 가져간 사람수와 기존 inventory 숫자가 동일해야 함.