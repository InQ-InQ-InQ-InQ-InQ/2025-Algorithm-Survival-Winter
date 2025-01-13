const fs = require("fs");
const filePath = process.platform === "linux" ? 0 : "input.txt";
const input = fs.readFileSync(filePath, "utf8").toString().trim().split("\n");

const solution = () => {
  const n = parseInt(input[0]);
  const values = input.slice(1).map((val) => parseInt(val));
  n === 0 ? console.log(0) : console.log(getAverage(n, values));
};

function getExcludedValues(n, values) {
  const exclude = Math.round(n * 0.15);
  if (exclude === 0) return values; // 제외할 사람이 없으므로 점수 그대로 반환함
  const sortedValues = values.sort((a, b) => a - b);
  const excludedValues = sortedValues.slice(exclude, -exclude);
  return excludedValues;
}

function getAverage(n, values) {
  const excludedValues = getExcludedValues(n, values); // 반환된 점수 배열
  if (excludedValues.length === 0) return 0; // 점수 배열에 값이 없으면 0 반환
  const sum = excludedValues.reduce((acc, val) => acc + val, 0);
  const avg = sum / excludedValues.length;
  return Math.round(avg); // 값이 존재하면 평균 구하고 반올림
}

solution();
