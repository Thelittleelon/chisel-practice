file://<WORKSPACE>/src/test/scala/MyModule_test.scala
### java.lang.IndexOutOfBoundsException: -1

occurred in the presentation compiler.

presentation compiler configuration:


action parameters:
offset: 550
uri: file://<WORKSPACE>/src/test/scala/MyModule_test.scala
text:
```scala
import chisel3._
import chisel3.simulator.scalatest.ChiselSim
import org.scalatest.funsuite.AnyFunSuite // <--- Đổi thư viện này
import org.scalatest.matchers.should.Matchers

// Kế thừa AnyFunSuite thay vì AnyFlatSpec
class ModuleTest extends AnyFunSuite with Matchers with ChiselSim {

    // Bây giờ bạn CÓ THỂ dùng từ khóa test
    test("") { 
        // Vẫn phải dùng simulate để giả lập phần cứng
        simulate(new RunInside.multiplexer()) { c =>
            c.io.in.poke(true)
            c.io.out_mux.expect(3.U)

            c.io.in.poke(@@)
            c.io.out_mul.expect(8.U)
        }
    }
}
```



#### Error stacktrace:

```
scala.collection.LinearSeqOps.apply(LinearSeq.scala:129)
	scala.collection.LinearSeqOps.apply$(LinearSeq.scala:128)
	scala.collection.immutable.List.apply(List.scala:79)
	dotty.tools.dotc.util.Signatures$.applyCallInfo(Signatures.scala:244)
	dotty.tools.dotc.util.Signatures$.computeSignatureHelp(Signatures.scala:101)
	dotty.tools.dotc.util.Signatures$.signatureHelp(Signatures.scala:88)
	dotty.tools.pc.SignatureHelpProvider$.signatureHelp(SignatureHelpProvider.scala:46)
	dotty.tools.pc.ScalaPresentationCompiler.signatureHelp$$anonfun$1(ScalaPresentationCompiler.scala:435)
```
#### Short summary: 

java.lang.IndexOutOfBoundsException: -1