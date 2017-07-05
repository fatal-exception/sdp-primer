#!/usr/bin/env scala

import scala.io.StdIn.readLine

val num = readLine("give us a number: ").toInt
println(if (num > 100) "That's a big number" else "That's a small number")
