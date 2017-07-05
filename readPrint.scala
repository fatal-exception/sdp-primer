#!/usr/bin/env scala
import scala.io.StdIn.readLine

val number = readLine("Enter a number: ").toInt
val half = readLine("Now enter half that number: ").toInt
println(if (number / 2 == half) "Well done!" else "idiot...")
