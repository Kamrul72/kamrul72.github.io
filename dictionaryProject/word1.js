var express = require('express');
var app= express();
app.set('view engine','pug');

app.get('/',function (req, res){
    var sql = require('mysql');
    var config={
    user: 'root',
    password: 'root',
    database: 'entries',
    server:'localhost'

    };
    

    sql.Connect('config',function(err){
        if(err)console.log(err);
        var request=new sql.Request();
        request.query('select * from etries',function(err , recordSet){
            if(err)console.log(err);
            res.send(recordSet);
        });
    });
    
});

var server = app.listen(8080,function(){
    console.log("server running");
});


