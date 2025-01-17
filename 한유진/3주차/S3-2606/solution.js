const fs = require("fs");
const filePath = process.platform === "linux" ? 0 : "input.txt";
const input = fs.readFileSync(filePath, "utf8").toString().trim().split("\n");

const solution = () => {
  const pcs = input.slice(2);

  const cons = new Map();
  pcs.forEach((pc) => {
    const [id, connected] = pc.split(" ").map((val) => parseInt(val));
    if (cons.has(id)) {
      cons.get(id).push(connected);
    } else {
      cons.set(id, [connected]);
    }
    if (cons.has(connected)) {
      cons.get(connected).push(id);
    } else {
      cons.set(connected, [id]);
    }
  });
  console.log(bfs(cons, 1));
};

function bfs(cons, start) {
  const visited = new Set();
  const queue = [start];

  visited.add(start);

  while (queue.length > 0) {
    const currentNode = queue.shift();

    if (!cons.has(currentNode)) continue;

    for (const neigh of cons.get(currentNode)) {
      if (!visited.has(neigh)) {
        visited.add(neigh);
        queue.push(neigh);
      }
    }
  }

  return visited.size - 1;
}

solution();
