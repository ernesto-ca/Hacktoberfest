const gameBoard = (function () {
  let boardState = [];

	// DOM cache
	const cells = document.querySelectorAll(".cell");
	const menuButtons = document.querySelector(".menu-btn");
	const playAgainBtn = document.querySelector(".play-again");
	const resetScoresBtn = document.querySelector(".reset-score");
	
	// Event binds
	cells.forEach((cell) => cell.addEventListener("click", cellPress));
	playAgainBtn.addEventListener("click", reset);
	resetScoresBtn.addEventListener("click", resetScore);

	const getBoardState = () => boardState;

  function render() {
    for (let i = 0; i < boardState.length; i++) {
      cells[i].classList.add("_" + boardState[i]);
    }
  }

  function cellPress(e) {
    const cellPos = e.target.id.substr(-1);
    const marker = player1.isPlaying() ? "x" : "o";

    if (!boardState[cellPos]) {
      boardState[cellPos] = marker;
    }
		render();
		
    if (Game.winnerFound()) {
			highlightWinningLine(Game.getWinningLine());	
			GUI.displayWinner(Game.getWinner());
			return;		
		}
		
		Game.changeActivePlayer();
		setTimeout(GUI.highlightCurrentPlayer, 200);
  }

  const highlightWinningLine = (line) => {
    line.forEach((index) => {
      document.getElementById("cell-" + index).classList.toggle("winner");
		});
	};

  function reset() {
		const line = Game.getWinningLine();
		menuButtons.style.visibility = "hidden";

		line.forEach((index) => {
      document.getElementById("cell-" + index).classList.toggle("winner");
		});
		
		for (let i = 0; i < boardState.length; i++) {
      cells[i].classList.toggle("_" + boardState[i]);
    }
		boardState = []
    Game.start();
	};
	
	function resetScore() {
		score.reset();
		score.updateScore();
		reset();
	}

  return {
		getBoardState,
		reset
  };
})();

const Game = (function () {
  let board;
  let plays;
	let winningLine;

	const getWinningLine = () => winningLine;

  function start() {
		winningLine = [];
		plays = 1;
		board = gameBoard.getBoardState();
	}

  const changeActivePlayer = () => {
    player1.togglePlaying();
    player2.togglePlaying();
  };

  const winnerFound = () => {
    // horizontal check
    for (let i = 0; i < 9; i += 3) {
      if (hasSameMarker(i, i + 1, i + 2)) {
        return true;
      }
    }

    // vertical check
    for (let i = 0; i < 2; i++) {
      if (hasSameMarker(i, i + 3, i + 6)) {
        return true;
      }
    }

    // diagonal check
    if (hasSameMarker(0, 4, 8) || hasSameMarker(2, 4, 6)) {
      return true;
		}

		// draw check
    if (plays === 9) {
			GUI.draw();
    }
    plays++;

    return false;
  };

  const hasSameMarker = (ind1, ind2, ind3) => {
    if (
      board[ind1] === undefined ||
      board[ind2] === undefined ||
      board[ind3] === undefined
    ) {
      return false;
    }

    if (board[ind1] === board[ind2] && board[ind2] === board[ind3]) {
      winningLine = [ind1, ind2, ind3];
      return true;
    }
  };

  function getWinner () {
		if (player1.isPlaying()) {
			player1.addScore();
			score.updateScore();
			return "Player 1";
		} else {
			player2.addScore();
			score.updateScore();
      return "Player 2";
		}
	} 

  return {
    start,
    changeActivePlayer,
    winnerFound,
    getWinningLine,
    getWinner,
  };
})();

const score = (function() {
	const playerOneScore = document.querySelector("#player1 .score");
	const playerTwoScore = document.querySelector("#player2 .score");
	

	function updateScore() {
		playerOneScore.textContent = player1.getSCore();
		playerTwoScore.textContent = player2.getSCore();
	}

	function reset() {
		player1.resetScore();
		player2.resetScore();
	}

	return {
		updateScore,
		reset
	}
})();

const GUI = (function () {
	const resultText = document.querySelector(".menu-btn h2");
	const menuButtons = document.querySelector(".menu-btn");
	const player1Elem = document.querySelector("#player1");
	const player2Elem = document.querySelector("#player2");
	const start = document.querySelector(".start-btn");
	const startMenu = document.querySelector(".start-menu");
	const starth1 = document.querySelector(".start-menu h1");
	const startBtn = document.querySelector(".start-menu .btn");
	

	start.addEventListener("click", startGame);

	function startGame() {
		startMenu.classList.add("start-hide");
		starth1.classList.add("h1-hide");
		startBtn.classList.add("start-btn-hide");
	}

	function draw() {
		resultText.textContent = "Draw!";
		menuButtons.style.visibility = "visible";
	}

	function displayWinner(winner) {
		resultText.textContent = winner + " wins!";
		menuButtons.style.visibility = "visible";
	}

	function highlightCurrentPlayer() {
		player1Elem.classList.toggle("playing");
		player2Elem.classList.toggle("playing");
	}

	return {
		draw,
		displayWinner,
		highlightCurrentPlayer
	}
})();

const Player = (marker, playing) => {
	let score = 0;

	const addScore = () => score += 1;
	const getSCore = () => score;
	const resetScore = () => score = 0;

  const getMarker = () => marker;

  const isPlaying = () => playing;

  const togglePlaying = () => (playing = !playing);

  return {
		addScore,
		getSCore,
		resetScore,
    isPlaying,
    togglePlaying,
    getMarker,
  };
};

let player2 = Player("o", false);
let player1 = Player("x", true);
Game.start();
