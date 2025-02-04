const fs = require("fs");
const filePath = process.platform === "linux" ? 0 : "input.txt";
const input = fs.readFileSync(filePath, "utf8").toString().trim().split("\n");

const solution = () => {
  const [N, M, V] = input[0].split(" ").map(Number);

  const adjList = Array.from({ length: N + 1 }, () => []);

  input.slice(1).forEach((val) => {
    const [from, to] = val.split(" ").map(Number);
    adjList[from].push(to);
    adjList[to].push(from);
  });

  adjList.forEach((list) => list.sort((a, b) => a - b));

  function dfs(start) {
    const visited = new Array(N + 1).fill(false);
    const result = [];

    function dfsRecursive(vertex) {
      visited[vertex] = true;
      result.push(vertex);

      for (const next of adjList[vertex]) {
        if (!visited[next]) {
          dfsRecursive(next);
        }
      }
    }

    dfsRecursive(start);
    return result;
  }

  function bfs(start) {
    const visited = new Array(N + 1).fill(false);
    const result = [];
    const queue = [start];
    visited[start] = true;

    while (queue.length > 0) {
      const vertex = queue.shift();
      result.push(vertex);

      for (const next of adjList[vertex]) {
        if (!visited[next]) {
          visited[next] = true;
          queue.push(next);
        }
      }
    }

    return result;
  }

  console.log(dfs(V).join(" "));
  console.log(bfs(V).join(" "));
};

solution();
