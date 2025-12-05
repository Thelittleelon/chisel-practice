import chisel3._

// The Object containing both the hardware definition and the execution logic
object RunInside extends App {

  // --- Hardware Definition (Nested Class) ---
  // class MyModule extends Module {
  //   val io = IO(new Bundle {
  //     val in  = Input(UInt(4.W))
  //     val out = Output(UInt(4.W))
  //   })

  //   // Scala Logic: This executes immediately during circuit elaboration
  //   val two = 1 + 1
  //   println(s"[Scala Print] 1 + 1 = $two")

  //   // Chisel Logic: This constructs the hardware graph (nodes and wires)
  //   // It does NOT calculate the result '2' right now.
  //   val utwo = 1.U + 1.U
  //   println(s"[Chisel Print] 1.U + 1.U = $utwo") 
  //   // Output will be something like "UInt<2>(OpResult)", not the number 2.

  //   // Connect input to output
  //   io.out := io.in
  // }

  class multiplexer extends Module {
    val io = IO(new Bundle {
      val in = Input(Bool())
      val out_mux = Output(UInt(4.W))
    })

    // val s = true.B
    io.out_mux := Mux(io.in, 3.U, 0.U)
  }

  // --- Main Execution Logic ---
  println("--- Elaboration Started ---")
  
  // Convert the Chisel module to Verilog string to trigger elaboration
  // We can instantiate MyModule directly because we are inside the same scope
  val verilog = getVerilogString(new multiplexer())
  
  println(verilog)
  println("--- Elaboration Finished ---")
}