import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Counting extends JPanel{
	Timer timer;
	static JPanel countPanel;
	static JLabel clk_label;
	static int sec =30;
	static int min=1;
	static int mili =0;
	BufferedReader reader;
	static PrintWriter writer;
	static int i=0;
	public Counting(BufferedReader reader,final PrintWriter writer,final String s){
		this.reader = reader;
		this.writer = writer;
		setPreferredSize(new Dimension(10,50));
		timer = new Timer();
		countPanel = new JPanel();
		countPanel.setLayout(new FlowLayout());
		add(countPanel, BorderLayout.CENTER);
		clk_label = new JLabel(min+":"+sec+":"+mili);//시간표시 레이블
		countPanel.add(clk_label);
		JButton thin = new JButton ("▼");//초단위 감소 판넬
      	thin.addActionListener(
      		new ActionListener(){
      			public void actionPerformed(ActionEvent e){
      				down_timer();
      				writer.println("52131433");
      				writer.flush();
      			}
      		}
      	);
      	countPanel.add(thin);
      	JButton thick = new JButton ("▲");//초단위 증가 판넬
      	thick.addActionListener(//clear에 listen를 시켜준다.
      		new ActionListener(){
      			public void actionPerformed(ActionEvent e){
      				up_timer();
      				writer.println("52131444");
      				writer.flush();
      			}
      		}
      	);
      	countPanel.add(thick);
      	JButton start = new JButton ("START!");//초단위 증가 판넬
      	start.addActionListener(//clear에 listen를 시켜준다.
      		new ActionListener(){
      			public void actionPerformed(ActionEvent e){
      				startTimer(1000);
      				writer.println("52131415");
      				writer.flush();
      				JOptionPane.showMessageDialog(Counting.this,"정답은  "+ s,"정답",0);
       			}
      		}
      	);
      	countPanel.add(start);
	}
	public void up_timer(){
		WorkTask.up();
	}
	public void down_timer(){
		WorkTask.down();
	}
	public void reset_timer(){
		min = 0;
		sec = 0;
		mili = 5;
	}
	public void startTimer(int delay){
		timer.schedule(new WorkTask(), delay, 10);
	}
	
	public static class WorkTask extends TimerTask {
		private static void drawString(){
			clk_label.setText(min+":"+sec+":"+mili);
		}
		public static void up(){//시간 설정!
			sec++;
			if(sec==60){
				sec=0;
				min++;
			}
			drawString();
		}
		public static void down(){//시간 설정!
			if(sec==0){
				if(min >0){	
					min--;
					sec=59;
				}
			}
			else sec--;
			drawString();
		}
		@Override
		public void run() {//작동!
			drawString();
			if(mili == 0){
				if (sec == 0) {
					if (min >= 1) {
						sec = 59;
						min--;
					}
					else{
						cancel();
						min = 1;
						sec = 30;
						writer.println("52131555");
	      				writer.flush();
						drawString();
					}
				}
				else{
					mili =99;
					sec--;
				}
			}
			else mili--;
		}
	}
}