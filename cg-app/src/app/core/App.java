// TODO
package app.core;

import app.dialog.DialogSobre;
import app.enums.RasterizationEnum;
import app.extra.FrameHeartBeating;
import app.panels.Menu2D;
import app.panels.Menu3D;
import app.panels.PanelMenuCircunferencia;
import app.panels.PanelMenuImagem;
import app.panels.PanelMenuRasterizacao;
import app.panels.PanelMenuRecorteReta;
import app.extra.CartesianPlane;
import app.lines.Circle;
import app.lines.Pixel;
import app.lines.Rasterization;
import app.coordinateSystems.NormalizationFunctions;
import app.transformations.Heartbeat;
import app.transformations.Image;
import app.transformations.Transformations2D;
import app.transformations.Transformations3D;
import app.transformations.TransformationsImage;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.List;
import javax.swing.JPanel;

/**
 * JFrame principal da aplicação.
 *
 * @author Luis Thiago <lthiago.github.io>
 */
public class App extends javax.swing.JFrame {

    private final PanelMenuRasterizacao panelMenuRasterizacao;
    private final PanelMenuCircunferencia panelMenuCircunferencia;
    private final Menu2D panelMenu2D;
    private final Menu3D panelMenu3D;
    private final PanelMenuRecorteReta panelMenuRecorteReta;
    private final PanelMenuImagem panelMenuImagem;

    /**
     * Construtor padrão.
     */
    public App() {
        panelMenuRasterizacao = PanelMenuRasterizacao.getInstance();
        panelMenuCircunferencia = PanelMenuCircunferencia.getInstance();
        panelMenu2D = Menu2D.getInstance();
        panelMenu3D = Menu3D.getInstance();
        panelMenuRecorteReta = PanelMenuRecorteReta.getInstance();
        panelMenuImagem = PanelMenuImagem.getInstance();
        
        initComponents();
        sistemaCoordenadas();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        panelMenuLeft = new javax.swing.JPanel();
        panelBox = new javax.swing.JPanel();
        panelPlanoCartesiano = app.extra.CartesianPlane.getInstance();
        jLabel12 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        labelResTela = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        labelX = new javax.swing.JLabel();
        labelNDCX = new javax.swing.JLabel();
        labelDCX = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        labelDCY = new javax.swing.JLabel();
        labelNDCY = new javax.swing.JLabel();
        labelY = new javax.swing.JLabel();
        menuBar = new javax.swing.JMenuBar();
        menuQ1 = new javax.swing.JMenu();
        menuItemReta = new javax.swing.JMenuItem();
        menuItemCircuferencia = new javax.swing.JMenuItem();
        menuQ2 = new javax.swing.JMenu();
        itemPrintLine = new javax.swing.JMenuItem();
        itemPulse = new javax.swing.JMenuItem();
        itemBeatingHeart = new javax.swing.JMenuItem();
        menuQ3 = new javax.swing.JMenu();
        menuRecorte = new javax.swing.JMenuItem();
        menuItem2D = new javax.swing.JMenuItem();
        menuItem3D = new javax.swing.JMenuItem();
        menuQ4 = new javax.swing.JMenu();
        menuSobre = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Computação Gráfica - 2020.2");
        setExtendedState(6);
        setMinimumSize(new java.awt.Dimension(1080, 720));
        setName("framePrincipal"); // NOI18N
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                actionResized(evt);
            }
        });

        panelMenuLeft.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        panelMenuLeft.setMinimumSize(new java.awt.Dimension(240, 0));
        panelMenuLeft.setPreferredSize(new java.awt.Dimension(240, 2));

        javax.swing.GroupLayout panelMenuLeftLayout = new javax.swing.GroupLayout(panelMenuLeft);
        panelMenuLeft.setLayout(panelMenuLeftLayout);
        panelMenuLeftLayout.setHorizontalGroup(
            panelMenuLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 242, Short.MAX_VALUE)
        );
        panelMenuLeftLayout.setVerticalGroup(
            panelMenuLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 671, Short.MAX_VALUE)
        );

        panelPlanoCartesiano.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        panelPlanoCartesiano.setPreferredSize(new java.awt.Dimension(550, 550));

        javax.swing.GroupLayout panelPlanoCartesianoLayout = new javax.swing.GroupLayout(panelPlanoCartesiano);
        panelPlanoCartesiano.setLayout(panelPlanoCartesianoLayout);
        panelPlanoCartesianoLayout.setHorizontalGroup(
            panelPlanoCartesianoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panelPlanoCartesianoLayout.setVerticalGroup(
            panelPlanoCartesianoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 671, Short.MAX_VALUE)
        );

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel12.setText("C. Saída:");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel11.setText("C. Normalização:");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel10.setText("C. Entrada:");

        labelResTela.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        labelResTela.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelResTela.setText("Tela:");

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel13.setText("DCX:");

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel14.setText("NDCX:");

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel15.setText("X:");

        labelX.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        labelX.setText("0");

        labelNDCX.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        labelNDCX.setText("0");

        labelDCX.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        labelDCX.setText("0");

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel16.setText("DCY:");

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel17.setText("NDCY:");

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel18.setText("Y:");

        labelDCY.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        labelDCY.setText("0");

        labelNDCY.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        labelNDCY.setText("0");

        labelY.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        labelY.setText("0");

        javax.swing.GroupLayout panelBoxLayout = new javax.swing.GroupLayout(panelBox);
        panelBox.setLayout(panelBoxLayout);
        panelBoxLayout.setHorizontalGroup(
            panelBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBoxLayout.createSequentialGroup()
                .addGroup(panelBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelBoxLayout.createSequentialGroup()
                        .addComponent(labelResTela, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(590, 590, 590))
            .addGroup(panelBoxLayout.createSequentialGroup()
                .addGroup(panelBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBoxLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(panelBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(labelNDCY, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
                            .addComponent(labelNDCX, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelBoxLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(panelBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelBoxLayout.createSequentialGroup()
                                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(labelDCY))
                            .addGroup(panelBoxLayout.createSequentialGroup()
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(labelDCX))))
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelBoxLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(panelBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelX)
                            .addComponent(labelY))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelPlanoCartesiano, javax.swing.GroupLayout.DEFAULT_SIZE, 672, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelBoxLayout.setVerticalGroup(
            panelBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPlanoCartesiano, javax.swing.GroupLayout.DEFAULT_SIZE, 683, Short.MAX_VALUE)
            .addGroup(panelBoxLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelResTela)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(labelDCX))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(labelDCY))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel11)
                .addGap(3, 3, 3)
                .addGroup(panelBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(labelNDCY))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(labelNDCX))
                .addGap(10, 10, 10)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(labelX))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(labelY))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        menuBar.setPreferredSize(new java.awt.Dimension(104, 25));

        menuQ1.setText("Q1. Desenhar");

        menuItemReta.setText("Reta");
        menuItemReta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openMenuReta(evt);
            }
        });
        menuQ1.add(menuItemReta);

        menuItemCircuferencia.setText("Circunferência e Elipse");
        menuItemCircuferencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openMenuCircunferencia(evt);
            }
        });
        menuQ1.add(menuItemCircuferencia);

        menuBar.add(menuQ1);

        menuQ2.setText("Q2. Batimento cardíaco ");

        itemPrintLine.setText("Print Line");
        itemPrintLine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemPrintLineActionPerformed(evt);
            }
        });
        menuQ2.add(itemPrintLine);

        itemPulse.setText("Pulso");
        itemPulse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemPulseActionPerformed(evt);
            }
        });
        menuQ2.add(itemPulse);

        itemBeatingHeart.setText("No Plano Cartesiano");
        itemBeatingHeart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemBeatingHeartActionPerformed(evt);
            }
        });
        menuQ2.add(itemBeatingHeart);

        menuBar.add(menuQ2);

        menuQ3.setText("Q3. Transformações");

        menuRecorte.setText("Recorte de Reta");
        menuRecorte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuRecorteReta(evt);
            }
        });
        menuQ3.add(menuRecorte);

        menuItem2D.setText("2D");
        menuItem2D.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openTrans2D(evt);
            }
        });
        menuQ3.add(menuItem2D);

        menuItem3D.setText("3D");
        menuItem3D.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openTrans3D(evt);
            }
        });
        menuQ3.add(menuItem3D);

        menuBar.add(menuQ3);

        menuQ4.setText("Q4. Operações em Imagem");
        menuQ4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuQ4MouseClicked(evt);
            }
        });
        menuBar.add(menuQ4);

        menuSobre.setText("Sobre");
        menuSobre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuSobreMouseClicked(evt);
            }
        });
        menuBar.add(menuSobre);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(panelMenuLeft, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelBox, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelBox, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelMenuLeft, javax.swing.GroupLayout.DEFAULT_SIZE, 683, Short.MAX_VALUE))
                .addContainerGap())
        );

        setSize(new java.awt.Dimension(1096, 759));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Abre menu para desenhar reta.
     */
    private void openMenuReta(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openMenuReta
        panelMenuLeft.setVisible(true);
        CartesianPlane.getInstance().redraw();
        changeMenuLeft(panelMenuRasterizacao);
    }//GEN-LAST:event_openMenuReta

     /**
     * Abre menu para desenhar circunferência e elipse.
     */
    private void openMenuCircunferencia(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openMenuCircunferencia
        panelMenuLeft.setVisible(true);
        CartesianPlane.getInstance().redraw();
        changeMenuLeft(panelMenuCircunferencia);
    }//GEN-LAST:event_openMenuCircunferencia

     /**
     * Abre menu para utilizar as transformações 2D.
     */
    private void openTrans2D(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openTrans2D
        panelMenuLeft.setVisible(true);
        CartesianPlane.getInstance().redraw();
        changeMenuLeft(panelMenu2D);
    }//GEN-LAST:event_openTrans2D

     /**
     * Abre menu para utilizar as transformações 3D.
     */
    private void openTrans3D(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openTrans3D
        panelMenuLeft.setVisible(true);
        CartesianPlane.getInstance().redesenha3D();
        changeMenuLeft(panelMenu3D);
    }//GEN-LAST:event_openTrans3D

    /**
     * Evento disparado toda vez que a tela é redimensinada. Seta a resolução da tela atual.
     */
    private void actionResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_actionResized
        CartesianPlane p = CartesianPlane.getInstance();
        labelResTela.setText("Tela: " + p.getWidth() + "x" + p.getAltura());
    }//GEN-LAST:event_actionResized

     /**
     * Abre menu para utilizar o algoritmo de recorte de linha.
     */
    private void menuRecorteReta(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuRecorteReta
        panelMenuLeft.setVisible(true);
        CartesianPlane.getInstance().redraw();
        changeMenuLeft(panelMenuRecorteReta);
    }//GEN-LAST:event_menuRecorteReta

    /**
     * Abre painel que exibe informações do projeto.
     */
    private void menuSobreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuSobreMouseClicked
         new DialogSobre(this, true).setVisible(true);
    }//GEN-LAST:event_menuSobreMouseClicked

    /**
     * documentar quando implementar...
     */
    private void menuQ4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuQ4MouseClicked
        panelMenuLeft.setVisible(true);
        CartesianPlane.getInstance().redraw();
        changeMenuLeft(panelMenuImagem);
    }//GEN-LAST:event_menuQ4MouseClicked

    /**
     * Não exibe a linha do deslocamento e exibe o objeto "pulsando".
     */
    private void itemPulseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemPulseActionPerformed
        boolean printLine = false;
        executaAnimacao(printLine);
    }//GEN-LAST:event_itemPulseActionPerformed

    /**
     * Exibe a linha do deslocamento do objeto.
     */
    private void itemPrintLineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemPrintLineActionPerformed
        boolean printLine = true;
        executaAnimacao(printLine);
    }//GEN-LAST:event_itemPrintLineActionPerformed
    
    /**
     * Inicia a execução do Heart Beating no plano cartesiano.
     * @param evt 
     */
    private void itemBeatingHeartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemBeatingHeartActionPerformed
        openBeatingHeart();
    }//GEN-LAST:event_itemBeatingHeartActionPerformed

    /**
     * Executa o beating heart.
     */
    private void openBeatingHeart(){      
       Heartbeat heart = new Heartbeat();
       heart.startAnimation();
    }
    
    /**
     * Executa o JFrame que possui a animação.
     */
    private void executaAnimacao(boolean printLine){
        int width = 550;
        int height = 300;
        FrameHeartBeating f = new FrameHeartBeating(width, height, printLine);

        f.setTitle("Heart Beating (Exercício 2.5)");
        f.setSize(width, height);
        f.setType(Type.POPUP);
        f.setVisible(true);
        f.setResizable(false);
        f.setLocationRelativeTo(null);
    }
    
    /**
     * Altera o jPanel do menu esquerdo de acordo com o jPanel passado como parâmetro.
     */
    private void changeMenuLeft(JPanel panel) {
        panelMenuLeft.removeAll();
        panelMenuLeft.repaint();

        panelMenuLeft.setLayout(new GridLayout());
        panelMenuLeft.add(panel);

        panelMenuLeft.validate();
    }

    /**
     * Altera o jPanel do central adicionando o novo componente passado como parâmetro.
     */
    private void changePanelCentral(Component component) {
        javax.swing.GroupLayout panelBoxLayout = new javax.swing.GroupLayout(panelBox);
        panelBox.setLayout(panelBoxLayout);
        panelBoxLayout.setHorizontalGroup(
                panelBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelBoxLayout.createSequentialGroup()
                                .addComponent(component, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
        );
        panelBoxLayout.setVerticalGroup(
                panelBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(component, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );
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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(App.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(App.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(App.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(App.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new App().setVisible(true);
            }
        });
    }

    /**
     * Executa o algoritmo selecionado.
     * @param instance Instância de algum painel de opções.
     */
    public static void runResult(Object instance) {
        if (instance instanceof PanelMenuRasterizacao) {
            processaRasterizacaoReta(PanelMenuRasterizacao.getInstance());
        } else if (instance instanceof PanelMenuCircunferencia) {
            processaRasterizacaoCircunferencia(PanelMenuCircunferencia.getInstance());
        } else if (instance instanceof Menu2D) {
            processaTransformacoes2D(Menu2D.getInstance());
        } else if (instance instanceof Menu3D) {
            processaTransformacoes3D(Menu3D.getInstance());
        } else if (instance instanceof PanelMenuImagem) {
            processaTransformacoesImagem(PanelMenuImagem.getInstance());
        }
    }

    /**
     * Processa o pedido vindo do Painel de rasterização de reta.
     */
    private static void processaRasterizacaoReta(PanelMenuRasterizacao menu) {
        Rasterization rast = Rasterization.getInstance();
        CartesianPlane.getInstance().redraw();

        if (menu.getTipoAlgoritimo().equals(RasterizationEnum.DDA)) {
            rast.ddaMethod(menu.getPontoInicial(), menu.getPontoFinal(), menu.getColor(), menu.getTextAreaResult());
        } else if (menu.getTipoAlgoritimo().equals(RasterizationEnum.MIDPOINT)) {
            rast.midpointMethod(menu.getPontoInicial(), menu.getPontoFinal(), menu.getColor(), menu.getTextAreaResult());
        }
    }

    /**
     * Processa o pedido vindo do Painel de rasterização de circunferência.
     */
    private static void processaRasterizacaoCircunferencia(PanelMenuCircunferencia menu) {
        Circle circ = Circle.getInstance();

        switch (menu.getTipoAlgoritimo()) {
            case MIDPOINT:
                circ.midpointFunction((int) menu.getRaioX(), menu.getColor());
                break;
            case EXPLICIT_EQUATION:
                circ.explicitFunction((int) menu.getRaioX(), menu.getColor());
                break;
            case TRIGONOMETRIC:
                circ.trigonometricFunction((int) menu.getRaioX(), menu.getColor());
                break;
            case ELLIPSE:
                List<Pixel> lista = circ.ellipseFunction((int) menu.getRaioX(), (int) menu.getRaioY(), menu.getColor());
            default:
                break;
        }
    }

    /**
     * Processa o pedido vindo da tela de transformações 2D.
     */
    private static void processaTransformacoes2D(Menu2D menu) {
        if (Menu2D.matrixObject != null) {
            Transformations2D trans2D = Transformations2D.getInstance();

            //matriz objeto original. Atualizada a cada transformação
            double[][] matrizObjeto = Menu2D.matrixObject;

            switch (menu.getTipoAlgoritimo()) {
                case TRANSLATION:
                    // Aplica translação
                    matrizObjeto = trans2D.translation(matrizObjeto, menu.getValorX(), menu.getValorY());
                    break;
                case SCALE:
                    // Aplica scale de acordo com Sx e Sy
                    matrizObjeto = trans2D.scale(matrizObjeto, menu.getValorX(), menu.getValorY());
                    break;
                case ROTATION:
                    // Aplica rotação de acordo com o ângulo
                    matrizObjeto = trans2D.rotation(matrizObjeto, menu.getAngulo());
                    break;
                case REFLECTION:
                    // Aplica reflexão de acordo com o eixo selecionado
                    matrizObjeto = trans2D.reflection(matrizObjeto, menu.getEixo());
                    break;
                case SHEAR:
                    // Aplica shear de acordo com o valor de a e b
                    matrizObjeto = trans2D.shear(matrizObjeto, menu.getValorX(), menu.getValorY());
                    break;
                case COMPOSITE_TRANSFORMATION:
                    matrizObjeto = trans2D.composite(menu.listaDeTransformacoes, matrizObjeto);
                    break;
                default:
                    break;
            }
            // Desenha o objeto no plano.
            CartesianPlane.getInstance().drawObjeto2D(matrizObjeto, menu.getColor());
        }
    }

    /**
     * Processa o pedido vindo da tela de transformações 3D.
     */
    private static void processaTransformacoes3D(Menu3D menu) {
        if (Menu3D.matrixObject3D != null) {
            Transformations3D trans3D = Transformations3D.getInstance();

            //matriz objeto original. Atualizada a cada transformação
            double[][] matrizObjeto3D = Menu3D.matrixObject3D;

            switch (menu.getTipoAlgoritimo()) {
                case TRANSLATION:
                    // Aplica translação
                    matrizObjeto3D = trans3D.translation(matrizObjeto3D, menu.getValorX(), menu.getValorY(), menu.getValorZ());
                    break;
                case SCALE:
                    // Aplica scale de acordo com Sx e Sy
                    matrizObjeto3D = trans3D.scale(matrizObjeto3D, menu.getValorX(), menu.getValorY(), menu.getValorZ());
                    break;
                case ROTATION:
                    // Aplica rotação de acordo com o ângulo
                    matrizObjeto3D = trans3D.rotation(matrizObjeto3D, menu.getAngulo(), menu.getEixo());
                    break;
                case REFLECTION:
                    // Aplica reflexão de acordo com o eixo selecionado
                    matrizObjeto3D = trans3D.reflection(matrizObjeto3D, menu.getEixo());
                    break;
                case SHEAR:
                    // Aplica shear de acordo com o valor de a e b
                    matrizObjeto3D = trans3D.shear(matrizObjeto3D, menu.getValorX(), menu.getAlignmentY(), menu.getEixo());
                    break;
                case COMPOSITE_TRANSFORMATION:
                    matrizObjeto3D = trans3D.composite(menu.listaDeTransformacoes, matrizObjeto3D);
                    break;
                default:
                    break;
            }

            // Desenha o objeto no espaço.
            CartesianPlane.getInstance().drawObjeto3D(matrizObjeto3D, menu.getColor());
        }
    }
    
    /**
     * Calcula e exibe o sistema de coordenadas de acordo com os pontos no plano cartesiano.
     * O Evento mouseMoved é utilizado para pegar as coordenadas no plano cartesiano.
     */
    private void sistemaCoordenadas() {
        panelPlanoCartesiano.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                super.mouseMoved(e);

                // Pega a instancia do Plano Cartesiano
                CartesianPlane planoCartesiano = CartesianPlane.getInstance();

                // Calcula o dc - Entrada de dispositivo | Será o mesmo que a saída
                int dcx = e.getX() - planoCartesiano.getCenterXValue();
                int dcy = (e.getY() - planoCartesiano.getCenterYValue()) * -1;

                // Calcula o ndc - Normalização do dispositivo
                double ndcx = NormalizationFunctions.calculateNDCX(planoCartesiano.getWidth(), dcx);
                double ndcy = NormalizationFunctions.calculateNDCX(planoCartesiano.getAltura(), dcy);

                labelNDCX.setText(String.format("%.6f", ndcx));
                labelNDCY.setText(String.format("%.6f", ndcy));

                labelDCX.setText(String.valueOf(NormalizationFunctions.calculateDCX(planoCartesiano.getWidth(), (float) ndcx)));
                labelDCY.setText(String.valueOf(NormalizationFunctions.calculateDCY(planoCartesiano.getAltura(), (float) ndcy)));

                labelX.setText(String.valueOf(Math.round(dcx)));
                labelY.setText(String.valueOf(Math.round(dcy)));
            }
        });
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /**
     * Processa o pedido vindo da tela de transformações na Image.
     */
    private static void processaTransformacoesImagem(PanelMenuImagem menu) {
        if (PanelMenuImagem.imagem != null) {
            TransformationsImage transImg = TransformationsImage.getInstance();
            Image imagem = PanelMenuImagem.imagem;

            switch (menu.getTipoAlgoritimo()) {
                case TRANSLATION:
                    transImg.translation(imagem, menu.getValorX(), menu.getValorY());
                    break;
                case SCALE:
                    transImg.scale(imagem, menu.getValorX(), menu.getValorY());
                    break;
                case ROTATION:
                    transImg.rotation(imagem, menu.getAngulo());
                    break;
                case REFLECTION:
                    transImg.reflection(imagem, menu.getEixo());
                    break;
                case SHEAR:
                    transImg.shear(imagem, menu.getValorX(), menu.getValorY());
                    break;
                default:
                    break;
            }
        }
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JMenuItem itemBeatingHeart;
    private javax.swing.JMenuItem itemPrintLine;
    private javax.swing.JMenuItem itemPulse;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel labelDCX;
    private javax.swing.JLabel labelDCY;
    private javax.swing.JLabel labelNDCX;
    private javax.swing.JLabel labelNDCY;
    private javax.swing.JLabel labelResTela;
    private javax.swing.JLabel labelX;
    private javax.swing.JLabel labelY;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem menuItem2D;
    private javax.swing.JMenuItem menuItem3D;
    private javax.swing.JMenuItem menuItemCircuferencia;
    private javax.swing.JMenuItem menuItemReta;
    private javax.swing.JMenu menuQ1;
    private javax.swing.JMenu menuQ2;
    private javax.swing.JMenu menuQ3;
    private javax.swing.JMenu menuQ4;
    private javax.swing.JMenuItem menuRecorte;
    private javax.swing.JMenu menuSobre;
    private javax.swing.JPanel panelBox;
    private javax.swing.JPanel panelMenuLeft;
    private static javax.swing.JPanel panelPlanoCartesiano;
    // End of variables declaration//GEN-END:variables
}