package pos.salessummary.saleslist;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import org.jfree.data.xy.DefaultTableXYDataset;

import pos.ImageScaledTool;

public class ListImgLabel extends JLabel {

	ImageScaledTool tool = new ImageScaledTool();

	public ListImgLabel() {

		setIcon(new ImageIcon(tool.getScaledImage(
				"images/PosImages/매출 요약 이미지/검색 매출 리스트 기본 틀.png", 500, 500)));
		setBounds(620, 155, 500, 500);

	}
}
