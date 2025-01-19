function solution(numbers) {
  const result = new Array(numbers.length).fill(-1); // 결과 배열을 -1로 초기화
  const stack = []; // 인덱스를 저장할 스택

  for (let i = 0; i < numbers.length; i++) {
    // 현재 숫자가 스택의 top 인덱스가 가리키는 숫자보다 크면 뒷 큰수로 설정
    while (stack.length > 0 && numbers[stack[stack.length - 1]] < numbers[i]) {
      const index = stack.pop(); // 스택에서 인덱스를 꺼냄
      result[index] = numbers[i]; // 해당 인덱스의 뒷 큰수를 현재 숫자로 설정
    }
    stack.push(i); // 현재 인덱스를 스택에 추가
  }

  return result;
}
