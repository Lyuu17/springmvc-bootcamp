window.addEventListener('DOMContentLoaded', async () => {
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

  const addGameBtnElem = document.getElementById('add-game-btn');
  if (addGameBtnElem) {
    addGameBtnElem.addEventListener('click', () => {
      window.location.href = `/game/add`;
    });
  }

  const gameDataContainerColElem = document.getElementById('game-data-container-col');
  if (gameDataContainerColElem) {
    const gameScreenshotResponse = await fetch(`/game/steam/details/${gameDataContainerColElem.getAttribute('data-steamid')}`);
    const { screenshotUrl } = await gameScreenshotResponse.json();

    if (screenshotUrl !== undefined) {
      gameDataContainerColElem.innerHTML = `
      <div class="flex-column w-25 mb-4" id="game-image-column">
        <div class="border rounded m-2">
          <img width="100%" height="100%"
               class="border rounded" src="${screenshotUrl}"
               alt="Screenshot"/>
        </div>
      </div>
      ${gameDataContainerColElem.innerHTML}`
    }
  }

  const gameNewsContainerRowElem = document.getElementById('game-data-container-row');
  if (gameNewsContainerRowElem) {
    const gameScreenshotResponse = await fetch(`/game/steam/news/${gameNewsContainerRowElem.getAttribute('data-steamid')}`);
    const newsData = await gameScreenshotResponse.json();

    const { status } = newsData;

    if (status === undefined && newsData.length > 0) {
      let html = "";
      newsData.forEach(data => {
        const { title, url, author, contents } = data;

        html += `
          <div class="mb-3 border">
            <div class="bg-success p-sm-2">
              <h4><a class="text-decoration-none text-white" href="${url}">${title}</a></h4>
            </div>
            <div class="m-2">
              <h5>${author}</h5>
            </div>
            <div class="m-2">
              ${contents.replace(/{STEAM_CLAN_IMAGE}/g, "https://steamcdn-a.akamaihd.net/steamcommunity/public/images/clans")}
            </div>
          </div>
        `;
      });

      gameNewsContainerRowElem.innerHTML += `
      <div class="d-flex flex-row m-2" id="game-news-container">
        <div class="d-flex flex-column">
          <h4>News</h4>
          <div>${html}</div>
        </div>
      </div>
      `;
    }
  }
});