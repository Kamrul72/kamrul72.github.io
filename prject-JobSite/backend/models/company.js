const mongoose = require("mongoose");

const companySchema = mongoose.Schema({
  _id: mongoose.Schema.Types.ObjectId,
  companyName: String,
  password: String,
  email: String,
  about: String,
  postedJobs: [{
    jobRole: String,
    experience: String,
    skills:String,
    jobDescription: String,
    jobType: String,
    postedDate:String

  }],
seekers:[{
    name: String,
    email: String,
    phone: String,
    location: String,
    appliedFor: String,
}]
});

module.exports = mongoose.model("Company", companySchema);
