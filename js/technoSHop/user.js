/* ── Auth ─────────────────────────────────────────── */
const session = requireAuth("user");
if (session) {
  document.getElementById("sessionLabel").textContent =
    `Welcome, ${session.username}`;
  init();
}

function init() {
  renderShop();
  updateCartCount();

  // Cart modal close
  document.getElementById("cartModal").addEventListener("click", (e) => {
    if (e.target === e.currentTarget) closeCart();
  });
  document.getElementById("modalClose").addEventListener("click", closeCart);

  // Event delegation for shop buttons (set once)
  document.getElementById("shop").addEventListener("click", handleShopClick);
}

/* ── Render ───────────────────────────────────────── */
function renderShop() {
  const items = getItems();
  const cart = getCart();
  const shop = document.getElementById("shop");

  shop.innerHTML = items
    .map((item) => {
      const cartEntry = cart.find((c) => c.id === item.id);
      const cartQty = cartEntry ? cartEntry.qty : 0;
      const soldOut = item.quantity <= 0;

      return `
      <div class="item${soldOut ? " sold-out" : ""}" id="card-${item.id}">
        <div class="item-img-wrap">
          <img src="${item.img}" alt="${item.name}" loading="lazy">
          <span class="item-badge">${item.badge}</span>
          ${soldOut ? '<div class="sold-overlay">SOLD OUT</div>' : ""}
        </div>
        <div class="details">
          <h3>${item.name}</h3>
          <p>${item.desc}</p>

          <div class="stock-row">
            <span class="stock-label${soldOut ? " out" : ""}">
              ${soldOut ? "✕ Out of stock" : `<i class="bi bi-boxes"></i> ${item.quantity} left`}
            </span>
            ${cartQty > 0 ? `<span class="in-cart-tag">${cartQty} in cart</span>` : ""}
          </div>

          <div class="price-row">
            <div class="price-display">
              <span class="price-label">Price</span>
              <span class="price-value" id="price-${item.id}">${formatPrice(item.price)}</span>
            </div>
            <button class="btn-increment" data-id="${item.id}"${soldOut ? " disabled" : ""}>
              <i class="bi bi-plus-lg"></i>+50
            </button>
          </div>

          <div class="cart-controls">
            <button class="btn-cart-minus" data-action="minus" data-id="${item.id}"${cartQty <= 0 ? " disabled" : ""}>
              <i class="bi bi-dash-lg"></i>
            </button>
            <span class="cart-qty-num">${cartQty}</span>
            <button class="btn-cart-add" data-action="add" data-id="${item.id}"${soldOut ? " disabled" : ""}>
              <i class="bi bi-plus-lg"></i> Add to Cart
            </button>
          </div>
        </div>
      </div>
    `;
    })
    .join("");
}

/* ── Shop click handler (delegated) ──────────────── */
function handleShopClick(e) {
  const incBtn = e.target.closest(".btn-increment");
  const addBtn = e.target.closest(".btn-cart-add");
  const minBtn = e.target.closest(".btn-cart-minus");

  if (incBtn) incrementPrice(incBtn.dataset.id);
  if (addBtn) changeCart(addBtn.dataset.id, 1);
  if (minBtn) changeCart(minBtn.dataset.id, -1);
}

/* ── +50 price ────────────────────────────────────── */
function incrementPrice(id) {
  const items = getItems();
  const item = items.find((i) => i.id === id);
  if (!item) return;

  item.price += 50;
  saveItems(items);

  const el = document.getElementById(`price-${id}`);
  if (el) {
    el.textContent = formatPrice(item.price);
    el.classList.remove("bumped");
    void el.offsetWidth;
    el.classList.add("bumped");
  }
}

/* ── Cart ─────────────────────────────────────────── */
function changeCart(id, delta) {
  const items = getItems();
  const item = items.find((i) => i.id === id);
  if (!item || item.quantity <= 0) return;

  let cart = getCart();
  let entry = cart.find((c) => c.id === id);

  if (delta > 0) {
    if (!entry) {
      entry = { id, qty: 0, name: item.name, img: item.img };
      cart.push(entry);
    }
    entry.qty = Math.min(entry.qty + 1, item.quantity);
  } else {
    if (!entry || entry.qty <= 0) return;
    entry.qty--;
    if (entry.qty === 0) cart = cart.filter((c) => c.id !== id);
  }

  saveCart(cart);
  updateCartCount();
  renderShop(); // re-render so in-cart badge updates
}

function updateCartCount() {
  const total = getCart().reduce((s, c) => s + c.qty, 0);
  const orders = getOrders();
  document.getElementById("cartCount").textContent = total + orders.length;
}

/* ── Cart modal ───────────────────────────────────── */
function openCart() {
  const cart = getCart();
  const orders = getOrders();
  const items = getItems();
  const body = document.getElementById("cartBody");
  let html = "";

  if (cart.length === 0 && orders.length === 0) {
    html = '<p class="empty-msg">Your cart is empty.</p>';
  } else {
    if (cart.length > 0) {
      html += '<p class="cart-section-title">In Cart</p>';
      html += cart
        .map((c) => {
          const item = items.find((i) => i.id === c.id);
          const price = item ? item.price : 0;
          return `
          <div class="cart-row">
            <img src="${c.img}" alt="${c.name}">
            <div class="cart-row-info">
              <strong>${c.name}</strong>
              <span>Qty: ${c.qty} &nbsp;·&nbsp; ${formatPrice(price)} each</span>
              <span class="total-price">Total: ${formatPrice(price * c.qty)}</span>
            </div>
          </div>`;
        })
        .join("");
    }
    if (orders.length > 0) {
      html +=
        '<p class="cart-section-title purchased-title">✅ Purchased & Received</p>';
      html += orders
        .map(
          (o) => `
        <div class="cart-row purchased">
          <img src="${o.img}" alt="${o.name}">
          <div class="cart-row-info">
            <strong>${o.name}</strong>
            <span>Qty: ${o.qty} &nbsp;·&nbsp; ${formatPrice(o.price)} each</span>
            <span class="received-tag">Received</span>
          </div>
        </div>`,
        )
        .join("");
    }
  }

  document.getElementById("cartBody").innerHTML = html;
  document.getElementById("cartModal").classList.add("open");
}

function closeCart() {
  document.getElementById("cartModal").classList.remove("open");
}

/* ── Notification ─────────────────────────────────── */
function showNotif(msg) {
  const n = document.getElementById("notif");
  n.textContent = msg;
  n.classList.add("show");
  setTimeout(() => n.classList.remove("show"), 3500);
}
