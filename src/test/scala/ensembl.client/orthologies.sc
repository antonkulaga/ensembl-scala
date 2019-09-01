import ensembl.client._
//import pprint
import upickle.default._

import ensembl.client._
//import pprint
import upickle.default._


val EnsemblClient = new EnsemblClient()
val genes = List(
  "ENSG00000111704",
  "ENSG00000204531",
  "ENSG00000181449",
  "ENSG00000088305",
  "ENSG00000164362"
)
val h = EnsemblClient.getHomology("ENSG00000111704")

println(h)
println("================")
//pprint.PPrinter.BlackWhite.pprintln(h.homologies.head)

h.homologies.map(hom=>homtaxonomy_level).toSet