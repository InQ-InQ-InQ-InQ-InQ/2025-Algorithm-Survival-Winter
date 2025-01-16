function solution(s){
    var answer = true;

    let news = s.toUpperCase();
    let num = 0 ;
    for(let i=0; i<news.length; i++){
        if(news[i] === "P"){num++; }
        if(news[i] === "Y"){num--; }
    }
    
    if(num !==0){answer= false;}

    return answer;
}