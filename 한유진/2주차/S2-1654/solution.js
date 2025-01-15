const fs = require("fs");
const filePath = process.platform === "linux" ? 0 : "input.txt";
const input = fs.readFileSync(filePath, "utf8").toString().trim().split("\n");

const solution = () => {
  const { n, dest, lines } = handleInput(input);
  const result = binarySearch(dest, lines);
  console.log(result);
};

function binarySearch(dest, lines) {
  let left = 1;
  let right = Math.max(...lines);
  let result = 0;

  while (left <= right) {
    const mid = Math.floor((left + right) / 2);
    const sum = lines.reduce((acc, line) => acc + Math.floor(line / mid), 0);

    if (sum >= dest) {
      result = mid;
      left = mid + 1;
    } else {
      right = mid - 1;
    }
  }

  return result;
}

function handleInput(input) {
  const [n, dest] = input[0].split(" ").map((val) => parseInt(val));
  const lines = input
    .slice(1)
    .map((val) => parseInt(val))
    .sort((a, b) => a - b);
  return { n, dest, lines };
}

solution();
