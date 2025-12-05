error id: file://<WORKSPACE>/src/main/scala/GenVerilog_example.scala:`<none>`.
file://<WORKSPACE>/src/main/scala/GenVerilog_example.scala
empty definition using pc, found symbol in pc: `<none>`.
empty definition using semanticdb
empty definition using fallback
non-local guesses:
	 -chisel3/Counter4Bit#
	 -Counter4Bit#
	 -scala/Predef.Counter4Bit#
offset: 269
uri: file://<WORKSPACE>/src/main/scala/GenVerilog_example.scala
text:
```scala
import chisel3._
// KHÔNG CẦN import chisel3.stage.ChiselStage nữa

object GenVerilog extends App {
  println("--- Start generating Verilog ---")

  // 1. Xem nhanh trên màn hình
  // Hàm này có sẵn ngay trong chisel3
  val verilogString = getVerilogString(new Counter4@@Bit())
  // println(verilogString)

  // 2. Xuất ra file
  // Hàm emitVerilog thay thế cho ChiselStage.emitSystemVerilogFile cũ
  emitVerilog(
    new Passthrough(), 
    Array("--target-dir", "generated") // Tham số chỉ định thư mục đầu ra
  )
  
  // println("--- Đã xuất file thành công vào thư mục 'generated' ---")
  println("--- Successfully exported Verilog file into the folder 'generated' ---")
}
```


#### Short summary: 

empty definition using pc, found symbol in pc: `<none>`.