const fs = require("fs");
const filePath = process.platform === "linux" ? 0 : "input.txt";
const input = fs.readFileSync(filePath, "utf8").toString().trim().split("\n");

const solution = () => {
  const N = parseInt(input[0].split(" "));
  const adjList = Array.from({ length: N + 1 }, () => []);
  let visited = new Array(N + 1).fill(false);
  let connection = 0;

  input.slice(1).forEach((val) => {
    const [from, to] = val.split(" ").map(Number);
    adjList[from].push(to);
    adjList[to].push(from);
  });

  function dfs(start) {
    visited[start] = true;
    for (next of adjList[start]) {
      if (!visited[next]) dfs(next);
    }
  }

  for (let i = 1; i <= N; i++) {
    if (!visited[i]) {
      connection++;
      dfs(i);
    }
  }

  console.log(connection);
};

solution();
