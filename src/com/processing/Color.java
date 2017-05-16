package com.processing;

public class Color {
	
	private int red;
	private int green;
	private int blue;
	
	public int getRed() {
		return red;
	}

	public void setRed(int red) {
		this.red = red;
	}

	public int getGreen() {
		return green;
	}

	public void setGreen(int green) {
		this.green = green;
	}

	public int getBlue() {
		return blue;
	}

	public void setBlue(int blue) {
		this.blue = blue;
	}

	public Color(double red, double green, double blue) {
		this.red = (int) red;
		this.green = (int) green;
		this.blue = (int) blue;
	}

	public static Color RED = new Color(255, 0, 0);
	public static Color GREEN = new Color(0, 255, 0);
	public static Color BLUE = new Color(0, 0, 255);
	public static Color BLACK = new Color(0, 0, 0);
	public static Color WHITE = new Color(255, 255, 255);
	public static Color TEAL = new Color(0, 128, 128);

	public static Color getRandomColor() {
		return new Color((int) (Math.random() * 255), (int) (Math.random() * 255), (int) (Math.random() * 255));
	}

	public static Color[] getAdjacentColors(Color c) {
		return getComplementaryTriadColors(c, 50);
	}

	public Color(int rgb) {
		java.awt.Color c = new java.awt.Color(rgb);
		this.red = c.getRed();
		this.blue = c.getBlue();
		this.green = c.getGreen();
	}

	public static Color[] getTriadColors(Color c) {
		return getComplementaryTriadColors(c, 165);
	}

	public static Color[] getComplementaryTriadColors(Color c, int angle) {
		Color[] res = new Color[3];
		float hsbc1 = 0;
		float hsbc2 = 0;
		int red = c.getRed();
		int blue = c.getBlue();
		int green = c.getGreen();
		float pct = (float) (0.27777 * (float) angle) / 100;
		float[] hsb = java.awt.Color.RGBtoHSB(red, green, blue, null);
		hsbc1 = (float) (hsb[0] + pct);
		hsbc2 = (float) (hsb[0] - pct);
		if (hsbc1 > 1)
			hsbc1 -= 1;
		if (hsbc2 < 0)
			hsbc2 += 1;
		int rgb = java.awt.Color.HSBtoRGB(hsbc1, hsb[1], hsb[2]);
		res[0] = new Color(rgb);
		res[1] = c;
		rgb = java.awt.Color.HSBtoRGB(hsbc2, hsb[1], hsb[2]);
		res[2] = new Color(rgb);
		return res;
	}

	public static Color[] getComplementaryTetraColors(Color c, int angle) {
		Color[] res = new Color[4];
		float hsbc1 = 0;
		int red = c.getRed();
		int blue = c.getBlue();
		int green = c.getGreen();
		float pct = getAnglePct(angle);
		float[] hsb = java.awt.Color.RGBtoHSB(red, green, blue, null);
		hsbc1 = (float) (hsb[0] + pct);
		if (hsbc1 > 1)
			hsbc1 -= 1;
		int rgb = java.awt.Color.HSBtoRGB(hsbc1, hsb[1], hsb[2]);
		res[1] = new Color(rgb);
		pct = getAnglePct(180);
		hsbc1 = (float) (hsb[0] + pct);
		if (hsbc1 > 1)
			hsbc1 -= 1;
		rgb = java.awt.Color.HSBtoRGB(hsbc1, hsb[1], hsb[2]);
		res[2] = new Color(rgb);
		res[0] = c;
		pct = getAnglePct(180 + angle);
		hsbc1 = (float) (hsb[0] + pct);
		if (hsbc1 > 1)
			hsbc1 -= 1;
		rgb = java.awt.Color.HSBtoRGB(hsbc1, hsb[1], hsb[2]);
		res[3] = new Color(rgb);
		return res;
	}

	private static float getAnglePct(int angle) {
		return (float) (0.27777 * (float) angle) / 100;
	}

}
