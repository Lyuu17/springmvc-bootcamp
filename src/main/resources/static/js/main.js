window.addEventListener('DOMContentLoaded', () => {
  document.querySelectorAll('.delete-game-btn').forEach(elem => {
    elem.addEventListener('click', () => {
      if (confirm('Delete this game?')) {
        window.location.href = `/game/delete/${elem.getAttribute('data-id')}`;
      }
    });
  });
});