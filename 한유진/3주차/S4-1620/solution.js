const fs = require("fs");
const filePath = process.platform === "linux" ? 0 : "input.txt";
const input = fs.readFileSync(filePath, "utf8").toString().trim().split("\n");

const solution = () => {
  const N = parseInt(input[0].split(" ")[0]);
  const pokedex = new Map();
  const pokedexArr = input.slice(1, N + 1);
  pokedexArr.forEach((value, index) => pokedex.set(value, index));
  const question = input.slice(N + 1);
  for (q of question) {
    solveQuestion(pokedex, q, pokedexArr);
  }
};

function solveQuestion(pokedex, question, arr) {
  if (isNaN(question)) {
    console.log(pokedex.get(question) + 1);
  } else {
    const index = parseInt(question) - 1;
    console.log(arr[index]);
  }
}

solution();
