import java.util.Arrays;

public class Bitmap {

	private final int m_width;
	private final int m_height;
	private final byte m_components[];

	public Bitmap(int width, int height) {
		m_width = width;
		m_height = height;
		m_components = new byte[width * height * 4];
	}

	public void Clear(byte shade) {
		Arrays.fill(m_components, shade);
	}

	public void DrawPixel(int x, int y, byte a, byte b, byte g, byte r) {
		int index = (x + y * m_width) * 4;
		m_components[index + 0] = a;
		m_components[index + 1] = b;
		m_components[index + 2] = g;
		m_components[index + 3] = r;
	}

	public void CopyToByteArray(byte[] dest) {
		for (int i = 0; i < m_width * m_height; i++) {
			dest[i * 3 + 0] = m_components[i * 4 + 1];
			dest[i * 3 + 1] = m_components[i * 4 + 2];
			dest[i * 3 + 2] = m_components[i * 4 + 3];
		}
	}

	public int GetWidth() { return m_width; }

	public int GetHeight() { return m_height; }
		
	// }// public void CopyToIntArray(int[] dest) {
		// for (int i = 0; i < m_width * m_height; i++) {
			// int a = (int) m_components[i * 4 + 0] << 24;
			// int r = (int) m_components[i * 4 + 1] << 16;
			// int g = (int) m_components[i * 4 + 2] << 8;
			// int b = (int) m_components[i * 4 + 3];
// 
			// dest[i] = a | r | g | b;
		// }
	// }
}
