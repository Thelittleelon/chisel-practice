error id: file://<WORKSPACE>/src/test/scala/passthrough_test.scala:`<none>`.
file://<WORKSPACE>/src/test/scala/passthrough_test.scala
empty definition using pc, found symbol in pc: `<none>`.
empty definition using semanticdb
empty definition using fallback
non-local guesses:
	 -chisel3/c/io/out/expect.
	 -chisel3/c/io/out/expect#
	 -chisel3/c/io/out/expect().
	 -c/io/out/expect.
	 -c/io/out/expect#
	 -c/io/out/expect().
	 -scala/Predef.c.io.out.expect.
	 -scala/Predef.c.io.out.expect#
	 -scala/Predef.c.io.out.expect().
offset: 588
uri: file://<WORKSPACE>/src/test/scala/passthrough_test.scala
text:
```scala
import chisel3._
import chisel3.simulator.scalatest.ChiselSim
import org.scalatest.funsuite.AnyFunSuite // <--- Đổi thư viện này
import org.scalatest.matchers.should.Matchers

// Kế thừa AnyFunSuite thay vì AnyFlatSpec
class PassthroughTest extends AnyFunSuite with Matchers with ChiselSim {

    // Bây giờ bạn CÓ THỂ dùng từ khóa test
    test("Passthrough test") { 
        // Vẫn phải dùng simulate để giả lập phần cứng
        simulate(new Passthrough()) { c =>
            c.io.in.poke(0.U)
            c.io.out.expect(0.U)

            c.io.in.poke(1.U)
            c.io.out.expect@@(1.U)
        }
    }
}
```


#### Short summary: 

empty definition using pc, found symbol in pc: `<none>`.