function solution(strings, n) {
    let result = [];
    for(let i=0; i<strings.length; i++){
        strings[i] = strings[i][n]+strings[i] ;
    }

    let newArr = strings.sort();
    let removed =[];
    for(let i=0; i<newArr.length; i++){
        newArr[i] = newArr[i].split("");
        removed[i] = newArr[i].splice(0,1);
        result[i] = newArr[i].join("");
    }

    return result;


}