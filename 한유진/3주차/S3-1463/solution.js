const fs = require("fs");
const filePath = process.platform === "linux" ? 0 : "input.txt";
const input = fs.readFileSync(filePath, "utf8").toString().trim().split("\n");

const solution = () => {
  const N = parseInt(input[0]);

  let dp = [0, 0, 1, 1];

  for (let i = 4; i <= N; i++) {
    dp[i] = dp[i - 1] + 1;

    if (i % 6 == 0) {
      dp[i] = Math.min(dp[i / 3] + 1, dp[i / 2] + 1, dp[i]);
    }

    if (i % 3 === 0) {
      dp[i] = Math.min(dp[i], dp[i / 3] + 1);
    }

    if (i % 2 === 0) {
      dp[i] = Math.min(dp[i], dp[i / 2] + 1);
    }
  }

  console.log(dp[N]);
};

solution();
