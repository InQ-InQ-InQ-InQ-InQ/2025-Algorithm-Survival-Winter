const fs = require("fs");
const filePath = process.platform === "linux" ? 0 : "input.txt";
const input = fs.readFileSync(filePath, "utf8").toString().trim().split("\n");

const solution = () => {
  const cases = input.slice(1).map((val) => val.split(" ").map(Number));
  for (const c of cases) {
    const [M, N, x, y] = c;
    console.log(getYear(M, N, x, y));
  }
};

function getYear(M, N, x, y) {
  const maxYear = lcm(M, N);

  let year = x;
  while (year <= maxYear) {
    if (((year - 1) % N) + 1 === y) {
      return year;
    }
    year += M;
  }

  return -1;
}

const gcd = (num1, num2) => (num2 > 0 ? gcd(num2, num1 % num2) : num1);
const lcm = (a, b) => (a * b) / gcd(a, b);

solution();
