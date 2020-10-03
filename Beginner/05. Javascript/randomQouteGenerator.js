let wordOne = ['i','you','they','we']
let wordTwo = ['like','hate','dislike','love']
let wordThree = ['apple','cake','banana','durian']
const getResult = (listOne,listTwo,listThree) =>{
    {
      let generate = ` ${listOne[Math.floor(Math.random() * listOne.length)]} ${listTwo[Math.floor(Math.random() * listTwo.length)]} ${listThree[Math.floor(Math.random() * listThree.length)]} `
      console.log(generate)
    }
  }

  getResult(wordOne,wordTwo,wordThree)