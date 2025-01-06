const fs = require("fs");
const input = fs.readFileSync("./input.txt").toString().trim().split("\n");

const solution = () => {
  const result = getRanks();
  console.log(result.join(" "));
};

class Weight {
  constructor(a, b) {
    this.x = a;
    this.y = b;
  }
}

function getWeights() {
  const values = input.slice(1);
  const weights = [];
  for (let i = 0; i < values.length; i++) {
    const [a, b] = values[i].split(" ").map((val) => parseInt(val));
    if (!isNaN(a) && !isNaN(b)) {
      weights.push(new Weight(a, b));
    }
  }
  return weights;
}

function isBigger(a, b) {
  return a.x < b.x && a.y < b.y;
}

function getRanks() {
  const weights = getWeights();
  const result = [];
  for (let weight of weights) {
    let num = 0;
    for (let compWeight of weights) {
      if (isBigger(weight, compWeight)) num++;
    }
    result.push(num + 1);
  }
  return result;
}

solution();
