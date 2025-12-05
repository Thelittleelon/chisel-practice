error id: file://<WORKSPACE>/src/test/scala/MyModule_test_trial.scala:`<none>`.
file://<WORKSPACE>/src/test/scala/MyModule_test_trial.scala
empty definition using pc, found symbol in pc: `<none>`.
empty definition using semanticdb
empty definition using fallback
non-local guesses:
	 -chisel3/chisel3/simulator/EphemeralSimulator.
	 -chisel3/simulator/EphemeralSimulator.chisel3.simulator.EphemeralSimulator.
	 -chisel3/simulator/EphemeralSimulator.
	 -scala/Predef.chisel3.simulator.EphemeralSimulator.
offset: 128
uri: file://<WORKSPACE>/src/test/scala/MyModule_test_trial.scala
text:
```scala
import chisel3._
// Important: Import EphemeralSimulator to run simulation in a standalone app
import chisel3.simulator.Ephemera@@lSimulator._ 

object RunMyOperators extends App {

  // --- 1. Hardware Definition (Module) ---
//   class MyOperators extends Module {
//     val io = IO(new Bundle {
//       // Inputs (Hardcoded for this example to match your expectations)
//       val in_a = Input(UInt(4.W))
//       val in_b = Input(UInt(4.W))
      
//       // Outputs
//       val out_add = Output(UInt(4.W))
//       val out_sub = Output(UInt(4.W))
//       val out_mul = Output(UInt(4.W))
//     })

//     // Simple arithmetic logic
//     io.out_add := io.in_a + io.in_b
//     io.out_sub := io.in_a - io.in_b
//     io.out_mul := io.in_a * io.in_b
//   }

//   println("--- Simulation Started ---")

  // --- 2. Simulation Logic ---
  // We use 'simulate' directly here. No need for 'test("...")' wrapper.
  simulate(new MyOperators) { c =>
    
    // Set inputs (Example values to get result 5, 1, 8)
    // Let's assume a = 3, b = 2 for add/sub, but mul needs 4*2
    // Since inputs change, let's test step by step.

    // Case 1: Testing Addition (2 + 3 = 5)
    c.io.in_a.poke(2.U)
    c.io.in_b.poke(3.U)
    c.clock.step() // Advance time
    c.io.out_add.expect(5.U)
    println("[PASS] Addition check: 2 + 3 = 5")

    // Case 2: Testing Subtraction (3 - 2 = 1)
    c.io.in_a.poke(3.U)
    c.io.in_b.poke(2.U)
    c.clock.step()
    c.io.out_sub.expect(1.U)
    println("[PASS] Subtraction check: 3 - 2 = 1")

    // Case 3: Testing Multiplication (4 * 2 = 8)
    c.io.in_a.poke(4.U)
    c.io.in_b.poke(2.U)
    c.clock.step()
    c.io.out_mul.expect(8.U)
    println("[PASS] Multiplication check: 4 * 2 = 8")
  }

  println("--- Simulation Finished Successfully ---")
}
```


#### Short summary: 

empty definition using pc, found symbol in pc: `<none>`.