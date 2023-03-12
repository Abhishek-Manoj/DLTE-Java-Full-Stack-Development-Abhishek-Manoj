$(document).ready(()=>{
    $("#addButton").click(()=>{
    const cid=$("#customerID").val()
    const cname=$("#customerName").val()
    const pname=$("#payeeName").val()
    const pacc=$("#payeeAccNo").val()
    const ifsc=$("#payeeIFSC").val()  
    //Assigning the values entered to jQuery variables.
    $(".error").remove()        
    // Removing the error statement each time the Submit button is triggered to avoid redundancy


    // Validation Conditions begin here
    if(cid==null || cid == "", cname == null || cname == "", pname =="" || pname == null, pacc == "" || pacc ==null,ifsc == "" || ifsc == null){
        $("#buttons").before("<p class=error>All fields are mandatory!!</p>")
    }
    else if(!((/^(\d{5})$/).test(cid))){
        $("#customerID").after("<p class=error>Customer ID should contain 5 digits!!</p>")
    }
    else if(!((/^([a-zA-Z]{3,})$/).test(cname))){
        $("#customerName").after("<p class=error>Customer Name should contain letters with minimum of 3 letters</p>")
    }
    else if(!((/^([a-zA-Z]{3,})$/).test(pname))){
        $("#payeeName").after("<p class=error>Payee Name should contain letters with minimum of 3 letters</p>")
    }
    else if(!((/^(\d{12})$/).test(pacc))){
        $("#payeeAccNo").after("<p class=error>Account Number is a 12 digit number</p>")
    }
    else if(!((/^[A-Z]{4}0[A-Z0-9]{6}$/).test(ifsc))){
        $("#payeeIFSC").after("<p class=error>Incorrect IFSC code format</p>")
    }
    });
});