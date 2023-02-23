function calculate(){
    let transAmts = new Array()
    let debit = 0
    //Entering the amounts to the array from index 0-9
    transAmts[0] = document.forms['limit'].amount1.value
    transAmts[1] = document.forms['limit'].amount2.value
    transAmts[2] = document.forms['limit'].amount3.value
    transAmts[3] = document.forms['limit'].amount4.value
    transAmts[4] = document.forms['limit'].amount5.value
    transAmts[5] = document.forms['limit'].amount6.value
    transAmts[6] = document.forms['limit'].amount7.value
    transAmts[7] = document.forms['limit'].amount8.value
    transAmts[8] = document.forms['limit'].amount9.value
    transAmts[9] = document.forms['limit'].amount10.value

    //checking if the transaction is a debit, if yes debit will be incremented by 1
    for(i=0;i<10;i++){
        if(transAmts[i]<transAmts[i-1]){
            debit+=1
        }
    }

    //Output message
    if(debit>3){
        alert("You have exceeded the transaction limit : "+debit+". You will be charged "+debit*20+" for the same.")
    }

}
