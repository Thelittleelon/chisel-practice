error id: file://<WORKSPACE>/src/main/scala/comb_logic_example.scala:`<none>`.
file://<WORKSPACE>/src/main/scala/comb_logic_example.scala
empty definition using pc, found symbol in pc: `<none>`.
empty definition using semanticdb
empty definition using fallback
non-local guesses:
	 -chisel3.
	 -chisel3#
	 -chisel3().
	 -scala/Predef.
	 -scala/Predef#
	 -scala/Predef().
offset: 882
uri: file://<WORKSPACE>/src/main/scala/comb_logic_example.scala
text:
```scala
import chisel3._

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

  class MyOperators extends Module {
    val io = IO(new Bundle {
      val in = Input(UInt(4.@@W))
      val out_add = Output(UInt(4.W))      
      val out_sub = Output(UInt(4.W))
      val out_mul = Output(UInt(4.W))
    })

    io.out_add := 1.U + 4.U
    io.out_sub := 2.U - 1.U 
    io.out_mul := 4.U * 2.U 
  }

  // --- Main Execution Logic ---
  println("--- Elaboration Started ---")
  
  // Convert the Chisel module to Verilog string to trigger elaboration
  // We can instantiate MyModule directly because we are inside the same scope
  val verilog = getVerilogString(new MyOperators)
  
  println(verilog)
  println("--- Elaboration Finished ---")
}
```


#### Short summary: 

empty definition using pc, found symbol in pc: `<none>`.