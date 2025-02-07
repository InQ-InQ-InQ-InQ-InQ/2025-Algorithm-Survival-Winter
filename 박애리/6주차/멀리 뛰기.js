function solution(n) {
  if (n === 1) {
    return n;
  }
  let [a, b] = [1, 1]; //구조 분해할당으로 접근근
  for (let i = 2; i < n + 1; i++) {
    [a, b] = [b, (a + b) % 1234567]; // 이전의 배열에 있던 해당배열 이전결과:a, 해당배열결과:b ||
    // 지금 시점에서는 전전결과: a, 전결과 :b 인데 a+b를 더해주면 원하는 결과 출력력
  }

  return b;
}
