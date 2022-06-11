package com.example.demo.entity

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "member")
class Member (name: String, email : String){
    @Id @GeneratedValue
    var id : Long? = null
    var username : String = name
    var email : String = email

    override fun toString(): String {
        return "Member(id=$id, username='$username', email='$email')"
    }

}