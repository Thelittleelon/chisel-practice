import chisel3._


object GenVerilog extends App {
  println("--- Start generating Verilog ---")


  val verilogString = getVerilogString(new Counter4Bit())
  // println(verilogString)

  // Export files
  // Hàm emitVerilog thay thế cho ChiselStage.emitSystemVerilogFile cũ
  emitVerilog(
    new RunInside.multiplexer(), 
    Array("--target-dir", "generated") // Output directory
  )
  
  println("--- Successfully exported Verilog file into the folder 'generated' ---")
}