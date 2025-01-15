const fs = require("fs");
const filePath = process.platform === "linux" ? 0 : "input.txt";
const input = fs.readFileSync(filePath, "utf8").toString().trim().split("\n");

const solution = () => {
  const [N, M] = input[0].split(" ").map((val) => parseInt(val));
  let map = new Map();
  input
    .slice(1, N + 1)
    .forEach((val) => map.set(val.split(" ")[0], val.split(" ")[1]));
  const questions = input.slice(N + 1);
  for (q of questions) {
    console.log(map.get(q));
  }
};

solution();
