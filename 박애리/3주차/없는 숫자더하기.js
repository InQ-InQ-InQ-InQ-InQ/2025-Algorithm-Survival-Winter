// function solution(numbers) {
//   var testArr = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9];
//   let sum = 0;
//   testArr.forEach((num) => {
//     numbers.includes(num) ? null : (sum += num);
//   });

//   return sum;
// }

function solution(numbers) {
  let sum = 0;

  for (let i = 0; i < 10; i++) {
    if (!numbers.includes(i)) sum += i;
  }

  return sum;
}

const arr = [5, 8, 4, 0, 6, 7, 9];

const result = solution(arr);
console.log(result);
