file://<WORKSPACE>/src/test/scala/passthrough_test.scala
### java.lang.IndexOutOfBoundsException: -1

occurred in the presentation compiler.

presentation compiler configuration:


action parameters:
offset: 459
uri: file://<WORKSPACE>/src/test/scala/passthrough_test.scala
text:
```scala
import chisel3._
import chisel3.simulator.scalatest.ChiselSim // Sử dụng thư viện Sim mới của Chisel 7
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class passthroughTest extends AnyFlatSpec with Matchers with ChiselSim {
    test(new Passthrough()) { c =>
        c.io.in.poke(0.U)
        c.io.out.expect(0.U)
        c.io.in.poke(1.U)
        c.io.out.expect(1.U)
        c.io.in.poke(2.U)
        c.io.in.expect(@@)
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