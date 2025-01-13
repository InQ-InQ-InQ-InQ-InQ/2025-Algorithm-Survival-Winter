const fs = require("fs");
const filePath = process.platform === "linux" ? 0 : "input.txt";
const input = fs.readFileSync(filePath, "utf8").toString().trim().split("\n");

const solution = () => {
  const inputs = input.slice(1).map((val) => parseInt(val));
  const nums = getPoppedValues(inputs);
  console.log(sum(nums));
};

function getPoppedValues(values) {
  let result = [];
  for (let value of values) {
    value === 0 ? result.pop() : result.push(value);
  }
  return result;
}

function sum(values) {
  if (values.length === 0) return 0;
  return values.reduce((acc, val) => acc + val, 0);
}

solution();
