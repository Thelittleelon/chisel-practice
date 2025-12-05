error id: file://<WORKSPACE>/src/test/scala/MyFirstCircuit_test.scala:`<none>`.
file://<WORKSPACE>/src/test/scala/MyFirstCircuit_test.scala
empty definition using pc, found symbol in pc: `<none>`.
empty definition using semanticdb
empty definition using fallback
non-local guesses:
	 -chisel3/dut/clock/step.
	 -chisel3/dut/clock/step#
	 -chisel3/dut/clock/step().
	 -chisel3/util/dut/clock/step.
	 -chisel3/util/dut/clock/step#
	 -chisel3/util/dut/clock/step().
	 -chisel3/tester/dut/clock/step.
	 -chisel3/tester/dut/clock/step#
	 -chisel3/tester/dut/clock/step().
	 -dut/clock/step.
	 -dut/clock/step#
	 -dut/clock/step().
	 -scala/Predef.dut.clock.step.
	 -scala/Predef.dut.clock.step#
	 -scala/Predef.dut.clock.step().
offset: 390
uri: file://<WORKSPACE>/src/test/scala/MyFirstCircuit_test.scala
text:
```scala
import chisel3._
import chisel3.util._
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers
import chisel3.tester._

class MyFirstCircuitTest extends AnyFlatSpec with ChiselScalatestTester with Matchers {
  "MyFirstCircuit" should "add 1 to input" in {
    test(new MyFirstCircuit) { dut =>
      // Chu kỳ 1
      dut.io.in.poke(0.U)
      dut.clock.step@@(1)
      dut.io.out.expect(1.U)


      dut.io.in.poke(5.U)
      dut.clock.step(1)
      dut.io.out.expect(6.U)
    }
  }
}
```


#### Short summary: 

empty definition using pc, found symbol in pc: `<none>`.