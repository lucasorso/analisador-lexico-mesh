/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unesc.mesh.view;

import com.unesc.mesh.controles.Arquivo;
import com.unesc.mesh.controles.Automato;
import com.unesc.mesh.controles.Log;
import com.unesc.mesh.controles.NumeroLinha;
import com.unesc.mesh.controles.Sintatico;
import com.unesc.mesh.controles.Tokens;
import com.unesc.mesh.exception.SemanticoException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Lucas
 */
public class MainView extends javax.swing.JFrame {

    private Arquivo arq = new Arquivo();
    private String codigo = "";
    private File file = null;

    List<Tokens> listTokens;
    ArrayList<List<Integer>> listGramaticaRegra;
    Map<String, Integer> hashMapTokens;
    Map<String, Integer> hashMapNaoTerminais;

    /**
     * Creates new form MainView
     */
    public MainView() throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException, IOException {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        initComponents();
        NumeroLinha getNumeroLinha = new NumeroLinha(this.codigo_jTextArea);
        codigo_jScrollPane.setRowHeaderView(getNumeroLinha);
        codigo_jTextArea.setTabSize(2);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        topo_jPanel = new javax.swing.JPanel();
        analisar_JButton = new javax.swing.JButton();
        abrir_jButton = new javax.swing.JButton();
        salvar_jButton = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        codigo_jPanel = new javax.swing.JPanel();
        codigo_jScrollPane = new javax.swing.JScrollPane();
        codigo_jTextArea = new javax.swing.JTextArea();
        token_jPanel = new javax.swing.JPanel();
        token_jScrollPane = new javax.swing.JScrollPane();
        token_jTable = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        areaSintatico = new javax.swing.JTextArea();
        semantico_jPanel2 = new javax.swing.JPanel();
        semantico_jScrollPane2 = new javax.swing.JScrollPane();
        jMenuBar = new javax.swing.JMenuBar();
        arquivo_jMenu = new javax.swing.JMenu();
        abrir_jMenuItem = new javax.swing.JMenuItem();
        salvar_jMenuItem = new javax.swing.JMenuItem();
        sair_jMenuItem = new javax.swing.JMenuItem();
        sobre_jMenu = new javax.swing.JMenu();
        desenvolvedores_jMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Mesh Compiler");
        setExtendedState(MAXIMIZED_BOTH);

        analisar_JButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/unesc/mesh/icons/application_osx_terminal.png"))); // NOI18N
        analisar_JButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                analisar_JButtonActionPerformed(evt);
            }
        });

        abrir_jButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/unesc/mesh/icons/folder_explore.png"))); // NOI18N
        abrir_jButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                abrir_jButtonActionPerformed(evt);
            }
        });

        salvar_jButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/unesc/mesh/icons/page_save.png"))); // NOI18N
        salvar_jButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salvar_jButtonActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/unesc/mesh/icons/tick.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout topo_jPanelLayout = new javax.swing.GroupLayout(topo_jPanel);
        topo_jPanel.setLayout(topo_jPanelLayout);
        topo_jPanelLayout.setHorizontalGroup(
            topo_jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(topo_jPanelLayout.createSequentialGroup()
                .addComponent(abrir_jButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(salvar_jButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(analisar_JButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        topo_jPanelLayout.setVerticalGroup(
            topo_jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, topo_jPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(topo_jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addComponent(salvar_jButton)
                    .addGroup(topo_jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(analisar_JButton, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(abrir_jButton, javax.swing.GroupLayout.Alignment.TRAILING))))
        );

        codigo_jPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Código"));

        codigo_jTextArea.setColumns(20);
        codigo_jTextArea.setRows(5);
        codigo_jTextArea.setText("inicio_programa{\n      void _calculaArea (int _a, int _b) {\n      declaravariaveis int _totalArea;\n             inicio_corpo\n            \n             fim_corpo\n      };\n        \n      constante _CONST = 10;  _CONSTA = 90;\n      declaravariaveis float _diametro,  _total;\n      \n      inicio_corpo\n      \n      fim_corpo \n}");
        codigo_jScrollPane.setViewportView(codigo_jTextArea);

        javax.swing.GroupLayout codigo_jPanelLayout = new javax.swing.GroupLayout(codigo_jPanel);
        codigo_jPanel.setLayout(codigo_jPanelLayout);
        codigo_jPanelLayout.setHorizontalGroup(
            codigo_jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(codigo_jPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(codigo_jScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 835, Short.MAX_VALUE)
                .addContainerGap())
        );
        codigo_jPanelLayout.setVerticalGroup(
            codigo_jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, codigo_jPanelLayout.createSequentialGroup()
                .addComponent(codigo_jScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 354, Short.MAX_VALUE)
                .addContainerGap())
        );

        token_jPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Token"));

        token_jScrollPane.setViewportBorder(javax.swing.BorderFactory.createEtchedBorder());

        token_jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Linha", "Token", "Código"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        token_jScrollPane.setViewportView(token_jTable);
        if (token_jTable.getColumnModel().getColumnCount() > 0) {
            token_jTable.getColumnModel().getColumn(0).setResizable(false);
            token_jTable.getColumnModel().getColumn(0).setPreferredWidth(5);
            token_jTable.getColumnModel().getColumn(2).setPreferredWidth(5);
        }

        javax.swing.GroupLayout token_jPanelLayout = new javax.swing.GroupLayout(token_jPanel);
        token_jPanel.setLayout(token_jPanelLayout);
        token_jPanelLayout.setHorizontalGroup(
            token_jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(token_jPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(token_jScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 267, Short.MAX_VALUE)
                .addContainerGap())
        );
        token_jPanelLayout.setVerticalGroup(
            token_jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(token_jPanelLayout.createSequentialGroup()
                .addComponent(token_jScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Saída do Sintático e Semântico"));

        areaSintatico.setColumns(20);
        areaSintatico.setRows(5);
        jScrollPane1.setViewportView(areaSintatico);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 702, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE)
                .addContainerGap())
        );

        semantico_jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Tabela Semântico"));

        semantico_jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Variável", "Tipo", "Categoria"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        semantico_jScrollPane2.setViewportView(semantico_jTable1);

        javax.swing.GroupLayout semantico_jPanel2Layout = new javax.swing.GroupLayout(semantico_jPanel2);
        semantico_jPanel2.setLayout(semantico_jPanel2Layout);
        semantico_jPanel2Layout.setHorizontalGroup(
            semantico_jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(semantico_jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(semantico_jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        semantico_jPanel2Layout.setVerticalGroup(
            semantico_jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(semantico_jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(semantico_jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        arquivo_jMenu.setText("Arquvio");

        abrir_jMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/unesc/mesh/icons/folder_explore.png"))); // NOI18N
        abrir_jMenuItem.setText("Abrir");
        abrir_jMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                abrir_jMenuItemActionPerformed(evt);
            }
        });
        arquivo_jMenu.add(abrir_jMenuItem);

        salvar_jMenuItem.setText("Salvar");
        salvar_jMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salvar_jMenuItemActionPerformed(evt);
            }
        });
        arquivo_jMenu.add(salvar_jMenuItem);

        sair_jMenuItem.setText("Sair");
        sair_jMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sair_jMenuItemActionPerformed(evt);
            }
        });
        arquivo_jMenu.add(sair_jMenuItem);

        jMenuBar.add(arquivo_jMenu);

        sobre_jMenu.setText("Sobre");

        desenvolvedores_jMenuItem.setText("Desenvolvedores");
        desenvolvedores_jMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                desenvolvedores_jMenuItemActionPerformed(evt);
            }
        });
        sobre_jMenu.add(desenvolvedores_jMenuItem);

        jMenuBar.add(sobre_jMenu);

        setJMenuBar(jMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(codigo_jPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(token_jPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(topo_jPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(semantico_jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(topo_jPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(token_jPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(codigo_jPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(semantico_jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void abrir_jMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_abrir_jMenuItemActionPerformed
        try {
            abrirArquivo();
        } catch (NullPointerException | IOException ex) {
            Logger.getLogger(MainView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_abrir_jMenuItemActionPerformed

    private void salvar_jMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salvar_jMenuItemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_salvar_jMenuItemActionPerformed

    private void desenvolvedores_jMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_desenvolvedores_jMenuItemActionPerformed
        DevelopersView devShow = new DevelopersView();
        devShow.setVisible(true);
    }//GEN-LAST:event_desenvolvedores_jMenuItemActionPerformed

    private void abrir_jButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_abrir_jButtonActionPerformed
        try {
            limparCampo();
            abrirArquivo();
        } catch (IOException ex) {
            Log.gravar(ex.getMessage(), Log.LOG);
            Logger.getLogger(MainView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_abrir_jButtonActionPerformed

    private void analisar_JButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_analisar_JButtonActionPerformed
        limpaTabelas();
        try {
            analisarCodigo();
        } catch (SemanticoException ex) {
            Logger.getLogger(MainView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_analisar_JButtonActionPerformed

    private void salvar_jButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salvar_jButtonActionPerformed
        if (arq.gravarArquivo(codigo_jTextArea.getText())) {
            limparCampo();
        }
    }//GEN-LAST:event_salvar_jButtonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            adicionarRegrasGramatica();
        } catch (IOException ex) {
            Logger.getLogger(MainView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void sair_jMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sair_jMenuItemActionPerformed
        System.exit(NORMAL);
    }//GEN-LAST:event_sair_jMenuItemActionPerformed

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
            java.util.logging.Logger.getLogger(MainView.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainView.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainView.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainView.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            try {
                new MainView().setVisible(true);
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException | IOException ex) {
                Logger.getLogger(MainView.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton abrir_jButton;
    private javax.swing.JMenuItem abrir_jMenuItem;
    private javax.swing.JButton analisar_JButton;
    private javax.swing.JTextArea areaSintatico;
    private javax.swing.JMenu arquivo_jMenu;
    private javax.swing.JPanel codigo_jPanel;
    private javax.swing.JScrollPane codigo_jScrollPane;
    public static javax.swing.JTextArea codigo_jTextArea;
    private javax.swing.JMenuItem desenvolvedores_jMenuItem;
    private javax.swing.JButton jButton1;
    private javax.swing.JMenuBar jMenuBar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuItem sair_jMenuItem;
    private javax.swing.JButton salvar_jButton;
    private javax.swing.JMenuItem salvar_jMenuItem;
    private javax.swing.JPanel semantico_jPanel2;
    private javax.swing.JScrollPane semantico_jScrollPane2;
    public static final javax.swing.JTable semantico_jTable1 = new javax.swing.JTable();
    private javax.swing.JMenu sobre_jMenu;
    private javax.swing.JPanel token_jPanel;
    private javax.swing.JScrollPane token_jScrollPane;
    private javax.swing.JTable token_jTable;
    private javax.swing.JPanel topo_jPanel;
    // End of variables declaration//GEN-END:variables

    private boolean abrirArquivo() throws NullPointerException, IOException {

        this.file = arq.abrirArquivo();
        if (file != null) {
            this.codigo = arq.lerArquivo(file.getAbsolutePath());
            codigo_jTextArea.setText(codigo);
            return true;
        } else {
            Log.gravar("Nenhum arquivo selecionado", "Log.txt");
            return false;
        }
    }

    private void analisarCodigo() throws SemanticoException {
        areaSintatico.setText(" ");
        //Passando Hash Map
        Automato automato = new Automato(codigo_jTextArea.getText(), token_jTable);
        Sintatico sintatio = new Sintatico(automato);
        try {
//            List<Tokens> listTokensEncontrados = automato.getListaTokens();
            for (Tokens t : automato.getListaTokens()){
                if (sintatio.analisadorSintatico(areaSintatico, t)){
                    continue;
                } else {
                    break;
                }
            }
        } catch (Exception ex) {
            System.out.println("\nErro " + ex.getMessage());
            // Aqui vai lançar exeção de semântica.
        }
    }

//    private void adicionarTokens() throws IOException {
//
//        this.hashMapTokens = new HashMap<String, Integer>();
//
//        File file = new File(getClass().getResource("../arquivos/tokens.txt").getFile());
//        FileReader fileReader = new FileReader(file.getAbsoluteFile());
//        BufferedReader bufferedReader = new LineNumberReader(fileReader);
//        while (bufferedReader.ready()) {
//            String linha = bufferedReader.readLine();
//            String[] valor;
//            valor = linha.split(" "); //separa por espaço número e palavra
//            hashMapTokens.put(valor[0].toString(), Integer.parseInt(valor[1])); // adiciona no ashMap
//        }
//    }
//    private void adicionarNaoTerminais() throws IOException {
//
//        this.hashMapNaoTerminais = new HashMap<String, Integer>();
//
//        File file = new File(getClass().getResource("../arquivos/naoTerminaisCodificados.txt").getFile());
//        FileReader fileReader = new FileReader(file.getAbsoluteFile());
//        BufferedReader bufferedReader = new LineNumberReader(fileReader);
//        while (bufferedReader.ready()) {
//            String linha = bufferedReader.readLine();
//            String[] valor;
//            valor = linha.split(" "); //separa por espaço número e palavra
//            hashMapNaoTerminais.put(valor[1].toString(), Integer.parseInt(valor[0])); // adiciona no ashMap
//        }
//    }
    private void adicionarRegrasGramatica() throws IOException {
        listGramaticaRegra = new ArrayList<List<Integer>>();
        File file = new File(getClass().getResource("../arquivos/GramaticaCodificada.txt").getFile());
        FileReader fileReader = new FileReader(file.getAbsoluteFile());
        BufferedReader bufferedReader = new LineNumberReader(fileReader);
        while (bufferedReader.ready()) {
            String linha = bufferedReader.readLine();
            int[] valorInt = Arrays.stream(linha.replace("-", "").split("	")).map(String::trim).mapToInt(Integer::parseInt).toArray();
            List<Integer> list = Arrays.stream(valorInt).boxed().collect(Collectors.toList());
            list.remove(0);
            listGramaticaRegra.add(list);
        }
        imprimirLista(listGramaticaRegra);
    }

    private void imprimirLista(List list) {
        list.forEach(System.out::println);
    }

    private void limparCampo() {
        codigo_jTextArea.setText("");
    }
    
    private void limpaTabelas(){
        /* Recupera referência da tabela de lexicos*/
        DefaultTableModel tabelaLexico;
        tabelaLexico = (DefaultTableModel) token_jTable.getModel();
        tabelaLexico.getDataVector().removeAllElements();
        
        /* Recupera referência da tabela de semanticos*/
        DefaultTableModel tabelaSemantico;
        tabelaSemantico = (DefaultTableModel) semantico_jTable1.getModel();
        tabelaSemantico.getDataVector().removeAllElements();
    }

    private void imprimeHashs() {

        System.out.print("---------- Imprimindo HashMap ----------\n");
        System.out.println(hashMapTokens.toString());
    }

    private void imprimeList() {

        System.out.print("---------- Imprimindo Lista ----------\n");
        System.out.println(listTokens.toString());
    }
}
