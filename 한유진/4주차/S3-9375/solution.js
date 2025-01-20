const fs = require("fs");
const filePath = process.platform === "linux" ? 0 : "input.txt";
const input = fs.readFileSync(filePath, "utf8").toString().trim().split("\n");

const solution = () => {
  let start = 2;
  let end = 0;
  while (end < input.length) {
    let N = parseInt(input[start - 1]);
    end = start + N;
    console.log(getCount(start, end));
    start = end + 1;
  }
};

function getCount(start, end) {
  const testCase = new Map();
  input.slice(start, end).forEach((val) => {
    const type = val.split(" ")[1];
    if (testCase.has(type)) testCase.set(type, testCase.get(type) + 1);
    else testCase.set(type, 2);
  });
  let result = 1;
  for (val of testCase.values()) {
    result *= val;
  }
  return result - 1;
}

solution();
