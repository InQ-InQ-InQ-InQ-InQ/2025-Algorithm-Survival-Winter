const fs = require("fs");
const filePath = process.platform === "linux" ? 0 : "input.txt";
const input = fs.readFileSync(filePath, "utf8").toString().trim().split("\n");

const solution = () => {
  const [T, M] = input[0].split(" ").map(Number);
  const trees = input[1].split(" ").map(Number);

  let left = 1;
  let right = Math.max(...trees);

  while (left <= right) {
    let mid = Math.floor((left + right) / 2);
    let sum = trees.reduce((acc, tree) => acc + Math.max(0, tree - mid), 0);
    if (sum >= M) {
      left = mid + 1;
    } else {
      right = mid - 1;
    }
  }
  console.log(right);
};

solution();
