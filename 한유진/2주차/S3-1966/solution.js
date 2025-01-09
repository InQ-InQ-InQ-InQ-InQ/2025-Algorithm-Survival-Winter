const fs = require("fs");
const filePath = process.platform === "linux" ? 0 : "input.txt";
const input = fs.readFileSync(filePath, "utf8").toString().trim().split("\n");

const solution = () => {
  const inputs = input.slice(1);
  const testCases = getTestCases(inputs);
  for (let testCase of testCases) {
    console.log(getDestOrder(testCase));
  }
};

function getTestCases(inputs) {
  let testCases = [];
  for (let i = 0; i < inputs.length; i += 2) {
    const dest = parseInt(inputs[i].split(" ")[1]);
    const queue = inputs[i + 1].split(" ").map((inp) => parseInt(inp));
    testCases.push(new TestCase(dest, queue));
  }
  return testCases;
}

function getDestOrder(testCase) {
  let dest = testCase.dest;
  let queue = testCase.queue;
  let destOrder = 0;

  const count = () => {
    if (queue.length === 0) return;
    if (isGoingToPrint(queue)) {
      destOrder++;
      if (dest === 0) return;
      else {
        queue.shift();
        dest = (dest - 1 + queue.length) % queue.length;
      }
    } else {
      queue.push(queue.shift());
      dest = (dest - 1 + queue.length) % queue.length;
    }
    count();
  };

  count();

  return destOrder;
}

function isGoingToPrint(queue) {
  // 지금 프린트될 예정인가? (뒤에 얘보다 큰수가 없는가?)
  return queue[0] === Math.max(...queue);
}

class TestCase {
  constructor(dest, queue) {
    this.dest = dest;
    this.queue = queue;
  }
}

solution();
