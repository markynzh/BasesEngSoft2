package view;

import components.RoundedButton;
import classes.Curso;
import classes.Professor;
import dao.CursoDAO;
import dao.ProfessorDAO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TelaCurso extends JPanel {
    // Campos
    private JTextField txtCodigo;
    private JTextField txtNomeCurso;
    private JTextField txtCargaHoraria;
    private JComboBox<String> comboProfessor;

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
    private final CursoDAO cursoDAO = new CursoDAO();
    private final ProfessorDAO professorDAO = new ProfessorDAO();

    //Construtor
    public TelaCurso() {
        setOpaque(false);
        setLayout(new BorderLayout(15,15));
        setBorder(BorderFactory.createEmptyBorder(20,20,20,20));

        criarFormulario();
        criarTabela();

        add(criarPainelPesquisa(), BorderLayout.SOUTH);

        configurarEventos();

        atualizarDados();
    }

    //Métodos
    private JPanel criarPainelPesquisa() {
        JPanel painel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        painel.setOpaque(false);

        JLabel lblPesquisar = new JLabel("Pesquisar Curso:");
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

        // Código (gerado pelo banco, exibido apenas quando editando)
        gbc.gridx = 0;
        gbc.gridy = 0;
        painel.add(criarLabel("Código:", fonte), gbc);

        gbc.gridx = 1;
        txtCodigo = new JTextField(25);
        txtCodigo.setEditable(false);
        txtCodigo.setToolTipText("Gerado automaticamente pelo banco de dados");
        painel.add(txtCodigo, gbc);

        // Nome do Curso
        gbc.gridx = 0;
        gbc.gridy++;
        painel.add(criarLabel("Nome do Curso:", fonte), gbc);

        gbc.gridx = 1;
        txtNomeCurso = new JTextField(25);
        painel.add(txtNomeCurso, gbc);

        // Carga Horária
        gbc.gridx = 0;
        gbc.gridy++;
        painel.add(criarLabel("Carga Horária:", fonte), gbc);

        gbc.gridx = 1;
        txtCargaHoraria = new JTextField(25);
        permitirApenasNumeros(txtCargaHoraria, 4);
        painel.add(txtCargaHoraria, gbc);

        // Professor Responsável
        gbc.gridx = 0;
        gbc.gridy++;
        painel.add(criarLabel("Professor Responsável:", fonte), gbc);

        gbc.gridx = 1;
        comboProfessor = new JComboBox<>();
        painel.add(comboProfessor, gbc);

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

        modelo.addColumn("Código");
        modelo.addColumn("Nome do Curso");
        modelo.addColumn("Carga Horária");
        modelo.addColumn("Professor Responsável");

        tabela = new JTable(modelo);
        tabela.getTableHeader().setFont(new Font("Segoe UI",Font.BOLD,14));
        tabela.setFont(new Font("Segoe UI",Font.PLAIN,14));
        tabela.setRowHeight(28);
        tabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scroll = new JScrollPane(tabela);

        scroll.setBorder(
                BorderFactory.createTitledBorder("Cursos Cadastrados")
        );
        add(scroll,BorderLayout.CENTER);
    }

    private void configurarEventos() {
        btnPesquisar.addActionListener(e -> pesquisarCurso());
        btnSalvar.addActionListener(e -> salvarCurso());
        btnEditar.addActionListener(e -> editarCurso());
        btnExcluir.addActionListener(e -> excluirCurso());

        tabela.getSelectionModel().addListSelectionListener(e -> {

            if (!e.getValueIsAdjusting() && tabela.getSelectedRow() != -1) {
                int linha = tabela.getSelectedRow();
                txtCodigo.setText(modelo.getValueAt(linha, 0).toString());
                txtNomeCurso.setText(modelo.getValueAt(linha, 1).toString());
                txtCargaHoraria.setText(modelo.getValueAt(linha, 2).toString());
                selecionarProfessorNoCombo(modelo.getValueAt(linha, 3).toString());
            }
        });
    }

    // Carrega cursos e a lista de professores disponíveis direto do banco
    public void atualizarDados() {
        carregarComboProfessores();
        modelo.setRowCount(0);

        List<Curso> lista = cursoDAO.listarCursos();

        for (Curso curso : lista) {
            modelo.addRow(new Object[]{
                    curso.getCodigo(),
                    curso.getNomeCurso(),
                    curso.getCargaHoraria(),
                    nomeDoProfessor(curso.getProfResponsavel())
            });
        }
    }

    private String nomeDoProfessor(Integer matricula) {
        if (matricula == null) {
            return "Sem professor";
        }
        Professor professor = professorDAO.buscarMatriculaProfessor(matricula);
        if (professor != null) {
            return professor.getNomeCompleto();
        }
        return "Professor não encontrado";
    }

    private void carregarComboProfessores() {
        comboProfessor.removeAllItems();
        for (Professor professor : professorDAO.listarProfessores()) {
            comboProfessor.addItem(professor.getNomeCompleto() + " (" + professor.getMatricula() + ")");
        }
    }

    private void selecionarProfessorNoCombo(String nomeProfessorNaTabela) {
        for (int i = 0; i < comboProfessor.getItemCount(); i++) {
            if (comboProfessor.getItemAt(i).startsWith(nomeProfessorNaTabela)) {
                comboProfessor.setSelectedIndex(i);
                return;
            }
        }
    }

    // Extrai a matrícula do professor a partir do texto "Nome (matrícula)" do combo
    private Integer matriculaDoProfessorSelecionado() {
        String selecionado = (String) comboProfessor.getSelectedItem();
        if (selecionado == null) {
            return null;
        }

        Matcher m = Pattern.compile("\\((\\d+)\\)$").matcher(selecionado);

        if (m.find()) {
            return Integer.parseInt(m.group(1));
        }
        return null;
    }

    private void salvarCurso() {
        if (tabela.getSelectedRow() != -1) {
            JOptionPane.showMessageDialog(this,
                    "Você selecionou um curso.\nUse o botão Editar para alterar os dados.");
            return;
        }

        String nome = txtNomeCurso.getText().trim();
        String cargaTexto = txtCargaHoraria.getText().trim();
        Integer matriculaProfessor = matriculaDoProfessorSelecionado();

        if(nome.isEmpty() || cargaTexto.isEmpty()){
            JOptionPane.showMessageDialog(this,
                    "Preencha todos os campos!");
            return;
        }

        if (matriculaProfessor == null) {
            JOptionPane.showMessageDialog(this,
                    "Cadastre ao menos um professor antes de criar um curso.");
            return;
        }

        Curso curso = new Curso(0, nome, Integer.parseInt(cargaTexto), matriculaProfessor);
        boolean ok = cursoDAO.cadastrarCurso(curso);

        if (ok) {
            atualizarDados();
            JOptionPane.showMessageDialog(this,
                    "Curso cadastrado com sucesso!");
            limparCampos();
        } else {
            JOptionPane.showMessageDialog(this,
                    "Erro ao cadastrar curso.",
                    "Erro",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private void editarCurso() {
        int linha = tabela.getSelectedRow();
        if (linha == -1) {
            JOptionPane.showMessageDialog(this,
                    "Selecione um curso para editar!");
            return;
        }

        String nome = txtNomeCurso.getText().trim();
        String cargaTexto = txtCargaHoraria.getText().trim();
        int codigo = Integer.parseInt(modelo.getValueAt(linha, 0).toString());
        Integer matriculaProfessor = matriculaDoProfessorSelecionado();

        if (nome.isEmpty() || cargaTexto.isEmpty() || matriculaProfessor == null) {
            JOptionPane.showMessageDialog(this,
                    "Preencha todos os campos!");
            return;
        }

        Curso curso = new Curso(codigo, nome, Integer.parseInt(cargaTexto), matriculaProfessor);
        boolean ok = cursoDAO.editarCurso(curso);

        if (ok) {
            atualizarDados();
            JOptionPane.showMessageDialog(this,
                    "Curso atualizado com sucesso!");
            limparCampos();
        } else {
            JOptionPane.showMessageDialog(this,
                    "Erro ao atualizar curso.",
                    "Erro",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private void excluirCurso() {
        int linha = tabela.getSelectedRow();
        if (linha == -1) {
            JOptionPane.showMessageDialog(this,
                    "Selecione um curso para excluir!");
            return;
        }

        int resposta = JOptionPane.showConfirmDialog(
                this,
                "Deseja realmente excluir este curso?",
                "Confirmação",
                JOptionPane.YES_NO_OPTION
        );

        if (resposta == JOptionPane.YES_OPTION) {
            int codigo = Integer.parseInt(modelo.getValueAt(linha, 0).toString());
            boolean ok = cursoDAO.excluirCurso(codigo);
            if (ok) {
                atualizarDados();
                JOptionPane.showMessageDialog(this,
                        "Curso excluído com sucesso!");
                limparCampos();
            } else {
                JOptionPane.showMessageDialog(this,
                        "Erro ao excluir curso. Ele pode ter alunos matriculados.",
                        "Erro",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void pesquisarCurso() {
        String pesquisa = txtPesquisar.getText().trim();
        if (pesquisa.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Digite o nome do curso.");
            return;
        }

        for (int i = 0; i < modelo.getRowCount(); i++) {
            String nome = modelo.getValueAt(i, 1).toString();
            if (nome.toLowerCase().contains(pesquisa.toLowerCase())) {
                tabela.setRowSelectionInterval(i, i);
                return;
            }
        }
        JOptionPane.showMessageDialog(this,
                "Curso não encontrado.");
    }

    private void limparCampos() {
        txtCodigo.setText("");
        txtNomeCurso.setText("");
        txtCargaHoraria.setText("");

        if (comboProfessor.getItemCount() > 0) {
            comboProfessor.setSelectedIndex(0);
        }
        tabela.clearSelection();

        txtNomeCurso.requestFocus();
    }
}