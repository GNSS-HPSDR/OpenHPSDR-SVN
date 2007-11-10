// ---------------------------------------------
//
// QS1R Receiver FPGA
// Copyright 2007 P.Covington N8VB
//
// Ver 1.0
//
// See Xilinx appnote: "Digitally Removing A DC Offset: Part2"
//
// dc_offset_correct dc_offset_correct_inst(
// .clk(),
// .clken(),
// .data_in(),
// .data_out(),


// RC = dT/k  = (1/196k)/(1/2^16) = 2^16/196,000 ~= 0.3sec
// accumulator  = 16.24 = 40 bits

// 16 OK - 15 OK - 14 OK - 13 OK - 12 OK - 11 OK

module dc_offset_correct_new(
input clk,
input clken,
input signed [23:0] data_in,
output signed [23:0] data_out

);

wire signed [23:0] dc_level = accumulator[33:10];
wire signed [23:0] corrected = data_in[23:0] - dc_level[23:0];
reg signed [33:0] accumulator;

always @(posedge clk) begin
	if (clken == 1'b0) begin
		accumulator <= 34'd0;
		end
	else begin
		accumulator <= accumulator + {{10{corrected[23]}},corrected[23:0]};
		end
end

assign data_out[23:0] = corrected[23:0];

endmodule



