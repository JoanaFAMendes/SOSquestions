/**
 * 
 */


$(document).ready(function () {

    // From Api
    var apiPath = "http://localhost:8080/SOSquestions/api";
    //Form Authentication
    var username;
    
    var apiKey;

    //Create
    var userID;
    var password;
    var email;


    var apiKey = sessionStorage.getItem("apiKey");
    var url = apiPath + "/users";
    
    //Create User
    $("#btnSignUp").click(function () {
        userID = $("#Cuname").val();
        userPassword = $("#Cpsw").val();
        email = $("#Cemail").val();
        console.log(userID);
        var form_data = {
            userID: userID,
            password: userPassword,
            email: email
        }
        console.log(form_data)
        var url2 = apiPath + "/users";
        $.ajax({
        	url: url2,
            type: "POST",
            data: form_data,
        	})
        	  .done(function( msg ) {
        		  console.log(msg);
                  console.log("Created")
                  window.open("./index.html","_self");
        	  });
     
        	});

    
 // Change User
    $("#editUser").click(function () {
        username = sessionStorage.getItem("username");
        apiKey = sessionStorage.getItem("apiKey");

        userPassword = $("#txtUserPasswordChange").val();
        email = $("#txtUserEmailChange").val();


        var form_data = {
            password: userPassword,
            email: email,
            apiKey: apiKey
        }
        var url = apiPath + "/users/" + username + "/?apiKey=" + apiKey
        $.ajax({
            url: url,
            type: "POST",
            data: form_data,
            success: function (data) {
                console.log(data)
                alert("Account Changed");
            }
        })
    });
    
  //Delete User
    $("#deleteUser").click(function () {
        username = sessionStorage.getItem("username");
        apiKey = sessionStorage.getItem("apiKey");
        var url = apiPath + "/users/" + username + "?apiKey=" + apiKey;
        
        $.ajax({
            url: url,
            type: "DELETE",
            success: function (data) {
                console.log(data);
                alert("Account Deleted, please create a new one");
                window.open("./index.html","_self");
                
            }
        });
    });
});