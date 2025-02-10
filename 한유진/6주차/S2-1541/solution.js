const fs = require("fs");
const filePath = process.platform === "linux" ? 0 : "input.txt";
const input = fs.readFileSync(filePath, "utf8").toString().trim().split("\n");

const solution = () => {
  const mod = input[0];
  const parts = mod.split("-");
  let result = 0;
  parts.forEach((part, index) => {
    if (index === 0) result = cal(part);
    else result = result - cal(part);
  });
  console.log(result);
};

function cal(mod) {
  const sum = mod.split("+").map(Number);
  return sum.reduce((a, b) => a + b, 0);
}

solution();
