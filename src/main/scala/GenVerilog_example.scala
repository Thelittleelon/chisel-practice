import chisel3._


object GenVerilog extends App {
  println("--- Start generating Verilog ---")


  val verilogString = getVerilogString(new Counter4Bit())
  // println(verilogString)

  // Export files
  emitVerilog(
    new RunInside.multiplexer(), 
    Array("--target-dir", "generated") // Output directory
  )
  
  println("--- Successfully exported Verilog file into the folder 'generated' ---")
}