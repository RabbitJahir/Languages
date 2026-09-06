/**
 * LOGIN.JS - User authentication page
 * Handles login form submission, validates credentials, and manages session creation
 */

/**
 * USERS: Database of valid login credentials and user roles
 * In a real application, this would be stored securely on a backend server
 * Current users:
 * - rabbit / rabbit (admin role - can manage inventory)
 * - username / password (user role - can browse and purchase)
 */
const USERS = {
  rabbit: { password: "rabbit", role: "admin" },
  username: { password: "password", role: "user" },
};

/**
 * Auto-redirect: If user is already logged in, redirect to appropriate page
 * This prevents people from seeing the login page if they're already authenticated
 * Runs immediately when page loads (IIFE - Immediately Invoked Function Expression)
 */
(function () {
  const s = localStorage.getItem("session");
  if (s) {
    // User already has a session, redirect based on their role
    const { role } = JSON.parse(s);
    window.location.href = role === "admin" ? "admin.html" : "index.html";
  }
})();

/**
 * Login form submission handler
 * Validates credentials against USERS object and creates session if valid
 */
document.getElementById("loginForm").addEventListener("submit", (e) => {
  e.preventDefault(); // Prevent the form from doing a traditional page reload

  // Get input values
  const u = document.getElementById("uname").value.trim();
  const p = document.getElementById("pass").value;
  const err = document.getElementById("loginError");

  // Check if user exists and password matches
  if (USERS[u] && USERS[u].password === p) {
    // Credentials valid: Create session and store in localStorage
    localStorage.setItem(
      "session",
      JSON.stringify({ username: u, role: USERS[u].role }),
    );
    // Redirect to appropriate page based on role (admin.html for admin, index.html for users)
    window.location.href =
      USERS[u].role === "admin" ? "admin.html" : "index.html";
  } else {
    // Credentials invalid: Show error and clear fields
    err.textContent = "Invalid username or password.";
    document.getElementById("uname").value = ""; // Clear username
    document.getElementById("pass").value = ""; // Clear password so user doesn't see it
  }
});
