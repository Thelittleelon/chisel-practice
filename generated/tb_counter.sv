// File: generated/tb_counter.sv
module tb_counter;
  reg clock;
  reg reset;
  reg io_enable;
  wire [3:0] io_count;
  wire io_tick;

  // 1. Gọi module Counter4Bit (DUT - Device Under Test)
  Counter4Bit uut (
    .clock(clock),
    .reset(reset),
    .io_enable(io_enable),
    .io_count(io_count),
    .io_tick(io_tick)
  );

  // 2. Tạo xung Clock
  initial begin
    clock = 0;
    forever #5 clock = ~clock; // Đảo trạng thái mỗi 5 đơn vị thời gian
  end

  // 3. Kịch bản test
  initial begin
    // Cài đặt file ghi sóng (QUAN TRỌNG)
    $dumpfile("wave.vcd"); // Tên file sóng sẽ tạo ra
    $dumpvars(0, tb_counter); // Ghi lại mọi tín hiệu trong module này

    // Khởi tạo
    reset = 1;
    io_enable = 0;
    #20; // Chờ 20 đơn vị
    reset = 0;
    
    // Test 1: Enable đếm
    #10 io_enable = 1;
    
    // Test 2: Chờ cho nó đếm tràn (hơn 16 chu kỳ)
    #200;
    
    // Test 3: Tắt enable
    io_enable = 0;
    #50;

    $finish; // Kết thúc mô phỏng
  end
endmodule