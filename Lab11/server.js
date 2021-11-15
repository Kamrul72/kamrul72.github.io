var url = require("url");
var express= require('express');
var app = express();
app.set('view engine', 'pug')
var ansCheck = require("./validation");
//var index = require("./index.js");
var count = 0;
var score = 0;
var database = ["[3, 1, 4, 1, 5]","[1, 1, 2, 3, 5]","[1, 4, 9, 16, 25]","[2, 3, 5, 7, 11]", "[1, 2, 4, 8, 16]"];
var num= "";
app.get('/',function(req,res){
       
        count=0;
        score=0;
        num= database[count];

        res.render('index',{count:count,score:score,num:num});
    })
    .listen(8080 ,function(){
        console.log('Server is running');
    });

    app.get('/validation.js',function(req, res){
        console.log(score + "score");
        var q = url.parse(req.url, true);

       if (count>=5){  res.render('result',{count:count,score:score});  }

        if (ansCheck.check(count, q.query)) {
            score++;
                  }
       
        if (count<5) {count++;
            console.log(count);
            num= database[count];
            res.render('index',{count:count,score:score,num:num});
        }
          

                



    });