const fs = require("fs");
const filePath = process.platform === "linux" ? 0 : "input.txt";
const input = fs.readFileSync(filePath, "utf8").toString().trim().split("\n");

const solution = () => {
  const N = parseInt(input[0]);
  const stairs = [0];
  input.slice(1).forEach((val) => stairs.push(parseInt(val)));
  const dp = new Array(N + 1).fill(0);

  dp[1] = stairs[1];
  if (N >= 2) dp[2] = stairs[1] + stairs[2];

  for (let i = 3; i <= N; i++) {
    dp[i] = Math.max(
      dp[i - 2] + stairs[i],
      dp[i - 3] + stairs[i - 1] + stairs[i]
    );
  }

  console.log(dp[N]);
};

solution();
