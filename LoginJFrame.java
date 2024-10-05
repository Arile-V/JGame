import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.*;
import java.lang.Object;

public class LoginJFrame extends JFrame implements ActionListener {
    //登录界面的类，写登录界面的代码
    JButton Jbt = new JButton();
    public LoginJFrame(Boolean TF){//构造方法
        //在创建登录界面的时候给这个界面设置信息
        this.setSize(488,430) ;
        this.setDefaultCloseOperation(2); //关闭方法
        Jbt.setBounds(200,320,100,50);
        Jbt.setText("登录");
        Jbt.addActionListener(this);
        this.getContentPane().add(Jbt);
        this.setAlwaysOnTop(true); //始终最前
        this.setLocationRelativeTo(null); //初始位置，null为居中
        this.setLayout(null);//取消默认布置模式
        this.setVisible(TF) ;
    }
    @Override
    public void actionPerformed(ActionEvent e){
        Object Click = e.getSource();
        if(Click == Jbt){
            new GameJFrame(true);
            this.setVisible(false);
        }
    }

}
