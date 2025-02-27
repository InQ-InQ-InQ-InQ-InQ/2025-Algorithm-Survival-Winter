const fs = require("fs");
const filePath = process.platform === "linux" ? 0 : "input.txt";
const input = fs.readFileSync(filePath, "utf8").toString().trim().split("\n");

const solution = () => {
  const M = Number(input[0]);
  const board = [];

  for (let i = 0; i < M; i++) {
    const row = input[i + 1].split(" ").map(Number);
    board.push(row);
  }

  function isSame(board) {
    const firstValue = board[0][0];
    for (let i = 0; i < board.length; i++) {
      for (let j = 0; j < board[i].length; j++) {
        if (board[i][j] !== firstValue) {
          return false;
        }
      }
    }
    return true;
  }

  function divideBoard(board) {
    const n = board.length;
    const halfIndex = Math.floor(n / 2);
    const newBoards = Array(4)
      .fill()
      .map(() => []);

    for (let i = 0; i < halfIndex; i++) {
      newBoards[0].push(board[i].slice(0, halfIndex));
    }

    for (let i = 0; i < halfIndex; i++) {
      newBoards[1].push(board[i].slice(halfIndex, n));
    }

    for (let i = halfIndex; i < n; i++) {
      newBoards[2].push(board[i].slice(0, halfIndex));
    }

    for (let i = halfIndex; i < n; i++) {
      newBoards[3].push(board[i].slice(halfIndex, n));
    }

    return newBoards;
  }

  function processBoard(board) {
    if (isSame(board)) {
      return board[0][0] === 0 ? [1, 0] : [0, 1];
    }

    if (board.length === 1) {
      return board[0][0] === 0 ? [1, 0] : [0, 1];
      // 길이 1이면 [0][0]의 숫자가 결국 해당 숫자의 카운트 up
    }

    const quadrants = divideBoard(board);
    let count0 = 0;
    let count1 = 0;

    for (let quadrant of quadrants) {
      const [q0, q1] = processBoard(quadrant);
      count0 += q0;
      count1 += q1;
    }

    return [count0, count1];
  }

  const result = processBoard(board);
  console.log(result[0]);
  console.log(result[1]);
};

solution();
