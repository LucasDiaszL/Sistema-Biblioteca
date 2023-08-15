import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Sistema_Biblioteca extends JFrame implements ActionListener {
    private JLabel label1, label2, label3, label4, label5, label6, label7;
    private JTextField textField1, textField2, textField3, textField4, textField5, textField6, textField7;
    private JButton addButton, viewButton, editButton, deleteButton, clearButton,exitButton;
    private JPanel panel;
    private ArrayList<String[]> books = new ArrayList<String[]>();

    public Sistema_Biblioteca(){
        setTitle("Sistema de Gerenciamento da biblioteca");
        setSize(600, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        label1 = new JLabel("Livro ID");
        label2 = new JLabel("Titulo Livro");
        label3 = new JLabel("Autor");
        label4 = new JLabel("Publicação");
        label5 = new JLabel("Ano da Publicação");
        label6 = new JLabel("ISBN");
        label7 = new JLabel("Número de copias");

        textField1 = new JTextField(10);
        textField2 = new JTextField(20);
        textField3 = new JTextField(20);
        textField4 = new JTextField(20);
        textField5 = new JTextField(10);
        textField6 = new JTextField(20);
        textField7 = new JTextField(10);

        addButton = new JButton("Adiconar");
        viewButton = new JButton("Visualizar");
        editButton = new JButton("Editar");
        deleteButton = new JButton("Deletar");
        clearButton = new JButton("Limpar");
        exitButton = new JButton("Sair");

        addButton.addActionListener(this);
        viewButton.addActionListener(this);
        editButton.addActionListener(this);
        deleteButton.addActionListener(this);
        clearButton.addActionListener(this);
        exitButton.addActionListener(this);

        panel = new JPanel(new GridLayout(10,2));
        panel.add(label1);
        panel.add(textField1);
        panel.add(label2);
        panel.add(textField2);
        panel.add(label3);
        panel.add(textField3);
        panel.add(label4);
        panel.add(textField4);
        panel.add(label5);
        panel.add(textField5);
        panel.add(label6);
        panel.add(textField6);
        panel.add(label7);
        panel.add(textField7);
        panel.add(addButton);
        panel.add(viewButton);
        panel.add(editButton);
        panel.add(deleteButton);
        panel.add(clearButton);
        panel.add(exitButton);

        add(panel);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource() == addButton){
            String[] livros = new String[7];
            livros[0] = textField1.getText();
            livros[1] = textField1.getText();
            livros[2] = textField1.getText();
            livros[3] = textField1.getText();
            livros[4] = textField1.getText();
            livros[5] = textField1.getText();
            livros[6] = textField1.getText();
            books.add(livros);
            JOptionPane.showMessageDialog(this,"Livro adiconado com sucesso");
            clearFields();
        }
        else if(e.getSource() == viewButton){
            String[] colunas = {"Livro ID", "Titulo Livro", "Autor", "Publicação", "Ano da Publicação", "ISBN", "Número de Copias"};
            Object[][] data = new Object[books.size()][7];
            for (int i = 0; i < books.size(); i++) {
                data[i][0] = books.get(i)[0];
                data[i][1] = books.get(i)[1];
                data[i][2] = books.get(i)[2];
                data[i][3] = books.get(i)[3];
                data[i][4] = books.get(i)[4];
                data[i][5] = books.get(i)[5];
                data[i][6] = books.get(i)[6];
            }
            JTable tabela = new JTable(data, colunas);
            JScrollPane scrollPane = new JScrollPane(tabela);
            JFrame frame = new JFrame("Visualizar Livros");
            frame.add(scrollPane);
            frame.setSize(800, 400);
            frame.setVisible(true);

        }
        else if(e.getSource() == editButton){
            String livroID = JOptionPane.showInputDialog(this, "Digite o Id do Livro para Edição:");
            for(int i = 0; i < books.size(); i++ ){
                if(books.get(i)[0].equals(livroID)){
                    String[] livro = new String[7];
                    livro[0] = livroID;
                    livro[1] = textField2.getText();
                    livro[3] = textField4.getText();
                    livro[4] = textField5.getText();
                    livro[5] = textField6.getText();
                    livro[6] = textField7.getText();
                    books.set(i, livro);
                    JOptionPane.showMessageDialog(this, "Livro editado com Sucesso!");
                    clearFields();
                    return;
                }
            }
            JOptionPane.showMessageDialog(this, "Não foi encontadado o livro!");
            
        }
        else if(e.getSource() == deleteButton){
            String livroID = JOptionPane.showInputDialog(this, "Digite o ID do livro para excluir:");
            for(int i = 0; i< books.size(); i ++){
                if(books.get(i)[0].equals(livroID)){
                    books.remove(i);
                    JOptionPane.showMessageDialog(this, "Livro deletado com sucesso");
                    clearFields();
                    return;
                }
            }
            JOptionPane.showMessageDialog(this, "Não foi encontadado o livro!");

        }
        else if(e.getSource() == clearButton){
            clearFields();
        }
        else if(e.getSource() == exitButton){
            System.exit(0);
        }
        
    }
        private void clearFields(){
            textField1.setText("");
            textField2.setText("");
            textField3.setText("");
            textField4.setText("");
            textField5.setText("");
            textField6.setText("");
            textField7.setText("");
        }

        public static void main(String[] args) {
            new Sistema_Biblioteca();
            
        }

       
        
}
