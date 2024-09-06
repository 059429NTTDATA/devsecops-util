package ntt.devsecops.util;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileUtil {

	public static BufferedImage resizeImage(BufferedImage originalImage, int width, int height) {
		BufferedImage resizedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		Graphics2D graphics = resizedImage.createGraphics();
		graphics.drawImage(originalImage, 0, 0, width, height, null);
		graphics.dispose();
		return resizedImage;
	}

	public static String readFileFromPathAsString(String filePath) throws IOException {
		Path path = Paths.get(filePath);
		byte[] bytes = Files.readAllBytes(path);
		String content = new String(bytes);
		return content;
	}

	public static Boolean writeStringToFileFromPath(String filePath, String valueWrite) throws IOException {
		Path path = Paths.get(filePath);
		Files.write(path, valueWrite.getBytes());
		return Boolean.TRUE;
	}
}
