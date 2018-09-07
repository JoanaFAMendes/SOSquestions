/**
 * 
 */
$(document).ready(function () {


    // From Api
    var apiPath = "http://localhost:8080/sosquestions/api";
    var apiKey;
    //Form Login
    var username;
    var password;


    // Login 
    $("#btnLogin").click(function () {
        username = $("#uname").val();
        password = $("#psw").val();
        sessionStorage.setItem("apiKey", "default");
        sessionStorage.setItem("username", username);


        var form_data = {
            userID: username,
            password: password
        }
        console.log(form_data);
        
        var url = apiPath + "/auth";
        $.ajax({
            url: url,
            type: "POST",
            data: form_data,
            success: function (data) {
                var token = data;
                sessionStorage.setItem("apiKey", token);
                apiKey = sessionStorage.getItem("apiKey");
                console.log(data); 
                console.log("Logged");
                window.open("./home.html","_self");
            }
        });
    });

    //Logout
    $("#logOut").click(function () {
        apiKey = "";
        username = "";
        sessionStorage.removeItem("apiKey");
        sessionStorage.removeItem("username");
        console.log(sessionStorage.getItem("apiKey"));
        console.log(sessionStorage.getItem("username"));
        window.open("./index.html","_self");
    });


});