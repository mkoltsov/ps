val a = <a>
           This is some XML.
           Here is a tag: <atag/>
         </a>
val b=         <a> {"hello"+", world"} </a>

val yearMade = 1955

val c = <a> { if (yearMade < 2000) <old>{yearMade}</old>
                else xml.NodeSeq.Empty }
</a>

val d= <a> {3 + 4} </a>

  abstract class CCTherm {
    val description: String
    val yearMade: Int
    val dateObtained: String
    val bookPrice: Int      // in US cents
    val purchasePrice: Int  // in US cents
    val condition: Int      // 1 to 10
    override def toString = description

    def toXML =
            <cctherm>
              <description>{description}</description>
              <yearMade>{yearMade}</yearMade>
              <dateObtained>{dateObtained}</dateObtained>
              <bookPrice>{bookPrice}</bookPrice>
              <purchasePrice>{purchasePrice}</purchasePrice>
              <condition>{condition}</condition>
</cctherm>
  }

  val therm = new CCTherm {
                 val description = "hot dog #5"
                 val yearMade = 1952
                 val dateObtained = "March 14, 2006"
                 val bookPrice = 2199
                 val purchasePrice = 500
                 val condition = 9
}

println(therm.toXML)

val e=  <a> {{{{brace yourself!}}}} </a>

println(<a>Sounds <tag/> good</a>.text)
println(<a> input ---&gt; output </a>.text)
println(<a><b><c>hello</c></b></a> \ "b")

val joe = <employee
                  name="Joe"
                  rank="code monkey"
                  serial="123"/>
println(joe \ "@name")
println(joe \ "@serial")

 def fromXML(node: scala.xml.Node): CCTherm =
          new CCTherm {
            val description   = (node \ "description").text
            val yearMade      = (node \ "yearMade").text.toInt
            val dateObtained  = (node \ "dateObtained").text
            val bookPrice     = (node \ "bookPrice").text.toInt
            val purchasePrice = (node \ "purchasePrice").text.toInt
            val condition     = (node \ "condition").text.toInt
}

val node = therm.toXML

println(fromXML(node))                  

  def proc(node: scala.xml.Node): String =
    node match {
      case <a>{contents}</a> => "It's an a: "+ contents
      case <b>{contents}</b> => "It's a b: "+ contents
      case _ => "It's something else."
}

 def proc2(node: scala.xml.Node): String =
          node match {
            case <a>{contents @ _*}</a> => "It's an a: "+ contents
            case <b>{contents @ _*}</b> => "It's a b: "+ contents
            case _ => "It's something else."
}

  val catalog =
    <catalog>
      <cctherm>
        <description>hot dog #5</description>
        <yearMade>1952</yearMade>
        <dateObtained>March 14, 2006</dateObtained>
        <bookPrice>2199</bookPrice>
        <purchasePrice>500</purchasePrice>
        <condition>9</condition>
      </cctherm>
      <cctherm>
        <description>Sprite Boy</description>
        <yearMade>1964</yearMade>
        <dateObtained>April 28, 2003</dateObtained>
        <bookPrice>1695</bookPrice>
        <purchasePrice>595</purchasePrice>
        <condition>5</condition>
      </cctherm>
    </catalog>

     catalog match {
    case <catalog>{therms @ _*}</catalog> =>
      for (therm <- therms)
        println("processing: "+
                (therm \ "description").text)
}

  catalog match {
    case <catalog>{therms @ _*}</catalog> =>
      for (therm @ <cctherm>{_*}</cctherm>  <-  therms)
        println("processing: "+
                (therm \ "description").text)
}
