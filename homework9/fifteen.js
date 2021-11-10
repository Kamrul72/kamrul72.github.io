$(document).ready(function() {

    const rows_columns = 4;
    let empty_x = 3;
    let empty_y = 3;
    init();
    $("#shufflebutton").on('click',shuffleButtonClick);
    //initialize and create the puzzle peices elements
   function init() {
      var num = 1;
      for (var i = 0; i < rows_columns; i++) {
        for (var j = 0; j < rows_columns; j++) {
        let content=num++;
          var tile = document.createElement("div");
          tile.classList.add("puzzlepiece");
          tile.style.left = 100 * j + "px";
          tile.style.top = 100 * i + "px"; 
          tile.style.backgroundPosition = (0 - 100 * j) + "px" + " " + (0 - 100 * i) + "px";
          tile.setAttribute("id", "peice_" + j + "_" + i);
          tile.innerHTML = content;
          tile.onmouseover = highlight;
          tile.onmouseout = unhighlight;
          tile.onclick = peiceClick;
          if (i != 3 || j != 3) { 
            document.getElementById("puzzlearea").appendChild(tile);
          }
        }
      }
    }
  
    // Check the next move is empty space 
    function validMove(tile) { 
      var neighbors = getNeighbors();
      if (neighbors.indexOf(tile.getAttribute("id")) != -1) {
        return true;
      } else {
        return false;
      }
    }
  
    // on mouse event callback
    function highlight() {
      if (validMove(this)) {
        this.classList.add("movablepiece");
      }
    }
  
    // on mouseleave event callback
    function unhighlight() {
      if (validMove(this)) {
        this.classList.remove("movablepiece");
      }
    }
  
    // Peice click event handler
    function peiceClick(){
      movePeice(this);
    }
  
    // Swaps the selected peice
    function movePeice(tile) {
      var tempEX = empty_x;
      var tempEY = empty_y;
      if (validMove(tile)) {
        empty_x = parseInt(tile.style.left) / 100; 
        empty_y = parseInt(tile.style.top) / 100;
        tile.style.top = 100 * tempEY + "px";
        tile.style.left = 100 * tempEX + "px";
        tile.setAttribute("id", "peice_" + tempEX + "_" + tempEY);
      }
    }
  
    // Shuffles the peices randomly  
    function shuffleButtonClick() {   
      for (var i = 0; i < 1000; i++) {
        var neighbors = getNeighbors();
        var rand = parseInt(Math.random() * neighbors.length);
        var tile = document.getElementById(neighbors[rand]);
        movePeice(tile);
      }
    }
  
    // Checks peice around selected tile to see if they're empty 
    function getNeighbors() {
      var up = "peice_" + empty_x + "_" + (empty_y - 1);
      var down = "peice_" + empty_x + "_" + (empty_y + 1);
      var left = "peice_" + (empty_x - 1) + "_" + empty_y;
      var right = "peice_" + (empty_x + 1) + "_" + empty_y;
  
      var peice = [up, down, left, right];
      var realpeice = [];
  
      for (var i = 0; i < peice.length; i++) {
        if (document.getElementById(peice[i]) != null) {
          realpeice.push(peice[i]);
        }
      }
      return realpeice;
    }
  
  });