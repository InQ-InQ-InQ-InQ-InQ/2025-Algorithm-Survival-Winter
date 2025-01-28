function solution(s, skip, index) {
  const result = s.split("").map((char) => {
    let charList = [];
    let num = 1;
    for (let i = 0; i < index; i++) {
      charList[i] = String.fromCharCode(
        ((char.charCodeAt(0) - 97 + i + num) % 26) + 97
      );

      while (skip.includes(charList[i])) {
        num++;
        charList[i] = String.fromCharCode(
          ((char.charCodeAt(0) - 97 + i + num) % 26) + 97
        );
      }
    }
    return charList[index - 1];
  });

  return result.join("");
}

const result = solution("aukks", "wbqd", 5);
console.log(result);
