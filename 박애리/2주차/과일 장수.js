function solution(k, m, score) {
    // 점수를 내림차순으로 정렬
    score.sort((a, b) => b - a);

    let totalProfit = 0;

    // m개씩 묶어서 최소 점수 * m만큼의 이익을 계산
    for (let i = 0; i + m <= score.length; i += m) {
        const box = score.slice(i, i + m);
        const minScore = box[box.length - 1];
        totalProfit += minScore * m;
    }

    return totalProfit;
}