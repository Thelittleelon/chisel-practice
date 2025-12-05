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

            c.io.in.poke(false)
            c.io.out_mux.expect(0.U)
        }
    }
}