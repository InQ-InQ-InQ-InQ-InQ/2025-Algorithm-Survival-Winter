const fs = require("fs");
const filePath = process.platform === "linux" ? 0 : "input.txt";
const input = fs.readFileSync(filePath, "utf8").toString().trim().split("\n");

const solution = () => {
  const N = parseInt(input[0]);
  const times = input[1]
    .split(" ")
    .map((val) => parseInt(val))
    .sort((a, b) => a - b);

  let result = [times[0]];
  let sum = times[0];
  for (let i = 1; i < N; i++) {
    result.push(result[i - 1] + times[i]);
    sum += result[i];
  }
  console.log(sum);
};

solution();
