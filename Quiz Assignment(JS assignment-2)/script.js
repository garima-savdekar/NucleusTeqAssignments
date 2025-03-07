const startBtn = document.getElementById("startbtn");
const restartBtn = document.getElementById("restartbtn");
const startScreen = document.getElementById("startscreen");
const quizContainer = document.getElementById("quizcontainer");
const endScreen = document.getElementById("endbox");
const question = document.getElementById("question");
const options = document.getElementById("options");
const timerElement = document.getElementById("time");
const timerdiv = document.getElementById("timer");
const feedbackcorr = document.getElementById("feedbackc");
const feedbackwrong = document.getElementById("feedbackw");
const scoreElement = document.getElementById("score");
const livescorep = document.getElementById("paralivescore");

let questions, currentQuestionIndex, score, timeLeft, timer;

const init = function () {
  let questions = [];
  let currentQuestionIndex = 0;
  let score = 0;
  let timeLeft = 15;
  let timer;
  endScreen.classList.add("hidden");
  startScreen.classList.remove("hidden");
};

init();

async function fetchQuestions() {
  const category = document.getElementById("category").value;
  const difficulty = document.getElementById("difficulty").value;
  const response = await fetch(
    `https://opentdb.com/api.php?amount=20&category=${category}&difficulty=${difficulty}&type=multiple`
  );
  const data = await response.json();
  questions = data.results;
  startGame();
}

function startGame() {
  startScreen.classList.add("hidden");
  quizContainer.classList.remove("hidden");
  livescorep.classList.remove("hidden");
  timerdiv.classList.remove("hidden");
  currentQuestionIndex = 0;
  score = 0;
  nextQuestion();
}

function nextQuestion() {
  if (currentQuestionIndex >= questions.length) {
    endGame();
    return;
  }
  feedbackcorr.textContent = "";
  feedbackwrong.textContent = "";
  clearInterval(timer);
  timeLeft = 15;
  timerElement.textContent = timeLeft;
  timer = setInterval(() => {
    timeLeft--;
    timerElement.textContent = timeLeft;
    if (timeLeft === 0) {
      clearInterval(timer);
      showAnswer(null, null);
    }
  }, 1000);

  const q = questions[currentQuestionIndex];
  question.innerHTML = `${currentQuestionIndex + 1}. ` + q.question;
  options.innerHTML = "";
  const answers = [...q.incorrect_answers, q.correct_answer].sort(
    () => Math.random() - 0.5
  );
  answers.forEach((answer) => {
    const button = document.createElement("button");
    button.innerHTML = answer;
    button.classList.add("option-btn");
    button.onclick = () => showAnswer(answer, button);
    options.appendChild(button);
  });
}

function showAnswer(selected, selectedbutton) {
  clearInterval(timer);
  const q = questions[currentQuestionIndex];
  const buttons = document.querySelectorAll(".option-btn");
  buttons.forEach((button) => {
    button.disabled = true;
    if (button.innerHTML === q.correct_answer) {
      button.classList.add("correct");
    }
    if (selected !== q.correct_answer && button === selectedbutton) {
      button.classList.add("incorrect");
    }
  });

  if (selected === q.correct_answer) {
    feedbackcorr.innerHTML = `Correct: ${q.correct_answer}`;
    score++;
    document.getElementById("livescore").textContent = score;
  } else {
    feedbackwrong.innerHTML = "Wrong!";
    feedbackcorr.innerHTML = `Correct answer: ${q.correct_answer}`;
  }
  if (!selectedbutton) {
    feedbackwrong.innerHTML = `Time's Up!`;
    feedbackcorr.innerHTML = `Correct answer: ${q.correct_answer}`;
  }

  currentQuestionIndex++;
  setTimeout(nextQuestion, 2000);
}

function endGame() {
  quizContainer.classList.add("hidden");
  endScreen.classList.remove("hidden");
  scoreElement.textContent = score;
}

startBtn.addEventListener("click", fetchQuestions);

restartBtn.addEventListener("click", init);
