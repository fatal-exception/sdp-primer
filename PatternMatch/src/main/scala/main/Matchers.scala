package main

object Matchers {
  def matchColour(colour: String): String = {
    if (colour == "red")
    "RED"
    else if (colour == "blue")
    "BLUE"
    else if (colour == "green")
    "GREEN"
    else "UNKNOWN COLOUR"
  }

  def oneOrTheOther(exp: Boolean): String = {
    exp match {
      case true => "True!"
      case _ => "It's false"
    }
  }

  def checkTruth(exp1: Boolean, exp2: Boolean) = {
    (exp1, exp2) match {
      case (true, true) => "Both are true"
      case (false, false) => "Both are false"
      case (true, false) => "First true, second false"
      case _ => "First false, second true"
    }
  }

  def forecast(sun: Int): String = {
    sun match {
      case 100 => "Sunny"
      case 80 => "Mostly Sunny"
      case 50 => "Partly Sunny"
      case 20 => "Mostly Cloudy"
      case 0 => "Cloudy"
      case _ => "Unknown"
    }
  }

}
