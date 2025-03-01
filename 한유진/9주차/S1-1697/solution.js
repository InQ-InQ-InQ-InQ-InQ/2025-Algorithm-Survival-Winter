const fs = require("fs");
const filePath = process.platform === "linux" ? 0 : "input.txt";
const input = fs.readFileSync(filePath, "utf8").toString().trim().split("\n");

const solution = () => {
  const [N, target] = input[0].split(" ").map(Number);
  let queueIndex = 0;
  const visited = new Set();

  if (N === target) {
    console.log(0);
    return;
  }

  if (N > target) {
    console.log(N - target);
    return;
  }

  let queue = [[N, 0]];
  visited.add(N);

  const maxLimit = target * 2;

  while (queue.length > queueIndex) {
    const [num, time] = queue[queueIndex++];

    for (const next of [num - 1, num + 1, num * 2]) {
      if (next < 0 || next > maxLimit || visited.has(next)) continue;
      if (next === target) {
        console.log(time + 1);
        return;
      }
      visited.add(next);
      queue.push([next, time + 1]);
    }
  }
};

solution();
