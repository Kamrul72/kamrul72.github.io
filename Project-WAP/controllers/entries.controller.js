const Entry = require("../models/entry.model.js");

exports.findAll = (req, res) => {
  
};

exports.findOne = (req, res) => {
    Entry.findByWord(req.params.word, (err, data) => {
      if (err) {
        if (err.kind === "not_found") {
          res.status(404).send({
            message: `Not found Entry with word ${req.params.word}.`
          });
        } else {
          res.status(500).send({
            message: "Error retrieving Word with id " + req.params.word
          });
        }
      } else res.send(data);
    });
  };