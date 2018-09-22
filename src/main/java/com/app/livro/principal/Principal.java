/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.livro.principal;

import com.app.livro.dao.LivroDAO;
import com.app.livro.model.Livro;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author 588095982
 */
public class Principal extends javax.swing.JFrame {

    private Livro livro;
    private Integer nota = 5;
    private BufferedImage imagemBuffer;
    private ByteArrayOutputStream bytesImg;
    private byte[] byteArray;

    /**
     * Creates new form Principal
     */
    public Principal() {
        initComponents();
        getLivros();
        event e = new event();
        jSlider.addChangeListener(e);
        btnNota.setText(nota.toString());
    }

    // método de operação buscar todos os livros -----------------------------------------------------------
    public void getLivros() {

        ((DefaultTableModel) tabelaLivros.getModel()).setNumRows(0);
        DefaultTableModel modelo = (DefaultTableModel) tabelaLivros.getModel();

        // retorna a lista de livro do banco
        List<Livro> livros = new LivroDAO().getLivros();

        // adiciona as lihas na tabela
        livros.forEach((l) -> {
            modelo.addRow(new Object[]{
                l.getId(),
                l.getAutor(),
                l.getLivro(),
                l.getNota(),
                l.getAnoEdicao(),
                l.getResenha()
            });
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtAutor = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtLivro = new javax.swing.JTextField();
        txtAnoEdicao = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        textAreaResenha = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        btnGravar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelaLivros = new javax.swing.JTable();
        btnAlterar = new javax.swing.JButton();
        btnExlcuir = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jSlider = new javax.swing.JSlider();
        btnNota = new javax.swing.JButton();
        btnImagem = new javax.swing.JButton();
        btnExluirImagem = new javax.swing.JButton();
        btnRelatorio = new javax.swing.JButton();
        btnGerarDados = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cadastro de Livros");
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Autor");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Livro");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Ano de Edição");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Resenha");

        textAreaResenha.setColumns(20);
        textAreaResenha.setRows(5);
        jScrollPane1.setViewportView(textAreaResenha);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel5.setText("Cadastro de Livros");

        btnGravar.setText("Gravar");
        btnGravar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGravarActionPerformed(evt);
            }
        });

        tabelaLivros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Autor", "Livro", "Nota", "Ano Edição", "Resenha"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaLivros.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaLivrosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabelaLivros);
        if (tabelaLivros.getColumnModel().getColumnCount() > 0) {
            tabelaLivros.getColumnModel().getColumn(0).setPreferredWidth(2);
            tabelaLivros.getColumnModel().getColumn(1).setPreferredWidth(2);
            tabelaLivros.getColumnModel().getColumn(2).setPreferredWidth(2);
            tabelaLivros.getColumnModel().getColumn(4).setPreferredWidth(2);
        }

        btnAlterar.setText("Alterar");
        btnAlterar.setEnabled(false);
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });

        btnExlcuir.setText("Excluir");
        btnExlcuir.setEnabled(false);
        btnExlcuir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExlcuirActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Nota");

        jSlider.setMajorTickSpacing(10);
        jSlider.setMaximum(10);
        jSlider.setMinorTickSpacing(1);
        jSlider.setPaintLabels(true);
        jSlider.setPaintTicks(true);
        jSlider.setValue(5);

        btnNota.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        btnImagem.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnImagem.setText("Foto");
        btnImagem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImagemActionPerformed(evt);
            }
        });

        btnExluirImagem.setText("Excluir foto");
        btnExluirImagem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExluirImagemActionPerformed(evt);
            }
        });

        btnRelatorio.setText("Relatório");
        btnRelatorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRelatorioActionPerformed(evt);
            }
        });

        btnGerarDados.setText("Gerar dados");
        btnGerarDados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGerarDadosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 694, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnGravar)
                                .addGap(18, 18, 18)
                                .addComponent(btnAlterar)
                                .addGap(18, 18, 18)
                                .addComponent(btnExlcuir)
                                .addGap(18, 18, 18)
                                .addComponent(btnCancelar)
                                .addGap(18, 18, 18)
                                .addComponent(btnRelatorio)
                                .addGap(18, 18, 18)
                                .addComponent(btnGerarDados)
                                .addGap(94, 94, 94)))
                        .addGap(0, 37, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel6)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtAnoEdicao, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtLivro, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtAutor, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnNota, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(83, 83, 83)
                                .addComponent(btnExluirImagem)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnImagem, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(64, 64, 64))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel5)
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtAutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtLivro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtAnoEdicao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(btnNota, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel6)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addComponent(btnImagem, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnExluirImagem)))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnAlterar)
                    .addComponent(btnRelatorio)
                    .addComponent(btnGravar)
                    .addComponent(btnExlcuir)
                    .addComponent(btnGerarDados))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(37, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // método de operação gravar um livro ---------------------------------------------------------------------
    private void btnGravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGravarActionPerformed

        if (validarDadosCadastro()) {

            // instancia um livro
            livro = new Livro(txtAutor.getText().trim(), txtLivro.getText().trim(),
                    txtAnoEdicao.getText().trim(), textAreaResenha.getText().trim(), nota);

            // trata a imagem antes de gravar no banco
            tratarImagemAntesDeGravar();

            // realiza a gravação do livro no banco
            new LivroDAO().gravarLivro(livro);

            // limpa o formulário de cadastro de livros
            limparFormularioCadastro();

            // busca todos os livros no banco
            getLivros();

        } else {
            JOptionPane.showMessageDialog(rootPane, "Dados inválidos!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnGravarActionPerformed

    // método para selecionar um livro do banco -----------------------------------------------------------------
    private void tabelaLivrosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaLivrosMouseClicked

        // retorna o id do livro selecionado na tabela
        Integer id = (Integer) tabelaLivros.getValueAt(tabelaLivros.getSelectedRow(), 0);

        // realizar a buscar de um livro no banco
        livro = new LivroDAO().buscarLivro(id);

        // preenche o formulário cadastro de livros
        txtAutor.setText(livro.getAutor());
        txtLivro.setText(livro.getLivro());
        txtAnoEdicao.setText(livro.getAnoEdicao());
        textAreaResenha.setText(livro.getResenha());
        jSlider.setValue(livro.getNota());

        try {
            if (livro.getImagem() != null) {
                imagemBuffer = ImageIO.read(new ByteArrayInputStream(livro.getImagem()));
                Image diminuirImagem = imagemBuffer.getScaledInstance(185, 190, 0);
                btnImagem.setIcon(new ImageIcon(diminuirImagem));
            } else {
                btnImagem.setIcon(null);
            }
        } catch (IOException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }

        btnAlterar.setEnabled(true);
        btnExlcuir.setEnabled(true);
        btnGravar.setEnabled(false);
    }//GEN-LAST:event_tabelaLivrosMouseClicked

    // método de operação alterar um livro -----------------------------------------------------------------
    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed

        if (validarDadosCadastro()) {
            // retorna o id do livro selecionado na tabela
            Integer id = (Integer) tabelaLivros.getValueAt(tabelaLivros.getSelectedRow(), 0);

            // instancia um livro
            livro = new Livro(txtAutor.getText().trim(), txtLivro.getText().trim(),
                    txtAnoEdicao.getText().trim(), textAreaResenha.getText().trim(), nota);

            // seta o id já existene do livro
            livro.setId(id);

            // trata a imagem antes de gravar no banco
            tratarImagemAntesDeGravar();
            // realiza as alterações no livro
            new LivroDAO().alterarLivro(livro);

            // limpa o formulário de cadastro de livros
            limparFormularioCadastro();
            jSlider.setValue(5);
            btnAlterar.setEnabled(false);
            btnExlcuir.setEnabled(false);
            btnGravar.setEnabled(true);

            // busca todos os livros no banco
            getLivros();

        } else {
            JOptionPane.showMessageDialog(rootPane, "Dados inválidos!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnAlterarActionPerformed

    // método para tratar a imagem antes de salvar no banco ------------------------------------------------
    public void tratarImagemAntesDeGravar() {
        try {
            if (imagemBuffer != null) {
                bytesImg = new ByteArrayOutputStream();
                ImageIO.write(imagemBuffer, "jpg", bytesImg);
                bytesImg.flush();
                byteArray = bytesImg.toByteArray();
                bytesImg.close();
                livro.setImagem(byteArray);
            }
        } catch (IOException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // método de operação excluir um livro ------------------------------------------------------------------
    private void btnExlcuirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExlcuirActionPerformed

        // retornar o id do livro selecionado na tabela
        Integer id = (Integer) tabelaLivros.getValueAt(tabelaLivros.getSelectedRow(), 0);

        // realiza a exclusão do livro
        new LivroDAO().deletarLivro(id);

        // limpar os dados do formulário de cadastro de livros
        limparFormularioCadastro();
        // atruibui caracteristicas aos botôes em tela
        cancelar();
        // busca todos os livros no banco
        getLivros();
    }//GEN-LAST:event_btnExlcuirActionPerformed

    // mótodo para cancelar -----------------------------------------------------------------------------------
    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // limpa o formulário de cadastro de livros
        limparFormularioCadastro();
        cancelar();
    }//GEN-LAST:event_btnCancelarActionPerformed

    // método para criar a opção selecionar foto ---------------------------------------------------------------
    private void btnImagemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImagemActionPerformed

        // cria um seletor de arquivos
        JFileChooser fileChooser = new JFileChooser();
        // configurar o seletor de arquivos
        fileChooser.setDialogTitle("Selecione a foto");
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fileChooser.setFileFilter(new FileNameExtensionFilter("Imagem", "jpg", "png"));
        // retorna o valor referente ao clique do mouse
        int retorno = fileChooser.showOpenDialog(this);

        try {
            // verifica se foi selecionado um arquivo
            if (retorno == JFileChooser.APPROVE_OPTION) {
                String caminho = fileChooser.getSelectedFile().getAbsolutePath();
                imagemBuffer = ImageIO.read(new File(caminho));
                Image diminuirImagem = imagemBuffer.getScaledInstance(185, 190, 0);
                btnImagem.setIcon(new ImageIcon(diminuirImagem));
            }
        } catch (IOException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnImagemActionPerformed

    // método para excluir a imagem do livro --------------------------------------------------------------------
    private void btnExluirImagemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExluirImagemActionPerformed
        imagemBuffer = null;
        btnImagem.setIcon(null);
    }//GEN-LAST:event_btnExluirImagemActionPerformed

    // método para validar os dados do cadastro de livro, valida os campos autor, livro e ano de edição ----------
    public boolean validarDadosCadastro() {

        boolean valido = true;

        if (("".equals(txtAutor.getText()) || ("".equals(txtAutor.getText()))
                || ("".equals(txtLivro.getText())) || ("".equals(txtAnoEdicao.getText())))) {

            valido = false;
        }

        return valido;
    }

    // método para gerar o relatóro de livros ---------------------------------------------------------------------
    private void btnRelatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRelatorioActionPerformed

        List<Livro> livros = new LivroDAO().getLivros();

        List<Map<String, ?>> dataSource = new ArrayList<>();

        livros.forEach((liv) -> {
            Map<String, Object> l = new HashMap<>();
            l.put("livro_id", liv.getId());
            l.put("livro_autor", liv.getAutor());
            l.put("livro_livro", liv.getLivro());
            l.put("livro_anoEdicao", liv.getAnoEdicao());
            l.put("livro_nota", liv.getNota());
            l.put("livro_dataCadastro", liv.getDataCadastro());
            dataSource.add(l);
        });

        JRDataSource data = new JRBeanCollectionDataSource(dataSource);
        String caminho = "livros.jrxml";

        try {
            JasperReport report = JasperCompileManager.compileReport(caminho);
            JasperPrint print = JasperFillManager.fillReport(report, null, data);
            JasperViewer view = new JasperViewer(print, false);
            view.setVisible(true);

        } catch (JRException ex) {
            Logger.getLogger(LivroDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnRelatorioActionPerformed

    // método utilizado para gerar 10 livros ---------------------------------------------------------------------
    private void btnGerarDadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGerarDadosActionPerformed

        new LivroDAO().gerarDados();
        getLivros();
    }//GEN-LAST:event_btnGerarDadosActionPerformed

    // método para limpar o dados do formulário de cadastro de livros --------------------------------------------
    public void limparFormularioCadastro() {
        txtAutor.setText("");
        txtLivro.setText("");
        txtAnoEdicao.setText("");
        textAreaResenha.setText("");
        btnImagem.setIcon(null);
        jSlider.setValue(5);
        imagemBuffer = null;
    }

    // método cancelar, atribui caracteristicas aos botões em tela -----------------------------------------------
    public void cancelar() {
        btnExlcuir.setEnabled(false);
        btnAlterar.setEnabled(false);
        btnGravar.setEnabled(true);
    }
    
    // -----------------------------------------------------------------------------------------------------------
    public class event implements ChangeListener {

        @Override
        public void stateChanged(ChangeEvent e) {
            nota = jSlider.getValue();
            btnNota.setText(nota.toString());
        }
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
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnExlcuir;
    private javax.swing.JButton btnExluirImagem;
    private javax.swing.JButton btnGerarDados;
    private javax.swing.JButton btnGravar;
    private javax.swing.JButton btnImagem;
    private javax.swing.JButton btnNota;
    private javax.swing.JButton btnRelatorio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSlider jSlider;
    private javax.swing.JTable tabelaLivros;
    private javax.swing.JTextArea textAreaResenha;
    private javax.swing.JTextField txtAnoEdicao;
    private javax.swing.JTextField txtAutor;
    private javax.swing.JTextField txtLivro;
    // End of variables declaration//GEN-END:variables
}
