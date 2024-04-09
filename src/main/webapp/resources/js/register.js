function checkAgreement() {
    document.getElementById('registerForm').addEventListener('submit', function(event) {
        var agreeCheckbox = document.getElementById('agree');
        if (!agreeCheckbox.checked) {
            event.preventDefault();
            alert('You must agree to the terms of service before registering.');
        }
    });
}

function checkPasswordMatch() {
    var password = document.getElementById("password").value;
    var retypePassword = document.getElementById("retype_password").value;

    if (password !== retypePassword) {
        document.getElementById("passwordMatchMessage").innerHTML =
            "Passwords do not match!";
        document.getElementById("submitButton").disabled = true;
    } else {
        document.getElementById("passwordMatchMessage").innerHTML =
            "";
        document.getElementById("submitButton").disabled = false;
    }
}