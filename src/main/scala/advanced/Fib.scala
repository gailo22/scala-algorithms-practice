package advanced

import cats.Eval

object Fib {

  def factorial(n: BigInt): Eval[BigInt] =
    if (n == 1) {
      Eval.now(n)
    } else {
      Eval.defer(factorial(n-1).map(_ * n))
    }

  //factorial(50000).value
}
