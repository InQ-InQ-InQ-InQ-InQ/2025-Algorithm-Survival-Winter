const fs = require("fs");
const filePath = process.platform === "linux" ? 0 : "input.txt";
const input = fs.readFileSync(filePath, "utf8").toString().trim().split("\n");

const solution = () => {
  const sum = new Map();
  sum.set(0, 0);
  const num = input[1].split(" ").map((val) => parseInt(val));
  num.forEach((val, index) => sum.set(index + 1, val + sum.get(index)));

  const cases = input.slice(2).map((val) => val.split(" "));
  cases.forEach((val) => {
    const [start, end] = val.map((val) => parseInt(val));
    if (start === end) console.log(num[start - 1]);
    else console.log(sum.get(end) - sum.get(start - 1));
  });
};

solution();
