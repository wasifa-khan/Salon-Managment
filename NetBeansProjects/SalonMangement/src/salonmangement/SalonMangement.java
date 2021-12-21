import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JFrame;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Salon_Project {
public static void main(String[] args) {
new Login();
}
}
public class Login extends JFrame implements ActionListener, KeyListener, FocusListener{
JButton ok,image;
JLabel login_username, login_password, error;
JTextField text_username;
JPasswordField text_password;
JPanel p1, p2, pf;

Login(){
setSize(600, 300);
setTitle("Login");
ok = new JButton("Login"); ok.addActionListener(this); ok.addKeyListener(this);
image = new JButton();


image.setBorder(BorderFactory.createEmptyBorder());
ImageIcon imgs = new ImageIcon(((new ImageIcon("E:\\Pic\\barber.jpg").getImage()
.getScaledInstance(160, 180, Image.SCALE_SMOOTH))));
image.setIcon(imgs);


error = new JLabel(); error.setForeground(Color.RED);
login_username = new JLabel(" Username "); 
login_password = new JLabel(" Password ");


text_username = new JTextField(15); text_username.addKeyListener(this);
text_username.addFocusListener(this);
text_password = new JPasswordField(15); text_password.setEchoChar('*');
text_password.addFocusListener(this);


Font f1 = new Font("TimesRoman", Font.BOLD, 18);
Font f2 = new Font("TimesRoman", Font.PLAIN, 18);


login_username.setFont(f1); login_username.setForeground(Color.darkGray);
login_password.setFont(f1); login_password.setForeground(Color.darkGray);
text_username.setFont(f2);
text_password.setFont(f2);
ok.setFont(f1); ok.setForeground(Color.darkGray); ok.setBackground(Color.CYAN);


p1 = new JPanel();
p2 = new JPanel(new GridBagLayout());
pf = new JPanel(new GridBagLayout());


GridBagConstraints c = new GridBagConstraints();
p1.add(image);


c.insets = new Insets(20,0,0,0);
c.gridx = 0; c.gridy = 0; p2.add(login_username, c);
c.gridx = 1; c.gridy = 0; p2.add(text_username, c);
c.gridx = 0; c.gridy = 1; p2.add(login_password, c);
c.gridx = 1; c.gridy = 1; p2.add(text_password, c);
c.gridx = 1; c.gridy = 2; c.anchor= GridBagConstraints.CENTER; p2.add(ok, c);
c.gridx = 1; c.gridy = 3; p2.add(error, c);


p1.setBackground(Color.white);
p2.setBackground(Color.white);
pf.setBackground(Color.white);
pf.add(p1); pf.add(p2);


this.getContentPane().add(pf);
setVisible(true);
this.setDefaultCloseOperation(EXIT_ON_CLOSE);
}


@Override
public void actionPerformed(ActionEvent ae) {
if(ae.getSource() == ok){
String user = text_username.getText();
String pass = text_password.getText();
if(user.equals("admin") && pass.equals("1234"))
{
this.setVisible(false);
new SalonShop();
}
else 
{
error.setText("Username or Password is not correct");
}
}
}


@Override
public void keyTyped(KeyEvent ke) {
char ch;
ch = ke.getKeyChar();
if((ch < 'a' || ch > 'z') && (ch != '\b')){
ke.consume();
}
}


@Override
public void keyPressed(KeyEvent ke) {
if(ke.getSource() == ok){
if(ke.getKeyCode() == KeyEvent.VK_ENTER) {
ok.doClick();
}
}
}


@Override
public void keyReleased(KeyEvent ke) { }


@Override
public void focusGained(FocusEvent fe) {
if(fe.getSource().equals(text_username) || fe.getSource().equals(text_password)){
error.setText("");
}
}


@Override
public void focusLost(FocusEvent fe) { }
}



public class Customer {
private String name;
private double serviceCharges;
private double productCharges;
SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
private Date date = new Date();

public Customer(String name, Date date, double serviceCharges, double productCharges){
this.name = name;
this.date = date;
this.serviceCharges = serviceCharges;
this.productCharges = productCharges;

}
public Customer(){ }

public void setName(String name){
this.name = name;
}
public String getName(){
return name;
}
public void setDate(Date date){
this.date = date;
}
public String getDate(){
return formatter.format(date);
}
public void setServiceCharges(double serviceCharges){
this.serviceCharges = serviceCharges;
}
public double getServiceCharges(){
return serviceCharges;
}
public void setProductCharges(double productCharges){
this.productCharges = productCharges;
}
public double getProductCharges(){
return productCharges;
}

public double getTotalExpense(){
return getProductCharges() + getServiceCharges();
}
public String toString(){
return " Customer Name: " + name + 
"\n MemberShip: Customer " + "\nDate: " + getDate() + "\n Service Charges " + 
getServiceCharges() + "\nProduct Charges: " + getProductCharges();
}
public String printCustomerBill(){
return toString() + "\n Total = " + getTotalExpense() + 
"\n________________________________________________\n";
}





class SalonShop extends JFrame implements ActionListener{
JToolBar tb;
JButton cus_add, show_bill, login_back, history, sp1,sp2,sp3;
JPanel p, pf;

Customer cus = new Customer();
Date d = new Date();
Font f = new Font("TimesRoman", Font.BOLD, 25);
Font f1 = new Font("TimesRoman", Font.BOLD, 18);
Font f2 = new Font("TimesRoman", Font.PLAIN, 18);

public SalonShop(){
super.setLayout(new BorderLayout());
tb = new JToolBar();

cus_add = new JButton(); cus_add.addActionListener(this);
show_bill = new JButton(); show_bill.addActionListener(this);
history = new JButton(); history.addActionListener(this);
login_back = new JButton(); login_back.addActionListener(this);

cus_add.setBorder(BorderFactory.createEmptyBorder()); 
ImageIcon imgc = new ImageIcon(((new ImageIcon("E:\\Pic\\addcustomerr.png").getImage()
.getScaledInstance(100, 100, Image.SCALE_SMOOTH))));
cus_add.setIcon(imgc);

show_bill.setBorder(BorderFactory.createEmptyBorder());
ImageIcon imgc2 = new ImageIcon(((new ImageIcon("E:\\Pic\\bill.jpeg").getImage()
.getScaledInstance(100, 100, Image.SCALE_SMOOTH))));
show_bill.setIcon(imgc2);

history.setBorder(BorderFactory.createEmptyBorder());
ImageIcon imgc3 = new ImageIcon(((new ImageIcon("E:\\Pic\\His.png").getImage()
.getScaledInstance(100, 100, Image.SCALE_SMOOTH))));
history.setIcon(imgc3);

login_back.setBorder(BorderFactory.createEmptyBorder());
ImageIcon imgc4 = new ImageIcon(((new ImageIcon("E:\\Pic\\llog.png").getImage()
.getScaledInstance(100, 100, Image.SCALE_SMOOTH))));
login_back.setIcon(imgc4);

p = new JPanel(new GridBagLayout());
GridBagConstraints c = new GridBagConstraints();
c.insets = new Insets(0, 0, 0, 10);
c.gridx = 0; c.gridy = 0; p.add(cus_add, c);
c.gridx = 1; c.gridy = 0; p.add(show_bill, c);
c.gridx = 2; c.gridy = 0; p.add(history, c);
c.gridx = 3; c.gridy = 0; p.add(login_back, c);

p.setBackground(Color.WHITE);
tb.setBackground(Color.WHITE);
tb.add(p);

//Final Panel 
pf = new JPanel(); pf.setBackground(Color.WHITE);
this.getContentPane().add(pf);

super.add(tb, BorderLayout.NORTH);
setTitle(" Salon Shop ");
super.setSize(750, 600);
this.setDefaultCloseOperation(EXIT_ON_CLOSE);
super.setVisible(true);
}

CustomerPanel cp;
BillPanel bp;
HistoryPanel hp;

@Override
public void actionPerformed(ActionEvent ae) {
if(ae.getSource().equals(cus_add)){
pf.removeAll();
pf.repaint();
pf.revalidate();

try{
cp = new CustomerPanel(cus);
pf.add(cp, BorderLayout.CENTER);
pf.repaint();
pf.revalidate();
}catch(Exception e){

}
}
else if(ae.getSource().equals(show_bill)){
pf.removeAll();
pf.repaint();
pf.revalidate();

try{
bp = new BillPanel(cus);
pf.add(bp, BorderLayout.CENTER);
pf.repaint();
pf.revalidate();
}catch(Exception e){

}
}
else if(ae.getSource().equals(history)){
pf.removeAll();
pf.repaint();
pf.revalidate();

try{
hp = new HistoryPanel();
pf.add(hp, BorderLayout.CENTER);
pf.repaint();
pf.revalidate();
}catch(Exception ex){
System.out.println(ex.getMessage());
}
}
else if(ae.getSource().equals(login_back)){
this.setVisible(false);
new Login();
}
}

}



public class CustomerPanel extends JPanel{
JButton add, sp1, sp2, sp3;
JTextField t_name, t_servCharges;
JLabel cus_name, serv_charges, select_style, detail, date;
JRadioButton rb1, rb2, rb3;
ButtonGroup g1;
JPanel p2;

Connection con;
Date d = new Date();
Font f = new Font("TimesRoman", Font.BOLD, 25);
Font f1 = new Font("TimesRoman", Font.BOLD, 18);
Font f2 = new Font("TimesRoman", Font.PLAIN, 18);

public CustomerPanel(Customer cus){
detail = new JLabel(" Customer Details ");
date= new JLabel(); date.setText(cus.getDate());
cus_name = new JLabel(" Customer Name ");
t_name = new JTextField(15);
serv_charges = new JLabel(" Service Charges ");
t_servCharges = new JTextField(8);
select_style = new JLabel(" Select Hair Style ");
rb1 = new JRadioButton(" 1500 "); rb1.setBackground(Color.WHITE);
rb2 = new JRadioButton(" 1000 "); rb2.setBackground(Color.WHITE);
rb3 = new JRadioButton(" 700 "); rb3.setBackground(Color.WHITE);
g1 = new ButtonGroup();
g1.add(rb1); g1.add(rb2); g1.add(rb3);
add = new JButton(" Add ");
//ActionListener in add button
add.addActionListener(new ActionListener(){
@Override
public void actionPerformed(ActionEvent ae) {
cus.setName(t_name.getText());
cus.setProductCharges(Double.parseDouble(t_servCharges.getText()));

//Checked Selected Radio Button
String radioB_select="";
if(rb1.isSelected()){ radioB_select= rb1.getText(); }
if(rb2.isSelected()){ radioB_select= rb2.getText(); }
if(rb3.isSelected()){ radioB_select= rb3.getText(); }
cus.setServiceCharges(Double.parseDouble(radioB_select));
sp1 = new JButton(); sp2 = new JButton(); sp3 = new JButton();

//Hair Icon Add
sp1.setBorder(BorderFactory.createEmptyBorder());
ImageIcon im1 = new ImageIcon(((new ImageIcon("E:\\Pic\\H6.jfif").getImage()
.getScaledInstance(45, 45, Image.SCALE_SMOOTH))));
sp1.setIcon(im1);

sp2.setBorder(BorderFactory.createEmptyBorder());
ImageIcon im2 = new ImageIcon(((new ImageIcon("E:\\Pic\\H5.jfif").getImage()
.getScaledInstance(60, 60, Image.SCALE_SMOOTH))));
sp2.setIcon(im2);

sp3.setBorder(BorderFactory.createEmptyBorder());
ImageIcon im3 = new ImageIcon(((new ImageIcon("E:\\Pic\\H6.jfif").getImage()
.getScaledInstance(45, 45, Image.SCALE_SMOOTH))));
sp3.setIcon(im3);

detail.setFont(f);
date.setFont(f1);
cus_name.setFont(f1);
serv_charges.setFont(f1);
select_style.setFont(f1);
add.setFont(f1); add.setBackground(Color.CYAN);
t_name.setFont(f1);
t_servCharges.setFont(f1);

this.setLayout(new GridBagLayout());
p2 = new JPanel();

p2.add(rb1); p2.add(sp1);
p2.add(rb2); p2.add(sp2);
p2.add(rb3); p2.add(sp3);
p2.setBackground(Color.WHITE);

GridBagConstraints c1 = new GridBagConstraints();
c1.insets = new Insets(20,0,0,0);
c1.anchor = GridBagConstraints.LINE_START;
c1.gridx = 0; c1.gridy = 0; this.add(detail, c1);
c1.gridx = 0; c1.gridy = 1; this.add(date, c1);
c1.gridx = 0; c1.gridy = 2; this.add(cus_name, c1);
c1.gridx = 1; c1.gridy = 2; this.add(t_name, c1);
c1.gridx = 0; c1.gridy = 3; this.add(select_style, c1);
c1.gridx = 1; c1.gridy = 3; this.add(p2, c1);
c1.gridx = 0; c1.gridy = 4; this.add(serv_charges, c1);
c1.gridx = 1; c1.gridy = 4; this.add(t_servCharges, c1);
c1.gridx = 1; c1.gridy = 5; this.add(add, c1);
this.setBackground(Color.WHITE);
}
}





public class BillPanel extends JPanel{
Date d = new Date();
Font f = new Font("TimesRoman", Font.BOLD, 25);
Font f1 = new Font("TimesRoman", Font.BOLD, 18);
Font f2 = new Font("TimesRoman", Font.PLAIN, 18);

public BillPanel(Customer cus){
try{
if(cus.getName().equals("")){

}
else{
JTextArea print_Bill = new JTextArea(cus.printCustomerBill());
print_Bill.setFont(f2); print_Bill.setEditable(false);
this.setBackground(Color.WHITE);
this.add(print_Bill);
}
}catch(NullPointerException e){
JLabel noFound = new JLabel(" No Customer Found !! "); 
noFound.setFont(f2);
this.add(noFound);
}
}
}



public class HistoryPanel extends JPanel{
JPanel customerdb, ScroolForPane;
JLabel namedb, datedb, servicedb, productdb, name, serv_charges, date, product_charges, total,
dbTotal, endline;
Connection con;

Font f1 = new Font("TimesRoman", Font.BOLD, 18);
Font f2 = new Font("TimesRoman", Font.PLAIN, 18);

HistoryPanel() {
this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
this.setPreferredSize(new Dimension(735, 450));

ScroolForPane = new JPanel();
ScroolForPane.setLayout(new BoxLayout(ScroolForPane, BoxLayout.PAGE_AXIS));
while(rs.next()){
customerdb = new JPanel();
customerdb.setLayout( new GridBagLayout());
customerdb.setPreferredSize(new Dimension(200, 150));
customerdb.setBackground(Color.WHITE);

name = new JLabel(" Name " ); name.setFont(f1);
date = new JLabel(" Date "); date.setFont(f1);
serv_charges = new JLabel(" Service Charges "); serv_charges.setFont(f1);
product_charges = new JLabel(" Product Charges "); product_charges.setFont(f1);
total = new JLabel(" Total "); total.setFont(f1);
endline = new JLabel(" ************************"); endline.setFont(f1);

namedb = new JLabel(); namedb.setFont(f2);
datedb = new JLabel(); namedb.setFont(f2);
servicedb = new JLabel(); namedb.setFont(f2);
productdb = new JLabel(); namedb.setFont(f2);
dbTotal = new JLabel(); namedb.setFont(f2);

namedb.setText(rs.getObject("Name").toString());
datedb.setText(rs.getObject("Date").toString());
servicedb.setText(rs.getObject("ServiceCharges").toString());
productdb.setText(rs.getObject("ProductCharges").toString());
Double t;
t = Double.parseDouble(rs.getObject("ServiceCharges").toString()) + 
Double.parseDouble(rs.getObject("ProductCharges").toString());
dbTotal.setText("" + t);

GridBagConstraints c = new GridBagConstraints();
c.anchor = GridBagConstraints.LINE_START;
c.insets = new Insets(5,20,0,20);
c.gridx = 0; c.gridy = 0; customerdb.add(name, c);
c.gridx = 1; c.gridy = 0; customerdb.add(namedb, c);
c.gridx = 0; c.gridy = 1; customerdb.add(date, c);
c.gridx = 1; c.gridy = 1; customerdb.add(datedb, c);
c.gridx = 0; c.gridy = 2; customerdb.add(serv_charges , c);
c.gridx = 1; c.gridy = 2; customerdb.add(servicedb, c);
c.gridx = 0; c.gridy = 3; customerdb.add(product_charges, c);
c.gridx = 1; c.gridy = 3; customerdb.add(productdb, c);
c.gridx = 0; c.gridy = 4; customerdb.add(total, c);
c.gridx = 1; c.gridy = 4; customerdb.add(dbTotal, c);

ScroolForPane.setBackground(Color.WHITE);
ScroolForPane.add(customerdb);
ScroolForPane.add(endline);
}
JScrollPane scrollPane = new JScrollPane(ScroolForPane);
scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

this.add(scrollPane);
this.setBackground(Color.WHITE);


}
}