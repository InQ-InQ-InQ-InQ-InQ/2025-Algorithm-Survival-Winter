const fs = require("fs");
const input = fs.readFileSync("./input.txt").toString().trim().split("\n");

const solution = () => {
  const points = inputToPoints();
  const sortedPoints = sortPoints(points);
  console.log(sortedPoints.map((point) => point.toString()).join("\n"));
};

class Point {
  constructor(x, y) {
    this.x = x;
    this.y = y;
  }
  toString() {
    return `${this.x} ${this.y}`;
  }
}

function isLarger(a, b) {
  if (a.y !== b.y) {
    return a.y - b.y;
  }
  return a.x - b.x;
}

function sortPoints(points) {
  return points.sort(isLarger);
}

function inputToPoints() {
  const values = input.slice(1);
  const points = [];
  for (let i = 0; i < values.length; i++) {
    const [x, y] = values[i].split(" ").map((val) => parseInt(val));
    if (!isNaN(x) && !isNaN(y)) {
      points.push(new Point(x, y));
    }
  }
  return points;
}

solution();
