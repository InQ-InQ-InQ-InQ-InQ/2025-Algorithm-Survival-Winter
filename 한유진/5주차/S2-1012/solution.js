const fs = require("fs");
const filePath = process.platform === "linux" ? 0 : "input.txt";
const input = fs.readFileSync(filePath, "utf8").toString().trim().split("\n");

const solution = () => {
  const N = parseInt(input[0]);
  let endpoint = 1;

  for (let i = 0; i < N; i++) {
    const [row, col, cnt] = input[endpoint]
      .split(" ")
      .map((val) => parseInt(val));
    const field = new Field(row, col);
    const visited = new Field(row, col);
    let worm = 0;

    for (let i = 0; i < cnt; i++) {
      const [r, c] = input[i + endpoint + 1]
        .split(" ")
        .map((val) => parseInt(val));
      field.field[c][r] = 1;
    }

    for (let i = 0; i < row; i++) {
      for (let j = 0; j < col; j++) {
        if (field.field[j][i] === 1 && visited.field[j][i] === 0) {
          dfs(field.field, visited, j, i);
          worm++;
        }
      }
    }

    endpoint = endpoint + cnt + 1;
    console.log(worm);
  }
};

function dfs(field, visited, x, y) {
  visited.field[x][y] = 1;

  if (x > 0) {
    if (field[x - 1][y] === 1 && visited.field[x - 1][y] === 0)
      dfs(field, visited, x - 1, y);
  }
  if (y > 0) {
    if (field[x][y - 1] === 1 && visited.field[x][y - 1] === 0)
      dfs(field, visited, x, y - 1);
  }
  if (y + 1 < visited.row) {
    if (field[x][y + 1] === 1 && visited.field[x][y + 1] === 0)
      dfs(field, visited, x, y + 1);
  }
  if (x + 1 < visited.col) {
    if (field[x + 1][y] === 1 && visited.field[x + 1][y] === 0)
      dfs(field, visited, x + 1, y);
  }
}

class Field {
  constructor(row, col) {
    this.row = row;
    this.col = col;
    this.field = Array.from(Array(col), () => Array(row).fill(0));
  }
}

solution();
