package keyboardlistener;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

import drawer.BackgroundPanel;

public class listener {
	//块数组
	protected static JPanel[] jp=new JPanel[16];
	
	//计数数组
	protected static int[] num=new int[8];
	
	//文字数组
	protected static JLabel[] jl=new JLabel[8];
	
	public static void main(String[] args) throws NativeHookException, IOException {
		//建立窗口
		JFrame main=new JFrame("键位映射监听器");
		
		//设置图标
		Image image=ImageIO.read(main.getClass().getResource("/images/logo.png"));
		main.setIconImage(image);
		
		//设置布局为空
		main.setLayout(null);
		
		//设置容器
		Container co=main.getContentPane();
		
		//获取屏幕高宽
		Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
		
		//设置窗口居中
		main.setBounds((screensize.width-180)/2, (screensize.height-430)/2, 180, 430);
		main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//设置八个键位的贴图
		JPanel up=new JPanel();
		Image imageup=ImageIO.read(main.getClass().getResource("/images/5.jpg"));
		up=new BackgroundPanel(imageup);
		up.setBounds(61, 20, 37, 40);
		jp[0]=up;
		JPanel upr=new JPanel();
		Image imageupr=ImageIO.read(main.getClass().getResource("/images/5r.jpg"));
		upr=new BackgroundPanel(imageupr);
		upr.setBounds(61, 20, 37, 40);
		jp[1]=upr;
		co.add(jp[0]);
		
		JPanel down=new JPanel();
		Image imagedown=ImageIO.read(main.getClass().getResource("/images/6.jpg"));
		down=new BackgroundPanel(imagedown);
		down.setBounds(61, 60, 37, 40);
		jp[2]=down;
		JPanel downr=new JPanel();
		Image imagedownr=ImageIO.read(main.getClass().getResource("/images/6r.jpg"));
		downr=new BackgroundPanel(imagedownr);
		downr.setBounds(61, 60, 37, 40);
		jp[3]=downr;
		co.add(jp[2]);
		
		JPanel left=new JPanel();
		Image imageleft=ImageIO.read(main.getClass().getResource("/images/7.jpg"));
		left=new BackgroundPanel(imageleft);
		left.setBounds(24, 60, 37, 40);
		jp[4]=left;
		JPanel leftr=new JPanel();
		Image imageleftr=ImageIO.read(main.getClass().getResource("/images/7r.jpg"));
		leftr=new BackgroundPanel(imageleftr);
		leftr.setBounds(24, 60, 37, 40);
		jp[5]=leftr;
		co.add(jp[4]);
		
		JPanel right=new JPanel();
		Image imageright=ImageIO.read(main.getClass().getResource("/images/8.jpg"));
		right=new BackgroundPanel(imageright);
		right.setBounds(98, 60, 37, 40);
		jp[6]=right;
		JPanel rightr=new JPanel();
		Image imagerightr=ImageIO.read(main.getClass().getResource("/images/8r.jpg"));
		rightr=new BackgroundPanel(imagerightr);
		rightr.setBounds(98, 60, 37, 40);
		jp[7]=rightr;
		co.add(jp[6]);
		
		JPanel shift=new JPanel();
		Image imageshift=ImageIO.read(main.getClass().getResource("/images/1.jpg"));
		shift=new BackgroundPanel(imageshift);
		shift.setBounds(24, 110, 92, 40);
		jp[8]=shift;
		JPanel shiftr=new JPanel();
		Image imageshiftr=ImageIO.read(main.getClass().getResource("/images/1r.jpg"));
		shiftr=new BackgroundPanel(imageshiftr);
		shiftr.setBounds(24, 110, 92, 40);
		jp[9]=shiftr;
		co.add(jp[8]);
		
		JPanel zkey=new JPanel();
		Image imagezkey=ImageIO.read(main.getClass().getResource("/images/2.jpg"));
		zkey=new BackgroundPanel(imagezkey);
		zkey.setBounds(24, 160, 37, 40);
		jp[10]=zkey;
		JPanel zkeyr=new JPanel();
		Image imagezkeyr=ImageIO.read(main.getClass().getResource("/images/2r.jpg"));
		zkeyr=new BackgroundPanel(imagezkeyr);
		zkeyr.setBounds(24, 160, 37, 40);
		jp[11]=zkeyr;
		co.add(jp[10]);
		
		JPanel xkey=new JPanel();
		Image imagexkey=ImageIO.read(main.getClass().getResource("/images/3.jpg"));
		xkey=new BackgroundPanel(imagexkey);
		xkey.setBounds(62, 160, 37, 40);
		jp[12]=xkey;
		JPanel xkeyr=new JPanel();
		Image imagexkeyr=ImageIO.read(main.getClass().getResource("/images/3r.jpg"));
		xkeyr=new BackgroundPanel(imagexkeyr);
		xkeyr.setBounds(62, 160, 37, 40);
		jp[13]=xkeyr;
		co.add(jp[12]);
		
		JPanel ckey=new JPanel();
		Image imageckey=ImageIO.read(main.getClass().getResource("/images/4.jpg"));
		ckey=new BackgroundPanel(imageckey);
		ckey.setBounds(98, 160, 37, 40);
		jp[14]=ckey;
		JPanel ckeyr=new JPanel();
		Image imageckeyr=ImageIO.read(main.getClass().getResource("/images/4r.jpg"));
		ckeyr=new BackgroundPanel(imageckeyr);
		ckeyr.setBounds(98, 160, 37, 40);
		jp[15]=ckeyr;
		co.add(jp[14]);
		
		//数组初始化
		num[0]=0;
		num[1]=0;
		num[2]=0;
		num[3]=0;
		num[4]=0;
		num[5]=0;
		num[6]=0;
		num[7]=0;
		
		//设置八个文字
		JLabel upl=new JLabel();
		upl.setText("上键："+num[0]+"次");
		upl.setBounds(24, 210, 200, 20);
		upl.setFont(new Font("宋体", Font.BOLD, 16));
		jl[0]=upl;
		co.add(jl[0]);
		
		JLabel downl=new JLabel();
		downl.setText("下键："+num[1]+"次");
		downl.setBounds(24, 230, 200, 20);
		downl.setFont(new Font("宋体", Font.BOLD, 16));
		jl[1]=downl;
		co.add(jl[1]);
		
		JLabel leftl=new JLabel();
		leftl.setText("左键："+num[2]+"次");
		leftl.setBounds(24, 250, 200, 20);
		leftl.setFont(new Font("宋体", Font.BOLD, 16));
		jl[2]=leftl;
		co.add(jl[2]);
		
		JLabel rightl=new JLabel();
		rightl.setText("右键："+num[3]+"次");
		rightl.setBounds(24, 270, 200, 20);
		rightl.setFont(new Font("宋体", Font.BOLD, 16));
		jl[3]=rightl;
		co.add(jl[3]);
		
		JLabel shiftl=new JLabel();
		shiftl.setText("低速键："+num[4]+"次");
		shiftl.setBounds(24, 290, 200, 20);
		shiftl.setFont(new Font("宋体", Font.BOLD, 16));
		jl[4]=shiftl;
		co.add(jl[4]);
		
		JLabel zkeyl=new JLabel();
		zkeyl.setText("射击键："+num[5]+"次");
		zkeyl.setBounds(24, 310, 200, 20);
		zkeyl.setFont(new Font("宋体", Font.BOLD, 16));
		jl[5]=zkeyl;
		co.add(jl[5]);
		
		JLabel xkeyl=new JLabel();
		xkeyl.setText("雷："+num[6]+"次");
		xkeyl.setBounds(24, 330, 200, 20);
		xkeyl.setFont(new Font("宋体", Font.BOLD, 16));
		jl[6]=xkeyl;
		co.add(jl[6]);
		
		JLabel ckeyl=new JLabel();
		ckeyl.setText("灵界："+num[7]+"次");
		ckeyl.setBounds(24, 350, 200, 20);
		ckeyl.setFont(new Font("宋体", Font.BOLD, 16));
		jl[7]=ckeyl;
		co.add(jl[7]);
		
		//设置监听
		GlobalScreen.registerNativeHook();
		GlobalScreen.addNativeKeyListener(new NativeKeyListener() {
			@Override
			public void nativeKeyPressed(NativeKeyEvent e) {
				int keyvalue=e.getKeyCode();
				switch(keyvalue){
				//上键
				case 57416:
					co.remove(jp[0]);
					co.add(jp[1]);
					co.remove(jl[0]);
					num[0]++;
					jl[0].setText("上键："+num[0]+"次");
					co.add(jl[0]);
					co.repaint();
					break;
				//上键
				case 57424:
					co.remove(jp[2]);
					co.add(jp[3]);
					co.remove(jl[1]);
					num[1]++;
					jl[1].setText("下键："+num[1]+"次");
					co.add(jl[1]);
					co.repaint();
					break;
				//左键
				case 57419:
					co.remove(jp[4]);
					co.add(jp[5]);
					co.remove(jl[2]);
					num[2]++;
					jl[2].setText("左键："+num[2]+"次");
					co.add(jl[2]);
					co.repaint();
					break;
				//右键
				case 57421:
					co.remove(jp[6]);
					co.add(jp[7]);
					co.remove(jl[3]);
					num[3]++;
					jl[3].setText("右键："+num[3]+"次");
					co.add(jl[3]);
					co.repaint();
					break;
				//shift键
				case 42:
					co.remove(jp[8]);
					co.add(jp[9]);
					co.remove(jl[4]);
					num[4]++;
					jl[4].setText("低速键："+num[4]+"次");
					co.add(jl[4]);
					co.repaint();
					break;
				//z键
				case 44:
					co.remove(jp[10]);
					co.add(jp[11]);
					co.remove(jl[5]);
					num[5]++;
					jl[5].setText("射击键："+num[5]+"次");
					co.add(jl[5]);
					co.repaint();
					break;
				//x键
				case 45:
					co.remove(jp[12]);
					co.add(jp[13]);
					co.remove(jl[6]);
					num[6]++;
					jl[6].setText("雷："+num[6]+"次");
					co.add(jl[6]);
					co.repaint();
					break;
				//c键
				case 46:
					co.remove(jp[14]);
					co.add(jp[15]);
					co.remove(jl[7]);
					num[7]++;
					jl[7].setText("灵界："+num[7]+"次");
					co.add(jl[7]);
					co.repaint();
					break;
				}
			}

			@Override
			public void nativeKeyReleased(NativeKeyEvent e) {
				int keyvalue=e.getKeyCode();
				switch(keyvalue){
				//上键
				case 57416:
					co.remove(jp[1]);
					co.add(jp[0]);
					co.repaint();
					break;
				//上键
				case 57424:
					co.remove(jp[3]);
					co.add(jp[2]);
					co.repaint();
					break;
				//左键
				case 57419:
					co.remove(jp[5]);
					co.add(jp[4]);
					co.repaint();
					break;
				//右键
				case 57421:
					co.remove(jp[7]);
					co.add(jp[6]);
					co.repaint();
					break;
				//shift键
				case 42:
					co.remove(jp[9]);
					co.add(jp[8]);
					co.repaint();
					break;
				//z键
				case 44:
					co.remove(jp[11]);
					co.add(jp[10]);
					co.repaint();
					break;
				//x键
				case 45:
					co.remove(jp[13]);
					co.add(jp[12]);
					co.repaint();
					break;
				//c键
				case 46:
					co.remove(jp[15]);
					co.add(jp[14]);
					co.repaint();
					break;
				}
			}

			@Override
			public void nativeKeyTyped(NativeKeyEvent e) {
			}
		});
				
		//显示窗口
		main.setVisible(true);
	}
}
