package me.ael.jwake;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * Sends Wake-on-LAN packets.
 * 
 * @author Alex Lindeman
 */
public class WakeOnLan
{
	public static final int PORT = 9;
	public byte[] address;

	public WakeOnLan(String address) throws IllegalArgumentException
	{
		this.address = translate(address);
	}

	/**
	 * Prepares and sends the WOL packet.
	 */
	public void send() throws IOException
	{
		byte[] payload = new byte[6 + 16 * address.length];

		for (int i = 0; i < 6; i ++)
		{
			payload[i] = (byte) 0xff;
		}

		for (int i = 6; i < payload.length; i += address.length)
		{
			System.arraycopy(address, 0, payload, i, address.length);
		}

		InetAddress address = InetAddress.getByName("255.255.255.255");
		DatagramPacket packet = new DatagramPacket(payload, payload.length, address, PORT);
		DatagramSocket socket = new DatagramSocket();
		socket.send(packet);
		socket.close();
	}

	/**
	 * Translates a string containing a MAC address into a byte array.
	 * 
	 * @param address MAC address as string
	 * @return byte[]
	 */
	public static byte[] translate(String address)
			throws IllegalArgumentException
	{
		byte[] bytes = new byte[6];
		String[] hex = address.split("(\\:|\\-)");

		if (hex.length != 6)
			throw new IllegalArgumentException("Invalid MAC address");

		try
		{
			for (int i = 0; i < 6; i ++)
			{
				bytes[i] = (byte) Integer.parseInt(hex[i], 16);
			}
		}
		catch (NumberFormatException e)
		{
			throw new IllegalArgumentException("Invalid hex digit in MAC address");
		}

		return bytes;
	}
}