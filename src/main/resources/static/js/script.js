// Confirm delete
function confirmDelete() {
    return confirm("Are you sure you want to delete this?");
}

// Show alert after actions
function showSuccess(message) {
    alert(message);
}

// Highlight status dynamically
document.addEventListener("DOMContentLoaded", function () {
    const statusCells = document.querySelectorAll("[data-status]");

    statusCells.forEach(cell => {
        const status = cell.getAttribute("data-status");
        cell.classList.add("status-" + status);
    });
});