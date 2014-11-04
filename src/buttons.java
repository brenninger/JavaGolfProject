import javax.swing.JFrame;


public abstract class Buttons {

	private JFrame frame;
	public Buttons() {
		
	}
	
//	public void close(JFrame curFrame){
//		JFrame frame = curFrame;
//	}
	public JFrame getFrame(){
		return frame;
	}
	void setFrame(JFrame curFrame){
		frame = curFrame;
	}
	public void closeFrame(){
		frame.setVisible(false);
	}
	public void end(){
		System.exit(0);
	}
	public abstract void submit();
	public abstract void clear();
}
