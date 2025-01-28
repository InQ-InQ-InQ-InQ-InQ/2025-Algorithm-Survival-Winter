const fs = require("fs");
const filePath = process.platform === "linux" ? 0 : "input.txt";
const input = fs.readFileSync(filePath, "utf8").toString().trim().split("\n");

const solution = () => {
  const numbers = input.slice(1).map((val) => parseInt(val));
  for (num of numbers) {
    console.log(getCount(num));
  }
};

function getCount(num) {
  const count = [0, 1, 2, 4];
  for (let i = 4; i <= num; i++) {
    count[i] = count[i - 1] + count[i - 2] + count[i - 3];
  }
  return count[num];
}

solution();
