import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.GraphicsConfiguration;

public class Main {

	private static int width, height;

	public static void main(String[] args) {
		GraphicsEnvironment graphics = GraphicsEnvironment.getLocalGraphicsEnvironment();
		GraphicsDevice device = graphics.getDefaultScreenDevice();
		GraphicsConfiguration config = device.getDefaultConfiguration();
		
		// width = (int) config.getBounds().getWidth();
		width = 800;
		// height = (int) config.getBounds().getHeight();
		height = 600;
			
		Display display = new Display(width, height, "Software Rendering", false);
		RenderContext target = display.GetFrameBuffer();
		Stars3D stars = new Stars3D(4096, 64.0f, 20.0f);

		Vertex minYVert = new Vertex(100, 100);
		Vertex midYVert = new Vertex(150, 200);
		Vertex maxYVert = new Vertex(80, 300);

		long previousTime = System.nanoTime();
		
		while(true) {
			long currentTime = System.nanoTime();
			float delta = (float) ((currentTime - previousTime) / 1000_000_000.0);
			previousTime = currentTime;

			// stars.UpdateAndRender(target, delta);
			target.Clear((byte) 0x00);

			// for (int j = 100; j < 200; j++) {
				// target.DrawScanBuffer(j, 300 - j, 300 + j);
			// }
			target.ScanConvertTriangle(minYVert, midYVert, maxYVert, 0);
			target.FillShape(100, 300);
			
			display.SwapBuffers();
		}
	}
}
