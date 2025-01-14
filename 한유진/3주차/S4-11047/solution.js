const fs = require("fs");
const filePath = process.platform === "linux" ? 0 : "input.txt";
const input = fs.readFileSync(filePath, "utf8").toString().trim().split("\n");

const solution = () => {
  const [N, K] = input[0].split(" ").map((val) => parseInt(val));
  const coins = input.slice(1).map((val) => parseInt(val));
  if (binarySearch(coins, K) === 0) {
    console.log(1);
    return;
  }
  const searchIndex =
    binarySearch(coins, K) === -1 ? undefined : binarySearch(coins, K);
  const searchCoin = coins.slice(0, searchIndex);
  console.log(findMinCoins(searchCoin, K));
};

function findMinCoins(coins, K) {
  let result = 0;
  for (let i = coins.length - 1; i >= 0; i--) {
    const count = Math.floor(K / coins[i]);
    K -= count * coins[i];
    result += count;
  }
  return result;
}

function binarySearch(numbers, K) {
  let left = 0;
  let right = numbers.length - 1;
  let result = -1;

  while (left <= right) {
    const mid = Math.floor((left + right) / 2);

    if (numbers[mid] === K) {
      return 0;
    } else if (numbers[mid] < K) {
      left = mid + 1;
    } else {
      result = mid;
      right = mid - 1;
    }
  }

  return result;
}

solution();
