const fs = require("fs");
const filePath = process.platform === "linux" ? 0 : "input.txt";
const input = fs.readFileSync(filePath, "utf8").toString().trim().split("\n");

const solution = () => {
  let map = new Map();
  const files = input
    .slice(1)
    .map((val) => val.split(".")[1])
    .sort();

  files.forEach((key) => {
    if (!map.has(key)) {
      map.set(key, 1);
    } else map.set(key, map.get(key) + 1);
  });

  new Set([...files]).forEach((key) => {
    if (map.has(key)) console.log(`${key} ${map.get(key)}`);
  });
};

solution();
