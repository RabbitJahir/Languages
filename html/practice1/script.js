const myForm = document.querySelector("#myForm");

// login page
if (myForm) { //submit always goes with form
  myForm.addEventListener("submit", (event) => {
    const message = document.querySelector("#message");

    const username = event.target.username.value;
    const password = event.target.password.value;

    if (username == "rabbit" && password == "123" || username == "ismail" && password == "black" ) {
      localStorage.setItem("username", username);
      window.location = "./dashboard.html";
    } else {
      message.textContent = "Wrong username or password.";
    }

    event.preventDefault();
  });
}

// Dashboard page
const title = document.querySelector("#title");

if (title) {
  const username = localStorage.getItem("username");

  title.textContent = `Welcome ${username}`;
}