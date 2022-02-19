var http = require('http');
var dt = require('./myModule');
http.createServer(function (req, res) {
    res.writeHead(200,
        { 'Content-Type': 'text/html' });
    res.write("Current date and time: " + dt.sahir());
    res.end();
}).listen(8080);