package essential


//              AND                         OR
//  IS-A      Is-a And                    Sum Type
//  HAS-A     Product Type               Has-a Or

object ProductType {
    
    case class A(b: B, c: C)
    case class B()
    case class C()

    // OR
    trait A1 {
        def b: B
        def c: C
    }
}

object SumType {

    sealed trait A
    final case class B() extends A
    final case class C() extends A

}


// ****** Is-a And ******
// trait B
// trait C
// trait A extends B with C


// ****** Has-a Or *******
// trait A {
//   def d: D
// }
// sealed trait D
// final case class B() extends D
// final case class C() extends D

// sealed trait A
// final case class D(b: B) extends A
// final case class E(c: C) extends A



