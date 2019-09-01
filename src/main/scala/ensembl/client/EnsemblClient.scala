package ensembl.client

import ujson.Value.Value
import upickle.default._
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
  with EnsemblLinkageDisequilibrium
  with EnsemblLookup
  with EnsemblMapping
  with EnsemblOntologies
  with EnsemblOverlap
  with EnsemblPhenotype
  with EnsemblRegulation
  with EnsemblSequence
  with EnsemblHaplotypes
  with EnsemblVEP
  with EnsemblVariation
  with EnsemblGA4GH

/**
  * Archive
  */
trait EnsemblArchive {

  /**
    * Uses the given identifier to return its latest version.
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
    * Retrieves a cafe tree of the gene tree using the gene tree stable identifier.
    * https://rest.ensembl.org/documentation/info/cafe_tree
    * TODO: optional parameters compara and nh_format
    */
  def getCafeTreeJSON(id: String, compara: String = "", nh_format: String = ""): Value = {
    ujson.read(
      requests.get(
        s"https://rest.ensembl.org/cafe/genetree/id/${id}",
        params = Map("content-type" -> "application/json")
      ).text
    )
  }

  /**
    * Retrieves the cafe tree of the gene tree that contains the gene / transcript / translation stable identifier.
    * https://rest.ensembl.org/documentation/info/cafe_tree_member_id
    * TODO: optional parameters compara, db_type, nh_format, object_type, species
    */
  def getCafeTreeMemberJSON(id: String, compara: String = "", db_type: String = "", nh_format: String = "",
                            object_type: String = "", species: String = ""): Value = {
    ujson.read(
      requests.get(
        s"https://rest.ensembl.org/cafe/genetree/member/id/${id}",
        params = Map("content-type" -> "application/json")
      ).text
    )
  }

  /**
    * Retrieves the cafe tree of the gene tree that contains the gene identified by a symbol.
    * https://rest.ensembl.org/documentation/info/cafe_tree_member_symbol
    * TODO: optional parameters compara, db_type, external_db, nh_format, object_type
    */
  def getCafeTreeMemberSymbolJSON(species: String, symbol: String, compara: String = "", db_type: String = "",
                                  external_db: String = "", nh_format: String = "", object_type: String = ""): Value = {
    ujson.read(
      requests.get(
        s"https://rest.ensembl.org/cafe/genetree/member/symbol/${species}/${symbol}",
        params = Map("content-type" -> "application/json")
      ).text
    )
  }

  /**
    * Retrieves a family information using the family stable identifier.
    * https://rest.ensembl.org/documentation/info/family
    * TODO: optional parameters aligned, compara, member_source, sequence
    */
  def getFamilyJSON(id: String, aligned: Boolean = true, compara: String = "", member_source: String = "",
                    sequence: String = ""): Value = {
    ujson.read(
      requests.get(
        s"https://rest.ensembl.org/family/id/${id}",
        params = Map("content-type" -> "application/json")
      ).text
    )
  }

  /**
    * Retrieves the information for all the families that contains
    * the gene / transcript / translation stable identifier.
    * https://rest.ensembl.org/documentation/info/family_member_id
    * TODO: optional parameters aligned, compara, member_source, sequence
    */
  def getFamilyMemberJSON(id: String, aligned: Boolean = true, compara: String = "", member_source: String = "",
                          sequence: String = ""): Value = {
    ujson.read(
      requests.get(
        s"https://rest.ensembl.org/family/member/id/${id}",
        params = Map("content-type" -> "application/json")
      ).text
    )
  }

  /**
    * Retrieves the information for all the families that contains the gene identified by a symbol.
    * https://rest.ensembl.org/documentation/info/family_member_symbol
    * TODO: optional parameters aligned, compara, db_type, external_db, member_source, object_type, sequence
    */
  def getFamilyMemberSymbolJSON(species: String, symbol: String, aligned: Boolean = true, compara: String = "",
                                db_type: String = "", external_db: String = "", member_source: String = "",
                                object_type: String = "", sequence: String = ""): Value = {
    ujson.read(
      requests.get(
        s"https://rest.ensembl.org/family/member/symbol/${species}/${symbol}",
        params = Map("content-type" -> "application/json")
      ).text
    )
  }

  /**
    * Retrieves a gene tree for a gene tree stable identifier.
    * https://rest.ensembl.org/documentation/info/genetree
    * TODO: optional parameters aligned, cigar_line, clusterset_id, compara, nh_format, prune_species, prune_taxon,
    * sequence
    */
  def getTreeJSON(id: String, aligned: Boolean = false, cigar_line: Boolean = false, clusterset_id: String = "",
                  compara: String = "", nh_format: String = "", prune_species: Int = 0,
                  sequence: String = ""): Value = {
    ujson.read(
      requests.get(
        s"https://rest.ensembl.org/genetree/id/${id}",
        params = Map("content-type" -> "application/json")
      ).text
    )
  }

  /**
    * Retrieves the gene tree that contains the gene / transcript / translation stable identifier.
    * https://rest.ensembl.org/documentation/info/genetree_member_id
    * TODO: optional parameters aligned, cigar_line, clusterset_id, compara, db_type, nh_format, object_type,
    * prune_species, prune_taxon, sequence, species
    */
  def getTreeMemberJSON(id: String, aligned: Boolean = false, cigar_line: Boolean = false, clusterset_id: String = "",
                        compara: String = "", db_type: String = "", nh_format: String = "", object_type: String = "",
                        prune_species: String = "", prune_taxon: Int = 0, sequence: String = "",
                        species: String = ""): Value = {
    ujson.read(
      requests.get(
        s"https://rest.ensembl.org/genetree/member/id/${id}",
        params = Map("content-type" -> "application/json")
      ).text
    )
  }

  /**
    * Retrieves the gene tree that contains the gene identified by a symbol.
    * https://rest.ensembl.org/documentation/info/genetree_member_symbol
    * TODO: optional parameters aligned, cigar_line, clusterset_id, compara, db_type, external_db, nh_format,
    * object_type, prune_species, prune_taxon, sequence
    */
  def getTreeMemberSymbolJSON(species: String, symbol: String, aligned: Boolean = false, cigar_line: Boolean = false,
                              clusterset_id: String = "", compara: String = "", db_type: String = "",
                              external_db: String = "", nh_format: String = "", object_type: String = "",
                              prune_species: String = "", prune_taxon: Int = 0, sequence: String = ""): Value = {
    ujson.read(
      requests.get(
        s"https://rest.ensembl.org/genetree/member/symbol/${species}/${symbol}",
        params = Map("content-type" -> "application/json")
      ).text
    )
  }

  /**
    * Retrieves genomic alignments as separate blocks based on a region and species.
    * https://rest.ensembl.org/documentation/info/genomic_alignment_region
    * TODO: optional parameters aligned, compact, compara, display_species_set, mask, method, species_set,
    * species_set_group
    */
  def getAlignmentRegionJSON(species: String, region: String, aligned: Boolean = true, compact: Boolean = true,
                             compara: String = "", display_species_set: String = "", mask: String = "",
                             method: String = "", species_set: String = "", species_set_group: String = ""): Value = {
    ujson.read(
      requests.get(
        s"https://rest.ensembl.org/alignment/region/${species}/${region}",
        params = Map("content-type" -> "application/json")
      ).text
    )
  }

  /**
    * Retrieves homology information (orthologs) by Ensembl gene id.
    * https://rest.ensembl.org/documentation/info/homology_ensemblgene
    * TODO: optional parameters aligned, cigar_line, compara, format, sequence, target_species, target_taxon,
    * type_homology
    * TODO: parameter "type" was renamed to "type_homology" due to compiler problem
    */
  def getHomologyJSON(id: String, aligned: Boolean = true, cigar_line: Boolean = true, compara: String = "",
                      format: String = "", sequence: String = "", target_species: String = "", target_taxon: Int = 0,
                      type_homology: String = ""): Value = {
    ujson.read(
      requests.get(
        s"https://rest.ensembl.org/homology/id/${id}",
        params = Map("content-type" -> "application/json")
      ).text
    )
  }

  def getHomology(id: String, aligned: Boolean = true, cigar_line: Boolean = true, compara: String = "",
                  format: String = "", sequence: String = "", target_species: String = "", target_taxon: Int = 0,
                  type_homology: String = ""): EnsemblResults.HomologyResults = {
    val v = getHomologyJSON(id, aligned, cigar_line, compara, format, sequence, target_species, target_taxon, type_homology)("data")(0)
    read[EnsemblResults.HomologyResults](v)
  }

  /**
    * Retrieves homology information (orthologs) by symbol.
    * https://rest.ensembl.org/documentation/info/homology_symbol
    * TODO: optional parameters aligned, cigar_line, compara, external_db, format, sequence, target_species,
    * target_taxon, type_homology
    * TODO: parameter "type" was renamed to "type_homology" due to compiler problem
    */
  def getHomologySymbolJSON(species: String, symbol: String, aligned: Boolean = true, cigar_line: Boolean = true,
                            compara: String = "", external_db: String = "", format: String = "", sequence: String = "",
                            target_species: String = "", target_taxon: Int = 0, type_homology: String = ""): Value = {
    ujson.read(
      requests.get(
        s"https://rest.ensembl.org/homology/symbol/${species}/${symbol}",
        params = Map("content-type" -> "application/json")
      ).text
    )
  }
}



/**
  * Cross References
  */
trait EnsemblCrossReference {

  /**
    * Looks up an external symbol and returns all Ensembl objects linked to it.
    * This can be a display name for a gene/transcript/translation, a synonym or an externally linked reference.
    * If a gene's transcript is linked to the supplied symbol the service will return both gene and transcript
    * (it supports transient links).
    * https://rest.ensembl.org/documentation/info/xref_external
    * TODO: optional parameters db_type, external_db, object_type
    */
  def getRefSymbolJSON(species: String, symbol: String, db_type: String = "", external_db: String = "",
                       object_type: String = ""): Value = {
    ujson.read(
      requests.get(
        s"https://rest.ensembl.org/xrefs/symbol/${species}/${symbol}",
        params = Map("content-type" -> "application/json")
      ).text
    )
  }

  /**
    * Perform lookups of Ensembl Identifiers and retrieve their external references in other databases.
    * https://rest.ensembl.org/documentation/info/xref_id
    * TODO: optional parameters all_levels, db_type, external_db, object_type, species
    */
  def getRefJSON(id: String, all_levels: Boolean = false, db_type: String = "", external_db: String = "",
                 object_type: String = "", species: String = ""): Value = {
    ujson.read(
      requests.get(
        s"https://rest.ensembl.org/xrefs/id/${id}",
        params = Map("content-type" -> "application/json")
      ).text
    )
  }

  /**
    * Performs a lookup based upon the primary accession or display label of an external reference and
    * returning the information we hold about the entry.
    * https://rest.ensembl.org/documentation/info/xref_name
    * TODO: optional parameters db_type, external_db
    */
  def getRefNameJSON(species: String, name: String, db_type: String = "", external_db: String = ""): Value = {
    ujson.read(
      requests.get(
        s"https://rest.ensembl.org/xrefs/name/${species}/${name}",
        params = Map("content-type" -> "application/json")
      ).text
    )
  }
}



/**
  * EQTL
  */
trait EnsemblQTL {

  /**
    * Returns the p-value for each SNP in a given gene (e.g. ENSG00000227232).
    * https://rest.ensembl.org/documentation/info/species_id
    * TODO: optional parameters statistic, tissue, variant_name
    */
  def getEqtlIdJSON(species: String, stable_id: String, statistic: String = "", tissue: String = "",
                    variant_name: String = ""): Value = {
    ujson.read(
      requests.get(
        s"https://rest.ensembl.org/eqtl/stable_id/${species}/${stable_id}",
        params = Map("content-type" -> "application/json")
      ).text
    )
  }

  /**
    * Returns the p-values for a SNP (e.g. rs123).
    * https://rest.ensembl.org/documentation/info/species_variant
    * TODO: optional parameters id, statistic, tissue
    */
  def getEqtlNameJSON(species: String, variant_name: String, id: String = "", statistic: String = "",
                      tissue: String = ""): Value = {
    ujson.read(
      requests.get(
        s"https://rest.ensembl.org/eqtl/variant_name/${species}/${variant_name}",
        params = Map("content-type" -> "application/json")
      ).text
    )
  }

  /**
    * Returns all tissues currently available in the DB.
    * https://rest.ensembl.org/documentation/info/tissues
    * TODO: ? Is the "species" optional parameter? Does the method work without parameter?
    */
  def getEqtlTissueJSON(species: String = ""): Value = {
    ujson.read(
      requests.get(
        if (species == "") s"https://rest.ensembl.org/eqtl/tissue"
        else s"https://rest.ensembl.org/eqtl/tissue/${species}",
        params = Map("content-type" -> "application/json")
      ).text
    )
  }
}



/**
  * Information
  */
trait EnsemblInformation {

  /**
    * List the names of analyses involved in generating Ensembl data.
    * https://rest.ensembl.org/documentation/info/analysis
    */
  def getInfoAnalysisJSON(species: String): Value = {
    ujson.read(
      requests.get(
        s"https://rest.ensembl.org/info/analysis/${species}",
        params = Map("content-type" -> "application/json")
      ).text
    )
  }

  /**
    * List the currently available assemblies for a species, along with toplevel sequences,
    * chromosomes and cytogenetic bands.
    * https://rest.ensembl.org/documentation/info/assembly_info
    * TODO: optional parameters bands, synonyms
    */
  def getInfoAssemblyJSON(species: String, bands: Boolean = false, synonyms: Boolean = false): Value = {
    ujson.read(
      requests.get(
        s"https://rest.ensembl.org/info/assembly/${species}",
        params = Map("content-type" -> "application/json")
      ).text
    )
  }

  /**
    * Returns information about the specified toplevel sequence region for the given species.
    * https://rest.ensembl.org/documentation/info/assembly_stats
    * TODO: optional parameters bands, synonyms
    */
  def getInfoAssemblyRegionJSON(species: String, region_name: String, bands: Boolean = false,
                                synonyms: Boolean = false): Value = {
    ujson.read(
      requests.get(
        s"https://rest.ensembl.org/info/assembly/${species}/${region_name}",
        params = Map("content-type" -> "application/json")
      ).text
    )
  }

  /**
    * List the functional classifications of gene models that Ensembl associates with a particular species.
    * Useful for restricting the type of genes/transcripts retrieved by other endpoints.
    * https://rest.ensembl.org/documentation/info/biotypes
    */
  def getInfoBiotypesJSON(species: String): Value = {
    ujson.read(
      requests.get(
        s"https://rest.ensembl.org/info/biotypes/${species}",
        params = Map("content-type" -> "application/json")
      ).text
    )
  }

  /**
    * Without argument the list of available biotype groups is returned.
    * With :group argument provided, list the properties of biotypes within that group.
    * Object type (gene or transcript) can be provided for filtering.
    * https://rest.ensembl.org/documentation/info/biotypes_groups
    * TODO: check implementation of method
    */
  def getInfoBiotypesGroupObjectJSON(group: String = "", object_type: String = ""): Value = {
    ujson.read(
      requests.get(
        if (group == "") s"https://rest.ensembl.org/info/biotypes/groups/${object_type}"
        else s"https://rest.ensembl.org/info/biotypes/groups/${group}/${object_type}",
        params = Map("content-type" -> "application/json")
      ).text
    )
  }

  /**
    * List the properties of biotypes with a given name.
    * Object type (gene or transcript) can be provided for filtering.
    * https://rest.ensembl.org/documentation/info/biotypes_name
    * TODO: optional parameter object_type
    */
  def getInfoBiotypesNameJSON(name: String, object_type: String = ""): Value = {
    ujson.read(
      requests.get(
        if (object_type == "") s"https://rest.ensembl.org/info/biotypes/name/${name}"
        else s"https://rest.ensembl.org/info/biotypes/name/${name}/${object_type}",
        params = Map("content-type" -> "application/json")
      ).text
    )
  }

  /**
    * List all compara analyses available (an analysis defines the type of comparative data).
    * https://rest.ensembl.org/documentation/info/compara_methods
    * TODO: optional parameters classOfMethod, compara
    * TODO: parameter "class" was renamed to "class_of_method" due to compiler problem
    */
  def getInfoComparaMethodsJSON(class_of_method: String = "", compara: String = ""): Value = {
    ujson.read(
      requests.get(
        s"https://rest.ensembl.org/info/compara/methods",
        params = Map("content-type" -> "application/json")
      ).text
    )
  }

  /**
    * List all collections of species analysed with the specified compara method.
    * https://rest.ensembl.org/documentation/info/compara_species_sets
    * TODO: optional parameter compara
    */
  def getInfoCompareSpeciesJSON(method: String, compara: String = ""): Value = {
    ujson.read(
      requests.get(
        s"https://rest.ensembl.org/info/compara/species_sets/${method}",
        params = Map("content-type" -> "application/json")
      ).text
    )
  }

  /**
    * Lists all available comparative genomics databases and their data release.
    * https://rest.ensembl.org/documentation/info/comparas
    */
  def getInfoComparasJSON(): Value = {
    ujson.read(
      requests.get(
        s"https://rest.ensembl.org/info/comparas",
        params = Map("content-type" -> "application/json")
      ).text
    )
  }

  /**
    * Shows the data releases available on this REST server.
    * May return more than one release (unfrequent non-standard Ensembl configuration).
    * https://rest.ensembl.org/documentation/info/data
    */
  def getInfoDataJSON(): Value = {
    ujson.read(
      requests.get(
        s"https://rest.ensembl.org/info/data",
        params = Map("content-type" -> "application/json")
      ).text
    )
  }

  /**
    * Lists all available external sources for a species.
    * https://rest.ensembl.org/documentation/info/external_dbs
    * TODO: optional parameters feature, filter
    */
  def getInfoExternalDbsJSON(species: String, feature: String = "", filter: String = ""): Value = {
    ujson.read(
      requests.get(
        s"https://rest.ensembl.org/info/external_dbs/${species}",
        params = Map("content-type" -> "application/json")
      ).text
    )
  }

  /**
    * Checks if the service is alive.
    * https://rest.ensembl.org/documentation/info/ping
    * TODO: suppose that the method can be simplified
    */
  def getInfoPingJSON(): Value = {
    ujson.read(
      requests.get(
        s"https://rest.ensembl.org/info/ping",
        params = Map("content-type" -> "application/json")
      ).text
    )
  }

  /**
    * Shows the current version of the Ensembl REST API.
    * https://rest.ensembl.org/documentation/info/rest
    * TODO: suppose that the method can be simplified
    */
  def getInfoRestJSON(): Value = {
    ujson.read(
      requests.get(
        s"https://rest.ensembl.org/info/rest",
        params = Map("content-type" -> "application/json")
      ).text
    )
  }

  /**
    * Shows the current version of the Ensembl API used by the REST server.
    * https://rest.ensembl.org/documentation/info/software
    * TODO: suppose that the method can be simplified
    */
  def getInfoSoftwareJSON(): Value = {
    ujson.read(
      requests.get(
        s"https://rest.ensembl.org/info/software",
        params = Map("content-type" -> "application/json")
      ).text
    )
  }

  /**
    * Lists all available species, their aliases, available adaptor groups and data release.
    * https://rest.ensembl.org/documentation/info/species
    * TODO: optional parameters division, hide_strain_info, strain_collection
    */
  def getInfoSpeciesJSON(division: String = "", hide_strain_info: Int = 0, strain_collection: String = ""): Value = {
    ujson.read(
      requests.get(
        s"https://rest.ensembl.org/species",
        params = Map("content-type" -> "application/json")
      ).text
    )
  }

  /**
    * List the variation sources used in Ensembl for a species.
    * https://rest.ensembl.org/documentation/info/variation
    * TODO: optional parameter filter
    */
  def getInfoVariationJSON(species: String, filter: String = ""): Value = {
    ujson.read(
      requests.get(
        s"https://rest.ensembl.org/info/variation/${species}",
        params = Map("content-type" -> "application/json")
      ).text
    )
  }

  /**
    * Lists all variant consequence types.
    * https://rest.ensembl.org/documentation/info/variation_consequence_types
    * TODO: check method's name
    */
  def getInfoVariationTypesJSON(): Value = {
    ujson.read(
      requests.get(
        s"https://rest.ensembl.org/variation_consequence_types",
        params = Map("content-type" -> "application/json")
      ).text
    )
  }

  /**
    * List all individuals for a population from a species.
    * https://rest.ensembl.org/documentation/info/variation_population_name
    * TODO: check method's name
    */
  def getInfoAllIndividualsJSON(species: String, population_name: String): Value = {
    ujson.read(
      requests.get(
        s"https://rest.ensembl.org/info/variation/populations/${species}/${population_name}",
        params = Map("content-type" -> "application/json")
      ).text
    )
  }

  /**
    * List all populations for a species.
    * https://rest.ensembl.org/documentation/info/variation_populations
    * TODO: optional parameter filter
    * TODO: check method's name
    */
  def getInfoAllPopulationsJSON(species: String, filter: String = ""): Value = {
    ujson.read(
      requests.get(
        s"https://rest.ensembl.org/info/variation/populations/${species}",
        params = Map("content-type" -> "application/json")
      ).text
    )
  }
}



/**
  * Linkage Disequilibrium
  */
trait EnsemblLinkageDisequilibrium {

  /**
    * Computes and returns LD values between the given variant and all other variants in a window centered
    * around the given variant. The window size is set to 500 kb.
    * https://rest.ensembl.org/documentation/info/ld_id_get
    * TODO: optional parameters attribs, d_prime, r2, window_size
    */
  def getldSpeciesPopulationJSON(species: String, id: String, population_name: String, attribs: Boolean = false,
                                 d_prime: Float = 0.0f, r2: Float = 0.0f, window_size: Int = 0): Value = {
    ujson.read(
      requests.get(
        s"https://rest.ensembl.org/ld/${species}/${id}/${population_name}",
        params = Map("content-type" -> "application/json")
      ).text
    )
  }

  /**
    * Computes and returns LD values between the given variants.
    * https://rest.ensembl.org/documentation/info/ld_pairwise_get
    * TODO: optional parameters d_prime, population_name, r2
    */
  def getIdSpeciesPairwiseJSON(species: String, id1: String, id2: String, d_prime: Float = 0.0f,
                               population_name: String = "", r2: Float = 0.0f): Value = {
    ujson.read(
      requests.get(
        s"https://rest.ensembl.org/ld/${species}/pairwise/${id1}/${id2}",
        params = Map("content-type" -> "application/json")
      ).text
    )
  }

  /**
    * Computes and returns LD values between all pairs of variants in the defined region.
    * https://rest.ensembl.org/documentation/info/ld_region_get
    * TODO: optional parameters d_prime, r2
    */
  def getIdSpeciesRegionJSON(species: String, region: String, population_name: String, d_prime: Float = 0.0f,
                             r2: Float = 0.0f): Value = {
    ujson.read(
      requests.get(
        s"https://rest.ensembl.org/ld/${species}/region/${region}/${population_name}",
        params = Map("content-type" -> "application/json")
      ).text
    )
  }

}



/**
  * Lookup
  */
trait EnsemblLookup {

  /**
    * Find the species and database for a single identifier e.g. gene, transcript, protein.
    * https://rest.ensembl.org/documentation/info/lookup
    * TODO: optional parameters db_type, expand, format, phenotypes, species, utr
    */
  def getLookupJSON(id: String, db_type: String = "", expand: Boolean = false, format: String = "",
                    phenotypes: Boolean = false, species: String = "", urt: Boolean = false): Value = {
    ujson.read(
      requests.get(
        s"https://rest.ensembl.org/lookup/id/${id}",
        params = Map("content-type" -> "application/json")
      ).text
    )
  }

  /**
    * Find the species and database for a symbol in a linked external database.
    * https://rest.ensembl.org/documentation/info/symbol_lookup
    * TODO: optional parameters expand, format
    */
  def getLookupSymbolJSON(species: String, symbol: String, expand: Boolean = false, format: String = ""): Value = {
    ujson.read(
      requests.get(
        s"https://rest.ensembl.org/lookup/symbol/${species}/${symbol}",
        params = Map("content-type" -> "application/json")
      ).text
    )
  }
}



/**
  * Mapping
  */
trait EnsemblMapping {

  /**
    * Convert from cDNA coordinates to genomic coordinates.
    * Output reflects forward orientation coordinates as returned from the Ensembl API.
    * https://rest.ensembl.org/documentation/info/assembly_cdna
    * TODO: optional parameters include_original_region, species
    */
  def getMapCdnaJSON(id: String, region: String, include_original_region: Boolean = false,
                     species: String = ""): Value = {
    ujson.read(
      requests.get(
        s"https://rest.ensembl.org/map/cdna/${id}/${region}",
        params = Map("content-type" -> "application/json")
      ).text
    )
  }

  /**
    * Convert from CDS coordinates to genomic coordinates.
    * Output reflects forward orientation coordinates as returned from the Ensembl API.
    * https://rest.ensembl.org/documentation/info/assembly_cds
    * TODO: optional parameters include_original_region, species
    */
  def getMapCdsJSON(id: String, region: String, include_original_region: Boolean = false,
                    species: String = ""): Value = {
    ujson.read(
      requests.get(
        s"https://rest.ensembl.org/map/cds/${id}/${region}",
        params = Map("content-type" -> "application/json")
      ).text
    )
  }

  /**
    * Convert the co-ordinates of one assembly to another.
    * https://rest.ensembl.org/documentation/info/assembly_map
    * TODO: optional parameters coord_system, target_coord_system
    * TODO: check method's name
    */
  def getMapConvertAsmJSON(species: String, asm_one: String, region: String, asm_two: String,
                           coord_system: String = "", target_coord_system: String = ""): Value = {
    ujson.read(
      requests.get(
        s"https://rest.ensembl.org/map/${species}/${asm_one}/${region}/${asm_two}",
        params = Map("content-type" -> "application/json")
      ).text
    )
  }

  /**
    * Convert from protein (translation) coordinates to genomic coordinates.
    * Output reflects forward orientation coordinates as returned from the Ensembl API.
    * https://rest.ensembl.org/documentation/info/assembly_translation
    * TODO: optional parameter species
    */
  def getMapTranslationJSON(id: String, region: String, species: String = ""): Value = {
    ujson.read(
      requests.get(
        s"https://rest.ensembl.org/map/translation/${id}/${region}",
        params = Map("content-type" -> "application/json")
      ).text
    )
  }
}



/**
  * Ontologies and Taxonomy
  */
trait EnsemblOntologies {

  /**
    * Reconstruct the entire ancestry of a term from is_a and part_of relationships
    * https://rest.ensembl.org/documentation/info/ontology_ancestors
    * TODO: optional parameter ontology
    */
  def getOntologyAncestorsJSON(id: String, ontology: String = ""): Value = {
    ujson.read(
      requests.get(
        s"https://rest.ensembl.org/ontology/ancestors/${id}",
        params = Map("content-type" -> "application/json")
      ).text
    )
  }

  /**
    * Reconstruct the entire ancestry of a term from is_a and part_of relationships
    * https://rest.ensembl.org/documentation/info/ontology_ancestors_chart
    * TODO: optional parameter ontology
    */
  def getOntologyAncestorsChartJSON(id: String, ontology: String = ""): Value = {
    ujson.read(
      requests.get(
        s"https://rest.ensembl.org/ontology/ancestors/chart/${id}",
        params = Map("content-type" -> "application/json")
      ).text
    )
  }

  /**
    * Find all the terms descended from a given term.
    * By default searches are conducted within the namespace of the given identifier.
    * https://rest.ensembl.org/documentation/info/ontology_descendants
    * TODO: optional parameters closest_term, ontology, subset, zero_distance
    */
  def getOntologyDescendantsJSON(id: String, closest_term: Boolean = false, ontology: String = "", subset: String = "",
                                 zero_distance: Boolean = false): Value = {
    ujson.read(
      requests.get(
        s"https://rest.ensembl.org/ontology/descendants/${id}",
        params = Map("content-type" -> "application/json")
      ).text
    )
  }

  /**
    * Search for an ontological term by its namespaced identifier.
    * https://rest.ensembl.org/documentation/info/ontology_id
    * TODO: optional parameters relation, simple
    */
  def getOntologyIdJSON(id: String, relation: String = "", simple: Boolean = false): Value = {
    ujson.read(
      requests.get(
        s"https://rest.ensembl.org/ontology/id/${id}",
        params = Map("content-type" -> "application/json")
      ).text
    )
  }

  /**
    * Search for a list of ontological terms by their name.
    * https://rest.ensembl.org/documentation/info/ontology_name
    * TODO: optional parameters ontology, relation, simple
    */
  def getOntologyNameJSON(name: String, ontology: String = "", relation: String = "",
                          simple: Boolean = false): Value = {
    ujson.read(
      requests.get(
        s"https://rest.ensembl.org/ontology/name/${name}",
        params = Map("content-type" -> "application/json")
      ).text
    )
  }

  /**
    * Return the taxonomic classification of a taxon node.
    * https://rest.ensembl.org/documentation/info/taxonomy_classification
    */
  def getTaxonomyClassificationJSON(id: String): Value = {
    ujson.read(
      requests.get(
        s"https://rest.ensembl.org/taxonomy/classification/${id}",
        params = Map("content-type" -> "application/json")
      ).text
    )
  }

  /**
    * Search for a taxonomic term by its identifier or name.
    * https://rest.ensembl.org/documentation/info/taxonomy_id
    * TODO: optional parameter simple
    */
  def getTaxonomyIdJSON(id: String, simple: Boolean = false): Value = {
    ujson.read(
      requests.get(
        s"https://rest.ensembl.org/taxonomy/id/${id}",
        params = Map("content-type" -> "application/json")
      ).text
    )
  }

  /**
    * Search for a taxonomic id by a non-scientific name.
    * https://rest.ensembl.org/documentation/info/taxonomy_name
    */
  def getTaxonomyNameJSON(name: String): Value = {
    ujson.read(
      requests.get(
        s"https://rest.ensembl.org/taxonomy/name/${name}",
        params = Map("content-type" -> "application/json")
      ).text
    )
  }
}



/**
  * Overlap
  */
trait EnsemblOverlap {

  /**
    * Retrieves features (e.g. genes, transcripts, variants and more) that overlap a region
    * defined by the given identifier.
    * https://rest.ensembl.org/documentation/info/overlap_id
    * TODO: optional parameters biotype, db_type, logic_name, misc_set, object_type, so_term, species, species_set,
    * variant_set
    * TODO: How to handle the required parameter "feature"?
    */
  def getOverlapIdJSON(id: String, feature: String = "", biotype: String = "", db_type: String = "",
                       logic_name: String = "", misc_set: String = "", object_type: String = "", so_term: String = "",
                       species: String = "", species_set: String = "", variant_set: String = ""): Value = {
    ujson.read(
      requests.get(
        s"https://rest.ensembl.org/overlap/id/${id}",
        params = Map("content-type" -> "application/json")
      ).text
    )
  }

  /**
    * Retrieves features (e.g. genes, transcripts, variants and more) that overlap a given region.
    * https://rest.ensembl.org/documentation/info/overlap_region
    * TODO: optional parameters biotype, db_type, logic_name, misc_set, so_term, species_set, trim_downstream,
    * trim_upstream, variant_set
    * TODO: How to handle the required parameter "feature"?
    */
  def getOverlapRegionJSON(species: String, region: String, feature: String = "", biotype: String = "",
                           db_type: String = "", logic_name: String = "", misc_set: String = "", so_term: String = "",
                           species_set: String = "", trim_downstream: Boolean = false, trim_upstream: Boolean = false,
                           variant_set: String = ""): Value = {
    ujson.read(
      requests.get(
        s"https://rest.ensembl.org/overlap/region/${species}/${region}",
        params = Map("content-type" -> "application/json")
      ).text
    )
  }

  /**
    * Retrieve features related to a specific Translation as described by its stable ID (e.g. domains, variants).
    * https://rest.ensembl.org/documentation/info/overlap_translation
    * TODO: optional parameters db_type, feature, so_term, species, type_data
    * TODO: parameter "type" was renamed to "type_data" due to compiler problem
    */
  def getOverlapTranslationJSON(id: String, db_type: String = "", feature: String = "", so_term: String = "",
                                species: String = "", type_data: String = ""): Value = {
    ujson.read(
      requests.get(
        s"https://rest.ensembl.org/overlap/translation/${id}",
        params = Map("content-type" -> "application/json")
      ).text
    )
  }
}



/**
  * Phenotype annotations
  */
trait EnsemblPhenotype{

  /**
    * Return phenotype annotations for genomic features given a phenotype ontology accession.
    * https://rest.ensembl.org/documentation/info/phenotype_accession
    * TODO: optional parameters include_children, include_pubmed_id, include_review_status, source
    */
  def getPhenotypeAccessionJSON(species: String, accession: String, include_children: Boolean = false,
                                include_pubmed_id: Boolean = false, include_review_status: Boolean = false,
                                source: String = ""): Value = {
    ujson.read(
      requests.get(
        s"https://rest.ensembl.org/phenotype/accession/${species}/${accession}",
        params = Map("content-type" -> "application/json")
      ).text
    )
  }

  /**
    * Return phenotype annotations for a given gene.
    * https://rest.ensembl.org/documentation/info/phenotype_gene
    * TODO: optional parameters include_associated, include_overlap_id, include_pubmed_id, include_review_status,
    * include_submitter
    */
  def getPhenotypeGeneJSON(species: String, gene: String, include_associated: Boolean = false,
                           include_overlap_id: Boolean = false, include_rpubmed_id: Boolean = false,
                           include_review_status: Boolean = false, include_submitter: Boolean = false): Value = {
    ujson.read(
      requests.get(
        s"https://rest.ensembl.org/phenotype/accession/${species}/${gene}",
        params = Map("content-type" -> "application/json")
      ).text
    )
  }

  /**
    * Return phenotype annotations that overlap a given genomic region.
    * https://rest.ensembl.org/documentation/info/phenotype_region
    * TODO: optional parameters feature_type, include_pubmed_id, include_review_status, include_submitter,
    * only_phenotypes
    */
  def getPhenotypeRegionJSON(species: String, region: String, feature_type: String = "",
                             include_pubmed_id: Boolean = false, include_review_status: Boolean = false,
                             include_submitter: Boolean = false, only_phenotypes: Boolean = false): Value = {
    ujson.read(
      requests.get(
        s"https://rest.ensembl.org/phenotype/region/${species}/${region}",
        params = Map("content-type" -> "application/json")
      ).text
    )
  }

  /**
    * Return phenotype annotations for genomic features given a phenotype ontology term.
    * https://rest.ensembl.org/documentation/info/phenotype_term
    * TODO: optional parameters include_children, include_pubmed_id, include_review_status, source
    */
  def getPhenotypeTermJSON(species: String, term: String, include_children: Boolean = false,
                           include_pubmed_id: Boolean = false, include_review_status: Boolean = false,
                           source: String = ""): Value = {
    ujson.read(
      requests.get(
        s"https://rest.ensembl.org/phenotype/term/${species}/${term}",
        params = Map("content-type" -> "application/json")
      ).text
    )
  }
}



/**
  * Regulation
  */
trait EnsemblRegulation {

  /**
    * Returns information about a specific microarray.
    * https://rest.ensembl.org/documentation/info/array
    */
  def getRegulatoryMicroarrayJSON(species: String, microarray: String, vendor: String): Value = {
    ujson.read(
      requests.get(
        s"https://rest.ensembl.org/regulatory/species/${species}/microarray/${microarray}/vendor/${vendor}",
        params = Map("content-type" -> "application/json")
      ).text
    )
  }

  /**
    * Returns information about all epigenomes available for the given species.
    * https://rest.ensembl.org/documentation/info/fetch_all_epigenomes
    */
  def getRegulatoryEpigenomeJSON(species: String): Value = {
    ujson.read(
      requests.get(
        s"https://rest.ensembl.org/regulatory/species/${species}/epigenome",
        params = Map("content-type" -> "application/json")
      ).text
    )
  }

  /**
    * Return the specified binding matrix.
    * https://rest.ensembl.org/documentation/info/get_binding_matrix
    * TODO: optional parameter unit
    */
  def getRegulatoryMatrixJSON(species: String, binding_matrix: String, unit: String = ""): Value = {
    ujson.read(
      requests.get(
        s"https://rest.ensembl.org/species/${species}/binding_matrix/${binding_matrix}",
        params = Map("content-type" -> "application/json")
      ).text
    )
  }

  /**
    * Returns information about all microarrays available for the given species
    * https://rest.ensembl.org/documentation/info/list_all_microarrays
    */
  def getRegulatoryMicroarrayAllJSON(species: String): Value = {
    ujson.read(
      requests.get(
        s"https://rest.ensembl.org/regulatory/species/${species}/microarray",
        params = Map("content-type" -> "application/json")
      ).text
    )
  }

  /**
    * Returns information about a specific probe from a microarray
    * https://rest.ensembl.org/documentation/info/probe
    * TODO: optional parameters gene, transcripts
    */
  def getRegulatoryProbeJSON(species: String, microarray: String, probe: String, gene: Boolean = false,
                             transcripts: Boolean = false): Value = {
    ujson.read(
      requests.get(
        s"https://rest.ensembl.org/regulatory/species/${species}/microarray/${microarray}/probe/${probe}",
        params = Map("content-type" -> "application/json")
      ).text
    )
  }

  /**
    * Returns information about a specific probe_set from a microarray.
    * https://rest.ensembl.org/documentation/info/probe_set
    * TODO: optional parameters gene, transcripts
    */
  def getRegulatoryProbeSetJSON(species: String, microarray: String, probe_set: String, gene: Boolean = false,
                                transcripts: Boolean = false): Value = {
    ujson.read(
      requests.get(
        s"https://rest.ensembl.org/regulatory/species/${species}/microarray/${microarray}/probe_set/${probe_set}",
        params = Map("content-type" -> "application/json")
      ).text
    )
  }

  /**
    * Returns a RegulatoryFeature given its stable ID (e.g. ENSR00000099113)
    * https://rest.ensembl.org/documentation/info/regulatory_id
    * TODO: optional parameter activity
    */
  def getRegulatoryFeatureJSON(species: String, id: String, activity: Boolean = false): Value = {
    ujson.read(
      requests.get(
        s"https://rest.ensembl.org/regulatory/species/${species}/id/${id}",
        params = Map("content-type" -> "application/json")
      ).text
    )
  }
}



/**
  * Sequence
  */
trait EnsemblSequence {

  /**
    * Request multiple types of sequence by stable identifier. Supports feature masking and expand options.
    * https://rest.ensembl.org/documentation/info/sequence_id
    * TODO: optional parameters db_type, end, expand_3prime, expand_5prime, format, mask, mask_feature,
    * multiple_sequences, object_type, species, start, type_sequence
    * TODO: parameter "type" was renamed to "type_sequence" due to compiler problem
    */
  def getSequenceIdJSON(id: String, db_type: String = "", end: Int = 0, expand_3prime: Int = 0, expand_5prime: Int = 0,
                        format: String = "", mask: String = "", mask_feature: Boolean = false,
                        multiple_sequences: Boolean = false, object_type: String = "", species: String = "",
                        start: Int = 0, type_sequence: String = ""): Value = {
    ujson.read(
      requests.get(
        s"https://rest.ensembl.org/sequence/id/${id}",
        params = Map("content-type" -> "application/json")
      ).text
    )
  }

  /**
    * Returns the genomic sequence of the specified region of the given species.
    * Supports feature masking and expand options.
    * https://rest.ensembl.org/documentation/info/sequence_region
    * TODO: optional parameters coord_system, coord_system_version, expand_3prime, expand_5prime, format, mask,
    * mask_feature
    */
  def getSequenceRegionJSON(species: String, region: String, coord_system: String = "",
                            coord_system_version: String = "", expand_3prime: Int = 0, expand_5prime: Int = 0,
                            format: String = "", mask: String = "", mask_feature: Boolean = false): Value = {
    ujson.read(
      requests.get(
        s"https://rest.ensembl.org/sequence/region/${species}/${region}",
        params = Map("content-type" -> "application/json")
      ).text
    )
  }
}



/**
  * Transcript Haplotypes
  */
trait EnsemblHaplotypes {

  /**
    * Computes observed transcript haplotype sequences based on phased genotype data.
    * https://rest.ensembl.org/documentation/info/info/transcript_haplotypes_get
    * TODO: optional parameters aligned_sequences, callback, samples, sequence
    */
  def getHaplotypesJSON(species: String, id: String, aligned_sequences: Boolean = false, callback: String = "",
                        samples: Boolean = false, sequence: Boolean = false): Value = {
    ujson.read(
      requests.get(
        s"https://rest.ensembl.org/transcript_haplotypes/${species}/${id}",
        params = Map("content-type" -> "application/json")
      ).text
    )
  }
}



/**
  * VEP
  */
trait EnsemblVEP {

  /**
    * Fetch variant consequences based on a HGVS notation.
    * https://rest.ensembl.org/documentation/info/vep_hgvs_get
    * TODO: optional parameters Blosum62, CSN, Conservation, GeneSplicer, MaxEntScan, appris, canonical, ccds, dbNSFP,
    * dbscSNV, distance, domains, failed, hgvs, merged, miRNA, minimal, numbers, protein, refseq, transcript_id,
    * tsl, uniprot, variant_class, xref_refseq
    */
  def getVepHgvsJSON(species: String, hgvs_notation: String, Blosum62: Boolean = false, CSN: Boolean = false,
                     Conservation: Boolean = false, GeneSplicer: Boolean = false, MaxEntScan: Boolean = false,
                     appris: Boolean = false, canonical: Boolean = false, ccds: Boolean = false,
                     dbNSFP: String = "", dbscSNV: Boolean = false, distance: Integer = 5000, domains: Boolean = false,
                     failed: Boolean = false, hgvs: Boolean = false, merged: Boolean = false, miRNA: Boolean = false,
                     minimal: Boolean = false, numbers: Boolean = false, protein: Boolean = false,
                     refseq: Boolean = false, transcript_id: String = "", tsl: Boolean = false, uniprot: Boolean = false,
                     variant_class: Boolean = false, xref_refseq: Boolean = false): Value = {
    ujson.read(
      requests.get(
        s"https://rest.ensembl.org/vep/${species}/hgvs/${hgvs_notation}",
        params = Map("content-type" -> "application/json")
      ).text
    )
  }

  /**
    * Fetch variant consequences based on a variant identifier.
    * https://rest.ensembl.org/documentation/info/vep_id_get
    * TODO: optional parameters Blosum62, CSN, Conservation, GeneSplicer, MaxEntScan, appris, canonical, ccds, dbNSFP,
    * dbscSNV, distance, domains, failed, hgvs, merged, miRNA, minimal, numbers, protein, refseq, transcript_id,
    * tsl, uniprot, variant_class, xref_refseq
    */
  def getVepIdJSON(species: String, id: String, Blosum62: Boolean = false, CSN: Boolean = false,
                   Conservation: Boolean = false, GeneSplicer: Boolean = false, MaxEntScan: Boolean = false,
                   appris: Boolean = false, canonical: Boolean = false, ccds: Boolean = false,
                   dbNSFP: String = "", dbscSNV: Boolean = false, distance: Integer = 5000, domains: Boolean = false,
                   failed: Boolean = false, hgvs: Boolean = false, merged: Boolean = false, miRNA: Boolean = false,
                   minimal: Boolean = false, numbers: Boolean = false, protein: Boolean = false,
                   refseq: Boolean = false, transcript_id: String = "", tsl: Boolean = false, uniprot: Boolean = false,
                   variant_class: Boolean = false, xref_refseq: Boolean = false): Value = {
    ujson.read(
      requests.get(
        s"https://rest.ensembl.org/vep/${species}/id/${id}",
        params = Map("content-type" -> "application/json")
      ).text
    )
  }

  /**
    * Fetch variant consequences.
    * https://rest.ensembl.org/documentation/info/vep_region_get
    * TODO: optional parameters Blosum62, CSN, Conservation, GeneSplicer, MaxEntScan, appris, canonical, ccds, dbNSFP,
    * dbscSNV, distance, domains, failed, hgvs, merged, miRNA, minimal, numbers, protein, refseq, transcript_id,
    * tsl, uniprot, variant_class, xref_refseq
    */
  def getVepRegionJSON(species: String, region: String, allele: String, Blosum62: Boolean = false, CSN: Boolean = false,
                       Conservation: Boolean = false, GeneSplicer: Boolean = false, MaxEntScan: Boolean = false,
                       appris: Boolean = false, canonical: Boolean = false, ccds: Boolean = false,
                       dbNSFP: String = "", dbscSNV: Boolean = false, distance: Integer = 5000, domains: Boolean = false,
                       failed: Boolean = false, hgvs: Boolean = false, merged: Boolean = false, miRNA: Boolean = false,
                       minimal: Boolean = false, numbers: Boolean = false, protein: Boolean = false,
                       refseq: Boolean = false, transcript_id: String = "", tsl: Boolean = false, uniprot: Boolean = false,
                       variant_class: Boolean = false, xref_refseq: Boolean = false): Value = {
    ujson.read(
      requests.get(
        s"https://rest.ensembl.org/vep/${species}/region/${region}/${allele}",
        params = Map("content-type" -> "application/json")
      ).text
    )
  }
}



/**
  * Variation
  */
trait EnsemblVariation {

  /**
    * Translate a variant identifier or HGVS notation to all possible variant IDs and HGVS.
    * https://rest.ensembl.org/documentation/info/variant_recoder
    * TODO: optional parameter fields
    */
  def getVariantRecoderJSON(species: String, id: String, fields: String = ""): Value = {
    ujson.read(
      requests.get(
        s"https://rest.ensembl.org/variant_recoder/${species}/${id}",
        params = Map("content-type" -> "application/json")
      ).text
    )
  }

  /**
    * Uses a variant identifier (e.g. rsID) to return the variation features including optional genotype,
    * phenotype and population data.
    * https://rest.ensembl.org/documentation/info/variation_id, genotyping_chips, phenotypes, pops, population_genotypes
    * TODO: optional parameters genotypes
    */
  def getVariationJSON(species: String, id: String, genotypes: Boolean = false, genotyping_chips: Boolean = false,
                       phenotypes: Boolean = false, pops: Boolean = false,
                       population_genotypes: Boolean = false): Value = {
    ujson.read(
      requests.get(
        s"https://rest.ensembl.org/variation/${species}/${id}",
        params = Map("content-type" -> "application/json")
      ).text
    )
  }

  /**
    * Fetch variants by publication using PubMed Central reference number (PMCID).
    * https://rest.ensembl.org/documentation/info/variation_pmcid_get
    */
  def getVariationPmcidJSON(species: String, pmcid: String): Value = {
    ujson.read(
      requests.get(
        s"https://rest.ensembl.org/variation/${species}/pmcid/${pmcid}",
        params = Map("content-type" -> "application/json")
      ).text
    )
  }

  /**
    * Fetch variants by publication using PubMed reference number (PMID).
    * https://rest.ensembl.org/documentation/info/variation_pmid_get
    */
  def getVariationPmidJSON(species: String, pmid: String): Value = {
    ujson.read(
      requests.get(
        s"https://rest.ensembl.org/variation/${species}/pmid/${pmid}",
        params = Map("content-type" -> "application/json")
      ).text
    )
  }
}



/**
  * Variation GA4GH
  */
trait EnsemblGA4GH {

  /**
    * Return Beacon information.
    * https://rest.ensembl.org/documentation/info/beacon_get
    */
  def getGa4ghBeaconJSON(): Value = {
    ujson.read(
      requests.get(
        s"https://rest.ensembl.org/ga4gh/beacon",
        params = Map("content-type" -> "application/json")
      ).text
    )
  }

  /**
    * Return the Beacon response for allele information.
    * https://rest.ensembl.org/documentation/info/beacon_query_get
    * TODO: mandatory parameters (they are not directly used in query) alternateBases, assemblyId, referenceBases,
    * referenceName, start
    * TODO: optional parameters datasetIds, includeDatasetResponses
    */
  def getGa4ghBeaconQueryJSON(alternateBases: String, assemblyId: String, referenceBases: String, referenceName: String,
                              start: Int, datasetIds: Array[String] = null,
                              includeDatasetResponses: Boolean = false): Value = {
    ujson.read(
      requests.get(
        s"https://rest.ensembl.org/ga4gh/beacon/query",
        params = Map("content-type" -> "application/json")
      ).text
    )
  }

  /**
    * Return the GA4GH record for a specific sequence feature given its identifier.
    * https://rest.ensembl.org/documentation/info/features_id
    */
  def getGa4ghFeaturesJSON(id: String): Value = {
    ujson.read(
      requests.get(
        s"https://rest.ensembl.org/ga4gh/features/${id}",
        params = Map("content-type" -> "application/json")
      ).text
    )
  }

  /**
    * Return the GA4GH record for a specific CallSet given its identifier.
    * https://rest.ensembl.org/documentation/info/gacallset_id
    */
  def getGa4ghCallSetsJSON(id: String): Value = {
    ujson.read(
      requests.get(
        s"https://rest.ensembl.org/ga4gh/callsets/${id}",
        params = Map("content-type" -> "application/json")
      ).text
    )
  }

  /**
    * Return the GA4GH record for a specific dataset given its identifier.
    * https://rest.ensembl.org/documentation/info/gadataset_id
    */
  def getGa4ghDataSetsJSON(id: String): Value = {
    ujson.read(
      requests.get(
        s"https://rest.ensembl.org/ga4gh/datasets/${id}",
        params = Map("content-type" -> "application/json")
      ).text
    )
  }

  /**
    * Return the GA4GH record for a specific featureSet given its identifier.
    * https://rest.ensembl.org/documentation/info/gafeatureset_id
    */
  def getGa4ghFeatureSetsJSON(id: String): Value = {
    ujson.read(
      requests.get(
        s"https://rest.ensembl.org/ga4gh/featuresets/${id}",
        params = Map("content-type" -> "application/json")
      ).text
    )
  }

  /**
    * Return the GA4GH record for a specific variant given its identifier.
    * https://rest.ensembl.org/documentation/info/gavariant_id
    */
  def getGa4ghVariantsJSON(id: String): Value = {
    ujson.read(
      requests.get(
        s"https://rest.ensembl.org/ga4gh/variants/${id}",
        params = Map("content-type" -> "application/json")
      ).text
    )
  }

  /**
    * Return the GA4GH record for a specific VariantSet given its identifier.
    * https://rest.ensembl.org/documentation/info/gavariantset_id
    */
  def getGa4ghVariantSetsJSON(id: String): Value = {
    ujson.read(
      requests.get(
        s"https://rest.ensembl.org/ga4gh/variantsets/${id}",
        params = Map("content-type" -> "application/json")
      ).text
    )
  }

  /**
    * Return data for a specific reference in GA4GH format by id.
    * https://rest.ensembl.org/documentation/info/references_id
    */
  def getGa4ghReferencesJSON(id: String): Value = {
    ujson.read(
      requests.get(
        s"https://rest.ensembl.org/ga4gh/references/${id}",
        params = Map("content-type" -> "application/json")
      ).text
    )
  }

  /**
    * Return data for a specific reference set in GA4GH format.
    * https://rest.ensembl.org/documentation/info/referenceSets_id
    */
  def getGa4ghReferenceSetsJSON(id: String): Value = {
    ujson.read(
      requests.get(
        s"https://rest.ensembl.org/ga4gh/referencesets/${id}",
        params = Map("content-type" -> "application/json")
      ).text
    )
  }

  /**
    * Return meta data for a specific annotation set in GA4GH format.
    * https://rest.ensembl.org/documentation/info/VariantAnnotationSet_id
    */
  def getGa4ghVariantAnnotationSetsJSON(id: String): Value = {
    ujson.read(
      requests.get(
        s"https://rest.ensembl.org/ga4gh/variantannotationsets/${id}",
        params = Map("content-type" -> "application/json")
      ).text
    )
  }
}