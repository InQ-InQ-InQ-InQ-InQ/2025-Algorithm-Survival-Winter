function findDivisors(num) {
  const divisors = [];
  for (let i = 2; i <= Math.sqrt(num); i++) {
    if (num % i === 0) {
      divisors.push(i);
      if (num / i !== i) divisors.push(num / i);
    }
  }
  return divisors.sort((a, b) => b - a);
}
function solution(brown, yellow) {
  const WholeTile = brown + yellow;
  const arr = findDivisors(WholeTile);
  const answer = [];
  for (let i = 0; i < arr.length; i++) {
    const realYellow = (WholeTile / arr[i] - 2) * (arr[i] - 2);
    const realBrown = (WholeTile / arr[i] + arr[i]) * 2 - 4;
    if (yellow === realYellow && brown === realBrown) {
      answer.push(arr[i]);
      answer.push(WholeTile / arr[i]);
      break;
    }
  }
  return answer;
}
