package ensembl.client

import requests.Response
import ujson.Value.Value

case object EnsemblClient extends EnsemblClient

/**
  * A client to Ensembl REST API
  * https://rest.ensembl.org/
  */
class EnsemblClient extends EnsemblArchive
  with EnsemblComparative
  with EnsemblCrossReference
  with EnsemblQTL
  with EnsemblInformation
  with EnsemblLookup
  with EnsemblMapping
  with EnsemblOntologies
  with EnsemblOverlap
  with EnsemblPhenotype
  with EnsemblSequence
  with EnsemblRegulation
  with EnsemblVariation
  with EnsemblVEP
  with EnsemblGA4GH

/**
  * Archive
  */
trait EnsemblArchive {

  /**
    * https://rest.ensembl.org/documentation/info/archive_id_get
    * example https://rest.ensembl.org/archive/id/ENSG00000157764?content-type=application/json
    */
  def getArchiveJSON(id: String): Value =  ujson.read(
    requests.get(
      s"https://rest.ensembl.org/archive/id/${id}",
      params = Map("content-type" -> "application/json")
    ).text
  )


}

/**
  * Comparative genomics
  */
trait EnsemblComparative {
  /**
    *
    https://rest.ensembl.org/documentation/info/cafe_tree
    TODO: optional parameters nh_format and compara
    */
  def getCafeTreeJSON(id: String, compara: String = "", nh_format: String = ""): Value = {
    ujson.read(
      requests.get(
        s"https://rest.ensembl.org/cafe/genetree/id/${id}",
        params = Map("content-type" -> "application/json")
      ).text
    )
  }
}

trait EnsemblCrossReference {

}

trait EnsemblQTL {

}

trait EnsemblInformation {

}

trait EnsemblLookup {

}

trait EnsemblMapping {

}

trait EnsemblOntologies {

}

trait EnsemblOverlap {

}

trait EnsemblPhenotype{
  
}

trait EnsemblSequence {
  
}

trait EnsemblRegulation {

}

trait EnsemblHaplotypes {

}

trait EnsemblVEP {

}

trait EnsemblVariation {

}

trait EnsemblGA4GH {

}