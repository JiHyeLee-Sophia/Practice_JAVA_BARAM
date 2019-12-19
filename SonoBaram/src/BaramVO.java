import javax.swing.Box;
import javax.swing.JButton;

public class BaramVO {
	JButton buttonD= new JButton();
	JButton buttonDD= new JButton();
	Box boxD=Box.createVerticalBox();
	
	
	public JButton getButtonD() {
		return buttonD;
	}
	public void setButtonD(JButton buttonD) {
		this.buttonD = buttonD;
	}
	public JButton getButtonDD() {
		return buttonDD;
	}
	public void setButtonDD(JButton buttonDD) {
		this.buttonDD = buttonDD;
	}
	public Box getBoxD() {
		return boxD;
	}
	public void setBoxD(Box boxD) {
		this.boxD = boxD;
	}
	
	
}
