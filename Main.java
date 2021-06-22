import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.GraphicsConfiguration;

public class Main {

	private static int width, height;

	public static void main(String[] args) {
		GraphicsEnvironment graphics = GraphicsEnvironment.getLocalGraphicsEnvironment();
		GraphicsDevice device = graphics.getDefaultScreenDevice();
		GraphicsConfiguration config = device.getDefaultConfiguration();
		
		width = (int) config.getBounds().getWidth();
		height = (int) config.getBounds().getHeight();
			
		Display display = new Display(width, height, "Software Rendering", true);
		Bitmap target = display.GetFrameBuffer();
		Stars3D stars = new Stars3D(4096, 64.0f, 20.0f);

		long previousTime = System.nanoTime();
		
		while(true) {
			long currentTime = System.nanoTime();
			float delta = (float) ((currentTime - previousTime) / 1000_000_000.0);
			previousTime = currentTime;

			stars.UpdateAndRender(target, delta);
			display.SwapBuffers();
		}
	}
}
