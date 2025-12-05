import chisel3._
import chisel3.simulator.scalatest.ChiselSim
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers


class ModuleTest extends AnyFunSuite with Matchers with ChiselSim {


    test("") { 

        simulate(new RunInside.multiplexer()) { c =>
            c.io.in.poke(true)
            c.io.out_mux.expect(3.U)

            c.io.in.poke(false)
            c.io.out_mux.expect(0.U)
        }
    }
}