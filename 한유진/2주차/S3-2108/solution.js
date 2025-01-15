const fs = require("fs");
const filePath = process.platform === "linux" ? 0 : "input.txt";
const input = fs.readFileSync(filePath, "utf8").toString().trim().split("\n");

const solution = () => {
  const values = input.slice(1).map((val) => parseInt(val));
  console.log(arithmeticAverage(values));
  console.log(centralValue(values));
  console.log(frequentValue(values));
  console.log(rangeValue(values));
};

function arithmeticAverage(values) {
  const sum = values.reduce((acc, val) => acc + val, 0);
  return parseInt(Math.round(sum / values.length));
}

function centralValue(values) {
  const sortedValues = values.sort((a, b) => a - b);
  const middleIndex = Math.ceil(sortedValues.length / 2);
  return sortedValues[middleIndex - 1];
}

function frequentValue(values) {
  const countMap = new Map();
  values.forEach((val) => {
    countMap.set(val, (countMap.get(val) || 0) + 1);
  });

  const sortedArray = [...countMap].sort((a, b) => b[1] - a[1]);
  if (sortedArray.length > 1 && sortedArray[0][1] === sortedArray[1][1]) {
    return sortedArray[1][0];
  }
  return sortedArray[0][0];
}
function rangeValue(values) {
  const min = Math.min(...values);
  const max = Math.max(...values);
  return max - min;
}

solution();
