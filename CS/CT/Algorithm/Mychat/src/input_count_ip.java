import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.net.*;
import java.io.*;

//채팅신청할 서버의 ip와 portNum을 입력
public class input_count_ip {
	JFrame frame,setIP;
	JTextField IpNum_f;
	JTextField PortNum_f;
	int count_port;
	String count_ip = "127.0.0.1";
	String myname;
	Integer myport;
	JTextField IP;
	input_count_ip(String name,int port){
		myname = name;
		myport = port;
		this.ip_portNum();
	}
	
	public void ip_portNum(){
		frame = new JFrame();
		frame.setLocation(350,400);
		JLabel PortNum_l = new JLabel("접속할 서버의 Port : ");
		JButton b_myip = new JButton("IP설정 (기본IP : 127.0.0.1)");
		JLabel l_myport = new JLabel("my port number : "+myport.toString());
		PortNum_f = new JTextField(10);
		JButton b = new JButton("OK");
		frame.setLayout(new GridLayout(5,1));
		frame.add(PortNum_l);
		frame.add(PortNum_f);
		frame.add(l_myport);
		frame.add(b);
		frame.add(b_myip);
		frame.setSize(230,225);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocation(200,200);
		b.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				count_port = Integer.parseInt(PortNum_f.getText());
				//port, ip번호를 받았으므로 이제 상대방 서버에 접속하고 채팅창 생성
				accept_server_request asr = new accept_server_request(count_port,count_ip,myname);
				frame.dispose();
			}
		});
		b_myip.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				setIP = new JFrame();
				JLabel PortNum = new JLabel("IP를 입력해주세요");
				IP = new JTextField(10);
				setIP.setLayout(new GridLayout(3,1));
				setIP.add(PortNum);
				setIP.add(IP);
				JButton c = new JButton("OK");
				setIP.add(c);
				setIP.setSize(150,150);
				setIP.setVisible(true);
				c.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e) {
						count_ip = IP.getText();
						//port, ip번호를 받았으므로 이제 상대방 서버에 접속하고 채팅창 생성
						setIP.dispose();
					}
				});
			}
		});
	}
}