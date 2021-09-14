package com.knoldus.db

import com.knoldus.models.Employee
import scala.collection.immutable.HashMap

class EmployeeReadDto {

  val ShubhamEmployee: Employee = Employee("Shubham","Gupta",23,12000,"Intern","knoldus","shubham.gupta@knoldus.com")
  val RajatEmployee: Employee = Employee("Rajat","Gupta",30,135000,"Software Engineer","Cognizant","rajat.gupta@cognizant.com")

  val employees: HashMap[String, Employee] = HashMap("Shubham" -> ShubhamEmployee, "Rajat" -> RajatEmployee)
  def getEmployeeByName(name: String): Option[Employee] = employees.get(name)

}
