import chisel3._
import chisel3.simulator.scalatest.ChiselSim
import org.scalatest.funsuite.AnyFunSuite // <--- Đổi thư viện này
import org.scalatest.matchers.should.Matchers

// Kế thừa AnyFunSuite thay vì AnyFlatSpec
class PassthroughTest extends AnyFunSuite with Matchers with ChiselSim {

    // Bây giờ bạn CÓ THỂ dùng từ khóa test
    test("") { 
        // Vẫn phải dùng simulate để giả lập phần cứng
        // simulate(new Passthrough()) { c =>
        //     c.io.in.poke(0.U)
        //     c.io.out.expect(0.U)

        //     c.io.in.poke(1.U)
        //     c.io.out.expect(1.U)
        // }

        simulate(new Passthrough(10)) { c =>
            c.io.in.poke(0.U)
            c.io.out.expect(0.U)

            c.io.in.poke(985.U)
            c.io.out.expect(985.U)
        }

        simulate(new Passthrough(20)) { c =>
            c.io.in.poke(0.U)
            c.io.out.expect(0.U)

            c.io.in.poke(1030000.U)
            c.io.out.expect(1030000.U)
        }
    }
}