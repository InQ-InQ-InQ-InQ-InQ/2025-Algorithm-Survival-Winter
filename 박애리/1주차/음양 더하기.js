function solution(absolutes, signs) {
    
    let sum = 0;

    for(let i=0; i<signs.length; i++){
        if(signs[i] === true ){
            sum += absolutes[i];
        }else{
            sum -= absolutes[i];
        }
        console.log(i);

    }

    return sum;gjf
}