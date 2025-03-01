const fs = require("fs");
const filePath = process.platform === "linux" ? 0 : "input.txt";
const input = fs.readFileSync(filePath, "utf8").toString().trim().split("\n");

const solution = () => {
  const [M, N] = input[0].split(" ").map(Number);
  const boards = [];
  const queue = [];
  let queueIndex = 0;

  for (let i = 0; i < N; i++) {
    const row = input[i + 1].split(" ").map(Number);
    boards.push(row);

    for (let j = 0; j < M; j++) {
      if (row[j] === 1) {
        queue.push({ x: j, y: i, days: 0 });
      }
    }
  }

  let max_days = 0;

  const dx = [0, 0, 1, -1];
  const dy = [1, -1, 0, 0];

  while (queueIndex < queue.length) {
    const { x, y, days } = queue[queueIndex++];
    max_days = Math.max(max_days, days);

    for (let i = 0; i < 4; i++) {
      const nx = x + dx[i];
      const ny = y + dy[i];

      if (nx >= 0 && nx < M && ny >= 0 && ny < N && boards[ny][nx] === 0) {
        boards[ny][nx] = 1;
        queue.push({ x: nx, y: ny, days: days + 1 });
      }
    }
  }

  for (let i = 0; i < N; i++) {
    if (boards[i].includes(0)) {
      console.log(-1);
      return;
    }
  }

  console.log(max_days);
};

solution();
