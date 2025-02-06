const fs = require("fs");
const filePath = process.platform === "linux" ? 0 : "input.txt";
const input = fs.readFileSync(filePath, "utf8").toString().trim().split("\n");

function solution() {
  const [N, M] = input[0].split(" ").map(Number);
  const nums = input[1]
    .split(" ")
    .map(Number)
    .sort((a, b) => a - b);
  const temp = [];
  const answer = [];

  function backtrack(start) {
    if (
      temp.filter((val) => val === nums[start]).length >
      nums.filter((val) => val === nums[start]).length
    )
      return;

    if (temp.length === M) {
      answer.push([...temp]);
      return;
    }

    for (let i = 0; i < N; i++) {
      temp.push(nums[i]);
      backtrack(i);
      temp.pop();
    }
  }

  backtrack(0);

  [...new Set(answer.map((arr) => arr.join(" ")))].forEach((val) =>
    console.log(val)
  );
}

solution();
