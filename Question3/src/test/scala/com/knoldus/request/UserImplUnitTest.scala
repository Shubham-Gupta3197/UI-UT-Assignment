package com.knoldus.request
import com.knoldus.models.User
import com.knoldus.validator.UserValidator
import org.mockito.MockitoSugar.{mock, when}
import org.scalatest.flatspec.AnyFlatSpec

class UserImplUnitTest extends AnyFlatSpec {

  val mockedUserValidator = mock[UserValidator]
  val ShubhamUser: User = User("Shubham","Gupta",23,"Knoldus","shubham.gupta@knoldus.com")

  "User" should "be created" in {
    val userImpl = new UserImpl(mockedUserValidator)

    when(mockedUserValidator.userIsValid(ShubhamUser)) thenReturn(true)
    val result = userImpl.createUser(ShubhamUser)
    assert(!result.isEmpty)
  }

  "User" should "not be created" in {
    val userImpl = new UserImpl(mockedUserValidator)

    when(mockedUserValidator.userIsValid(ShubhamUser)) thenReturn(false)
    val result = userImpl.createUser(ShubhamUser)
    assert(result.isEmpty)
  }

}
