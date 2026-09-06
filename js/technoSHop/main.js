/**
 * MAIN.JS - Shop interface (Alternative/Legacy implementation)
 * Note: This file appears to be a legacy/alternative version. The active shop page uses user.js instead.
 * This file demonstrates an older approach to managing the shop with individual price tracking per item.
 */

// Get the main shop container element
const shop = document.getElementById("shop");
// Get the cart count display element
const cartAmountEl = document.getElementById("cartAmount");

/**
 * shopItemsData: Local copy of items with their current prices
 * Similar to DEFAULT_ITEMS in shared.js but without quantity tracking
 * Each item has: id, name, price, description, image, badge
 */
const shopItemsData = [
  {
    id: "one",
    name: "Crown of the Blood God",
    price: 1000,
    desc: "On sale by the Technodad — the secondary crown of the Blood God, used by himself.",
    img: "technoblade-crown.jpeg",
    badge: "Authenticated Relic",
  },
  {
    id: "two",
    name: "Cape of the Blood God",
    price: 1000,
    desc: "The cape that swung the Blood God to his greatest victory. One of a kind.",
    img: "technoblade-cape.png",
    badge: "Battle-Worn",
  },
  {
    id: "three",
    name: "Sword of Legends",
    price: 1000,
    desc: "Forged in the fires of the Dream SMP. The blade that carved history.",
    img: "technoblade-crown.jpeg",
    badge: "Limited Edition",
  },
  {
    id: "four",
    name: "Potato of Power",
    price: 1000,
    desc: "The sacred potato. Millions were harvested so this one could ascend to glory.",
    img: "technoblade-crown.jpeg",
    badge: "Ultra Rare",
  },
];

/* ── Helpers ──────────────────────────────────────── */
/**
 * storageKey(id): Creates a localStorage key for storing individual item prices
 * @param {string} id - The item id
 * @returns {string} Storage key like "item_price_one"
 */
const storageKey = (id) => `item_price_${id}`;

/**
 * getPrice(id, defaultPrice): Retrieves the current price of an item from localStorage
 * Falls back to defaultPrice if not found (first time item is viewed)
 * @param {string} id - The item id
 * @param {number} defaultPrice - The default price if not in storage
 * @returns {number} The current item price
 */
function getPrice(id, defaultPrice) {
  const saved = localStorage.getItem(storageKey(id));
  return saved !== null ? parseInt(saved, 10) : defaultPrice;
}

/**
 * savePrice(id, price): Saves an item's price to localStorage
 * @param {string} id - The item id
 * @param {number} price - The new price to save
 */
function savePrice(id, price) {
  localStorage.setItem(storageKey(id), price);
}

function formatPrice(price) {
  return price.toLocaleString("en-US");
}

/* ── Render shop ──────────────────────────────────── */
/**
 * generateShop(): Generates HTML for all items and renders them in the shop
 * Each item displays:
 * - Image with badge
 * - Name and description
 * - Current price with +50 increment button
 */
function generateShop() {
  shop.innerHTML = shopItemsData
    .map(({ id, name, price: defaultPrice, desc, img, badge }) => {
      // Get current price from storage, or use default
      const price = getPrice(id, defaultPrice);
      return `
        <div class="item" id="product-${id}">
          <div class="item-img-wrap">
            <img src="${img}" alt="${name}">
            <span class="item-badge">${badge}</span>
          </div>
          <div class="details">
            <h3>${name}</h3>
            <p>${desc}</p>
            <div class="price-row">
              <div class="price-display">
                <span class="price-label">Price</span>
                <span class="price-value" id="price-${id}">$ ${formatPrice(price)}</span>
              </div>
              <!-- Button to increase price by $50 -->
              <button class="btn-increment" data-id="${id}">
                <i class="bi bi-plus-lg"></i>+50
              </button>
            </div>
          </div>
        </div>
      `;
    })
    .join("");
}

/* ── Increment handler ────────────────────────────── */
/**
 * increment(id): Increases an item's price by $50
 * Updates localStorage and the display with animation
 * @param {string} id - The item id to increment
 */
function increment(id) {
  // Find the item definition
  const key = shopItemsData.find((i) => i.id === id);
  if (!key) return;

  // Get current price and add $50
  const currentPrice = getPrice(id, key.price);
  const newPrice = currentPrice + 50;

  // Save new price to localStorage
  savePrice(id, newPrice);

  // Update display
  const priceEl = document.getElementById(`price-${id}`);
  priceEl.textContent = `$ ${formatPrice(newPrice)}`;

  // Bump animation: Remove class, trigger reflow, add class back to restart animation
  priceEl.classList.remove("bumped");
  void priceEl.offsetWidth; // reflow to restart animation
  priceEl.classList.add("bumped");

  updateCartCount(); // Update the total count badge
}

/* ── Cart count (total increments across all items) ── */
/**
 * updateCartCount(): Calculates total increments across all items
 * Assumes each $50 increment = 1 unit in cart
 * Updates the cart count display badge
 */
function updateCartCount() {
  let total = 0;
  // Loop through all items and count total $50 increments
  shopItemsData.forEach(({ id, price: defaultPrice }) => {
    const current = getPrice(id, defaultPrice);
    const increments = Math.round((current - defaultPrice) / 50);
    total += increments;
  });
  // Update the badge showing total count
  cartAmountEl.textContent = total;
}

/* ── Event delegation ─────────────────────────────── */
/**
 * Set up event listener for increment buttons
 * Uses event delegation: single listener on shop container captures all button clicks
 */
shop.addEventListener("click", (e) => {
  const btn = e.target.closest(".btn-increment");
  if (!btn) return;
  increment(btn.dataset.id);
});

/* ── Init ─────────────────────────────────────────── */
/**
 * Initialize the page: generate shop and update cart count
 * Called once when page loads
 */
generateShop();
updateCartCount();
