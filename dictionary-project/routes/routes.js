module.exports = app => {
    const entries = require("../controllers/entries.controller.js");
  
    var router = require("express").Router();  
    
    router.get("/", entries.findAll);
  
    router.get("/:word", entries.findOne);
    
    app.use('/api/search', router);
  };