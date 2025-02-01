const fs = require("fs");
const filePath = process.platform === "linux" ? 0 : "input.txt";
const input = fs.readFileSync(filePath, "utf8").toString().trim().split("\n");

const solution = () => {
  const [N, M, V] = input[0].split(" ").map((val) => parseInt(val));
  const graph = [];
  let result = [];
  let visited = Array.from({ length: N }).fill(0);

  input.slice(1).forEach((val) => {
    const [t, f] = val.split(" ").map((val) => parseInt(val));
    graph.push(new Node(t, f));
    graph.push(new Node(f, t));
  });

  graph.sort((a, b) => {
    if (a.to - b.to === 0) return a.from - b.from;
    else return a.to - b.to;
  });

  dfs(graph, V, result, visited);
  console.log(result.join(" "));
  visited = Array.from({ length: N }).fill(0);
  result = [];

  bfs(graph, V, result, visited);
  console.log(result.join(" "));
};

class Node {
  constructor(to, from) {
    this.to = to;
    this.from = from;
  }
}

function dfs(graph, v, result, visited) {
  let g = graph;
  visited[v - 1] = 1;
  result.push(v);

  current = g.filter((val) => val.to === v);
  g = g.filter((val) => val.to !== v);

  for (c of current) {
    if (visited[c.from - 1] === 0) dfs(g, c.from, result, visited);
  }
}

function bfs(graph, v, result, visited) {
  let g = graph;
  let queue = [];
  visited[v - 1] = 1;
  queue.push(v);
  result.push(v);

  while (queue.length > 0) {
    const current = queue.shift();
    const next = g.filter((val) => val.to === current).map((val) => val.from);
    for (n of next) {
      if (visited[n - 1] === 0) {
        queue.push(n);
        result.push(n);
        visited[n - 1] = 1;
      }
    }
  }
}

solution();
