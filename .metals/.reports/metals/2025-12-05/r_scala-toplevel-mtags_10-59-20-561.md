error id: file://<WORKSPACE>/src/main/scala/comb_logic_example.scala:[797..804) in Input.VirtualFile("file://<WORKSPACE>/src/main/scala/comb_logic_example.scala", "import chisel3._

// The Object containing both the hardware definition and the execution logic
object RunInside extends App {

  // --- Hardware Definition (Nested Class) ---
  class MyModule extends Module {
    val io = IO(new Bundle {
      val in  = Input(UInt(4.W))
      val out = Output(UInt(4.W))
    })

    // Scala Logic: This executes immediately during circuit elaboration
    val two = 1 + 1
    println(s"[Scala Print] 1 + 1 = $two")

    // Chisel Logic: This constructs the hardware graph (nodes and wires)
    // It does NOT calculate the result '2' right now.
    val utwo = 1.U + 1.U
    println(s"[Chisel Print] 1.U + 1.U = $utwo") 
    // Output will be something like "UInt<2>(OpResult)", not the number 2.

    // Connect input to output
    io.out := io.in
  }

  class  extends Module {
    val io = IO(new Bundle {
      val in = Input(UInt(1.W))
      val out_true = Output(UInt(4.W))
      val out_false = Output(UInt(4.W))
    })

  }

  // --- Main Execution Logic ---
  println("--- Elaboration Started ---")
  
  // Convert the Chisel module to Verilog string to trigger elaboration
  // We can instantiate MyModule directly because we are inside the same scope
  val verilog = getVerilogString(new MyOperators)
  
  println(verilog)
  println("--- Elaboration Finished ---")
}")
file://<WORKSPACE>/file:<WORKSPACE>/src/main/scala/comb_logic_example.scala
file://<WORKSPACE>/src/main/scala/comb_logic_example.scala:27: error: expected identifier; obtained extends


Current stack trace:
java.base/java.lang.Thread.getStackTrace(Thread.java:1619)
scala.meta.internal.mtags.ScalaToplevelMtags.failMessage(ScalaToplevelMtags.scala:1206)
scala.meta.internal.mtags.ScalaToplevelMtags.$anonfun$reportError$1(ScalaToplevelMtags.scala:1192)
scala.meta.internal.metals.StdReporter.$anonfun$create$1(ReportContext.scala:148)
scala.util.Try$.apply(Try.scala:217)
scala.meta.internal.metals.StdReporter.create(ReportContext.scala:143)
scala.meta.pc.reports.Reporter.create(Reporter.java:10)
scala.meta.internal.mtags.ScalaToplevelMtags.reportError(ScalaToplevelMtags.scala:1189)
scala.meta.internal.mtags.ScalaToplevelMtags.newIdentifier(ScalaToplevelMtags.scala:1095)
scala.meta.internal.mtags.ScalaToplevelMtags.emitMember(ScalaToplevelMtags.scala:782)
scala.meta.internal.mtags.ScalaToplevelMtags.loop(ScalaToplevelMtags.scala:263)
scala.meta.internal.mtags.ScalaToplevelMtags.indexRoot(ScalaToplevelMtags.scala:96)
scala.meta.internal.metals.SemanticdbDefinition$.foreachWithReturnMtags(SemanticdbDefinition.scala:83)
scala.meta.internal.metals.Indexer.indexSourceFile(Indexer.scala:546)
scala.meta.internal.metals.Indexer.$anonfun$reindexWorkspaceSources$3(Indexer.scala:677)
scala.meta.internal.metals.Indexer.$anonfun$reindexWorkspaceSources$3$adapted(Indexer.scala:674)
scala.collection.IterableOnceOps.foreach(IterableOnce.scala:630)
scala.collection.IterableOnceOps.foreach$(IterableOnce.scala:628)
scala.collection.AbstractIterator.foreach(Iterator.scala:1313)
scala.meta.internal.metals.Indexer.reindexWorkspaceSources(Indexer.scala:674)
scala.meta.internal.metals.MetalsLspService.$anonfun$onChange$2(MetalsLspService.scala:912)
scala.runtime.java8.JFunction0$mcV$sp.apply(JFunction0$mcV$sp.scala:18)
scala.concurrent.Future$.$anonfun$apply$1(Future.scala:691)
scala.concurrent.impl.Promise$Transformation.run(Promise.scala:500)
java.base/java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1136)
java.base/java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:635)
java.base/java.lang.Thread.run(Thread.java:840)

  class  extends Module {
         ^
#### Short summary: 

expected identifier; obtained extends