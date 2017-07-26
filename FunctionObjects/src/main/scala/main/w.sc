object Janitor	{
  var	salary:	Double = 15.00
}
class	Janitor(name:	String) {
  def getSalary(): Double = {
    Janitor.salary
  }
}

val j = new Janitor("bob")
val d: Double = j.getSalary()
