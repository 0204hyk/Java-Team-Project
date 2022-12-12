package pos;

import java.awt.Image;
import java.io.File;

import javax.swing.ImageIcon;

public class ImageScaledTool {
	
	public static Image getScaledImage(String filePath, int w, int h) {
		return new ImageIcon(filePath).getImage().getScaledInstance(w, h,Image.SCALE_AREA_AVERAGING);
	}
}
