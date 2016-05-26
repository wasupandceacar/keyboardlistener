package drawer;

import javax.swing.*;
import java.awt.*;

//panelªÊ÷∆±≥æ∞

public class BackgroundPanel extends JPanel{  
	private static final long serialVersionUID = -6352788025440244338L;  
	
	private Image image=null;
	
	public BackgroundPanel(Image image){
		this.image=image;
	}
	
	public void paintComponent(final Graphics g){
		g.drawImage(image, 0, 0, this.getWidth(),this.getHeight(),this);
	}
}
