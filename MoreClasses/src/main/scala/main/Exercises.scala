package main

object Exercises {
  class Overloading1 {
    def f():Int = 0
    def f(n:Int):Int = { 1 }
    def f(n:Int, n2: Int):Int = { 3 }
    def f(n:Int, n2: Int, n3: Int):Int = { 6 }
    def f(n:Int, n2: Int, n3: Int, n4: Int):Int = 10
  }

  class Dimension(var height: Int, var width: Int)

  class Info(var name: String, var description: String)

  class SimpleTime(val hours: Int, val minutes: Int) {
    override def toString: String = "hours: " + hours + " minutes: " + minutes
    def subtract(st: SimpleTime): SimpleTime = {

      def floorZero(i: Int): Int = if (i < 0) 0 else i

      var hourResult: Int = hours - st.hours
      var minResult: Int = 0
      if (minutes >= st.minutes) minResult = minutes - st.minutes
      else {
        minResult = (minutes + 60) - st.minutes
        hourResult -= 1
      }
      if (hourResult < 0) minResult = 0

      new SimpleTime(floorZero(hourResult), floorZero(minResult))
    }
  }

  class SimpleTimeDefault(val hours: Int = 0, val minutes: Int = 0) {
    override def toString: String = "hours: " + hours + " minutes: " + minutes

    def subtract(st: SimpleTimeDefault): SimpleTimeDefault = {
      def floorZero(i: Int): Int = if (i < 0) 0 else i
      var hourResult: Int = hours - st.hours
      var minResult: Int = 0
      if (minutes >= st.minutes) minResult = minutes - st.minutes
      else {
        minResult = (minutes + 60) - st.minutes
        hourResult -= 1
      }
      if (hourResult < 0) minResult = 0

      new SimpleTimeDefault(floorZero(hourResult), floorZero(minResult))
    }
  }

  class SimpleTimeAux(val hours: Int, val minutes: Int) {
    def this(hours: Int) {
      this(hours, 0)
    }

    override def toString: String = "hours: " + hours + " minutes: " + minutes

    def subtract(st: SimpleTimeAux): SimpleTimeAux = {
      def floorZero(i: Int): Int = if (i < 0) 0 else i
      var hourResult: Int = hours - st.hours
      var minResult: Int = 0
      if (minutes >= st.minutes) minResult = minutes - st.minutes
      else {
        minResult = (minutes + 60) - st.minutes
        hourResult -= 1
      }
      if (hourResult < 0) minResult = 0

      new SimpleTimeAux(floorZero(hourResult), floorZero(minResult))
    }
  }

  def main(args: Array[String]) {
    assert((new Overloading1).f() == 0)
    assert((new Overloading1).f(1) == 1)
    assert((new Overloading1).f(1, 2) == 3)
    assert((new Overloading1).f(1, 2, 3) == 6)
    assert((new Overloading1).f(1, 2, 3, 4) == 10)

    val c = new Dimension(5,7)
    assert(c.height == 5)
    c.height = 10
    assert(c.height == 10)
    c.width = 19
    assert(c.width == 19)

    val info = new Info("stuff", "Something")
    assert(info.name == "stuff")
    assert(info.description == "Something")
    info.description = "Something else"
    assert(info.description == "Something else")
    info.name = "This is the new name"
    assert(info.name == "This is the new name")

    val t1 = new SimpleTime(10, 30)
    val t2 = new SimpleTime(9, 30)
    val st: SimpleTime = t1.subtract(t2)
    assert(st.hours == 1)
    assert(st.minutes == 0)
    val st2 = new SimpleTime(10, 30).subtract(new SimpleTime(9, 45))
    assert(st2.hours == 0)
    assert(st2.minutes == 45)
    val st3 = new SimpleTime(9, 30).subtract(new SimpleTime(10, 0))
    assert(st3.hours == 0)
    assert(st3.minutes == 0)

    val auxT1 = new SimpleTimeAux(10, 5)
    val auxT2 = new SimpleTimeAux(6)
    val auxST = auxT1.subtract(auxT2)
    assert(auxST.hours == 4)
    assert(auxST.minutes == 5)
    val auxST2 = new SimpleTimeAux(12).subtract(new SimpleTimeAux(9, 45))
    assert(auxST2.hours == 2)
    assert(auxST2.minutes == 15)

    val anotherT1 = new SimpleTimeDefault(10, 30)
    val anotherT2 = new SimpleTimeDefault(9)
    val anotherST = anotherT1.subtract(anotherT2)
    assert(anotherST.hours == 1)
    assert(anotherST.minutes == 30)
    val anotherST2 = new SimpleTimeDefault(10).subtract(new SimpleTimeDefault(9, 45))
    assert(anotherST2.hours == 0)
    assert(anotherST2.minutes == 15)

    val myT1 = new SimpleTimeDefault(minutes = 45)
    assert(myT1.hours == 0)
    assert(myT1.minutes == 45)
  }

}
