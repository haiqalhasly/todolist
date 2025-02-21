package TasQ.src.ui;



import TasQ.src.service.taskController;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;


public class MainUI {
    private taskController taskController = new taskController();
    private JFrame frame;
    private DefaultListModel<String> taskListModel = new DefaultListModel<>();
    private JList<String> taskList = new JList<>(taskListModel);
    private JTextField titleField = new JTextField(15);
    private JTextField descriptionField = new JTextField(15);
    private JTextField expField = new JTextField(5);
    private JButton addButton = new JButton("Add Task");
    private JButton deleteButton = new JButton("Delete Task");

    public MainUI() {
        frame = new JFrame("TasQ - Admin Panel");
        frame.setSize(400, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Dark Mode Panel
        JPanel panel = new JPanel();
        panel.setBackground(new Color(20, 20, 20)); // Dark background
        panel.setLayout(new GridLayout(6, 1, 10, 10));

        // Set text color
        taskList.setForeground(Color.WHITE);
        taskList.setBackground(new Color(30, 30, 30));
        titleField.setBackground(new Color(40, 40, 40));
        descriptionField.setBackground(new Color(40, 40, 40));
        expField.setBackground(new Color(40, 40, 40));
        titleField.setForeground(Color.WHITE);
        descriptionField.setForeground(Color.WHITE);
        expField.setForeground(Color.WHITE);

        // Pixel Font (Optional)
        Font pixelFont = new Font("Monospaced", Font.BOLD, 14);
        taskList.setFont(pixelFont);
        titleField.setFont(pixelFont);
        descriptionField.setFont(pixelFont);
        expField.setFont(pixelFont);
        addButton.setFont(pixelFont);
        deleteButton.setFont(pixelFont);

        panel.add(new JLabel("Title:", SwingConstants.CENTER));
        panel.add(titleField);
        panel.add(new JLabel("Description:", SwingConstants.CENTER));
        panel.add(descriptionField);
        panel.add(new JLabel("EXP:", SwingConstants.CENTER));
        panel.add(expField);
        panel.add(addButton);
        panel.add(deleteButton);

        frame.add(panel, BorderLayout.NORTH);
        frame.add(new JScrollPane(taskList), BorderLayout.CENTER);

        // Button Actions
        addButton.addActionListener(this::addTask);
        deleteButton.addActionListener(this::deleteTask);

        frame.setVisible(true);
    }

    private void addTask(ActionEvent e) {
        String title = titleField.getText();
        String description = descriptionField.getText();
        int exp = Integer.parseInt(expField.getText());
        taskController.addTask(title, description, exp);
        updateTaskList();
    }

    private void deleteTask(ActionEvent e) {
        int selectedIndex = taskList.getSelectedIndex();
        if (selectedIndex >= 0) {
            taskController.deleteTask(selectedIndex + 1);
            updateTaskList();
        }
    }

    private void updateTaskList() {
        taskListModel.clear();
        for (TasQ.src.model.Task task : taskController.getAllTasks()) {
            taskListModel.addElement(task.getTitle() + " - " + task.getExp() + " EXP");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MainUI::new);
    }
}
