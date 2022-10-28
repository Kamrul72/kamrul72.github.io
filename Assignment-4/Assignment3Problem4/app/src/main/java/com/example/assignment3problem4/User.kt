package com.example.assignment3problem4

class User:java.io.Serializable {
    var firstName:String
    var lastName:String
    var userName:String
    var password:String
    constructor(firstName:String ,lastName:String,userName:String,password:String){
        this.firstName=firstName
        this.lastName=lastName
        this.userName=userName
        this.password=password
    }

}