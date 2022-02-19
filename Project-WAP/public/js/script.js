$(document).ready(function () {
    
  
    $("form").on("submit", function (event) {
      let word = $(this).find("#search").val();
      console.log(word);
      let url = "http://localhost:8080/api/search/"+word; 
      $.ajax(url, {
        type: "GET",
        dataType: "json",
        success: function (result) {
          $("#def").html("");
          if (result.length === 0) {
            let notFound = $(
              "<div><p>Sorry, the term you searched for was not found in our Dictionary!</p></div>"
            );
            notFound.css({
              color: "red",
              "font-family": " monospace",
              "font-size": "16px",
              "margin-top": "15px",
            });
            $("#def").prepend(notFound);
          }
          $("#def").append($("<ol></ol>"));
          for (let i = 0; i < result.length; i++) {
            let defn = $(
              "<li>(" +
                result[i].wordtype +
                ") :: " +
                result[i].definition +
                "</li>"
            );
            defn.appendTo($("#def > ol"));
          }
        },
        error: function (err) {
          console.log(err);
        },
      });
  
      event.preventDefault();
    });
  });
  