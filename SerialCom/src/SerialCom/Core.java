package SerialCom;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import com.fazecast.jSerialComm.SerialPort;

public class Core {
	// define Serial port
	private SerialPort serialPort;
	private int BaudRate;

	public Core(int BaudRate) throws InterruptedException {
		Thread.sleep(500);
		this.BaudRate = BaudRate;
	}

	public Core(int BaudRate, int inputPort) throws InterruptedException {
		Thread.sleep(500);
		this.BaudRate = BaudRate;
		setPort(inputPort);
	}
	// send via serial port method
	public void send(Object input) throws InterruptedException {
		if (serialPort.openPort()) {
			PrintWriter pw = new PrintWriter(serialPort.getOutputStream());
			pw.println(input);
			pw.flush();
			pw.close();
			Thread.sleep(100);
		}

	}
	// receive via serial port method
	public String receive() throws IOException, InterruptedException {
		String output = null;
		if (serialPort.openPort()) {
			BufferedReader br = new BufferedReader(new InputStreamReader(serialPort.getInputStream()));
			Thread.sleep(100);
			output = br.readLine();
			br.close();
		}
		return output;
	}
	// get available port to connect as a string array
	public String[] getPorts() {
		int length = SerialPort.getCommPorts().length;
		String[] outputs = new String[length];
		if (length != 0) {
			for (int i = 0; i < length; i++) {
				outputs[i] = SerialPort.getCommPorts()[i].getDescriptivePortName();
			}
		}
		return outputs;
	}
	// check if the port is open or not
	public boolean getPortStatus() {
		return serialPort.isOpen();
	}
	// port setup
	public void setPort(int input) throws InterruptedException {
		serialPort = SerialPort.getCommPort(SerialPort.getCommPorts()[input].getSystemPortName());
		serialPort.setComPortParameters(BaudRate, 8, 1, 0);
		serialPort.setComPortTimeouts(SerialPort.TIMEOUT_WRITE_BLOCKING, 0, 0);
		serialPort.openPort();
		Thread.sleep(1000);
	}
}
