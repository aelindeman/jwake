package me.ael.jwake;

public class Machine
{
	/**
	 * Display name of the machine.
	 */
	public String name;
	
	/**
	 * MAC address of the machine, as a string, with digit pairs separated by
	 * either colons or hyphens.
	 */
	public String address;
	
	public Machine(String[] data)
	{
		this.name = data[0];
		this.address = data[1];
	}
	
	public Machine(String name, String address)
	{
		this.name = name;
		this.address = address;
	}
}
