const fs = require("fs");
const filePath = process.platform === "linux" ? 0 : "input.txt";
const input = fs.readFileSync(filePath, "utf8").toString().trim().split("\n");

const solution = () => {
  const cases = input.slice(1).map((val) => parseInt(val));
  const dp = [0, 1, 1, 1, 2, 2];
  for (c of cases) {
    for (i = 6; i <= c; i++) {
      dp[i] = dp[i - 5] + dp[i - 1];
    }
    console.log(dp[c]);
  }
};

solution();
