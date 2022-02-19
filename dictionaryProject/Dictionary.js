var url = require("url");

var express= require('express');
var app = express();
app.set('view engine', 'pug')

app.use(express.static('public'));

app.get('/',function(req,res){
       
            res.render('dict');
    })
    .listen(8080 ,function(){
        console.log('Server is running');
    });

    
          
       
                



   