import ensembl.client._

val testArchive = EnsemblClient.getArchiveJSON("ENSG00000157764")
val testTree = EnsemblClient.getCafeTreeJSON("ENSGT00390000003602")