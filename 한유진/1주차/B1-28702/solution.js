const fs = require("fs");
const input = fs.readFileSync("./input.txt").toString().trim().split("\n");

const solution = () => {
  const nextNum = findNextNum();
  console.log(toString(nextNum));
};

function findNextNum() {
  const result = input
    .map((val, index) => {
      const num = parseInt(val, 10);
      if (!isNaN(num)) {
        return parseInt(val, 10) + 3 - index;
      }
      return null;
    })
    .filter((val) => val !== null);
  return result[0];
}

function isFizz(num) {
  return num % 3 === 0;
}

function isBuzz(num) {
  return num % 5 === 0;
}

function isFizzBuzz(num) {
  return isFizz(num) && isBuzz(num);
}

function toString(num) {
  return `${
    isFizzBuzz(num)
      ? "FizzBuzz"
      : isFizz(num)
      ? "Fizz"
      : isBuzz(num)
      ? "Buzz"
      : num
  }`;
}

solution();
