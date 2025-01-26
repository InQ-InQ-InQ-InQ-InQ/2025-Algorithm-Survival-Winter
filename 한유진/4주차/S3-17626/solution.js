const fs = require("fs");
const filePath = process.platform === "linux" ? 0 : "input.txt";
const input = fs.readFileSync(filePath, "utf8").toString().trim().split("\n");

const solution = () => {
  const N = parseInt(input[0]);
  const dp = [0, 1, 2, 3, 1];
  for (let i = 5; i <= N; i++) {
    const a = Math.floor(Math.sqrt(i));
    const b = i - a * a;

    let min = 10;
    for (let j = 1; j < a; j++) {
      const c = (a - j) * (a - j);
      const d = i - c;
      min = Math.min(min, dp[d]);
    }

    dp[i] = Math.min(min, dp[b]) + 1;
  }
  console.log(dp[N]);
};

solution();
