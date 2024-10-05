
import java.util.Random;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.border.BevelBorder;
import java.awt.event.ActionListener;

public class GameJFrame extends JFrame implements KeyListener,ActionListener{
    
    int i = 0 ;
    int j = 0 ;
    int k = 1 ;
    int e = 0 ;
    int x = 0 ;
    int y = 0 ;
    int step = 0 ;

    //创建菜单选项下面的条目
    JMenuItem replayItem = new JMenuItem("重新游戏");
    JMenuItem reloginItem = new JMenuItem("重新登录");
    JMenuItem closeItem = new JMenuItem("退出");
    JMenuItem accountItem = new JMenuItem("公众号");


    int[] temparr = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,0};
    Random r = new Random();
    int[][] twoways = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,0}};
    int[][] win = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,0}};
    public GameJFrame(){
        init();

        JMenuBar jMenuBar = MenuInit();

        initImage(false);

        this.setJMenuBar(jMenuBar);
        //显示设置
        this.setVisible(true);
    }
    public GameJFrame(Boolean T){
        init();

        JMenuBar jMenuBar = MenuInit();

        initImage(T);

        this.setJMenuBar(jMenuBar);
        //显示设置
        this.setVisible(true);
    }

    private JMenuBar MenuInit() {
        //初始化菜单
        //创建菜单对象
        JMenuBar jMenuBar = new JMenuBar();

        //创建选项对象
        JMenu functionJMenu = new JMenu("功能");
        JMenu aboutJMenu = new JMenu("关于我们");

        
        
        //把条目加入菜单
        functionJMenu.add(replayItem);
        functionJMenu.add(reloginItem);
        functionJMenu.add(closeItem);

        aboutJMenu.add(accountItem);

        //给条目添加动作监听

        replayItem.addActionListener(this);
        reloginItem.addActionListener(this);
        closeItem.addActionListener(this);
        accountItem.addActionListener(this);

        //把选项添加到菜单条里面

        jMenuBar.add(functionJMenu);
        jMenuBar.add(aboutJMenu);
        return jMenuBar;
    }

    private void init() {
        this.setSize(603,680);
        this.setTitle("拼图"); //设置标题
        this.setAlwaysOnTop(true); //始终最前
        this.setLocationRelativeTo(null); //初始位置，null为居中
        this.setDefaultCloseOperation(2); //关闭方法 0不能关 1默认设置 2是所有窗口关闭时才关闭虚拟机 3是关闭时完全关闭虚拟机
        this.setLayout(null);//取消默认布置模式
        this.addKeyListener(this);
    }

    private void initImage(int[][] twoways){

        this.getContentPane().removeAll();

        JLabel StepCount = new JLabel("步数:" + this.step);
        StepCount.setBounds(50, 30, 100, 20);
        this.getContentPane().add(StepCount);
        
        if(victory()){
            //显示win
            JLabel winJLabel = new JLabel(new ImageIcon("Game.ui\\好照片\\win.png"));
            winJLabel.setBounds(203, 283, 105, 105);
            winJLabel.setBorder(new BevelBorder(0));
            this.getContentPane().add(winJLabel);
        }

        int i,j;
        for(i=0;i<4;i+=1){
            for(j=0;j<4;j+=1){
            
            //创建JLabel对象(管理容器
           JLabel jLabel1 = new JLabel(new ImageIcon("Game.ui\\好照片\\"+twoways[i][j]+".png"));
           if(twoways[i][j] == 0){
                this.x = i ;
                this.y = j ;
           }
            //指定位置
            jLabel1.setBounds(85+105*j, 105+105*i, 105, 105);
            //添加边框
            jLabel1.setBorder(new BevelBorder(1));
            //把管理容器添加到界面中
            this.getContentPane().add(jLabel1);
            }
        }
        this.getContentPane().repaint();
    }

    private void initImage(Boolean TF){

        this.getContentPane().removeAll();
        JLabel StepCount = new JLabel("步数:" + this.step);
        StepCount.setBounds(50, 30, 100, 20);
        this.getContentPane().add(StepCount);

        if(TF){
            for(i = 0; i < temparr.length; i++){
                int index = r.nextInt(temparr.length);
                int temp = temparr[i] ;
                temparr[i] = temparr[index] ;
                temparr[index] = temp ;
            }
            for(e=0;e<4;e+=1){
                for(j=0;j<4;j+=1){
                    twoways[e][j] = temparr[k-1] ;
                    k+=1;
                }
            }
            for(i=0;i<4;i+=1){
                for(j=0;j<4;j+=1){
                
                //创建JLabel对象(管理容器
               JLabel jLabel1 = new JLabel(new ImageIcon("Game.ui\\好照片\\"+twoways[i][j]+".png"));
                k+=1;
                if(twoways[i][j] == 0){
                    this.x = i ;
                    this.y = j ;
               }
                //指定位置
                jLabel1.setBounds(85+105*j, 105+105*i, 105, 105);
                //添加边框
                jLabel1.setBorder(new BevelBorder(1));
                //把管理容器添加到界面中
                this.getContentPane().add(jLabel1);
                }
            }
        }else{
            for(i=0;i<4;i+=1){
                for(j=0;j<4;j+=1){
                
                //创建JLabel对象(管理容器
               JLabel jLabel1 = new JLabel(new ImageIcon("Game.ui\\好照片\\"+twoways[i][j]+".png"));
                k+=1;
                //指定位置
                jLabel1.setBounds(85+105*j, 105+105*i, 105, 105);
                //添加边框
                jLabel1.setBorder(new BevelBorder(1));
                //把管理容器添加到界面中
                this.getContentPane().add(jLabel1);
                }
            }
        }
        this.getContentPane().repaint();
        k = 1;
    }
    @Override
    public void keyPressed(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }
    @Override
    public void keyReleased(KeyEvent e) {
        if(victory()){
            return;
        }
        int code = e.getKeyCode();
        if (code == 37) {//向左
            System.out.println("向左"+x+y);
            if(x<4 & y<4 & x>=0 & y >=0){
                if(y == 3 ){
                    return ;
                }
                twoways[x][y] = twoways[x][y + 1];
                twoways[x][y + 1] = 0 ;
                y ++ ;
                step++ ;
            }
        }else if(code ==38 ){//向上
            System.out.println("向上"+x+y);
            if(x<4 & y<4 & x>=0 & y >=0){
                if(x == 3 ){
                    return ;
                }
                twoways[x][y] = twoways[x + 1][y];
                twoways[x + 1 ][y] = 0 ;
                x ++ ;
                step++ ;
            }
        }else if(code == 39){//向右
            System.out.println("向右"+x+y);
            if(x<4 & y<4 & x>=0 & y >=0){
                if(y == 0 ){
                    return ;
                }
                twoways[x][y] = twoways[x][y - 1];
                twoways[x][y - 1] = 0 ;
                y -- ;
                step++ ;
            }
        }else if(code == 40){//向下 
            if(x == 0 ){
                return ;
            }
            System.out.println("向下"+x+y);
            if(x<4 & y<4 & x>=0 & y >=0){
                twoways[x][y] = twoways[x - 1][y];
                twoways[x - 1][y] = 0 ;
                x -- ;
                step++ ;
            }
        }else if(code == 87){
            twoways = win ;
        }
        initImage(twoways);
    }
    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }

    public boolean victory(){
        for(int i = 0; i < twoways.length ; i ++){
            for(int j = 0 ; j < twoways[i].length ; j++){
                //
                if(twoways[i][j] != win[i][j] ){
                    return false ;
                }
            }
        }
        return true ;
    }

    @Override

    public void actionPerformed(ActionEvent e){
        Object Click = e.getSource();

        if(Click == replayItem){
            this.step = 0 ;
            initImage(true);
        }else if(Click == reloginItem){
            System.out.println("重新登录");
            this.setVisible(false);
            new LoginJFrame(true);
        }else if(Click == closeItem){
            System.exit(0);
        }else if(Click == accountItem){
            JDialog jDialog = new JDialog();
            JLabel jLabel = new JLabel("我自己出品");
            jLabel.setBounds(200,100,100,20);
            jDialog.getContentPane().add(jLabel);
            jDialog.setSize(300, 220);
            jDialog.setAlwaysOnTop(true);
            jDialog.setLocationRelativeTo(null);
            jDialog.setModal(true);
            jDialog.setVisible(true);
        }

    }
}