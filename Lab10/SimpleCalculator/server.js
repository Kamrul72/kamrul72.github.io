const express =require('express');
const app=express();

var url = require("url");
var path = require("path");
var cModule = require("./cModule.js");
var fs = require("fs");


app.use((req,res,next)=>{
    var q = url.parse(req.url, true);
    var ext = path.extname(q.pathname);
    
    if (ext == ".css") {
        res.writeHead(200, { "Content-Type": "text/css" });
        res.write(fs.readFileSync("style.css"), "utf-8");
    } else if (q.pathname == "/add.js") {
        cModule.calc(req, res, q.query);
    } else {
        res.writeHead(200, { "Content-Type": "text/html" });
        res.write(fs.readFileSync("index.html"), "utf-8");
    }
    res.end();
});

app.listen(8080,()=>{
    console.log('Server is running ');
});