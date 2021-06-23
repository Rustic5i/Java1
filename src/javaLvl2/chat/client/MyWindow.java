package javaLvl2.chat.client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class MyWindow extends JFrame {
    private JTextField jtf;
    private JTextArea jta;
    private final String SERVER_ADDR = "localhost";
    private final int SERVER_PORT = 8189;
    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;
    private boolean isAuthorized;
    private JPanel bottomPanel, upperPanel;

    public void setAuthorized(boolean isAuthorized){
        this.isAuthorized = isAuthorized;
        if (this.isAuthorized){
            upperPanel.setVisible(false);
            bottomPanel.setVisible(true);
        }else {
            upperPanel.setVisible(true);
            bottomPanel.setVisible(false);
        }
    }

    public MyWindow() {
        setBounds(600, 300, 500, 500);
        setTitle("Client");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jta = new JTextArea();
        jta.setEditable(false);
        jta.setLineWrap(true);
        JScrollPane jsp = new JScrollPane(jta);
        add(jsp, BorderLayout.CENTER);
        bottomPanel = new JPanel(new BorderLayout());
        add(bottomPanel, BorderLayout.SOUTH);
        JButton jbSend = new JButton("SEND");
        bottomPanel.add(jbSend,BorderLayout.EAST);
        jtf = new JTextField();
        bottomPanel.add(jtf, BorderLayout.CENTER);
        upperPanel = new JPanel(new GridLayout());
        JTextField jtfLogin = new JTextField();
        JPasswordField jtfPass = new JPasswordField();
        JButton jbAuth = new JButton("Auth");
        upperPanel.add(jtfLogin);
        upperPanel.add(jtfPass);
        upperPanel.add(jbAuth);
        add(upperPanel, BorderLayout.NORTH);
        setAuthorized(false);


        jbAuth.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(socket == null){
                    connect();
                }
                sendAuthMsg(jtfLogin.getText(), new String(jtfPass.getPassword()));
            }
        });

        jbSend.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              if (!jtf.getText().trim().isEmpty()){
                  sendMsg();
                  jtf.grabFocus();
              }
            }
        });
        jtf.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { sendMsg();
            }
        });
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                super.windowClosed(e);
                if(socket != null){

                    try {
                        out.flush();
                        out.close();
                        in.close();
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                }
            }
        });
        setVisible(true);
    }
    public void connect() {
        try {
            socket = new Socket(SERVER_ADDR, SERVER_PORT);
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
                new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (true) {
                        String str = in.readUTF();
                        if (str.equals("123")) {
                            setAuthorized(true);
                            jta.append("Вы авторизованы\n");
                            break;
                        }
                        if (str!=null){
                            jta.append(str);
                            jta.append("\n");
                        }
                    }
                    while (true){
                        String str = in.readUTF();
                        if (str!=null){
                            jta.append(str);
                            jta.append("\n");
                        }
                    }
                } catch (Exception e) {
                }
            }
        }).start();
    }
    public void sendMsg() {
        try {
            String a = jtf.getText();
            out.writeUTF(a);
            out.flush();
            jtf.setText("");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null,"Ошибка отправки сообщения");
        }
    }
    public void sendAuthMsg(String login, String pass){

        try {
            String a = "/auth "+login+" "+pass;
            out.writeUTF(a);
            out.flush();
        } catch (IOException e) {
            System.out.println("Auth error");
        }

    }

}

