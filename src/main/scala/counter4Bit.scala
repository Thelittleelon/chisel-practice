// src/main/scala/Counter4Bit.scala

import chisel3._

class Counter4Bit extends Module {
  val io = IO(new Bundle {
    val enable = Input(Bool())      // Tín hiệu cho phép đếm
    val count  = Output(UInt(4.W))  // Giá trị đếm hiện tại (4 bit)
    val tick   = Output(Bool())     // Tín hiệu báo tràn (Overflow/Wrap around)
  })

  // Tạo một thanh ghi 4 bit, khởi tạo giá trị ban đầu là 0
  val cntReg = RegInit(0.U(4.W))

  // Logic đếm: Chỉ tăng khi enable = true
  when(io.enable) {
    // Tự động wrap-around: 15 + 1 -> 0 (với UInt 4 bit)
    cntReg := cntReg + 1.U
  }

  // Kết nối đầu ra
  io.count := cntReg
  
  // Tín hiệu tick lên mức cao khi đếm đến 15 VÀ đang được enable
  io.tick := (cntReg === 15.U) && io.enable
}