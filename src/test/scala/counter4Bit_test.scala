// src/test/scala/Counter4Bit_test.scala

import chisel3._
import chisel3.simulator.scalatest.ChiselSim // Sử dụng thư viện Sim mới của Chisel 7
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class Counter4BitTest extends AnyFlatSpec with Matchers with ChiselSim {

  "Counter4Bit" should "count accurately and wrap around" in {
    simulate(new Counter4Bit) { dut =>
      
      // 1. Kiểm tra trạng thái Reset (Khởi đầu)
      dut.io.enable.poke(false.B)
      dut.clock.step(1)
      dut.io.count.expect(0.U) // Sau reset phải là 0
      
      // 2. Bắt đầu đếm (Enable = true)
      dut.io.enable.poke(true.B)
      
      // Chạy vòng lặp kiểm tra từ 0 đến 15
      for (expectedVal <- 1 to 15) {
        dut.clock.step(1)
        dut.io.count.expect(expectedVal.U)
        
        // Kiểm tra tín hiệu tick: Chỉ tick khi đạt 15
        if (expectedVal == 15) {
          dut.io.tick.expect(true.B)
        } else {
          dut.io.tick.expect(false.B)
        }
      }

      // 3. Kiểm tra Wrap around (15 -> 0)
      dut.clock.step(1)
      dut.io.count.expect(0.U) // Phải quay về 0
      
      // 4. Kiểm tra chức năng Pause (Enable = false)
      dut.io.enable.poke(false.B) // Tắt đếm
      dut.clock.step(3)            // Chạy vài chu kỳ clock
      dut.io.count.expect(0.U)     // Giá trị phải giữ nguyên là 0, không tăng
    }
  }
}