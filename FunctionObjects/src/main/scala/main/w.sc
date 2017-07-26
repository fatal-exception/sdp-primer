val v = Vector(1,2,3,4)
println(v.reduce((s: StringBuilder, i: Int) => s.append(i)))