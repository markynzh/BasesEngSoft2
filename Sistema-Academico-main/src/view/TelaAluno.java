package view;

import components.RoundedButton;
import classes.Estudante;
import dao.EstudanteDAO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.text.ParseException;
import java.util.List;

public class TelaAluno extends JPanel {
    // Campos
    private JTextField txtNome;
    private JFormattedTextField txtDataNascimento;
    private JTextField txtMatricula;

    // Pesquisa
    private JTextField txtPesquisar;
    private RoundedButton btnPesquisar;

    // Tabela
    private JTable tabela;
    private DefaultTableModel modelo;

    // Botões
    private RoundedButton btnSalvar;
    private RoundedButton btnEditar;
    private RoundedButton btnExcluir;

    // Lógica (DAO)
    private final EstudanteDAO estudanteDAO = new EstudanteDAO();

    //Construtor
    public TelaAluno() {
        setOpaque(false);
        setLayout(new BorderLayout(15,15));
        setBorder(BorderFactory.createEmptyBorder(20,20,20,20));

        add(criarPainelPesquisa(), BorderLayout.SOUTH);

        criarFormulario();
        criarTabela();
        configurarEventos();

        atualizarDados();
    }

    //Métodos
    private JPanel criarPainelPesquisa() {
        JPanel painel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        painel.setOpaque(false);

        JLabel lblPesquisar = new JLabel("Pesquisar (Nome ou Matrícula):");
        lblPesquisar.setForeground(Color.WHITE);
        lblPesquisar.setFont(new Font("Segoe UI", Font.PLAIN, 16));

        txtPesquisar = new JTextField(20);

        btnPesquisar = new RoundedButton("Pesquisar");

        painel.add(lblPesquisar);
        painel.add(txtPesquisar);
        painel.add(btnPesquisar);

        return painel;
    }

    private void criarFormulario() {
        JPanel painel = new JPanel(new GridBagLayout());
        painel.setOpaque(false);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10,10,10,10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        Font fonte = new Font("Segoe UI", Font.PLAIN,16);

        // Nome
        gbc.gridx = 0;
        gbc.gridy = 0;
        painel.add(criarLabel("Nome Completo:", fonte), gbc);

        gbc.gridx = 1;
        txtNome = new JTextField(25);
        painel.add(txtNome, gbc);

        // Data de nascimento
        gbc.gridx = 0;
        gbc.gridy++;
        painel.add(criarLabel("Data de Nascimento:", fonte), gbc);

        gbc.gridx = 1;
        try {
            MaskFormatter mascara = new MaskFormatter("##/##/####");
            mascara.setPlaceholderCharacter('_');

            txtDataNascimento = new JFormattedTextField(mascara);

        } catch (ParseException e) {
            txtDataNascimento = new JFormattedTextField();
        }
        txtDataNascimento.setColumns(25);
        painel.add(txtDataNascimento, gbc);

        // Matrícula
        gbc.gridx = 0;
        gbc.gridy++;
        painel.add(criarLabel("Matrícula:", fonte), gbc);

        gbc.gridx = 1;
        txtMatricula = new JTextField(25);
        permitirApenasNumeros(txtMatricula,10);
        painel.add(txtMatricula, gbc);

        // Botões
        JPanel painelBotoes = new JPanel(new FlowLayout(FlowLayout.CENTER,15,20));
        painelBotoes.setOpaque(false);

        btnSalvar = new RoundedButton("Salvar");
        btnEditar = new RoundedButton("Editar");
        btnExcluir = new RoundedButton("Excluir");

        painelBotoes.add(btnSalvar);
        painelBotoes.add(btnEditar);
        painelBotoes.add(btnExcluir);

        JPanel centro = new JPanel(new BorderLayout());
        centro.setOpaque(false);
        centro.add(painel, BorderLayout.CENTER);
        centro.add(painelBotoes, BorderLayout.SOUTH);

        add(centro, BorderLayout.NORTH);
    }

    private JLabel criarLabel(String texto, Font fonte){
        JLabel label = new JLabel(texto);
        label.setFont(fonte);
        label.setForeground(Color.WHITE);
        return label;
    }

    private void permitirApenasNumeros(JTextField campo, int limite){
        campo.addKeyListener(new java.awt.event.KeyAdapter(){

            @Override
            public void keyTyped(java.awt.event.KeyEvent e){
                char c = e.getKeyChar();
                if(c == java.awt.event.KeyEvent.VK_BACK_SPACE ||
                        c == java.awt.event.KeyEvent.VK_DELETE){
                    return;
                }
                if(!Character.isDigit(c)){
                    e.consume();
                    return;
                }
                if(campo.getText().length() >= limite){
                    e.consume();
                }
            }

        });
    }

    private void criarTabela(){
        modelo = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row,int column){
                return false;
            }
        };

        modelo.addColumn("Nome Completo");
        modelo.addColumn("Data de Nascimento");
        modelo.addColumn("Matrícula");

        tabela = new JTable(modelo);
        tabela.getTableHeader().setFont(new Font("Segoe UI",Font.BOLD,14));
        tabela.setFont(new Font("Segoe UI",Font.PLAIN,14));
        tabela.setRowHeight(28);
        tabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        JScrollPane scroll = new JScrollPane(tabela);
        scroll.setBorder(
                BorderFactory.createTitledBorder("Alunos Cadastrados")
        );
        add(scroll,BorderLayout.CENTER);
    }

    private void configurarEventos() {
        btnPesquisar.addActionListener(e -> pesquisarAluno());
        btnSalvar.addActionListener(e -> salvarAluno());
        btnEditar.addActionListener(e -> editarAluno());
        btnExcluir.addActionListener(e -> excluirAluno());

        tabela.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting() && tabela.getSelectedRow() != -1) {
                int linha = tabela.getSelectedRow();
                txtNome.setText(modelo.getValueAt(linha, 0).toString());
                txtDataNascimento.setText(modelo.getValueAt(linha, 1).toString());
                txtMatricula.setText(modelo.getValueAt(linha, 2).toString());

                txtMatricula.setEditable(false);
            }
        });
    }

    //Carrega os alunos direto do banco através da DAO
    public void atualizarDados() {
        modelo.setRowCount(0);
        List<Estudante> lista = estudanteDAO.listarEstudantes();
        for (Estudante estudante : lista) {
            modelo.addRow(new Object[]{
                    estudante.getNomeCompleto(),
                    estudante.getDataNascimento(),
                    estudante.getMatricula()
            });
        }
    }

    private void salvarAluno() {
        if (tabela.getSelectedRow() != -1) {
            JOptionPane.showMessageDialog(this,
                    "Você selecionou um aluno.\nUse o botão Editar para alterar os dados.");
            return;
        }

        String nome = txtNome.getText().trim();
        String data = txtDataNascimento.getText();
        String matriculaTexto = txtMatricula.getText().trim();

        if (nome.isEmpty()
                || data.equals("__/__/____")
                || matriculaTexto.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Preencha todos os campos!");
            return;
        }

        int matricula;
        try {
            matricula = Integer.parseInt(matriculaTexto);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Matrícula inválida!");
            return;
        }

        if (estudanteDAO.buscarMatriculaEstudante(matriculaTexto) != null) {
            JOptionPane.showMessageDialog(this,
                    "Já existe um aluno cadastrado com essa matrícula!");
            return;
        }

        Estudante estudante = new Estudante(matricula, nome, data);
        boolean ok = estudanteDAO.cadastrarEstudante(estudante);

        if (ok) {
            atualizarDados();
            JOptionPane.showMessageDialog(this,
                    "Aluno cadastrado com sucesso!");
            limparCampos();
        } else {
            JOptionPane.showMessageDialog(this,
                    "Erro ao cadastrar aluno. Verifique o console para detalhes.",
                    "Erro",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private void editarAluno() {
        int linha = tabela.getSelectedRow();
        if (linha == -1) {
            JOptionPane.showMessageDialog(this,
                    "Selecione um aluno para editar!");
            return;
        }

        String nome = txtNome.getText().trim();
        String data = txtDataNascimento.getText();
        int matricula = Integer.parseInt(modelo.getValueAt(linha, 2).toString());

        if (nome.isEmpty()
                || data.equals("__/__/____")) {
            JOptionPane.showMessageDialog(this,
                    "Preencha todos os campos!");
            return;
        }

        Estudante estudante = new Estudante(matricula, nome, data);
        boolean ok = estudanteDAO.editarEstudante(estudante);

        if (ok) {
            atualizarDados();
            JOptionPane.showMessageDialog(this,
                    "Aluno atualizado com sucesso!");
            limparCampos();
        } else {
            JOptionPane.showMessageDialog(this,
                    "Erro ao atualizar aluno.",
                    "Erro",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private void excluirAluno() {
        int linha = tabela.getSelectedRow();
        if (linha == -1) {
            JOptionPane.showMessageDialog(this,
                    "Selecione um aluno para excluir!");
            return;
        }

        int resposta = JOptionPane.showConfirmDialog(
                this,
                "Deseja realmente excluir este aluno?",
                "Confirmação",
                JOptionPane.YES_NO_OPTION
        );

        if (resposta == JOptionPane.YES_OPTION) {
            String matricula = modelo.getValueAt(linha, 2).toString();
            boolean ok = estudanteDAO.excluirEstudante(matricula);
            if (ok) {
                atualizarDados();
                JOptionPane.showMessageDialog(this,
                        "Aluno excluído com sucesso!");
                limparCampos();
            } else {
                JOptionPane.showMessageDialog(this,
                        "Erro ao excluir aluno. Ele pode estar matriculado em algum curso.",
                        "Erro",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void pesquisarAluno() {
        String pesquisa = txtPesquisar.getText().trim();
        if (pesquisa.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Digite um nome ou matrícula.");
            return;
        }

        for (int i = 0; i < modelo.getRowCount(); i++) {
            String nome = modelo.getValueAt(i, 0).toString();
            String matricula = modelo.getValueAt(i, 2).toString();
            if (nome.equalsIgnoreCase(pesquisa)
                    || matricula.equals(pesquisa)) {
                tabela.setRowSelectionInterval(i, i);
                return;
            }
        }
        JOptionPane.showMessageDialog(this,
                "Aluno não encontrado.");
    }

    private void limparCampos() {
        txtNome.setText("");
        txtDataNascimento.setValue(null);
        txtMatricula.setText("");
        txtMatricula.setEditable(true);

        tabela.clearSelection();

        txtNome.requestFocus();
    }
}