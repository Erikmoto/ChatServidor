/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Classes.Servidor;

/**
 *
 * @author ryuic
 */
public class InterfaceServidor extends javax.swing.JFrame {

    /**
     * Creates new form InterfaceServidor
     * @param servidor
     */
    
    public InterfaceServidor(Servidor servidor) {
        this.servidor = servidor;
        initComponents();
        this.IP.setText(servidor.getIP());
        this.porta.setText(String.valueOf(servidor.getPorta()));
    }

    private InterfaceServidor() {
        
    }
    
    private Servidor servidor;

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        IP = new javax.swing.JLabel();
        rotuloPorta = new javax.swing.JLabel();
        porta = new javax.swing.JLabel();
        painelTexto = new javax.swing.JScrollPane();
        areaTexto = new javax.swing.JTextArea();
        campoMensagem = new javax.swing.JTextField();
        enviarMensagem = new javax.swing.JButton();
        pararServidor = new javax.swing.JButton();
        rotuloIP = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        IP.setBackground(new java.awt.Color(153, 204, 255));
        IP.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        IP.setText("___.___.___.___");
        IP.setOpaque(true);

        rotuloPorta.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        rotuloPorta.setText("Porta");
        rotuloPorta.setOpaque(true);

        porta.setBackground(new java.awt.Color(153, 255, 153));
        porta.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        porta.setText("_____");
        porta.setOpaque(true);

        areaTexto.setEditable(false);
        areaTexto.setColumns(20);
        areaTexto.setRows(5);
        painelTexto.setViewportView(areaTexto);

        campoMensagem.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        campoMensagem.setText("Mensagem");
        campoMensagem.setEnabled(false);

        enviarMensagem.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        enviarMensagem.setText("Enviar");
        enviarMensagem.setEnabled(false);

        pararServidor.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        pararServidor.setText("Parar Servidor");
        pararServidor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pararServidorActionPerformed(evt);
            }
        });

        rotuloIP.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        rotuloIP.setText("IP");
        rotuloIP.setOpaque(true);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(279, 279, 279)
                                .addComponent(pararServidor))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(163, 163, 163)
                                .addComponent(rotuloIP)
                                .addGap(26, 26, 26)
                                .addComponent(IP)
                                .addGap(41, 41, 41)
                                .addComponent(rotuloPorta)
                                .addGap(18, 18, 18)
                                .addComponent(porta)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(painelTexto)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 37, Short.MAX_VALUE)
                                .addComponent(campoMensagem, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(enviarMensagem)
                                .addGap(20, 20, 20)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pararServidor)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rotuloIP)
                    .addComponent(IP)
                    .addComponent(rotuloPorta)
                    .addComponent(porta))
                .addGap(18, 18, 18)
                .addComponent(painelTexto, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoMensagem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(enviarMensagem))
                .addContainerGap(55, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(736, 519));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    
    private void pararServidor() {
        this.servidor.paraServidor();
    }
    
    private void pararServidorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pararServidorActionPerformed
        this.dispose();
        pararServidor();
    }//GEN-LAST:event_pararServidorActionPerformed
    
    public void imprimeMensagem(String mensagem) {
        this.areaTexto.setText(this.areaTexto.getText() + mensagem);
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(InterfaceServidor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InterfaceServidor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InterfaceServidor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InterfaceServidor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InterfaceServidor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel IP;
    private javax.swing.JTextArea areaTexto;
    private javax.swing.JTextField campoMensagem;
    private javax.swing.JButton enviarMensagem;
    private javax.swing.JScrollPane painelTexto;
    private javax.swing.JButton pararServidor;
    private javax.swing.JLabel porta;
    private javax.swing.JLabel rotuloIP;
    private javax.swing.JLabel rotuloPorta;
    // End of variables declaration//GEN-END:variables
}
