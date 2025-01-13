const fs = require("fs");
const filePath = process.platform === "linux" ? 0 : "input.txt";
const input = fs.readFileSync(filePath, "utf8").toString().trim().split("\n");

const solution = () => {
  const [m, n] = input[0].split(" ").map((val) => parseInt(val));
  const array = Array.from({ length: n + 1 }, () => true);
  console.log(getPrime(array, m, n));
};

function getPrime(array, m, n) {
  let result = [];
  for (let i = 2; i <= Math.sqrt(n); i++) {
    for (let j = 2; j * i <= n; j++) {
      array[j * i] = false;
    }
  }
  array.forEach((val, index) => {
    if (val === true) result.push(index);
  });

  return result.filter((num) => num !== 1 && num >= m && num <= n).join("\n");
}

solution();
