
var mysql = require('mysql');

var con = mysql.createConnection({
  host: "localhost",
  user: "kamrul",
  password: "root",
  database: "entries",
  insecureAuth : true
});

con.connect(function(err) {
  if (err) throw err;
  console.log("Connected!");
});