function solution(s) {
  return s.substr(Math.floor(s.length / 2), s.length % 2 === 0 ? 2 : 1);
}
const test = "abcde";
const result = solution(test);

console.log(result);
