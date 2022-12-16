object Main extends App {
  val myVal = {
    println("This is a val")
    1
  }
  println(myVal)
  println(myVal)

  var myVar = {
    println("This is a var")
    2
  }
  println(myVar)

  def myFun = {
    println("This is a function")
    3
  }

  lazy val myLazyVal = {
    println("This is lazy val")
    4
  }

  println(myVal)
  println(myVar)
  println(myFun)
  println(myFun)
  println(myLazyVal)
  println(myLazyVal)
  val myUnit: Unit = ()
  println(myUnit)
  println(myUnit.toString)

  def myFunction: Unit = {
    println("Hello World")
  }

  val myIf =
    if (3 < 4) { true } // Return Boolean
    else { throw new Exception() } // Return Nothing

  type StatusCode = Int
  def myHttpStatusCode(myStatusCode: StatusCode) = print(myStatusCode)

  myHttpStatusCode(200)

  def numberType(x: Int): String = {
    val myVal = 5
    if (x < 0) {
      "negative"
    } else if (x == 0) {
      "zero"
    } else {
      "positive" //String
    }
  }

  println(numberType(3))

  def number(x: Int) = x + 1

  def number_v2 = false
  val ints = List(1, 2, 3, 4, 5)
  for {
    i <- ints if number(i) > 2
  } {
    println(i)
  }

  val myValueI = 5
  def result(myValueI: Int) =
    myValueI match {
      case 1 => {
        println("Oh you like ones")
        "one"
      }
      case 2 => "two"
      case x => s"other: $x"
    }

  println(result(1))
  case class Person(name: String, age: Int)
  def speak(p: Any): Unit = {
    p match {
      case Person("Antonio", _) =>
        println(s"Yes it's me, Antonio")
      case myP @ Person(_, age) if age > 30 =>
        println(s"${myP.age} is practically dead")
      case s: String => println("LOL")
      case _         => println("Watch the Flintstones!")
    }
  }

  speak(Person("Fred", 100))

  def loop(times: Int)(f: Int => Unit): Unit = {
    for (index <- 0 to times) f(index)
  }

  loop(3) { index =>
    println(s"this is my $index time I got executed")
  }

  def sslBuilder(isSSL: Boolean): (String) => String = {
    val schema = if (isSSL) "https://" else "http://"
    (domain: String) => schema + domain
  }

  val url = sslBuilder(isSSL = false)("www.lego.com")

  val names = List("Antonio", "Jenny", "Philip", "Oliver", "Soren", "Josephine")
  val namesLength = names.map(elem => elem.length) // List(7, 5, 6, 6, 5, 9)
  val namesWithO = names.filter(elem => elem.contains("o"))

  val numbers = List(1, 2, 3)
  println(numbers.reduce((accumulator, element) => accumulator + element))
  val things =
    namesLength
      .filter(_ < 7)
      .reduce((a, b) => a + b)

  names.foreach(elem => println(elem)) // ???
  names.foreach(println(_)) // ???

  val firstElem: String = names.head
  println(firstElem.map(_.toString.toUpperCase).toList)

  println(namesLength)
  println(namesLength.map(elem => List(elem - 1, elem, elem + 1)))

  val states = Map(
    "it" -> "Italia",
    "dk" -> "Denmark"
  )
  for { (k, v) <- states } { println(s"key: $k, value: $v") }

  states.foreach((k, v) => println(s"key: $k, value: $v"))

  val moreStates =
    states + ("en" -> "England") // Map(it -> Italia, dk -> Denmark, en -> England)
  val evenMore =
    moreStates ++ Map(
      "es" -> "Spain",
      "de" -> "Germany"
    ) // HashMap(de -> Germany, en -> England, es -> Spain, IT -> Italia, DK -> Denmark)
  val removed = moreStates - "en"

  val numbers_list = 1 to 10
  println(numbers_list.toList)

  val chessBoard = for {
    letter <- 'A' to 'H'
    number <- 1 to 8
  } yield s"$letter$number"

  println(chessBoard.toList)

  case class User(name: String, age: Int)
  case class Student(name: String, email: String)
  val myUsers = List(User("Antonio", 32), User("Jenny", 27))
  val myStudents = List(Student("Antonio", "antonio@lego.com"))

  def getUser(name: String): Option[User] =
    myUsers.find(elem => elem.name.equalsIgnoreCase(name))

  def getStudent(user: User): Option[Student] =
    myStudents.find(elem => elem.name.equalsIgnoreCase(user.name))

  def findStudent(name: String): Option[Student] =
    for {
      myUser <- getUser(name)
      myStudent <- {
        println(s"I found a user $myUser")
        getStudent(myUser)
      }
    } yield myStudent

  println(findStudent("antonio"))
  println(findStudent("jenny"))
  println(findStudent("whatever"))
}
