package app

object ExampleApp {
  import fansi.{Back => BG, Color => FG, Str}

  def main(args: Array[String]): Unit = {
    val as = List(1,2,3)
    pprint.pprintln(as)

    val redOnWhite: Str = BG.White(FG.Red(" Hello "))
    println(redOnWhite.length)
    println(redOnWhite)
  }

}
