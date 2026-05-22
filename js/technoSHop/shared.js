/**
 * SHARED.JS - Core utility functions used across all pages
 * This file contains shared functionality for authentication, storage, cart management, and item operations.
 * Functions here are used by: login.js, user.js, admin.js, and main.js
 */

/* ── Default item catalogue ──────────────────────── */
/**
 * DEFAULT_ITEMS: The initial inventory of shop items
 * Each item contains: id, name, price, description, image, badge, and quantity
 * This data is stored in localStorage and can be modified by admins
 */
const DEFAULT_ITEMS = [
  {
    id: "one",
    name: "Crown of the Blood God",
    price: 1000,
    desc: "On sale by the Technodad — the secondary crown of the Blood God, used by himself.",
    img: "technoblade-crown.jpeg",
    badge: "Authenticated Relic",
    quantity: 10,
  },
  {
    id: "two",
    name: "Cape of the Blood God",
    price: 1000,
    desc: "The cape that swung the Blood God to his greatest victory. One of a kind.",
    img: "technoblade-cape.png",
    badge: "Battle-Worn",
    quantity: 5,
  },
  {
    id: "three",
    name: "Sword of Legends",
    price: 1000,
    desc: "Forged in the fires of the Dream SMP. The blade that carved history.",
    img: "technoblade-crown.jpeg",
    badge: "Limited Edition",
    quantity: 3,
  },
  {
    id: "four",
    name: "Potato of Power",
    price: 1000,
    desc: "The sacred potato. Millions harvested so this one could ascend to glory.",
    img: "technoblade-crown.jpeg",
    badge: "Ultra Rare",
    quantity: 1,
  },
];

/* ── Items ───────────────────────────────────────── */
/**
 * getItems(): Retrieves the current shop inventory from localStorage
 * If no items exist, initializes with DEFAULT_ITEMS
 * @returns {Array} Array of item objects
 */
function getItems() {
  const s = localStorage.getItem("shop_items");
  if (!s) {
    const d = JSON.parse(JSON.stringify(DEFAULT_ITEMS));
    saveItems(d);
    return d;
  }
  return JSON.parse(s);
}
/**
 * getSession(): Retrieves the current user session from localStorage
 * @returns {Object|null} Session object with {username, role} or null if not authenticated
 */
function getSession() {
  const s = localStorage.getItem("session");
  return s ? JSON.parse(s) : null;
}

/**
 * requireAuth(role): Security check to ensure user is authenticated and has correct role
 * If user is not authenticated, redirects to login.html
 * If user doesn't have required role, redirects to appropriate page (admin/user)
 * @param {string} role - Optional role to check: "admin" or "user"
 * @returns {Object|null} Session object if authenticated and authorized, null otherwise
 */
function requireAuth(role = null) {
  const s = getSession();
  if (!s) {
    window.location.href = "login.html";
    return null;
  }
  if (role && s.role !== role) {
    window.location.href = s.role === "admin" ? "admin.html" : "index.html";
    return null;
  }
  return s;
}

/**
 * logout(): Clears the session and redirects to login page
 * Called when user clicks logout button
/**
 * getCart(): Retrieves the current shopping cart from localStorage
 * Cart contains items the user has added but not yet purchased
 * @returns {Array} Array of cart entry objects {id, qty, name, img}
 */
function getCart() {
  const c = localStorage.getItem("cart");
  return c ? JSON.parse(c) : [];
}

/**
 * saveCart(cart): Saves the shopping cart to localStorage
 * @param {Array} c - Array of cart entry objects to save
 */
function saveCart(c) {
  localStorage.setItem("cart", JSON.stringify(c));
}

/**
 * getOrders(): Retrieves the user's completed/purchased orders from localStorage
 * Orders contain items the user has "purchased" (not a real transaction system)
 * @returns {Array} Array of order objects {id, qty, name, img, price}
 */
function getOrders() {
  const o = localStorage.getItem("orders");
  return o ? JSON.parse(o) : [];
}

/**
 * saveOrders(orders): Saves the user's orders to localStorage
 * @param {Array} o - Array of order objects to save
 */
function logout() {
  /**
   * formatPrice(price): Formats a number as USD currency
   * Example: formatPrice(1000) => "$1,000"
   * @param {number} p - The price to format
   * @returns {string} Formatted price string with $ symbol and comma separators
   */
  localStorage.removeItem("session");
  window.location.href = "login.html";
}

/* ── Cart ────────────────────────────────────────── */
function getCart() {
  const c = localStorage.getItem("cart");
  return c ? JSON.parse(c) : [];
}
function saveCart(c) {
  localStorage.setItem("cart", JSON.stringify(c));
}
function getOrders() {
  const o = localStorage.getItem("orders");
  return o ? JSON.parse(o) : [];
}
function saveOrders(o) {
  localStorage.setItem("orders", JSON.stringify(o));
}

/* ── Formatting ──────────────────────────────────── */
function formatPrice(p) {
  return "$" + Number(p).toLocaleString("en-US");
}
