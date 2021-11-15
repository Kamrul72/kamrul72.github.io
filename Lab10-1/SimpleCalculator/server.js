const express =require('express');
const app=express();

var url = require("url");
var path = require("path");
var cModule = require("./cModule.js");
var fs = require("fs");
var bodyParser = require('body-parser');

app.use((req,res,next)=>{
   // console.log("In the first Middlewar");
   res.writeHead(200, { "Content-Type": "text/html" });
    res.send(
        `<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="style.css">
    <title>Simple Calculator</title>
  </head>
  <body>
    <h1>Simple Calculator</h1>
    <form action="http://localhost:8080/add.js" method="GET">
      <hr />
      <label>First Value <input type="text" name="first" /></label>
      <hr />
      <label>Second Value <input type="text" name="second" /></label>
      <hr />
      <label
        >Operation Type
        <select id="operation" name="operation">
          <option value="add">Add</option>
          <option value="subtract">Subtract</option>
          <option value="multiply">Multiply</option>
          <option value="divide">Divide</option>
        </select>
      </label>
      <hr />
      <input id="button" type = "submit" value = "Submit">
    </form>
  </body>
</html>`
    );


    res.end();
    next();
});

app.get('/add.js',(req,res,next)=>{
   
   
    var q = url.parse(req.url, true);
    var vals=q.query;
    var operation = vals.operation;
    var result = 0;
    console.log(operation + " first --" + vals.first + "second" + vals.second);
    if (operation == "add") {
        result = parseInt(vals.first) + parseInt(vals.second);
        console.log(result);
    } else if (operation == "subtract") {
        result = parseInt(vals.first) - parseInt(vals.second);
    } else if (operation == "multiply") {
        result = parseInt(vals.first) * parseInt(vals.second);
    } else {
        result = parseInt(vals.first) / parseInt(vals.second);
    }
    console.log(result);
    console.log(q.pathname);
    console.log(q.query);
   
     // cModule.calc(req, res, q.query);
    











   
    //res.redirect('/');
   //res.setHeader('Content-Type', 'text/plain');
    //res.write('you posted:\n');
    //console.log(q.query.first);
   // cModule.calc(req, res, q.query);

  /* res.send(

    `<!DOCTYPE html>
    <html lang="en">
      <head>
        <meta charset="UTF-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <link rel="stylesheet" href="style.css">
        <title>Simple Calculator</title>
      </head>
      <body>
        <h1>The answer is</h1>
        </body>
        </html>`

   );
   */
   
});


app.listen(8080,()=>{
    console.log('Server is running ');
});
