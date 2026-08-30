package view;

import components.GradientPanel;
import components.MenuButton;

import javax.swing.*;
import java.awt.*;

public class JanelaPrincipal extends JFrame {
    //Layout responsável por trocar as telas
    private CardLayout cardLayout;
    private JPanel painelConteudo;

    //Botões do menu
    private MenuButton btnInicio;
    private MenuButton btnAlunos;
    private MenuButton btnProfessores;
    private MenuButton btnCursos;
    private MenuButton btnVinculacoes;
    private MenuButton btnRelatorios;
    private MenuButton btnSair;

    private TelaAluno telaAluno;
    private TelaProfessor telaProfessor;
    private TelaCurso telaCurso;
    private TelaVinculacoes telaVinculacoes;
    private TelaRelatorios telaRelatorios;

    //Construtor
    public JanelaPrincipal() {
        configurarJanela();
        inicializarComponentes();
        setVisible(true);
    }

    //Métodos
    private void configurarJanela() {
        setTitle("Sistema de Gerenciamento Estudantil");
        setSize(1300, 750);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
    }

    private void inicializarComponentes() {
        GradientPanel fundo = new GradientPanel();
        fundo.setLayout(new BorderLayout());

        fundo.add(criarBarraSuperior(), BorderLayout.NORTH);
        fundo.add(criarMenuLateral(), BorderLayout.WEST);
        fundo.add(criarPainelCentral(), BorderLayout.CENTER);

        setContentPane(fundo);

        configurarEventos();
    }

    // Barra superior
    private JPanel criarBarraSuperior() {
        JPanel barra = new JPanel(new BorderLayout());
        barra.setPreferredSize(new Dimension(0, 60));
        barra.setBackground(new Color(24, 24, 36));

        JLabel titulo = new JLabel("Sistema de Gerenciamento Estudantil");
        titulo.setFont(new Font("Segoe UI", Font.BOLD, 22));
        titulo.setForeground(Color.WHITE);
        titulo.setBorder(BorderFactory.createEmptyBorder(0,20,0,0));
        barra.add(titulo, BorderLayout.WEST);

        JLabel versao = new JLabel("Versão 1.0");
        versao.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        versao.setForeground(Color.LIGHT_GRAY);
        versao.setBorder(BorderFactory.createEmptyBorder(0,0,0,20));
        barra.add(versao, BorderLayout.EAST);

        return barra;
    }

    // Menu lateral
    private JPanel criarMenuLateral() {
        JPanel menu = new JPanel(new BorderLayout());
        menu.setPreferredSize(new Dimension(230, 0));
        menu.setBackground(new Color(25, 25, 35));

        // LOGO
        JPanel logo = new JPanel();
        logo.setPreferredSize(new Dimension(230, 170));
        logo.setBackground(new Color(25,25,35));
        logo.setLayout(new BoxLayout(logo, BoxLayout.Y_AXIS));

        JLabel titulo1 = new JLabel("Sistema");
        titulo1.setAlignmentX(Component.CENTER_ALIGNMENT);
        titulo1.setFont(new Font("Segoe UI", Font.BOLD, 28));
        titulo1.setForeground(Color.WHITE);

        JLabel titulo2 = new JLabel("Gerenciamento");
        titulo2.setAlignmentX(Component.CENTER_ALIGNMENT);
        titulo2.setFont(new Font("Segoe UI", Font.BOLD, 24));
        titulo2.setForeground(Color.WHITE);

        JLabel titulo3 = new JLabel("Estudantil");
        titulo3.setAlignmentX(Component.CENTER_ALIGNMENT);
        titulo3.setFont(new Font("Segoe UI", Font.BOLD, 24));
        titulo3.setForeground(Color.WHITE);

        logo.add(Box.createVerticalGlue());
        logo.add(titulo1);
        logo.add(Box.createVerticalStrut(8));
        logo.add(titulo2);
        logo.add(Box.createVerticalStrut(8));
        logo.add(titulo3);
        logo.add(Box.createVerticalGlue());

        // MENU
        JPanel botoes = new JPanel();
        botoes.setBackground(new Color(25,25,35));
        botoes.setLayout(new BoxLayout(botoes, BoxLayout.Y_AXIS));
        botoes.setBorder(BorderFactory.createEmptyBorder(10,0,10,0));

        btnInicio = new MenuButton("Início");
        btnAlunos = new MenuButton("Alunos");
        btnProfessores = new MenuButton("Professores");
        btnCursos = new MenuButton("Cursos");
        btnVinculacoes = new MenuButton("Vinculações");
        btnRelatorios = new MenuButton("Relatórios");

        MenuButton[] lista = {
                btnInicio,
                btnAlunos,
                btnProfessores,
                btnCursos,
                btnVinculacoes,
                btnRelatorios
        };

        for(MenuButton b : lista){
            b.setMaximumSize(new Dimension(Integer.MAX_VALUE,48));
            b.setPreferredSize(new Dimension(220,48));
            b.setAlignmentX(Component.LEFT_ALIGNMENT);

            botoes.add(b);
        }

        // SAIR
        JPanel rodape = new JPanel();
        rodape.setBackground(new Color(25,25,35));
        rodape.setBorder(BorderFactory.createEmptyBorder(15,0,20,0));

        rodape.setLayout(new BoxLayout(rodape,BoxLayout.Y_AXIS));

        btnSair = new MenuButton("Sair");
        btnSair.setMaximumSize(new Dimension(Integer.MAX_VALUE,48));
        btnSair.setPreferredSize(new Dimension(220,48));
        btnSair.setAlignmentX(Component.LEFT_ALIGNMENT);

        rodape.add(new JSeparator());
        rodape.add(Box.createVerticalStrut(15));
        rodape.add(btnSair);

        menu.add(logo,BorderLayout.NORTH);
        menu.add(botoes,BorderLayout.CENTER);
        menu.add(rodape,BorderLayout.SOUTH);

        return menu;
    }

    // Painel Central
    private JPanel criarPainelCentral() {
        cardLayout = new CardLayout();
        painelConteudo = new JPanel(cardLayout);
        painelConteudo.setOpaque(false);

        telaAluno = new TelaAluno();
        telaProfessor = new TelaProfessor();
        telaCurso = new TelaCurso();
        telaVinculacoes = new TelaVinculacoes();
        telaRelatorios = new TelaRelatorios();

        painelConteudo.add(new TelaInicio(), "INICIO");
        painelConteudo.add(telaAluno, "ALUNOS");
        painelConteudo.add(telaProfessor, "PROFESSORES");
        painelConteudo.add(telaCurso, "CURSOS");
        painelConteudo.add(telaVinculacoes, "VINCULACOES");
        painelConteudo.add(telaRelatorios, "RELATORIOS");

        return painelConteudo;
    }

    private void configurarEventos() {
        btnInicio.addActionListener(e ->
                cardLayout.show(painelConteudo, "INICIO"));

        btnAlunos.addActionListener(e -> {
            telaAluno.atualizarDados();
            cardLayout.show(painelConteudo, "ALUNOS");
        });

        btnProfessores.addActionListener(e -> {
            telaProfessor.atualizarDados();
            cardLayout.show(painelConteudo, "PROFESSORES");
        });

        btnCursos.addActionListener(e -> {
            telaCurso.atualizarDados();
            cardLayout.show(painelConteudo, "CURSOS");
        });

        btnVinculacoes.addActionListener(e -> {
            telaVinculacoes.atualizarDados();
            cardLayout.show(painelConteudo, "VINCULACOES");
        });

        btnRelatorios.addActionListener(e -> {
            telaRelatorios.atualizarDados();
            cardLayout.show(painelConteudo, "RELATORIOS");
        });

        btnSair.addActionListener(e -> System.exit(0));
    }
}