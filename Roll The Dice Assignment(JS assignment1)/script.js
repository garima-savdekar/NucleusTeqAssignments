const editbtn1 = document.getElementById("edit1");
const editbtn2 = document.getElementById("edit2");

const player0 = document.querySelector(".d0");
const player1 = document.querySelector(".d1");
const win = document.getElementById("winner");

const score0 = document.querySelector("#score0");
const score1 = document.getElementById("score1");

const current0 = document.getElementById("current0");
const current1 = document.getElementById("current1");

const d = document.querySelector(".dice");
const btnNew = document.querySelector(".btnnew");
const btnRoll = document.querySelector(".btnroll");
const btnSave = document.querySelector(".btnsave");
const namesblock = document.querySelector(".namess");

let scores, currentScore, activePlayer, playing;

const start = function () {
  scores = [0, 0];
  currentScore = 0;
  activePlayer = 0;
  playing = true;
  score0.textContent = 0;
  score1.textContent = 0;
  current0.textContent = 0;
  current1.textContent = 0;
  document.getElementById("editname1").value = "Player 1";
  document.getElementById("editname2").value = "Player 1";
  document.getElementById("name0").textContent = "Player 1";
  document.getElementById("name1").textContent = "Player 2";
  d.classList.add("hidden");
  namesblock.classList.remove("hidden");
  win.textContent = "";
  player0.classList.remove("playerwinner");
  player1.classList.remove("playerwinner");
  player0.classList.add("playeractive");
  player1.classList.remove("playeractive");
};
start();

const switchPlayer = function () {
  document.getElementById(`current${activePlayer}`).textContent = 0;
  currentScore = 0;
  activePlayer = activePlayer == 0 ? 1 : 0;
  player0.classList.toggle("playeractive");
  player1.classList.toggle("playeractive");
};

editbtn1.addEventListener("click", function () {
  const name1 = document.getElementById("editname1").value;
  document.getElementById("name0").textContent = name1;
});

editbtn2.addEventListener("click", function () {
  const name2 = document.getElementById("editname2").value;
  document.getElementById("name1").textContent = name2;
});

btnRoll.addEventListener("click", function () {
  if (playing) {
    const dice = Math.trunc(Math.random() * 6) + 1;
    d.classList.remove("hidden");
    namesblock.classList.add("hidden");
    d.src = `dice${dice}.png`;
    if (dice != 1) {
      currentScore += dice;
      document.getElementById(`current${activePlayer}`).textContent =
        currentScore;
    } else {
      currentScore += 0;
      document.getElementById(`current${activePlayer}`).textContent =
        currentScore;
    }
  }
});

btnSave.addEventListener("click", function () {
  if (playing) {
    scores[activePlayer] += currentScore;
    document.getElementById(`score${activePlayer}`).textContent =
      scores[activePlayer];
    if (scores[activePlayer] >= 100) {
      playing = false;
      d.classList.add("hidden");
      const ans = document.getElementById(`name${activePlayer}`).textContent;
      win.textContent = `${ans} Wins`;

      document.querySelector(`.d${activePlayer}`).classList.add("playerwinner");
      document
        .querySelector(`.d${activePlayer}`)
        .classList.remove("playeractive");
    } else {
      switchPlayer();
    }
  }
});

btnNew.addEventListener("click", start);
