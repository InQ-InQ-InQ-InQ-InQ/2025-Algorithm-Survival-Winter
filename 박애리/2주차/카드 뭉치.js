function solution(cards1, cards2, goal) {
  var answer = true;
  let first_Cardes;
  let second_Cardes;
  let goal_Index = goal.length;
  let num1 = 0;
  let num2 = 0;
  let j = 0;

  for (let i = 0; i < cards1.length; i++) {
    if (cards1[i] === goal[0]) {
      first_Cardes = cards1;
      second_Cardes = cards2;
      break;
    }
  }

  if (first_Cardes !== cards1) {
    for (let i = 0; i < cards2.length; i++) {
      if (cards2[i] === goal[0]) {
        first_Cardes = cards2;
        second_Cardes = cards1;
        break;
      }
    }
  }

  while (j !== goal_Index) {
    if (goal[j] === first_Cardes[j] || goal[j] === first_Cardes[j - num2]) {
      j++;
      num1 = j - num2; //
    } else if (goal[j] === second_Cardes[j - num1]) {
      j++;
      num2 = j - num1; //
    } else {
      return false;
    }
  }

  return answer;
}

const cards_1 = ["i", "to", "water"];
const cards_2 = ["want", "drink"];
const goall = ["i", "want", "to", "drink", "water"];

const result = solution(cards_1, cards_2, goall);

console.log(result);
