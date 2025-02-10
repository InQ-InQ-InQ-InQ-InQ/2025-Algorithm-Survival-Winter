const fs = require("fs");
const filePath = process.platform === "linux" ? 0 : "input.txt";
const input = fs.readFileSync(filePath, "utf8").toString().trim().split("\n");

function solution() {
  const [N, M] = input[0].split(" ").map(Number);
  const nums = [
    ...new Set(
      input[1]
        .split(" ")
        .map(Number)
        .sort((a, b) => a - b)
    ),
  ];
  const temp = [];

  function backtrack(start) {
    if (temp.length === M) {
      console.log(temp.join(" "));
      return;
    }

    for (let i = start; i < nums.length; i++) {
      const num = nums[i];
      temp.push(num);
      backtrack(i);
      temp.pop();
    }
  }

  backtrack(0);
}

solution();
