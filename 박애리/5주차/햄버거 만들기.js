function solution(ingredient) {
  let num = 0;
  let burger = [];
  for (const i of ingredient) {
    burger.push(i);
    console.log("전체 재료는 ", burger);
    console.log(burger.slice(-4));
    if (burger.slice(-4).join("") === "1231") {
      num++;
      burger.splice(-4);
    }
  }

  return num;
}

const result = solution([1, 3, 2, 1, 2, 3, 1, 2]);
console.log(result);
