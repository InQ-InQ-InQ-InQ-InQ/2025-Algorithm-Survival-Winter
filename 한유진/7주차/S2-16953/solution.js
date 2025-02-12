const fs = require("fs");
const filePath = process.platform === "linux" ? 0 : "input.txt";
const input = fs.readFileSync(filePath, "utf8").toString().trim().split("\n");

const solution = () => {
  const [start, target] = input[0].split(" ").map(Number);

  function bfs(start) {
    const queue = [[start, 0]];
    const visited = new Set([start]);

    while (queue.length > 0) {
      const [current, steps] = queue.shift();

      if (current === target) {
        console.log(steps + 1);
        return;
      }

      const nextNumbers = [current * 2, parseInt(current.toString() + "1")];

      for (const next of nextNumbers) {
        if (next <= target && !visited.has(next)) {
          visited.add(next);
          queue.push([next, steps + 1]);
        }
      }
    }

    console.log(-1);
    return;
  }

  bfs(start);
};

solution();
