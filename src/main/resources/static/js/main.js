window.addEventListener('DOMContentLoaded', () => {
  document.querySelectorAll('.delete-game-btn').forEach(elem => {
    elem.addEventListener('click', () => {
      if (confirm('Delete this game?')) {
        window.location.href = `/game/delete/${elem.getAttribute('data-id')}`;
      }
    });
  });

  document.querySelectorAll('.edit-game-btn').forEach(elem => {
    elem.addEventListener('click', () => {
      window.location.href = `/game/edit/${elem.getAttribute('data-id')}`;
    });
  });

  document.getElementById('add-game-btn').addEventListener('click', () => {
    window.location.href = `/game/add`;
  });
});