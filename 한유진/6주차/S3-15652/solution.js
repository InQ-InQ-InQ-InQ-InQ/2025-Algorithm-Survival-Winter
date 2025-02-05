const fs = require("fs");
const filePath = process.platform === "linux" ? 0 : "input.txt";
const input = fs.readFileSync(filePath, "utf8").toString().trim().split("\n");

function solution() {
  const [N, M] = input[0].split(" ").map(Number);
  const answer = [];
  const temp = [];

  function backtrack(start) {
    if (temp.length === M) {
      answer.push([...temp]);
      return;
    }

    for (let i = start; i <= N; i++) {
      temp.push(i);
      backtrack(i + 1);
      temp.pop();
    }
  }

  backtrack(1);
  const fs = require("fs");
  const filePath = process.platform === "linux" ? 0 : "input.txt";
  const input = fs.readFileSync(filePath, "utf8").toString().trim().split("\n");

  function solution() {
    const [N, M] = input[0].split(" ").map(Number);
    const answer = [];
    const temp = [];

    function backtrack(start) {
      if (temp.length === M) {
        answer.push([...temp]);
        return;
      }

      for (let i = start; i <= N; i++) {
        temp.push(i);
        backtrack(i);
        temp.pop();
      }
    }

    backtrack(1);

    for (let a of answer) {
      console.log(a.join(" "));
    }
  }

  solution();

  for (let a of answer) {
    console.log(a.join(" "));
  }
}

solution();
