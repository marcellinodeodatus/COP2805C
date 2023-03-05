//Assignment 04
//Deodatus Marcellino
//10/12/2018

import java.io.File;

import java.io.FileNotFoundException;//exception

import java.io.FileOutputStream;

import java.io.IOException;

public class BitOutputStream {

	private File file;

	private byte buffer;

	private FileOutputStream fos;

	private int numBitsOccupied = 0;

	//Method BitOutputStream
	public BitOutputStream(File file) {

		super();

		this.file = file;

		try {

			fos = new FileOutputStream(this.file);

		} catch (FileNotFoundException e) {

			e.printStackTrace();

		}

	}//end BitOutputStream

	//writeBit (char)
	public void writeBit(char bit) {

		System.out.println("Buffer : " + buffer);

		buffer = (byte) (buffer << 1);

		if (bit == '1') {

			buffer = (byte) (buffer | 1);

		}

		numBitsOccupied++;

		if (numBitsOccupied == 8) {

			writeBufferToFile();

			numBitsOccupied = 0;

			buffer = 0;

		}

	}//end writeBit (char)

	//writeBit (string)
	public void writeBit(String bits) {

		if (null != bits) {

			for (char bit : bits.toCharArray()) {

				writeBit(bit);

			}

		}

	}//end writeBit (string)

	public void close() {

		if (numBitsOccupied < 8) {

			buffer = (byte) (buffer << (8 - numBitsOccupied));

		}

		writeBufferToFile();

		try {

			fos.close();

		} catch (IOException e) {

			e.printStackTrace();

		}

		numBitsOccupied=0;

	}//end close

	private void writeBufferToFile() {

		try {

			for (int i = 1; i <= 8; i++) {

				if ((buffer & 0x80) != 0) {

					fos.write('1');

				} else {

					fos.write('0');

				}

				buffer = (byte) (buffer << 1);

			}

		} catch (IOException e) {

			e.printStackTrace();

		}

	}

	public static void main(String[] args) throws IOException {

		BitOutputStream bos = new BitOutputStream(new File("Assignment04.dat"));

		bos.writeBit('0');

		bos.writeBit("1000");

		bos.writeBit("0100");

		bos.writeBit("1000");

		bos.writeBit("0100");

		bos.writeBit("1101");

		bos.close();

	}//end main

}