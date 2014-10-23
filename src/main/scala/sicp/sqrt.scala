package sicp

/**
 * Chapter 1
 * Exercise 1.7, 1.8
 */
object Root {
	def main(args: Array[String]): Unit = {
		println(root_iter(2, 1, 1.0E-15, good_enough_B, improve_cubert))
//		println(root_iter(2, 1, 900000000000.0, good_enough_B,improve_cubert))
//		println(root_iter(2, 1, 0.000000000000001, good_enough_B, improve_sqrt))
//		println(root_iter(2, 1, 900000000000.0, good_enough_B, improve_sqrt))
		//println(sqrt_iter(2,1,java.lang.Double.parseDouble(args(0)), good_enough_A))
		//println(sqrt_iter(2,1,java.lang.Double.parseDouble(args(0)), good_enough_B))
	}

	def good_enough_A(prev_guess: Double, guess: Double, x: Double): Boolean = {
		val minus = Math.abs(guess * guess - x)
		println("guess:" + guess)
		println("minus:" + minus)
		if (minus <= 0.000001) {
			return true
		} else {
			return false
		}
	}

	def good_enough_B(prev_guess: Double, guess: Double, x: Double): Boolean = {
		val minus = Math.abs(guess - prev_guess) / guess
		println("prev:" + prev_guess)
		println("guess:" + guess)
		println("minus:" + minus)
		if (minus <= 1.0E-10) {
			return true
		} else {
			return false
		}
	}

	def improve_sqrt(guess: Double, x: Double): Double = {
		return (x / guess + guess) / 2
	}

	def improve_cubert(guess:Double, x:Double):Double={
		return (x/(guess*guess)+2*guess)/3
	}

	def root_iter(prev_guess: Double,
				  guess: Double,
				  x: Double,
				  good_enough: (Double, Double, Double) => Boolean,
				  improve:(Double,Double)=>Double): Double = {
		if (good_enough(prev_guess, guess, x)) {
			return guess
		} else {
			root_iter(guess, improve(guess, x), x, good_enough, improve)
		}
	}
}
