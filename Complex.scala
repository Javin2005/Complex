import scala.io.StdIn._

case class Complex(a: Double, b: Double) {
  def modulus: Double = math.sqrt(a * a + b * b)
  def conjugate: Complex = Complex(a, -b)

  // Define multiplication for complex numbers
  def *(other: Complex): Complex = {
    val real = a * other.a - b * other.b
    val imaginary = a * other.b + b * other.a
    Complex(real, imaginary)
  }
}

@main def start: Unit = {
    
    println("input Re: ")
    val re = try {
      readLine().toInt
    } catch {
      case e: NumberFormatException => 
        println("Invalid input for real part, defaulting to 0.")
        0
    }

    println("input Im: ")
    val im = try {
      readLine().toInt
    } catch {
      case e: NumberFormatException => 
        println("Invalid input for imaginary part, defaulting to 0.")
        0
    }

    val z = Complex(re, im)
    val conjugateZ = z.conjugate

    val result = Complex(1, 0) * conjugateZ // multiplicera täljare och nämnare
    val denominator = z * conjugateZ

    val resultInForm = Complex(result.a / denominator.a, result.b / denominator.a)
    println(s"Resultatet i a + bi form: ${resultInForm.a} + ${resultInForm.b}i")
}
