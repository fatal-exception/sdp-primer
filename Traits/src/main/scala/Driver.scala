object Driver {
  def main(args: Array[String]): Unit = {

    val doubleHalfCaf = new Coffee(shots=2, decaf=1)
    val tripleHalfCaf = new Coffee(shots=3, decaf=2)
    assert(doubleHalfCaf.decaf == 1)
    assert(doubleHalfCaf.caf == 1)
    assert(doubleHalfCaf.shots == 2)
    assert(tripleHalfCaf.decaf == 2)
    assert(tripleHalfCaf.caf == 1)
    assert(tripleHalfCaf.shots == 3)

    val tea = new Tea
    assert(tea.describe == "Earl Grey")
    assert(tea.calories == 0)
    val lemonZinger = new Tea(decaf = true, name = "Lemon Zinger")
    assert(lemonZinger.describe == "Lemon Zinger decaf")
    assert(lemonZinger.calories == 0)
    val sweetGreen = new Tea( name = "Jasmine Green", sugar = true)
    assert(sweetGreen.describe == "Jasmine Green + sugar")
    assert(sweetGreen.calories == 16)
    val teaLatte = new Tea(sugar = true, milk = true)
    assert(teaLatte.describe == "Earl Grey + milk + sugar")
    assert(teaLatte.calories == 116)

    val tea2 = new Tea2
    assert(tea2.describe == "Earl Grey")
    assert(tea2.calories == 0)
    assert(tea2.name == "Earl Grey")
    val lemonZinger2 = new Tea2(decaf = true, name="Lemon Zinger")
    assert(lemonZinger2.describe == "Lemon Zinger decaf")
    assert(lemonZinger2.calories == 0)
    assert(lemonZinger2.decaf)
    val sweetGreen2 = new Tea2(name="Jasmine Green", sugar=true)
    assert(sweetGreen2.describe == "Jasmine Green + sugar")
    assert(sweetGreen2.calories == 16)
    assert(sweetGreen2.sugar)
    val teaLatte2 = new Tea2(sugar=true, milk=true)
    assert(teaLatte2.describe == "Earl Grey + milk + sugar")
    assert(teaLatte2.calories == 116)
    assert(teaLatte2.milk)

    val washer = new ClothesWasher3("LG 100", 3.6)
    assert(washer.wash(2, 1) == "Wash used 2 bleach and 1 fabric softener")
    assert(washer.wash() == "Simple wash")

    val p = Person("Jane", "Smile", "jane@smile.com")
    assert(p.first == "Jane")
    assert(p.last == "Smile")
    assert(p.email == "jane@smile.com")

    val people = Array(
      Person("Jane","Smile","jane@smile.com"),
      Person("Ron","House","ron@house.com"),
      Person("Sally","Dove","sally@dove.com"))
    assert(people(0).toString == "Person(Jane,Smile,jane@smile.com)")
    assert(people(1).toString == "Person(Ron,House,ron@house.com)")
    assert(people(2).toString == "Person(Sally,Dove,sally@dove.com)")

    val dogs = Array(Dog("Fido","Golden Lab"), Dog("Ruff","Alaskan Malamute"),Dog("Fifi","Miniature Poodle"))
    assert(dogs(0).toString == "Dog(Fido,Golden Lab)")
    assert(dogs(1).toString == "Dog(Ruff,Alaskan Malamute)")
    assert(dogs(2).toString == "Dog(Fifi,Miniature Poodle)")

    val c = new Dimension(5,7)
    assert(c.height == 5)
//    c.height = 10
//    assert(c.height == 10)
    c.width = 19
    assert(c.width == 19)
  }

}
