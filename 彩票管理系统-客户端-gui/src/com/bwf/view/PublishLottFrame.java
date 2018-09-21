/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bwf.view;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.bwf.client.ClientDemo;
import com.bwf.jar.MyRequest;
import com.bwf.jar.MyResponse;
import com.bwf.util.UiUtil;

/**
 *
 * @author admin
 */
public class PublishLottFrame extends javax.swing.JFrame {
	
	private ObjectOutputStream oos;
	MyResponse lastResponse;
	private String uName;
	List<String> lotteryMeg;
	final int pageNum = 5;
	Integer pageCount = null;
    /**
     * Creates new form PublishLottFrame
     */
    public PublishLottFrame(ObjectOutputStream oos, MyResponse lastResponse, String uName) {
    	this.oos = oos;
		this.lastResponse = lastResponse;
		this.uName = uName;
    	initComponents();
        init();
    }
    
     private void init(){
    	 this.setTitle("你有本事不发行，我就有本事不买");
  		// 不可调大小
  		this.setResizable(false);
  		UiUtil.setFrameCenter(this);
  		UiUtil.setFrameImage(this);
  		jPriceField.setText("");
  		jPageField.setText("1");
  		this.jTextArea1.setText("期数\t价格\t开奖状态\t中奖号码\t\t销售数量\t奖池金额");
  		jPageField.requestFocus();
  		
  		synchronized (ClientDemo.class) {
 			if (ClientDemo.lastResponse == null) {
 				try {
 					ClientDemo.class.wait();
 				} catch (InterruptedException e) {
 					e.printStackTrace();
 				}
 			}

 			// 读到了消息
 			lastResponse = ClientDemo.lastResponse;
 			ClientDemo.lastResponse = null;
 			System.out.println(lastResponse.getrMeg().get(MyResponse.MEG_CONTENT));
 			// 拿到所有的彩票信息
 			lotteryMeg = lastResponse.getHistoryList();
// 			int pageNum = 5;// 每页5条信息
// 			Integer pageCount = null;
 			if (lotteryMeg.size() % pageNum > 0) {
 				pageCount = lotteryMeg.size() / pageNum + 1;
 			} else {
 				pageCount = lotteryMeg.size() / pageNum;
 			}

// 			int pageCount = (int) Math.ceil(buyerMeg.size()/pageNum);//有多少页
 			// 1-[0,4] 2-[5,9] 3-[11,15]
 			this.jLabel6.setText(String.valueOf(pageCount));
// 			"请输入要跳转的页数，共" + pageCount + "页："
 			int page = 1;
 			List<String> pageMeg = getMegByPage((page * pageNum - 5), lotteryMeg);
 			for (String p : pageMeg) {
 				String record = this.jTextArea1.getText();
 				record = record+"\n"+p;
 				this.jTextArea1.setText(record);
 			}

 			ClientDemo.class.notify();
 		}
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jPageField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jGoButton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jPriceField = new javax.swing.JTextField();
        jPublishButton = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jBackButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("宋体", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 204, 102));
        jLabel1.setText("发行彩票");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jPageField.setText("？");
        jPageField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPageFieldActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("宋体", 0, 14)); // NOI18N
        jLabel3.setText("页");

        jGoButton.setBackground(new java.awt.Color(51, 51, 255));
        jGoButton.setForeground(new java.awt.Color(204, 153, 0));
        jGoButton.setText("GO");
        jGoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jGoButtonActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("宋体", 0, 14)); // NOI18N
        jLabel4.setText("发行价格：");

        jPriceField.setText("price");
        jPriceField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPriceFieldActionPerformed(evt);
            }
        });

        jPublishButton.setBackground(new java.awt.Color(0, 204, 204));
        jPublishButton.setForeground(new java.awt.Color(255, 102, 255));
        jPublishButton.setText("发行彩票");
        jPublishButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
					jPublishButtonActionPerformed(evt);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        });

        jLabel5.setFont(new java.awt.Font("宋体", 0, 14)); // NOI18N
        jLabel5.setText("/");

        jLabel6.setText("总");

        jBackButton.setBackground(new java.awt.Color(0, 0, 0));
        jBackButton.setForeground(new java.awt.Color(255, 255, 255));
        jBackButton.setText("返回");
        jBackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBackButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(221, 221, 221)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(211, 211, 211)
                        .addComponent(jPageField, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 7, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)
                        .addGap(35, 35, 35)
                        .addComponent(jGoButton)))
                .addContainerGap(30, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPriceField, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPublishButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBackButton)
                .addGap(44, 44, 44))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jPageField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jGoButton)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jPriceField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPublishButton)
                    .addComponent(jBackButton))
                .addGap(43, 43, 43))
        );

        pack();
    }// </editor-fold>                        

    private void jGoButtonActionPerformed(java.awt.event.ActionEvent evt) {    
    	//每次go之前先置空
    	this.jTextArea1.setText("期数\t价格\t开奖状态\t中奖号码\t\t销售数量\t奖池金额");
    	
    	if (lotteryMeg.size() % pageNum > 0) {
			pageCount = lotteryMeg.size() / pageNum + 1;
		} else {
			pageCount = lotteryMeg.size() / pageNum;
		}

//		int pageCount = (int) Math.ceil(buyerMeg.size()/pageNum);//有多少页
		// 1-[0,4] 2-[5,9] 3-[11,15]
		this.jLabel6.setText(String.valueOf(pageCount));
//		"请输入要跳转的页数，共" + pageCount + "页："
		int page = Integer.parseInt(jPageField.getText().trim());
		List<String> pageMeg = getMegByPage((page * pageNum - 5), lotteryMeg);
		for (String p : pageMeg) {
			String record = this.jTextArea1.getText();
			record = record+"\n"+p;
			this.jTextArea1.setText(record);
		}
    }                                         

    private void jPublishButtonActionPerformed(java.awt.event.ActionEvent evt) throws IOException {                                               
    	// 可以发行
//		System.out.println("请输入新一期彩票的单价：");
		String newPrice = jPriceField.getText().trim();

		MyRequest request = new MyRequest(MyRequest.TYPE_ADMIN_ISSUE);
		request.getUmap().put(MyRequest.MEG_USERNAME, uName);
		request.getUmap().put(MyRequest.MEG_LEVEL, "管理员");
		request.getUmap().put(MyRequest.LOTTERY_NEWPRICE, newPrice);
		// 包装好了，就发送过去，序列化
		oos.writeObject(request);
		oos.flush();

		synchronized (ClientDemo.class) {
			if (ClientDemo.lastResponse == null) {
				try {
					ClientDemo.class.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

			
			// 读到了消息
			lastResponse = ClientDemo.lastResponse;
			ClientDemo.lastResponse = null;
			JOptionPane.showMessageDialog(this, "发行成功");
//			System.out.println(lastResponse2.getrMeg().get(MyResponse.MEG_CONTENT));
			// 发行成功了
			jPriceField.setText("");
			ClientDemo.class.notify();
		}
    }                                              

    private void jPageFieldActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
    }                                          

    private void jPriceFieldActionPerformed(java.awt.event.ActionEvent evt) {                                            
        // TODO add your handling code here:
    }                                           

    private void jBackButtonActionPerformed(java.awt.event.ActionEvent evt) {                                            
    	 //返回
    	AdminFrame af = new AdminFrame(oos, lastResponse, uName);
    	af.setVisible(true);
    	this.dispose();
    }                                           
    
    private List<String> getMegByPage(int start, List<String> buyerMeg) {
		List<String> pageList = new ArrayList<>();
		;
		for (int i = start; i < buyerMeg.size() && i <= (start + 4); i++) {
			pageList.add(buyerMeg.get(i));
		}
		return pageList;
	}
    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(PublishLottFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(PublishLottFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(PublishLottFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(PublishLottFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new PublishLottFrame().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton jBackButton;
    private javax.swing.JButton jGoButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField jPageField;
    private javax.swing.JTextField jPriceField;
    private javax.swing.JButton jPublishButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration                   
}
