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


//��¼��֤��
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
	private JFrame f=new JFrame("������");
	private JButton submit=new JButton("��¼");//��ť
	private JButton reset=new JButton("����");//��ť

	private JLabel namelab=new JLabel("�û���");//��ǩ
	private JLabel passlab=new JLabel("��    ��");//��ǩ
	private JLabel infolab=new JLabel("�û���¼ϵͳ");//��ǩ
	private JTextField nameText=new JTextField();//����һ���ı���
	private JPasswordField passText=new JPasswordField();//����һ���ı���
	public Home() {
		Font fnt=new Font("Serief",Font.BOLD,12);//������ʾ����
		infolab.setFont(fnt);
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(arg0.getSource()==submit) {//�жϴ���Դ�Ƿ����ύ��ť
					String tname=nameText.getText();//�õ�������û���
					//�õ���������룬ͨ��getPassword()�����ַ�����
					String tpass=new String(passText.getPassword());
					//ʵ����LoginCheck���󣬴���������û�������
					LoginCheck log=new LoginCheck(tname,tpass);
					if(log.validate()) {
						infolab.setText("��¼�ɹ�");
					}else {
						infolab.setText("��¼ʧ��");
					}
				}
				if(arg0.getSource()==reset) {//�жϴ���Դ�Ƿ������ð�ť
					nameText.setText("");//����ı���
					passText.setText("");//��������
					infolab.setText("�û���¼ϵͳ");//�ָ���ǩ��ʾ
				}
			}
		});
		f.addWindowListener(new WindowAdapter() {//���봰�ڼ���
			//��д���ڹرշ���
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


