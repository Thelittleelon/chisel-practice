import chisel3._
// KHÔNG CẦN import chisel3.stage.ChiselStage nữa

object GenVerilog extends App {
  println("--- Start generating Verilog ---")

  // 1. Xem nhanh trên màn hình
  // Hàm này có sẵn ngay trong chisel3
  val verilogString = getVerilogString(new Counter4Bit())
  // println(verilogString)

  // 2. Xuất ra file
  // Hàm emitVerilog thay thế cho ChiselStage.emitSystemVerilogFile cũ
  emitVerilog(
    new RunInside.multiplexer(), 
    Array("--target-dir", "generated") // Tham số chỉ định thư mục đầu ra
  )
  
  // println("--- Đã xuất file thành công vào thư mục 'generated' ---")
  println("--- Successfully exported Verilog file into the folder 'generated' ---")
}