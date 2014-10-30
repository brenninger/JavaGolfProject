import javax.swing.JFrame;


public abstract class buttons {

	private JFrame frame;
	public buttons() {
		
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
	public abstract void submit2();
	public abstract void clear();
	public abstract void clear2();
}
