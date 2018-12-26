import ensembl.client._

val EnsemblClient = new EnsemblClient()

// Archive
val testArchive = EnsemblClient.getArchiveJSON("ENSG00000157764")

// Comparative Genomics
val testCafeTree = EnsemblClient.getCafeTreeJSON("ENSGT00390000003602")
val testCafeTreeMember = EnsemblClient.getCafeTreeMemberJSON("ENSG00000167664")
val testCafeTreeMemberSymbol = EnsemblClient.getCafeTreeMemberSymbolJSON("homo_sapiens", "BRCA2")
val testFamily = EnsemblClient.getFamilyJSON("PTHR15573")
val testFamilyMember = EnsemblClient.getFamilyMemberJSON("ENSG00000167664")
val testFamilyMemberSymbol = EnsemblClient.getFamilyMemberSymbolJSON("homo_sapiens", "BRCA2")
val testTree = EnsemblClient.getTreeJSON("ENSGT00390000003602")
val testTreeMember = EnsemblClient.getTreeMemberJSON("ENSG00000167664")
val testTreeMemberSymbol = EnsemblClient.getTreeMemberSymbolJSON("homo_sapiens", "BRCA2")
val testAlignmentRegion = EnsemblClient.getAlignmentRegionJSON("homo_sapiens", "X:1000000..1000100:1")
val testHomology = EnsemblClient.getHomologyJSON("ENSG00000157764")
val testHomologySymbol = EnsemblClient.getHomologySymbolJSON("homo_sapiens", "BRCA2")

// Cross References
val testRefSymbol = EnsemblClient.getRefSymbolJSON("homo_sapiens", "BRCA2")
val testRef = EnsemblClient.getRefJSON("ENSG00000157764")
val testRefName = EnsemblClient.getRefNameJSON("homo_sapiens", "BRCA2")

// EQTL
val testEqtlId = EnsemblClient.getEqtlIdJSON("homo_sapiens", "ENSG00000122435")
val testEqtlName = EnsemblClient.getEqtlNameJSON("homo_sapiens", "rs123")
val testEqtlTissue0 = EnsemblClient.getEqtlTissueJSON()
val testEqtlTissue1 = EnsemblClient.getEqtlTissueJSON("homo_sapiens")

// Information
val testInfoAnalysis = EnsemblClient.getInfoAnalysisJSON("homo_sapiens")
val testInfoAssembly = EnsemblClient.getInfoAssemblyJSON("homo_sapiens")
val testInfoAssemblyRegion = EnsemblClient.getInfoAssemblyRegionJSON("homo_sapiens", "X")
val testInfoBiotypes = EnsemblClient.getInfoBiotypesJSON("homo_sapiens")
val testInfoBiotypes0 = EnsemblClient.getInfoBiotypesGroupObjectJSON()
val testInfoBiotypes1a = EnsemblClient.getInfoBiotypesGroupObjectJSON(group = "coding")
val testInfoBiotypes1b = EnsemblClient.getInfoBiotypesGroupObjectJSON(object_type = "gene")
val testInfoBiotypes2 = EnsemblClient.getInfoBiotypesGroupObjectJSON(group = "coding", object_type = "gene")
val testInfoBiotypesName = EnsemblClient.getInfoBiotypesNameJSON("CRISPR")
val testInfoCompara = EnsemblClient.getInfoComparaMethodsJSON()
val testInfoCompareSpecies = EnsemblClient.getInfoCompareSpeciesJSON("EPO")
val testInfoComparas = EnsemblClient.getInfoComparasJSON()
val testInfoData = EnsemblClient.getInfoDataJSON()
val testInfoExternalDbs = EnsemblClient.getInfoExternalDbsJSON("homo_sapiens")
val testInfoPing = EnsemblClient.getInfoPingJSON()
val testInfoRest = EnsemblClient.getInfoRestJSON()
val testInfoSoftware = EnsemblClient.getInfoSoftwareJSON()
val testInfoSpecies = EnsemblClient.getInfoSpeciesJSON()
val testInfoVariation = EnsemblClient.getInfoVariationJSON("homo_sapiens")
val testInfoVariationTypes = EnsemblClient.getInfoVariationTypesJSON()
val testInfoAllIndividuals = EnsemblClient.getInfoAllIndividualsJSON("human", "1000GENOMES:phase_3:ASW")
val testInfoAllPopulations = EnsemblClient.getInfoAllPopulationsJSON("homo_sapiens")

// Linkage Disequilibrium
val testldSpeciesPopulation = EnsemblClient.getldSpeciesPopulationJSON("homo_sapiens", "rs56116432", "1000GENOMES:phase_3:KHV")
val testIdSpeciesPairwise = EnsemblClient.getIdSpeciesPairwiseJSON("homo_sapiens", "rs6792369", "rs1042779")
val testIdSpeciesRegion = EnsemblClient.getIdSpeciesRegionJSON("homo_sapiens", "6:25837556..25843455", "1000GENOMES:phase_3:KHV")

// Lookup
val testLookup = EnsemblClient.getLookupJSON("ENSG00000157764")
val testLookupSymbol = EnsemblClient.getLookupSymbolJSON("homo_sapiens", "BRCA2")

// Mapping
val testMapCdna = EnsemblClient.getMapCdnaJSON("ENST00000288602", "100..300")
val testMapCds = EnsemblClient.getMapCdsJSON("ENST00000288602", "1..1000")
val testMapConvertAsm = EnsemblClient.getMapConvertAsmJSON("homo_sapiens", "GRCh37", "X:1000000..1000100:1", "GRCh38")
val testMapTranslation = EnsemblClient.getMapTranslationJSON("ENSP00000288602", "100..300")


// Ontologies and Taxonomy
val testOntologyAncestors = EnsemblClient.getOntologyAncestorsJSON("GO:0005667")
val testOntologyAncestorsChart = EnsemblClient.getOntologyAncestorsChartJSON("GO:0005667")
val testOntologyDescendants = EnsemblClient.getOntologyDescendantsJSON("GO:0005667")
val testOntologyId = EnsemblClient.getOntologyIdJSON("GO:0005667")
//val testOntologyName = EnsemblClient.getOntologyNameJSON("transcription factor complex")
//val testTaxonomyClassification = EnsemblClient.getTaxonomyClassificationJSON("Homo sapiens")
//val testTaxonomyId = EnsemblClient.getTaxonomyIdJSON("Homo sapiens")
val testTaxonomy = EnsemblClient.getTaxonomyNameJSON("Homo%25")

// Overlap
val testOverlapId = EnsemblClient.getOverlapIdJSON("ENSG00000157764", "-")
val testOverlapRegion = EnsemblClient.getOverlapRegionJSON("homo_sapiens", "X:1..1000:1", "-")
val testOverlapTranslation = EnsemblClient.getOverlapTranslationJSON("ENSP00000288602")

// Phenotype annotations
val testPhenotypeAccession = EnsemblClient.getPhenotypeAccessionJSON("homo_sapiens", "EFO:0003900")
val testPhenotypeGene = EnsemblClient.getPhenotypeGeneJSON("homo_sapiens", "ENSG00000157764")
val testPhenotypeRegion = EnsemblClient.getPhenotypeRegionJSON("homo_sapiens", "9:22125500-22136000:1")
//val testPhenotypeTerm = EnsemblClient.getPhenotypeTermJSON("homo_sapiens", "coffee consumption")

// Regulation
val testRegulatoryMicroarray = EnsemblClient.getRegulatoryMicroarrayJSON("homo_sapiens", "HumanWG_6_V2", "ILMN_1763508")
val testRegulatoryEpigenome = EnsemblClient.getRegulatoryEpigenomeJSON("homo_sapiens")
val testRegulatoryMatrix = EnsemblClient.getRegulatoryMatrixJSON("homo_sapiens", "ENSPFM0001")
val testRegulatoryMicroarrayAll = EnsemblClient.getRegulatoryMicroarrayAllJSON("homo_sapiens")
val testRegulatoryProbe = EnsemblClient.getRegulatoryProbeJSON("homo_sapiens", "HumanWG_6_V2", "ILMN_1763508")
val testRegulatoryProbeSet = EnsemblClient.getRegulatoryProbeSetJSON("homo_sapiens", "HG-U133_Plus_2", "202820_at")
val testRegulatoryFeature = EnsemblClient.getRegulatoryFeatureJSON("homo_sapiens", "ENSR00000099113")

// Sequence
val testSequenceId = EnsemblClient.getSequenceIdJSON("ENSG00000157764")
val testSequenceRegion = EnsemblClient.getSequenceRegionJSON("homo_sapiens", "X:1000000..1000100:1")

// Transcript Haplotypes
val testHaplotypes = EnsemblClient.getHaplotypesJSON("homo_sapiens", "ENST00000288602")

// VEP
val testVepHgvs = EnsemblClient.getVepHgvsJSON("homo_sapiens", "AGT:c.803T>C")
val testVepId = EnsemblClient.getVepIdJSON("homo_sapiens", "rs56116432")
//val testVepRegion = EnsemblClient.getVepRegionJSON("homo_sapiens", "9:22125503-22125502:1", " C")

// Variation
val testVariantRecoder = EnsemblClient.getVariantRecoderJSON("homo_sapiens", "rs56116432")
val testVariation = EnsemblClient.getVariationJSON("homo_sapiens", "rs56116432")
val testVariationPmcid = EnsemblClient.getVariationPmcidJSON("homo_sapiens", "PMC5002951")
val testVariationPmid = EnsemblClient.getVariationPmidJSON("homo_sapiens", "26318936")

// Variation GA4GH
val testGa4ghBeacon = EnsemblClient.getGa4ghBeaconJSON()
val testGa4ghBeaconQuery = EnsemblClient.getGa4ghBeaconQueryJSON("C", "GRCh38", "G", "9", 22125503)
val testGa4ghFeatures = EnsemblClient.getGa4ghFeaturesJSON("ENST00000381657.7")
val testGa4ghCallSets = EnsemblClient.getGa4ghCallSetsJSON("1")
val testGa4ghDataSets = EnsemblClient.getGa4ghDataSetsJSON("6e340c4d1e333c7a676b1710d2e3953c")
val testGa4ghFeatureSets = EnsemblClient.getGa4ghFeatureSetsJSON("Ensembl")
val testGa4ghVariants = EnsemblClient.getGa4ghVariantsJSON("1:rs1333049")
val testGa4ghVariantSets = EnsemblClient.getGa4ghVariantSetsJSON("1")
val testGa4ghReferences = EnsemblClient.getGa4ghReferencesJSON("9489ae7581e14efcad134f02afafe26c")
val testGa4ghReferenceSets = EnsemblClient.getGa4ghReferenceSetsJSON("GRCh38")
val testGa4ghVariantAnnotationSets = EnsemblClient.getGa4ghVariantAnnotationSetsJSON("Ensembl")