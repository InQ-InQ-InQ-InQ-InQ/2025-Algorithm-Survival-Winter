function solution(s1, s2) {
  return s1.filter((charac) => {
    return s2.includes(charac);
  }).length;
}

