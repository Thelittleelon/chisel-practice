error id: file://<WORKSPACE>/src/main/scala/myFirstCircuit.scala:`<none>`.
file://<WORKSPACE>/src/main/scala/myFirstCircuit.scala
empty definition using pc, found symbol in pc: `<none>`.
empty definition using semanticdb
empty definition using fallback
non-local guesses:
	 -chisel3/test.
	 -chisel3/test#
	 -chisel3/test().
	 -chisel3/util/test.
	 -chisel3/util/test#
	 -chisel3/util/test().
	 -chisel3/tester/test.
	 -chisel3/tester/test#
	 -chisel3/tester/test().
	 -chisel3/tester/RawTester.test.
	 -chisel3/tester/RawTester.test#
	 -chisel3/tester/RawTester.test().
	 -dotvisualizer/test.
	 -dotvisualizer/test#
	 -dotvisualizer/test().
	 -test.
	 -test#
	 -test().
	 -scala/Predef.test.
	 -scala/Predef.test#
	 -scala/Predef.test().
offset: 98
uri: file://<WORKSPACE>/src/main/scala/myFirstCircuit.scala
text:
```scala
import chisel3._
import chisel3.util._
import chisel3.tester._
import chisel3.tester.RawTester.tes@@t
import dotvisualizer._

class Passthrough extends Module {
  val io = IO(new Bundle {
    val in = Input(UInt(4.W))
    val out = Output(UInt(4.W))
  })
  io.out := io.in

  test(new Passthrough()) { c =>
    c.io.in.poke(0.U)     // Set our input to value 0
    c.io.out.expect(0.U)  // Assert that the output correctly has 0
    c.io.in.poke(1.U)     // Set our input to value 1
    c.io.out.expect(1.U)  // Assert that the output correctly has 1
    c.io.in.poke(2.U)     // Set our input to value 2
    c.io.out.expect(2.U)  // Assert that the output correctly has 2
}
println("SUCCESS!!") // Scala Code: if we get here, our tests passed!

}
```


#### Short summary: 

empty definition using pc, found symbol in pc: `<none>`.