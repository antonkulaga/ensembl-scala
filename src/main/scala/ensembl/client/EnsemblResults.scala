package ensembl.client

import ujson.Value
import upickle.default._
import upickle.default.{macroRW, ReadWriter => RW}

import scala.collection.MapView
/*
case class Ortholog(
                   `type`: String,

                   )

method_link_type	"ENSEMBL_PARALOGUES"
target	{…}
dn_ds	null
type	"other_paralog"
source	{…}
taxonomy_level	"Bilateria"

 */

object EnsemblResults {
  sealed trait EnsemblResults
  object HomologyResults{
    implicit val rw: RW[HomologyResults] = macroRW
  }
  case class HomologyResults(id: String, homologies: Vector[Homology]) {

    /* by homology type*/
    lazy val other_paralog= this.copy(homologies = homologies.filter(_.`type`=="other_paralog"))
    lazy val within_species_paralog= this.copy(homologies = homologies.filter(_.`type`=="within_species_paralog"))
    lazy val ortholog_one2many= this.copy(homologies = homologies.filter(_.`type`=="ortholog_one2many"))
    lazy val ortholog_many2many = this.copy(homologies = homologies.filter(_.`type`=="ortholog_many2many"))

    lazy val byTargetSpecies: Map[String,HomologyResults] = homologies.groupBy(h=>h.target.species).map{ case (s, h) => (s , this.copy(id, homologies =h))}
    lazy val bySourceSpecies: Map[String,HomologyResults] = homologies.groupBy(h=>h.source.species).map{ case (s, h) => (s , this.copy(id, homologies =h))}

    def filter(fun: Homology => Boolean) = this.copy(id, homologies = homologies.filter(fun))

    def bySpecies(species: String*): HomologyResults = {
      val sps: Set[String] = species.toSet[String].map(s=>s.toLowerCase.replace(" ", "_"))
      this.filter(h=>sps.contains(h.target.species))
    }

  }

  object HomologyGeneInfo {
    implicit val rw: RW[HomologyGeneInfo] = macroRW
  }
  case class HomologyGeneInfo(cigar_line : String,
                              align_seq: String,
                              protein_id: String,
                              id: String,
                              perc_id: Double,
                              perc_pos: Double,
                              species: String,
                              taxon_id: Double)

 object Homology{
   implicit val rw: RW[Homology] = macroRW
 }
  case class Homology(
                       method_link_type: String,
                       source: HomologyGeneInfo,
                       target: HomologyGeneInfo,
                       `type`: String,
                       taxonomy_level: String,
                       dn_ds: Value
                      )
}