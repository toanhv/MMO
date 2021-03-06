package proscom.test;

import java.io.DataInputStream;
import java.io.OutputStream;
import java.net.Socket;

public class TestManager implements Runnable {

	public TestManager() {
		super();
	}
	
	@Override
	public void run() {
		try (
				//Socket socket = new Socket("124.158.12.89", 7001);
				Socket socket = new Socket("localhost", 7001);
				OutputStream out = socket.getOutputStream();
				DataInputStream reader = new DataInputStream(socket.getInputStream());
			) {
			
			out.write(createIdAssignmentComplete());
			out.flush();
			
			out.write(createSystemModeConfig());
			out.flush();
			
			Thread.sleep(100);
			
			out.write(createOutputModeConfig());
			out.flush();
			
			Thread.sleep(100);
			
			out.write(createParameterConfig());
			out.flush();
			
			Thread.sleep(100);
			
			out.write(createTimerConfig());
			out.flush();
			
			Thread.sleep(100);
			
			out.write(createSystemModeReport());
			out.flush();
			
			Thread.sleep(100);
			
			out.write(createOutputModeReport());
			out.flush();
			
			Thread.sleep(100);
			
			out.write(createParameterReport());
			out.flush();
			
			Thread.sleep(100);
			
			out.write(createTimerCounterReport());
			out.flush();
			
			Thread.sleep(100);
			
			out.write(createSensorReport());
			out.flush();
			
			Thread.sleep(100);
			
			out.write(createAlarmReport());
			out.flush();
			
			Thread.sleep(100);
			
			out.write(createAlarmClearance());
			out.flush();
			
			Thread.sleep(100);
			
			out.write(createIdAssignmentComplete());
			out.flush();
			
			Thread.sleep(100);
			
			out.write(createIdReport());
			out.flush();
			
			//Thread.sleep(500);
			
			//out.write(createAccountReport());
			//out.flush();
			
			Thread.sleep(100);
			
			out.write(createRechargeAccountComplete());
			out.flush();
			
			Thread.sleep(100);
			
			out.write(createPassResetComplete());
			out.flush();
			
			Thread.sleep(100);
			
			out.write(createEmergencyStop());
			out.flush();
			
			Thread.sleep(100);
			
			out.write(createAccountReport());
			out.flush();
			
			byte[] buffer = new byte[1024];
			while ((reader.read(buffer, 0, buffer.length)) != -1) {
				reader.read(buffer);
		        System.out.println("Server says: " + new String(buffer));
		    }
			/*while ((response = in.readLine()) != null) {
				System.out.println("\t<<= " + response);
			}*/
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//SYSTEM MODE CONFIG
	private byte[] createSystemModeConfig() {
		
		String result = "";
		
		for (int i = 0; i < 1; i++)
			result = "0" + "000" + "0000" 
					+ "0" + "111" + "0000" + "11" + "001000" 
					+ "0000" + "000010000100" + "000000000100" + "000000000001" + "000000000000000000000001"; // 084 004 001 000001

		return result.getBytes();
	}
	
	// OUTPUT MODE CONFIG COMPLETE
	private byte[] createOutputModeConfig() {
		
		String result = "";
		
		for (int i = 0; i < 1; i++)
			result = "0" + "000" + "0001" 
					+ "0" + "111" + "0000" + "11" + "001000" 
					+ "0000" + "000010000100" + "000000000100" + "000000000001" + "000000000000000000000001"; // 084 004 001 000001

		return result.getBytes();
	}
	
	// PARAMETER CONFIG COMPLETE
	private byte[] createParameterConfig() {
		
		String result = "";
		
		for (int i = 0; i < 1; i++)
			result = "0" + "000" + "0010" 
					+ "0" + "111" + "0000" + "11" + "001000" 
					+ "0000" + "000010000100" + "000000000100" + "000000000001" + "000000000000000000000001"; // 084 004 001 000001

		return result.getBytes();
	}
	
	// TIMER CONFIG COMPLETE
	private byte[] createTimerConfig() {
		
		String result = "";
		
		for (int i = 0; i < 1; i++)
			result = "0" + "000" + "0011" 
					+ "0" + "111" + "0000" + "11" + "001000" 
					+ "0000" + "000010000100" + "000000000100" + "000000000001" + "000000000000000000000001"; // 084 004 001 000001

		return result.getBytes();
	}
	
	// SYSTEM MODE REPORT
	private byte[] createSystemModeReport() {
		
		String result = "";
		
		for (int i = 0; i < 1; i++)
			result = "0" + "000" + "0100" 
					// ID
					+ "0" + "111" + "0000" + "11" + "001000" 
					+ "0000" + "000010000100" + "000000000100" + "000000000001" + "000000000000000000000001" // 084 004 001 000001
					// system mode
					+ "0" + "000" + "0000" + "11" + "000001" 
					+ "00000001";

		return result.getBytes();
	}
	
	// OUTPUT MODE REPORT
	private byte[] createOutputModeReport() {
		
		String result = "";
		
		for (int i = 0; i < 1; i++)
			result = "0" + "000" + "0101" // 0|000|0101
					// ID
					+ "0" + "111" + "0000" + "11" + "001000" 
					+ "0000" + "000010000100" + "000000000100" + "000000000001" + "000000000000000000000001" // 084 004 001 000001
					// system mode
					+ "00000001" + "11011000" 
					+ "00000011" + "00000000" + "00000000"
					+ "00000011" + "00000001" + "00000000"
					+ "00000011" + "00000001" + "00000000"
					+ "00000011" + "00000001" + "00000000"
					+ "00000011" + "00000000"
					+ "00000011" + "01100100" + "00000001" + "00000000"
					+ "00000001" + "00000000"
					+ "00000001" + "00000000";

		return result.getBytes();
	}
	
	// PARAMTER REPORT
	private byte[] createParameterReport() {
		
		String result = "";
		
		for (int i = 0; i < 1; i++)
			result = "0" + "000" + "0110" // 0|000|0110
					// ID
					+ "0" + "111" + "0000" + "11" + "001000" 
					+ "0000" + "000010000100" + "000000000100" + "000000000001" + "000000000000000000000001" // 084 004 001 000001
					// parameter
					+ "00000010" + "11010010" 
					+ "00000101"
					+ "00000001" + "00000010"
					+ "00000000" + "00000000" + "00000001" + "00000001" + "00011110"
					+ "00001010"
					+ "00011110"
					+ "00000001" + "00011110"
					+ "00000000" + "00000000" + "00000001" + "00000000" + "00011110"
					+ "00011110";

		return result.getBytes();
	}
	
	// TIMER COUNTER REPORT
	private byte[] createTimerCounterReport() {
		
		String result = "";
		
		for (int i = 0; i < 1; i++)
			result = "0" + "000" + "0111" // 0|000|0111
					// ID
					+ "01110000" + "11001000" 
					+ "0000" + "000010000100" + "000000000100" + "000000000001" + "000000000000000000000001" // 084 004 001 000001
					// timer counter
					+ "00000011" + "11000100" 
					+ "00000001"
					+ "00000001"
					+ "00000001"
					+ "00000001";

		return result.getBytes();
	}
	
	private byte[] createSensorReport() {
		
		String result = "";
		
		for (int i = 0; i < 1; i++)
			result = "0" + "000" + "1000" // 0|000|1000
					// ID
					+ "01110000" + "11001000" 
					+ "0000" + "000010000100" + "000000000100" + "000000000001" + "000000000000000000000001" // 084 004 001 000001
					// sensor value
					+ "00000110" + "11010000" 
					+ "00011110"
					+ "00011110"
					+ "00000001"
					+ "00011110"
					+ "00001010"
					+ "00001010"
					+ "00011110"
					+ "11111111"
					+ "01100100"
					+ "00000100"
					+ "000000000000000000000000000000000000000000000000";

		return result.getBytes();
	}
	
	// alarm report
	private byte[] createAlarmReport() {
		
		String result = "";
		
		for (int i = 0; i < 1; i++)
			result = "0" + "001" + "0000" // 0|001|0000
					// ID
					+ "01110000" + "11001000" 
					+ "0000" + "000010000100" + "000000000100" + "000000000001" + "000000000000000000000001" // 084 004 001 000001
					// alarm
					+ "00000111" + "11000001" 
					+ "00000000";

		return result.getBytes();
	}
	
	// alarm clearance
	private byte[] createAlarmClearance() {
		
		String result = "";
		
		for (int i = 0; i < 1; i++)
			result = "0" + "001" + "0001" // 0|001|0000
					// ID
					+ "01110000" + "11001000" 
					+ "0000" + "000010000100" + "000000000100" + "000000000001" + "000000000000000000000001" // 084 004 001 000001
					// alarm
					+ "00000111" + "11000001" 
					+ "00000000";

		return result.getBytes();
	}
	
	private byte[] createIdAssignmentComplete() {
		
		String result = "";
		
		for (int i = 0; i < 1; i++)
			result = "00100000" // 0|010|0000
					// SIM
					+ "01110001" + "11000110"
					+ "00000000"
					+ "00001001" 
					+ "00010010"
					+ "00110100"
					+ "01010110" 
					+ "01111000"
					// ID
					+ "01110000" + "11001000" 
					+ "0000" + "000010000100" + "000000000100" + "000000000001" + "000000000000000000000001" // 084 004 001 000001
					;
		
		result = "0010000001110101000010101000100110000100000001001000011100000001000000101001001001100000000000000000000001110000000010000000000010000100000000000100000000000001000000010000000000000000";

		return result.getBytes();
	}
	
	private byte[] createIdReport() {
		
		String result = "";
		
		for (int i = 0; i < 1; i++)
			result = "00100001" // 0|010|0001
					// SIM
					+ "01110001" + "11000110"
					+ "00000000"
					+ "00001001" 
					+ "00010010"
					+ "00110100"
					+ "01010110" 
					+ "01111000"
					// ID
					+ "01110000" + "11001000" 
					+ "0000" + "000010000100" + "000000000100" + "000000000001" + "000000000000000000000001" // 084 004 001 000001
					;

		return result.getBytes();
	}
	
	/*private byte[] createAccountReport() {
		
		String result = "";
		
		for (int i = 0; i < 1; i++)
			result = "00100010" // 0|010|0010
					// ID
					+ "01110000" + "11001000" 
					+ "0000" + "000010000100" + "000000000100" + "000000000001" + "000000000000000000000001" // 084 004 001 000001
					// alarm
					+ "01110011" + "11000001"
					+ "01010100011000010110100100100000011010110110100001101111011000010110111000100000011000110111010101100001001000000110001001100001011011100010000001100011011011110010000000110001001100000011000000100000010010110010000001101000011001010010000001101000011001010000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000"
					+ "01010100011000010110100100100000011010110110100001101111011000010110111000100000011000110111010101100001001000000110001001100001011011100010000001100011011011110010000000110001001100000011000000100000010010110010000001101000011001010010000001101000011001010000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000";

		return result.getBytes();
	}*/
	
	private byte[] createAccountReport() {
		
		String result = "";
		
		for (int i = 0; i < 1; i++)
			result = "00100010" // 0|010|0010
					// ID
					+ "01110000" + "11001000" 
					+ "0000" + "000010000100" + "000000000100" + "000000000001" + "000000000000000000000001" // 084 004 001 000001
					// account
					+ "01110011" + "11000001"
					+ "&&Tai khoan goc cua quy khach la 0 dong. De biet cac CT dac biet cua Quy khach, vui long bam goi *098#.##";

		return result.getBytes();
	}
	
	// RECHARGE ACCOUNT COMPLETE
	private byte[] createRechargeAccountComplete() {
		
		String result = "";
		
		for (int i = 0; i < 1; i++)
			result = "0" + "010" + "0011" 	// 0|010|0011
					+ "0" + "111" + "0000" + "11" + "001000" 
					+ "0000" + "000010000100" + "000000000100" + "000000000001" + "000000000000000000000001"; // 084 004 001 000001

		return result.getBytes();
	}
	
	// PASS RESET COMPLETE
	private byte[] createPassResetComplete() {
		
		String result = "";
		
		for (int i = 0; i < 1; i++)
			result = "0" + "010" + "0100" 	// 0|010|0100
					+ "0" + "111" + "0000" + "11" + "001000" 
					+ "0000" + "000010000100" + "000000000100" + "000000000001" + "000000000000000000000001"; // 084 004 001 000001

		return result.getBytes();
	}
	
	// EMERGENCY
	private byte[] createEmergencyStop() {
		
		String result = "";
		
		for (int i = 0; i < 1; i++) {
			result = "0" + "011" + "0000"
					+ "0" + "111" + "0000" + "11" + "001000" 
					+ "0000" + "000010000100" + "000000000100" + "000000000001" + "000000000000000000000001"; // 084 004 001 000001
			
			result += "0" + "011" + "0001"
					+ "0" + "111" + "0000" + "11" + "001000" 
					+ "0000" + "000010000100" + "000000000100" + "000000000001" + "000000000000000000000001"; // 084 004 001 000001
			
			result += "0" + "011" + "0010"
					+ "0" + "111" + "0000" + "11" + "001000" 
					+ "0000" + "000010000100" + "000000000100" + "000000000001" + "000000000000000000000001"; // 084 004 001 000001
			
			result += "0" + "011" + "0011"
					+ "0" + "111" + "0000" + "11" + "001000" 
					+ "0000" + "000010000100" + "000000000100" + "000000000001" + "000000000000000000000001"; // 084 004 001 000001
			
		}

		return result.getBytes();
	}
	
	public static void main(String[] args) {
		// test with 1000 device.
		for (int i = 0; i < 1; i++) {
			(new Thread(new TestManager())).start();
		}
	}
}
