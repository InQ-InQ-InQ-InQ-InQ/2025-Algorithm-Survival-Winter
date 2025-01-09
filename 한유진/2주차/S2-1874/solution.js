const fs = require("fs");
const filePath = process.platform === "linux" ? 0 : "input.txt";
const input = fs.readFileSync(filePath, "utf8").toString().trim().split("\n");

const solution = () => {
  const n = parseInt(input[0]);
  const dest = input.slice(1).map((val) => parseInt(val));
  console.log(stackToDest(n, dest));
};

function stackToDest(n, dest) {
  let stack = [];
  let stringResult = [];
  let current = 1;

  for (let i = 0; i < n; i++) {
    while (current <= dest[i]) {
      stack.push(current++);
      stringResult.push("+");
    }

    if (stack.pop() !== dest[i]) {
      return "NO";
    }
    stringResult.push("-");
  }

  return stringResult.join("\n");
}

solution();
