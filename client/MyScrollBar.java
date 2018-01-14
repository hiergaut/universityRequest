/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.plaf.metal.MetalScrollBarUI;

/**
 *
 * @author gauthier
 */
public class MyScrollBar extends MetalScrollBarUI {
	private Image imageThumb, imageTrack;

	private JButton b = new JButton() {

		@Override

		public Dimension getPreferredSize() {

			return new Dimension(0, 0);

		}

	};

	public MyScrollBar() {

		imageThumb = FauxImage.create(32, 32, Color.blue.darker());

		imageTrack = FauxImage.create(32, 32, Color.lightGray);

	}

	@Override
	protected void paintThumb(Graphics g, JComponent c, Rectangle r) {

		g.setColor(Color.blue);

		((Graphics2D) g).drawImage(imageThumb,
			r.x, r.y, r.width, r.height, null);

	}

	@Override
	protected void paintTrack(Graphics g, JComponent c, Rectangle r) {

		((Graphics2D) g).drawImage(imageTrack,
			r.x, r.y, r.width, r.height, null);

	}

	@Override
	protected JButton createDecreaseButton(int orientation) {

		return b;

	}

	@Override
	protected JButton createIncreaseButton(int orientation) {

		return b;

	}

	private static class FauxImage {

		static public Image create(int w, int h, Color c) {

			BufferedImage bi = new BufferedImage(
				w, h, BufferedImage.TYPE_INT_ARGB);

			Graphics2D g2d = bi.createGraphics();

			g2d.setPaint(c);

			g2d.fillRect(0, 0, w, h);

			g2d.dispose();

			return bi;

		}

	}
	
}
