package com.knoldus.request

import com.knoldus.db.CompanyReadDto
import com.knoldus.models.User
import com.knoldus.validator.{EmailValidator, UserValidator}
import org.scalatest.flatspec.AnyFlatSpec

class UserImplIntegrationTest extends AnyFlatSpec {

  val companyName = new CompanyReadDto
  val validateEmail = new EmailValidator
  val userValidator = new UserValidator(companyName,validateEmail)

  val userImpl = new UserImpl(userValidator)

  "User" should "not be created as company does not exists in DB" in {
    val ankurUser: User = User("Ankur","Aggarwal",24,"Oracle","Ankur.aggarwal@oracle.com")

    val result = userImpl.createUser(ankurUser)
    assert(result.isEmpty)
  }

  "User" should "not be created as email id is not valid" in {
    val yashiUser: User = User("Yashi","singh",23,"Knoldus","yashi.singh@knoldus")

    val result = userImpl.createUser(yashiUser)
    assert(result.isEmpty)
  }

  "User" should "not be created as company does not exists in DB and email id is not valid" in {
    val mukulUser: User = User("Mukul","Gupta",22,"Microsoft","mukul.kumar@microsoft")

    val result = userImpl.createUser(mukulUser)
    assert(result.isEmpty)
  }

  "User" should "be created" in {
    val ShubhamUser: User = User("Shubham","Gupta",23,"Knoldus","shubham.gupta@knoldus.com")

    val result = userImpl.createUser(ShubhamUser)
    assert(!result.isEmpty)
  }

}
