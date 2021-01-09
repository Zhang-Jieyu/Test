package cn.edu.jsu.zjy.frm;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


//登录验证类
class LoginCheck{ 
	private String name;
	private String password;
	public LoginCheck(String name,String password) {
		this.name=name;
		this.password=password;
	}
	public boolean validate() {
		if("s1".equals(name)&&"123".equals(password)) {
			return true;
			
		}else {
			return false;
		}
	}
}

class Home{
	private JFrame f=new JFrame("主界面");
	private JButton submit=new JButton("登录");//按钮
	private JButton reset=new JButton("重置");//按钮

	private JLabel namelab=new JLabel("用户名");//标签
	private JLabel passlab=new JLabel("密    码");//标签
	private JLabel infolab=new JLabel("用户登录系统");//标签
	private JTextField nameText=new JTextField();//定义一个文本域
	private JPasswordField passText=new JPasswordField();//定义一个文本域
	public Home() {
		Font fnt=new Font("Serief",Font.BOLD,12);//定义显示字体
		infolab.setFont(fnt);
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(arg0.getSource()==submit) {//判断触发源是否是提交按钮
					String tname=nameText.getText();//得到输入的用户名
					//得到输入的密码，通过getPassword()返回字符数组
					String tpass=new String(passText.getPassword());
					//实例化LoginCheck对象，传入输入的用户名密码
					LoginCheck log=new LoginCheck(tname,tpass);
					if(log.validate()) {
						infolab.setText("登录成功");
					}else {
						infolab.setText("登录失败");
					}
				}
				if(arg0.getSource()==reset) {//判断触发源是否是重置按钮
					nameText.setText("");//清空文本框
					passText.setText("");//清空密码框
					infolab.setText("用户登录系统");//恢复标签显示
				}
			}
		});
		f.addWindowListener(new WindowAdapter() {//加入窗口监听
			//覆写窗口关闭方法
			public void windowClosing(WindowEvent arg0) {
				System.exit(1);
			}
		});
		f.setLayout(null);
		namelab.setBounds(5, 5, 60, 20);
		passlab.setBounds(5, 30, 60,20);
		infolab.setBounds(65,5, 220, 30);
		nameText.setBounds(65, 5, 100, 20);
		passText.setBounds(65, 30, 100, 20);
		submit.setBounds(165, 30, 60, 20);
		reset.setBounds(165, 30, 60, 20);
		f.add(namelab);
		f.add(passlab);
		f.add(infolab);
		f.add(nameText);
		f.add(passText);
		f.add(submit);
		f.add(reset);
		f.setSize(280, 130);
		f.setVisible(true);
	}
}
public class Room{			
	public static void main(String [] args) {
		new Home();
	}

	public String getMember() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getLeader() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getId() {
		// TODO Auto-generated method stub
		return null;
	}	
	}


