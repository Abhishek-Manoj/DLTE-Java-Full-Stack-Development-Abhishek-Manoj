credentials = [
    {
        "id":"abhishek@gmail.com",
        "password":"abhi@123"
    },
    {
        "id":"anika@gmail.com",
        "password":"anika@123"
    },
    {
        "id":"aashish@gmail.com",
        "password":"aashish@123"
    },
]

function verify(){
    let empuname = document.forms['login'].id.value             //storing username entered by employee
    let emppass = document.forms['login'].password.value        //storing password entered by employee

    credentials.forEach((item) => {
        if(item.id==empuname && item.password == emppass){
            window.location.href="http://127.0.0.1:5501/home.html"
        }
    })
}