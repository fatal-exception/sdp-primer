#!/usr/bin/env scala
import scala.io.StdIn.readLine

var num = -1
while ({
  num = readLine("Give us a number: ").toInt
  num != 0
}) {
  println("number is " + num)
  println("number squared  is " + (num * num).toString)
}
