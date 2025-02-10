function solution(arr) {
    // 두수를 곱한값을 최대 공약수로 나눠서 최소 공배수 구해주기
    return arr.reduce((a, b) => (a * b) / gcn(a, b)); // 이전 결과인 최소공배수와 현재 배열원소간의 최소공배수를 구함 (2개씩 비교함)
  }
  
  function gcn(a, b) {
    //최대 공약수 구해주기
    return a % b ? gcn(b, a % b) : b;
  }
  