const fs = require("fs");
const input = fs.readFileSync("./input.txt").toString().trim().split("\n");

const solution = () => {
  const n = parseInt(input[0], 10);
  const zeroRearIndex = getZeroRearIndex(n);
  console.log(zeroRearIndex);
};

function getZeroRearIndex(n) {
  let count = 0;
  while (n > 0) {
    n = parseInt(n / 5, 10);
    count = count + n;
  }
  return count;
}

solution();
