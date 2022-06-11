package com.example.demo.entity

import java.math.BigDecimal
import javax.persistence.*

@Entity
@Table(name = "account")
class Account(member: Member, number: String, balance: BigDecimal) {

    @Id
    @GeneratedValue
    var id: Long? = null

    @ManyToOne
    @JoinColumn(foreignKey = ForeignKey(ConstraintMode.NO_CONSTRAINT))
    var member: Member = member
    var number: String = number
    var balance: BigDecimal = balance


}