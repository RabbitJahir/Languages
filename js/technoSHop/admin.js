/**
 * ADMIN.JS - Admin dashboard for inventory management
 * This page allows admin users to update product prices and inventory quantities
 */

/* ── Auth ─────────────────────────────────────────── */
/**
 * Check that user is authenticated and has admin role
 * If not admin, requireAuth will redirect to appropriate page
 * If admin, extract username and display it in the session label
 */
const session = requireAuth("admin");
if (session) {
  document.getElementById("sessionLabel").textContent = session.username;
  renderAdmin(); // Populate the admin grid with editable items
}

/* ── Render ───────────────────────────────────────── */
/**
 * renderAdmin(): Generates the admin interface displaying all items as editable cards
 * Each card has:
 * - Item image and badge
 * - Name and editable price field
 * - Editable quantity field
 * - Current stock display
 * - Save button to persist changes
 */
function renderAdmin() {
  const items = getItems(); // Get all items from localStorage
  const grid = document.getElementById("adminGrid");

  // Create HTML for each item card with form inputs
  grid.innerHTML = items
    .map((item) => {
      let item = {id};
      return `
      <div class="admin-card" id="ac-${id}">
        <!-- Item image and badge -->
        <div class="admin-card-img">
          <img src="${item.img}" alt="${item.name}" loading="lazy">
          <span class="item-badge">${item.badge}</span>
        </div>
        <div class="admin-card-body">
          <h3 class="admin-item-name">${item.name}</h3>

          <!-- Price and Quantity input fields -->
          <div class="admin-fields">
            <!-- Price input: accepts values in increments of 50 -->
            <div class="admin-field">
              <label for="price-${item.id}">Price ($)</label>
              <input type="number" id="price-${item.id}" value="${item.price}" min="0" step="50">
            </div>

            <!-- Quantity input: accepts any non-negative integer -->
            <div class="admin-field">
              <label for="qty-${item.id}">Quantity</label>
              <input type="number" id="qty-${item.id}" value="${item.quantity}" min="0">
            </div>
          </div>

          <!-- Display current stock status -->
          <div class="admin-status-row">
            <span class="stock-pill">Stock: <strong id="stockDisplay-${item.id}">${item.quantity}</strong></span>
          </div>

          <!-- Save button: persists changes to localStorage -->
          <div class="admin-actions">
            <button class="btn-save"  onclick="saveItem('${item.id}')"><i class="bi bi-floppy"></i> Save</button>
          </div>
        </div>
      </div>
    `;
    })
    .join("");
}

/* ── Save price + qty ─────────────────────────────── */
/**
 * saveItem(id): Saves updated price and quantity for an item
 * Gets input values, validates, updates item, saves to localStorage, and shows confirmation
 * @param {string} id - The item id to save (e.g., "one", "two")
 */
function saveItem(id) {
  const items = getItems(); // Get current inventory
  const item = items.find((i) => i.id === id); // Find the specific item
  if (!item) return; // Safety check: item not found

  // Get new values from form inputs
  const newPrice = parseInt(document.getElementById(`price-${id}`).value, 10);
  const newQty = parseInt(document.getElementById(`qty-${id}`).value, 10);

  // Update price if valid (non-negative number)
  if (!isNaN(newPrice) && newPrice >= 0) item.price = newPrice;
  // Update quantity if valid (non-negative number)
  if (!isNaN(newQty) && newQty >= 0) item.quantity = newQty;

  // Persist changes to localStorage
  saveItems(items);

  // Update the visual stock display
  document.getElementById(`stockDisplay-${id}`).textContent = item.quantity;

  // Show success notification
  showToast(`✅ ${item.name} saved!`);
}

/**
 * showToast(message): Displays a temporary notification message
 * Used to confirm successful save operations
 * @param {string} message - The message to display
 */
function showToast(message) {
  const toast = document.getElementById("toast");
  toast.textContent = message;
  toast.classList.add("show");

  // Auto-hide after 2 seconds
  setTimeout(() => {
    toast.classList.remove("show");
  }, 2000);
}
