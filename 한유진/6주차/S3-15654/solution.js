const fs = require("fs");
const filePath = process.platform === "linux" ? 0 : "input.txt";
const input = fs.readFileSync(filePath, "utf8").toString().trim().split("\n");

function solution() {
  const [N, M] = input[0].split(" ").map(Number);
  const num = input[1]
    .split(" ")
    .map(Number)
    .sort((a, b) => a - b);
  const temp = [];
  const answer = [];

  function backtrack(start) {
    if (temp.filter((val) => val === num[start]).length > 1) return;

    if (temp.length === M) {
      answer.push([...temp]);
      return;
    }

    for (let i = 0; i < num.length; i++) {
      temp.push(num[i]);
      backtrack(i);
      temp.pop();
    }
  }

  backtrack();

  for (a of answer) {
    console.log(a.join(" "));
  }
}

solution();
