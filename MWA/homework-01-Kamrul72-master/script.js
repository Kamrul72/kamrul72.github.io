
const RANDOM_QUOTE_API_URL = 'http://api.quotable.io/random'
const quoteDisplayElement = document.getElementById('quoteDisplay')
const quoteInputElement = document.getElementById('quoteInput')
const timerElement = document.getElementById('timer')
const { Observable, of, from, fromEvent,interval } = rxjs;
 const { map, filter,throttleTime, debounceTime, take, pluck,pipe,subscribe,mergeAll} = rxjs.operators;
 //var input = fromEvent(quoteInputElement, 'input');

 quoteInputElement.addEventListener('input', () => {

  const arrayQuote = quoteDisplayElement.querySelectorAll('span')
  const arrayValue = quoteInputElement.value.split('')

  let correct = true

 
 arrayQuote.forEach((characterSpan, index) =>
  //of(...arrayQuote).pipe(map(x=>x)).subscribe((characterSpan, index) =>
  {
  

    const character = arrayValue[index]
    if (character == null) {
      characterSpan.classList.remove('correct')
      characterSpan.classList.remove('incorrect')
      correct = false
    } else if (character === characterSpan.innerText) {
      characterSpan.classList.add('correct')
      characterSpan.classList.remove('incorrect')
    } else {
      characterSpan.classList.remove('correct')
      characterSpan.classList.add('incorrect')
      correct = false
    }
  })

  if (correct) renderNewQuote()
})

function getRandomQuote() {
  return fetch(RANDOM_QUOTE_API_URL)
    .then(response => response.json())
    .then(data => data.content)
}

async function renderNewQuote() {
  const quote = await getRandomQuote()
  quoteDisplayElement.innerHTML = ''
  //quote.split('').forEach(character => {

of(...quote.split('')).pipe(map(x=>x)).subscribe(character => {

    const characterSpan = document.createElement('span')
    characterSpan.innerText = character
    quoteDisplayElement.appendChild(characterSpan)
  })
  quoteInputElement.value = null
  startTimer()
}

let startTime
function startTimer() {
  timerElement.innerText = 0
  startTime = new Date()
  //setInterval(() => {
    //timer.innerText = 
 // }, 1000)

 interval(1000).subscribe(()=>{ timer.innerText =getTimerTime()});          

}

function getTimerTime() {
  return Math.floor((new Date() - startTime) / 1000)
}



renderNewQuote()