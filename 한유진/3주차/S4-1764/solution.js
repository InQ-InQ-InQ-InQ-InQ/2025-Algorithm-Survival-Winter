const fs = require("fs");
const filePath = process.platform === "linux" ? 0 : "input.txt";
const input = fs.readFileSync(filePath, "utf8").toString().trim().split("\n");

const solution = () => {
  const [N, M] = input[0].split(" ").map((val) => parseInt(val));
  const notHeard = input.slice(1, N + 1);
  const notSeen = new Map();
  notHeard.sort((a, b) => a.localeCompare(b));
  input
    .slice(N + 1)
    .sort((a, b) => a.localeCompare(b))
    .forEach((val, ind) => notSeen.set(val, ind));

  let result = [];

  for (elem of notHeard) {
    if (notSeen.has(elem)) result.push(elem);
  }

  console.log(result.length);
  console.log(result.join("\n"));
};

solution();
