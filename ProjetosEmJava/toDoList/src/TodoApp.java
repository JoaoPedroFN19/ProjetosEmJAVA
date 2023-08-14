import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TodoApp {
    private JFrame frame;
    private JList<Task> taskList;
    private DefaultListModel<Task> listModel;
    private JTextField taskField;

    private TaskList tasks;

    public TodoApp() {
        tasks = new TaskList();

        frame = new JFrame("Lista de Tarefas");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        listModel = new DefaultListModel<>();
        taskList = new JList<>(listModel);
        frame.add(new JScrollPane(taskList), BorderLayout.CENTER);

        taskList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    int index = taskList.locationToIndex(e.getPoint());
                    Task task = listModel.getElementAt(index);
                    task.markCompleted();
                    listModel.setElementAt(task, index);
                }
            }
        });

        JPanel bottomPanel = new JPanel();
        taskField = new JTextField(20);
        JButton addButton = new JButton("Adicionar");

        JButton removeCompletedButton = new JButton("Remover Concluídas");
        removeCompletedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = listModel.getSize() - 1; i >= 0; i--) {
                    Task task = listModel.getElementAt(i);
                    if (task.isCompleted()) {
                        tasks.removeTask(task);
                        listModel.removeElement(task);
                    }
                }
            }
        });

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String description = taskField.getText();
                if (!description.isEmpty()) {
                    Task task = new Task(description);
                    tasks.addTask(task);
                    listModel.addElement(task);
                    taskField.setText("");
                }
            }
        });

        bottomPanel.add(taskField);
        bottomPanel.add(addButton);
        bottomPanel.add(removeCompletedButton);

        frame.add(bottomPanel, BorderLayout.SOUTH);

        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                TodoApp todoApp = new TodoApp();
            }
        });
    }
}
