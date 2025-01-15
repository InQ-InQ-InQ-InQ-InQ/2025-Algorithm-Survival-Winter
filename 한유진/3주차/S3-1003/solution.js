const fs = require("fs");
const filePath = process.platform === "linux" ? 0 : "input.txt";
const input = fs.readFileSync(filePath, "utf8").toString().trim().split("\n");

const solution = () => {
  const cases = input.slice(1).map((val) => parseInt(val));
  const fiboArr = [new Fibo(1, 0), new Fibo(0, 1)];
  for (let c of cases) {
    console.log(fibo(c, fiboArr).toString());
  }
};

function fibo(num, arr) {
  if (arr[num]) {
    return arr[num];
  }
  for (let i = 2; i <= num; i++) {
    arr[i] = arr[i - 1].add(arr[i - 2]);
  }
  return arr[num];
}

class Fibo {
  constructor(a, b) {
    this.zeroCnt = a;
    this.oneCnt = b;
  }
  add(other) {
    return new Fibo(this.zeroCnt + other.zeroCnt, this.oneCnt + other.oneCnt);
  }

  toString() {
    return `${this.zeroCnt} ${this.oneCnt}`;
  }
}

solution();
