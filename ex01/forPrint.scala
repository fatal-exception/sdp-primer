#!/usr/bin/env scala
import scala.io.StdIn.readLine
import scala.math.pow

for (i <- 1 to 25) {
  println(i + " " + pow(i, 2).toInt + " " + pow (i,3).toInt)
}
