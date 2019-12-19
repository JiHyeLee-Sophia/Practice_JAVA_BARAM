import java.awt.Container;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class BaramWindow extends JFrame implements KeyListener, Runnable {
	Container container = getContentPane();
	Toolkit tk = Toolkit.getDefaultToolkit();
	Image mouse = tk.getImage("img/마우스.png");
	Cursor myCursor = tk.createCustomCursor(mouse, new Point(10, 10), "Baram");

	JPanel panel;

	JButton buttonC = new JButton();
	JButton buttonD = new JButton();
	JButton buttonDD = new JButton();
	Box boxD = Box.createVerticalBox();
	Thread thread = new Thread(this);
	int a = 0;
	int d = 0;
	boolean m = false;
	boolean woe = false;

	public BaramWindow() {
		setTitle("바람의 나라");
		setSize(1100, 800);

		Dimension dimension1 = tk.getScreenSize();
		Dimension dimension2 = this.getSize();

		int x = (int) (dimension1.getWidth() / 2 - dimension2.getWidth() / 2);
		int y = (int) (dimension1.getHeight() / 2 - dimension2.getHeight() / 2);
		setLocation(x, y);
		setVisible(true);
		setCursor(myCursor);
		init();
		start();
	}

	private void init() {
		panel = new JPanel() {
			@Override
			protected void paintComponent(Graphics arg0) {
				super.paintComponent(arg0);
				Image image = new ImageIcon("img/배경.png").getImage();
				setOpaque(false);
				arg0.drawImage(image, 0, 0, getWidth(), getHeight(), this);
			}
		};
		container.add(panel);
		panel.setLayout(null);
		panel.add(buttonC);
		buttonC.setIcon(new ImageIcon("img/앞1.png"));
		buttonC.setLocation(100, 100);
		buttonC.setSize(165, 255);
		buttonC.setContentAreaFilled(false);
		buttonC.setBorderPainted(false);
		buttonC.setFocusPainted(false);
		buttonC.requestFocus();

		panel.add(boxD);
		boxD.add(buttonDD);
		boxD.add(buttonD);
		boxD.setLocation(500, 400);
		boxD.setSize(100, 100);

		buttonD.setIcon(new ImageIcon("img/다람쥐.png"));
		buttonD.setContentAreaFilled(false);
		buttonD.setBorderPainted(false);
		buttonD.setFocusPainted(false);
		buttonD.setSize(72, 45);

		buttonDD.setContentAreaFilled(false);
		buttonDD.setBorderPainted(false);
		buttonDD.setFocusPainted(false);
		buttonDD.setSize(72, 30);

		thread.start();

	}

	public void run() {
		while (true) {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			if (boxD.getX() <= 50) {
				boxD.setLocation(50, 200);
			} else {
				boxD.setLocation(boxD.getX() - 20, boxD.getY());

			}
		}
	}

	private void start() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		buttonC.addKeyListener(this);
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		if (arg0.getKeyCode() == KeyEvent.VK_LEFT) {
			woe = true; // 왼쪽은 woe=true
			if (a == 0) {
				if (m) {
					buttonC.setIcon(new ImageIcon("img/말타기좌3.png"));
				} else {
					buttonC.setIcon(new ImageIcon("img/좌3.png"));
				}
				a = 1;
				if (buttonC.getX() < 10) {
					buttonC.setLocation(10, buttonC.getY());
				}
			} else if (a == 1) {
				if (m) {
					buttonC.setIcon(new ImageIcon("img/말타기좌2.png"));
				} else {
					buttonC.setIcon(new ImageIcon("img/좌2.png"));
				}
				buttonC.setLocation(buttonC.getX() - 10, buttonC.getY());
				a = 2;
			} else if (a == 2) {
				if (m) {
					buttonC.setIcon(new ImageIcon("img/말타기좌3.png"));
				} else {
					buttonC.setIcon(new ImageIcon("img/좌3.png"));
				}
				buttonC.setLocation(buttonC.getX() - 10, buttonC.getY());
				a = 3;
			} else if (a == 3) {
				if (m) {
					buttonC.setIcon(new ImageIcon("img/말타기좌4.png"));
				} else {
					buttonC.setIcon(new ImageIcon("img/좌4.png"));
				}
				buttonC.setLocation(buttonC.getX() - 10, buttonC.getY());
				a = 0;
			}
		} else if (arg0.getKeyCode() == KeyEvent.VK_RIGHT) {
			woe = false;// 오른쪽은 woe=false
			if (a == 0) {
				if (m) {
					buttonC.setIcon(new ImageIcon("img/말타기우3.png"));
				} else {
					buttonC.setIcon(new ImageIcon("img/우3.png"));
				}
				a = 1;
				if (buttonC.getX() > 910) {
					buttonC.setLocation(910, buttonC.getY());
				}
			} else if (a == 1) {
				if (m) {
					buttonC.setIcon(new ImageIcon("img/말타기우2.png"));
				} else {
					buttonC.setIcon(new ImageIcon("img/우2.png"));
				}
				buttonC.setLocation(buttonC.getX() + 10, buttonC.getY());
				a = 2;
			} else if (a == 2) {
				if (m) {
					buttonC.setIcon(new ImageIcon("img/말타기우3.png"));
				} else {
					buttonC.setIcon(new ImageIcon("img/우3.png"));
				}
				buttonC.setLocation(buttonC.getX() + 10, buttonC.getY());
				a = 3;
			} else if (a == 3) {
				if (m) {
					buttonC.setIcon(new ImageIcon("img/말타기우4.png"));
				} else {
					buttonC.setIcon(new ImageIcon("img/우4.png"));
				}
				buttonC.setLocation(buttonC.getX() + 10, buttonC.getY());
				a = 0;
			}
		} else if (arg0.getKeyCode() == KeyEvent.VK_UP) {
			if (a == 0) {
				if (m) {
					buttonC.setIcon(new ImageIcon("img/말타기뒤3.png"));
				} else {
					buttonC.setIcon(new ImageIcon("img/뒤3.png"));
				}
				a = 1;
				if (buttonC.getY() < 10) {
					buttonC.setLocation(buttonC.getX(), 10);
				}
			} else if (a == 1) {
				if (m) {
					buttonC.setIcon(new ImageIcon("img/말타기뒤1.png"));
				} else {
					buttonC.setIcon(new ImageIcon("img/뒤1.png"));
				}
				buttonC.setLocation(buttonC.getX(), buttonC.getY() - 10);
				a = 2;
			} else if (a == 2) {
				if (m) {
					buttonC.setIcon(new ImageIcon("img/말타기뒤3.png"));
				} else {
					buttonC.setIcon(new ImageIcon("img/뒤3.png"));
				}
				buttonC.setLocation(buttonC.getX(), buttonC.getY() - 10);
				a = 3;
			} else if (a == 3) {
				if (m) {
					buttonC.setIcon(new ImageIcon("img/말타기뒤2.png"));
				} else {
					buttonC.setIcon(new ImageIcon("img/뒤2.png"));
				}
				buttonC.setLocation(buttonC.getX(), buttonC.getY() - 10);
				a = 0;
			}
		} else if (arg0.getKeyCode() == KeyEvent.VK_DOWN) {
			if (a == 0) {
				if (m) {
					buttonC.setIcon(new ImageIcon("img/말타기앞3.png"));
				} else {
					buttonC.setIcon(new ImageIcon("img/앞3.png"));
				}
				a = 1;
				if (buttonC.getY() > 460) {
					buttonC.setLocation(buttonC.getX(), 460);
				}
			} else if (a == 1) {
				if (m) {
					buttonC.setIcon(new ImageIcon("img/말타기앞1.png"));
				} else {
					buttonC.setIcon(new ImageIcon("img/앞1.png"));
				}
				buttonC.setLocation(buttonC.getX(), buttonC.getY() + 10);
				a = 2;
			} else if (a == 2) {
				if (m) {
					buttonC.setIcon(new ImageIcon("img/말타기앞3.png"));
				} else {
					buttonC.setIcon(new ImageIcon("img/앞3.png"));
				}
				buttonC.setLocation(buttonC.getX(), buttonC.getY() + 10);
				a = 3;
			} else if (a == 3) {
				if (m) {
					buttonC.setIcon(new ImageIcon("img/말타기앞2.png"));
				} else {
					buttonC.setIcon(new ImageIcon("img/앞2.png"));
				}
				buttonC.setLocation(buttonC.getX(), buttonC.getY() + 10);
				a = 0;
			}
		} else if (arg0.getKeyCode() == KeyEvent.VK_SHIFT) {
			String str2 = "";
			String str1 = "";
			if (!woe) {
				str2 = "img/사냥우2.png";
				str1 = "img/사냥우1.png";
			} else {
				str2 = "img/사냥좌2.png";
				str1 = "img/사냥좌1.png";
			}
			dependsWoE(str2, str1);

			int abNumX = Math.abs(boxD.getX() - buttonC.getX());
			int abNumY = Math.abs(boxD.getY() + boxD.getHeight()) - (buttonC.getY() + buttonC.getHeight());

			if (abNumX <= 100 && abNumY <= 100) {
				if (d < -80) {
					buttonD.setIcon(new ImageIcon("img/도토리.png"));
					thread.stop();
				} else {
					d -= 20;
					String str = String.valueOf(-20);
					buttonDD.setText(str);
					(new Thread() {
						@Override
						public void run() {
							try {
								Thread.sleep(1000);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
							buttonDD.setText("");
						}
					}).start();
				}
			}
		} else if (arg0.getKeyCode() == KeyEvent.VK_X) {
			if (!m) {
				buttonC.setIcon(new ImageIcon("img/말타기우3.png"));
				buttonC.setSize(127, 145);
				m = true;
			} else {
				buttonC.setIcon(new ImageIcon("img/우3.png"));
				buttonC.setSize(165, 255);
				m = false;
			}
		} else if (arg0.getKeyCode() == KeyEvent.VK_Z) {
			int abNumX = Math.abs(boxD.getX() - buttonC.getX());
			int abNumY = Math.abs((boxD.getY() + boxD.getHeight()) - (buttonC.getY() + buttonC.getHeight()));

			if (!woe) {
				buttonC.setIcon(new ImageIcon("img/앉기우1.png"));
				buttonC.setLocation(buttonC.getX(), buttonC.getY() + 10);
				if (abNumX <= 70 && abNumY <= 70) {
					boxD.setVisible(false);
				}
				(new Thread() {

	@Override
					public void run() {
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						buttonC.setIcon(new ImageIcon("img/우3.png"));
						buttonC.setLocation(buttonC.getX(), buttonC.getY() - 10);
					}
				}).start();

				boxD.setVisible(true);
				buttonD.setIcon(new ImageIcon("img/다람쥐.png"));
				boxD.setLocation(boxD.getX() + 100, boxD.getY() + 100);

			} else {
				buttonC.setIcon(new ImageIcon("img/앉기좌1.png"));
				buttonC.setLocation(buttonC.getX(), buttonC.getY() + 10);
				if (abNumX <= 50 && abNumY <= 50) {
					boxD.setVisible(false);
				}
				(new Thread() {
					@Override
					public void run() {
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						buttonC.setIcon(new ImageIcon("img/좌3.png"));
						buttonC.setLocation(buttonC.getX(), buttonC.getY() - 10);
					}
				}).start();
				boxD.setVisible(true);
				buttonD.setIcon(new ImageIcon("img/다람쥐.png"));

				Random random = new Random();
				int ranNum = random.nextInt(400);
				if (boxD.getX() + ranNum > 910) {
					boxD.setLocation(150, boxD.getY() + ranNum);
				} else if (boxD.getY() + ranNum > 460) {
					boxD.setLocation(boxD.getX() + ranNum, 150);
				} else {
					boxD.setLocation(boxD.getX() + ranNum, boxD.getY() + ranNum);
				}
				d = 0;
			
			}

		}

	}

	public void dependsWoE(String str2, String str1) {
		buttonC.setIcon(new ImageIcon(str2));
		buttonC.setSize(270, 255);
		if (woe) {
			buttonC.setLocation(buttonC.getX() - 100, buttonC.getY());
		}
		(new Thread() {
			@Override
			public void run() {
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				buttonC.setIcon(new ImageIcon(str1));
				// buttonC.setContentAreaFilled(false);
				buttonC.setSize(165, 255);
				if (woe) {
					buttonC.setLocation(buttonC.getX() + 100, buttonC.getY());
				}
			}
		}).start();

	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

}
