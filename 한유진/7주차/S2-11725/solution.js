const fs = require("fs");
const filePath = process.platform === "linux" ? 0 : "input.txt";
const input = fs.readFileSync(filePath, "utf8").toString().trim().split("\n");

const solution = () => {
  const N = Number(input[0]);
  const adjList = Array.from({ length: N + 1 }, () => []);
  const parent = new Array(N + 1).fill(0);

  input.slice(1).forEach((val) => {
    const [from, to] = val.split(" ").map(Number);
    adjList[from].push(to);
    adjList[to].push(from);
  });

  function dfs(current, prev) {
    parent[current] = prev;

    for (const next of adjList[current]) {
      if (next !== prev) {
        dfs(next, current);
      }
    }
  }

  dfs(1, 0);

  for (let i = 2; i <= N; i++) {
    console.log(parent[i]);
  }
};

solution();
