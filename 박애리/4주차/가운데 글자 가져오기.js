function solution(s) {
  const lengths = parseInt(s.length / 2);
  let midCharacter = "";
  const newArr = s.split("");
  if (s.length % 2 === 0) {
    return (midCharacter = newArr[lengths - 1] + newArr[lengths]);
  } else {
    return (midCharacter = newArr[lengths]);
  }
}
const test = "abcde";
const result = solution(test);

console.log(result);
