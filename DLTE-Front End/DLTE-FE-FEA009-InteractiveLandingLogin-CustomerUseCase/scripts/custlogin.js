
//Details of all customers in JSON format
let details=[{
    "ID":"SBI001",
    "password":"12345",
    "customername":"Abhishek",
    "cuspin":"9999",
    "cusstatus":"active",
    "accno":"9087",
    "accbal":"10000",
    "adharno":"1234567890123",
    "cuspan":"EP945P",
    "phno":"6562333454",
    "cusemail":"abhishekanoj2001@gmail.com"
},
{
    "ID":"SBI002",
    "password":"54321",
    "customername":"Aashish",
    "cuspin":"8888",
    "cusstatus":"active",
    "accno":"1425",
    "accbal":"1500",
    "adharno":"987654321",
    "cuspan":"WER09J",
    "phno":"9440971297",
    "cusemail":"aashishmanoj2009@gmail.com" 
}]

//Function to do authentication of customer ID and password
function authentication(){
    //storing user input into two variables
    let uname = document.forms['login'].ID.value
    let upass = document.forms['login'].password.value

    //Comparing those values with the values in the database.
    details.forEach((item)=>{
        if(item.ID == uname && item.password == upass){
            window.location.href = "http://127.0.0.1:5500/FEA009home.html#"
        }
    })
}