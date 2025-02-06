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
  const countMap = new Map();

  nums.forEach((num) => countMap.set(num, (countMap.get(num) || 0) + 1));

  function backtrack(depth) {
    if (depth === M) {
      console.log(temp.join(" "));
      return;
    }

    let prevNum = -1;

    for (let i = 0; i < N; i++) {
      const num = nums[i];

      if (prevNum === num || (countMap.get(num) || 0) === 0) continue;

      prevNum = num;
      temp.push(num);
      countMap.set(num, countMap.get(num) - 1);

      backtrack(depth + 1);

      temp.pop();
      countMap.set(num, countMap.get(num) + 1);
    }
  }

  backtrack(0);
}

solution();
