$("document").ready(function () {
  myObj = [];
  $tiles = $("#puzzlearea div");
  var emptyTile = { x: 300, y: 300 };
  $tiles.each(function (ind, elem) {
    eachitem(ind, elem, true);
  });
  function eachitem(position, elem, r) {
    setupPosition(position, elem, r);
  }

  $tiles.mouseover(function () {
    let left = $(this).position().left;
    let top = $(this).position().top;
    if (check(left, top) == true) {
      $(this).addClass("movablepiece");
    }
  });
  $tiles.mouseout(function () {
    $(this).removeClass("movablepiece");

  });
  $tiles.click(function () {
    let left = $(this).position().left;
    let top = $(this).position().top;
    swap(left, top, this);
  });

  function check(left, top) {
    if (emptyTile.x == left && Math.abs(emptyTile.y - top) <= 100) {
      return true;
    }
    else if (emptyTile.y == top && Math.abs(emptyTile.x - left) <= 100) {
      return true;
    }
    else return false;
  }

  function swap(left, top, elem) {
    if (check(left, top)) {
      temp = { x: left, y: top };
      $(elem).css({
        left: emptyTile.x + "px",
        top: emptyTile.y + "px"
      });
    }
    emptyTile = temp;
  }
  function setupPosition(position, elem, r) {
    pos = calcPos(position);
    if (r) {
      $(elem).css({
        "background-position": -pos.x + "px " + -pos.y + "px"
      })
    }
    $(elem).css({
      "background-image": "url(background.jpg)",
      top: pos.y,
      left: pos.x
    });
    $(elem).addClass("puzzlepiece");
  }

  function calcPos(ind) {
    return {
      x: (Number.parseInt(ind) % 4) * 100,
      y: Math.floor(ind / 4) * 100
    };
  }

  $('#shufflebutton').click(function shuffle() {
    var obj = [];
    let freecord;
    while (obj.length != 16) {
      let b = false;
      let rand = Math.floor(Math.random() * 16);
      obj.forEach(myFunction)

      function myFunction(item, index) {
        if (item == rand) {
          b = true;
        }

      }
      if (b == false) {
        obj.push(rand);
      }

    }
    let i = 0;
    $tiles.each(function (ind, elem) {
      setupPosition(obj[i], elem, false);
      i++;
    })
    emptyTile = calcPos(obj[i]);
    let inversion = countInversions(obj, emptyTile);
    let emptyodd = Math.abs((((emptyTile.y) / 100) - 4)) % 2

    if (emptyodd != 0 && inversion % 2 == 0) {

    }
    else if (emptyodd == 0 && inversion % 2 != 0) {

    }
    else {
      shuffle();
    }

  });
  function countInversions(array, emptyTile) {
    if (array === undefined) throw new Error("Array must be defined to count inversions");
    if (array.length === 0 || array.length === 1) return 0;

    var tally = 0;
    sort(array);
    return tally;
    function sort(arr) {
      if (arr.length === 1) return arr;
      var right = arr.splice(Math.floor(arr.length / 2), arr.length - 1);
      return merge(sort(arr), sort(right));
    }
    function merge(left, right) {
      var merged = [];
      var l = 0, r = 0;
      var multiplier = 0;
      while (l < left.length || r < right.length) {
        if (l === left.length) {
          merged.push(right[r]);
          r++;
        } else if (r === right.length) {
          merged.push(left[l]);
          l++;
          tally += multiplier;
        } else if (left[l] < right[r]) {
          merged.push(left[l]);
          tally += multiplier;
          l++;
        } else {
          merged.push(right[r]);
          r++;
          multiplier++;
        }
      }
      return merged;
    }
  }
});